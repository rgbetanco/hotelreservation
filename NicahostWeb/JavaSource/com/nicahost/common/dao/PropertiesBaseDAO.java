package com.nicahost.common.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.nicahost.common.exception.InitException;
import com.nicahost.common.exception.SbeException;
/**
 * Parsea archivos de propiedades.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 07-09-2004
 *
 */
public class PropertiesBaseDAO implements IBaseDAO {
	/**
	 * Parses a properties file and converts it to a <code>HashMap</code>.
	 * @param file the file to be parsed.
	 * @return a <code>HashMap</code> containing all values obtained from the properties file.
	 * @throws java.lang.NullPointerException
	 */
	public static Map parse(File file) {
		Properties properties = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			properties.load(is);
		}
		catch (FileNotFoundException fnfe) {
			SbeException sbeException = new SbeException(fnfe);
		}
		catch (IOException ioe) {
			SbeException sbeException = new SbeException(ioe);
		}
		finally {
			try {
				if (is != null) {
					is.close();
				}
			}
			catch (IOException ioe) {
				SbeException sbeException = new SbeException(ioe);
			}
		}
		return properties;
	}
	/* (non-Javadoc)
	 * @see net.bac.sbe.web.common.dao.IBaseDAO#init(java.lang.Object)
	 */
	public void init(Object properties) throws InitException {
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
