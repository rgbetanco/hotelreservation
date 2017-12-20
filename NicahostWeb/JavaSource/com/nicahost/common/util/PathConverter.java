package com.nicahost.common.util;

import javax.servlet.ServletContext;

/**
 * Encapsula la conversión de rutas relativas a absolutas. 
 * @author hjiron. 
 * @version 1.0
 * Fecha: 21-01-2005
 */
public class PathConverter implements IPathConverter {
	// Servlet context object.
	private static ServletContext context = null;
	
	/**
	 * Initializes the class.
	 * @param obj the initialization object.
	 */
	public void init(Object obj) {
		if (obj instanceof ServletContext) {
			context = (ServletContext) obj;
		}
	}
	
	/**
	 * Converts a relative file path to an absolute file path.
	 * @param filePath the path to be converted.
	 * @return absolute file path.
	 * @throws java.lang.NullPointerException
     */
	public String getAbsolutePath(String filePath) {
		return context.getRealPath(filePath);
	}
}
