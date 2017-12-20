package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Lista de elementos de tipo <code>DataSourceBean</code>.
 * @author hjiron
 * @version 1.0
 *
 */
public class DataSourceArrayBean extends ArrayList implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 1578070326295989088L;
	/**
	 * Constructor por defecto.
	 */
	public DataSourceArrayBean() {
		super();
	}
	/**
	 * Agrega un <code>DataSourceBean</code> a la lista.
	 * @param bean el <code>DataSourceBean</code> a agregar.
	 */
	public void addDataSourceBean(DataSourceBean bean) {
		this.add(bean);
	}
	/**
	 * Obtiene un <code>DataSourceBean</code> de la lista.
	 * @param index posición del <code>DataSourceBean</code>. 
	 * @return el <code>DataSourceBean</code> solicitado.
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	public DataSourceBean getDataSourceBean(int index) {
		return (DataSourceBean) this.get(index);
	}
}
