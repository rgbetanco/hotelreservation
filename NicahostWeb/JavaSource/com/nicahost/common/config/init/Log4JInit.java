/*
 * Created on Jul 15, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.nicahost.common.exception.InitException;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Log4JInit implements IInitializer {

	public void init(Object filePath) throws InitException {
		Properties properties = new Properties();
		InputStream is = null;	

		try {		
			is = new FileInputStream((String) filePath);
			properties.load(is);			
			PropertyConfigurator.configure(properties);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception ex) {
				
			}
		}

	}

}
