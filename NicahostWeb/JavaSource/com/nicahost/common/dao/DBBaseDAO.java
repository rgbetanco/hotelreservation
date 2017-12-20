package com.nicahost.common.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.nicahost.common.config.bean.DataSourceArrayBean;
import com.nicahost.common.config.bean.DataSourceBean;
import com.nicahost.common.config.init.IInitializer;
import com.nicahost.common.exception.InitException;
import com.nicahost.common.exception.SbeException;
/**
 * DAO base para los demás DAOs que accesan una base de datos.
 * Ofrece los metodos necesarios para ejecutar los SQL
 * @author hjiron
 * @version 1.0 
 */
public class DBBaseDAO implements IBaseDAO, IInitializer {
	/** Mensaje de error para cuando los datasources no se pueden inicializar. */
	private static final String DATASOURCES_ERROR = "DataSources not Initialized"; //$NON-NLS-1$
	/** Mensaje de error cuando se recibe un objeto de inicialización incorrecto. */
	private static final String INIT_OBJECT_ERROR = "Init object not an instance of "; //$NON-NLS-1$
	
	

	static Logger logger = Logger.getLogger(DBBaseDAO.class);	
	/**
	 * Almacena los data source para las diferentes conexiones a base de datos
	 */
	private static HashMap datasources = new HashMap();
	/* (non-Javadoc)
	 * @see net.bac.sbe.web.common.dao.IBaseDao#init(java.util.Properties)
	 */
	public void init(Object properties) throws InitException {
		if (properties instanceof ArrayList) {
			try {
				DataSourceArrayBean dataSourceArrayBean = (DataSourceArrayBean) properties;
				
				InitialContext initialContext = new InitialContext();
				for (int i = 0; i < dataSourceArrayBean.size(); i++) {
					try {
						DataSourceBean dataSourceBean = dataSourceArrayBean.getDataSourceBean(i);
						datasources.put(dataSourceBean.getName(), initialContext.lookup(dataSourceBean.getJndi()));						
					}
					catch (NamingException ne) {
						SbeException sbeException = new SbeException(ne);
						logger.error(DATASOURCES_ERROR);						
					}
					catch (Exception e) {
						SbeException sbeException = new SbeException(e);
						logger.error(DATASOURCES_ERROR, sbeException);
					}
				}
				if (datasources == null || datasources.isEmpty()) {
					InitException initException = new InitException(DATASOURCES_ERROR);
					logger.error(DATASOURCES_ERROR, initException);
					throw initException;
				}
			}
			catch (NamingException ne) {
				InitException initException = new InitException(ne);
				logger.error(DATASOURCES_ERROR, initException);
				throw initException;
			}
		}
		else {
			InitException initException = new InitException(INIT_OBJECT_ERROR + ArrayList.class.getName());
			logger.error(DATASOURCES_ERROR, initException);
			throw initException;
		}
	}
	/**
	 * Permite agregar un parámetro de configuración
	 * @param key Llave para referirse a la configuración
	 * @param value Objeto de configuración
	 */
	public void add(String key, Object value) {
		datasources.put(key, value);
	}
	/**
	 * Retorna una conexión para el data Source especificado
	 * @param dsName Identificador del data source
	 * @return <code>Connection</code> objeto de conexión
	 * @throws SQLException
	 */
	public Connection getPooledConnection(String dsName) throws SQLException {
		Connection conn = null;
		if (datasources.containsKey(dsName)) {
			conn = ((DataSource) datasources.get(dsName)).getConnection();
		}
		return conn;
	}
	/**
	 * Cierra la conexión especificada y la nulifica
	 * @param conn Objeto de conexión a cerrar
	 * @throws SQLException
	 */
	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
		conn = null;
	}
	/**
	 * Cierra la conexión y el prepared statment especificados y los nulifica
	 * @param conn Objeto de conexión a cerrar
	 * @param ps PreparedStatement a cerrar.
	 * @throws SQLException
	 */
	public void closeConnection(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) {
			ps.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
		ps = null;
		conn = null;
	}
	/**
	 * Cierra la conexión, el preparedstatment y el resultset especificados y los nulifica
	 * @param rs ResultSet a cerrar.
	 * @param conn Objeto de conexión a cerrar
	 * @param ps PreparedStatement a cerrar.
	 * @throws SQLException
	 */
	public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
		rs = null;
		ps = null;
		conn = null;
	}
	/**
	 * Permite prepara un SQL(String) en un <code>CallableStatement</code> listo para ejecutar.
	 * @param sql Sentencia SQL a preparar.
	 * @param dsName Nombre del data source a usar según la configuración
	 * @return <code>CallableStatement</code> con el SQL preparado
	 * @throws SQLException
	 */
	public CallableStatement prepareCALL(String sql, String dsName) throws SQLException {
		CallableStatement cstmt = null;
		if (datasources.containsKey(dsName)) {
			cstmt = getPooledConnection(dsName).prepareCall(sql);
			logger.info(this.getClass().getName().concat(" Prepared ".concat(sql)));			
		}
		return cstmt;
	}
	/**
	 * Permite prepara un SQL)String en un <code>PreparedStatement</code> listo para ejecutar.
	 * @param sql Sentencia SQL a preparar.
	 * @param dsName Nombre del data source a usar según la configuración
	 * @return <code>PreparedStatement</code> con el SQL preparado
	 * @throws SQLException
	 */
	public PreparedStatement prepareSQL(String sql, String dsName) throws SQLException {
		PreparedStatement pstmt = null;
		if (datasources.containsKey(dsName)) {
			pstmt = getPooledConnection(dsName).prepareStatement(sql);
			logger.info(this.getClass().getName().concat(" Prepared ".concat(sql)));
		}
		return pstmt;
	}
	/**
	 * Permite ejecutar un SQL de actualización
	 * @param preparedStatement Con el SQL ya preparado
	 * @throws SQLException
	 */
	public void executeUpdate(PreparedStatement preparedStatement) throws SQLException {
		try {
			preparedStatement.executeUpdate();
		}
		catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			throw sqle;
		}
	}
	/**
	 * Permite ejecutar un SQL de consulta
	 * @param callableStatement Con el SQl preparado
	 * @return <code>ResultSet</code> con el resultado de la consulta
	 * @throws SQLException
	 */
	public ResultSet executeQuery(CallableStatement callableStatement) throws SQLException {
		try {
			return callableStatement.executeQuery();
		}
		catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			throw sqle;
		}
	}
	/**
	 * Permite ejecutar un SQL de consulta
	 * @param preparedStatement Con el SQl preparado
	 * @return <code>ResultSet</code> con el resultado de la consulta
	 * @throws SQLException
	 */
	public ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException {
		try {
			return preparedStatement.executeQuery();
		}
		catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			throw sqle;
		}
	}
	/**
	 * Encargado de liberar los recursos adquiridos por el DAO
	 */
	public void destroy() {
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	protected void finalize() throws Throwable {
		super.finalize();
		destroy();
	}
}