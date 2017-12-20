package com.nicahost.common.util;

/**
 * Responsible for converting relative resource paths to absolute resource paths.
 * @author hjiron. 
 * @version 1.0
 * Fecha: 09-09-2004
 */
public interface IPathConverter {
	/**
	 * Initializes the object.
	 *  @param obj initialization <code>Object</code>
	 */
	public void init(Object obj);
	/**
	 * Converts paths to absolute paths.
	 * @param filePath <code>String</code> containing a file path (relative or absolute).
	 * @return <code>String</code> containing the equivalent absolute path.
	 */
	public String getAbsolutePath(String filePath);

}
