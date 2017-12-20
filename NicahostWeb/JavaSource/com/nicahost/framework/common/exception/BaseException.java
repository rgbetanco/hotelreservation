package com.nicahost.framework.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class BaseException extends Exception {
	
	protected Throwable rootCause = null;
	private List exceptions = new ArrayList();
	private String messageKey = null;
	private Object[] messageArgs = null;
	
	/**
	 * Constructor for CheckViewerBaseException.
	 */
	public BaseException() {
		super();
	}


	public BaseException(Throwable rootCause) {
		this.rootCause = rootCause;
	}
	
	
	public BaseException(String msgKey) {
		this.messageKey = msgKey;
	}
	
	public BaseException(String msgKey, Object[] args) {
    	this.messageKey = msgKey;
	    this.messageArgs = args;
  	}	
	
	
	/**
	 * Returns the exceptions.
	 * @return List
	 */
	public List getExceptions() {
		return exceptions;
	}
	
	/**
	 * Returns the messageArgs.
	 * @return Object[]
	 */
	public Object[] getMessageArgs() {
		return messageArgs;
	}

	/**
	 * Returns the messageKey.
	 * @return String
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * Returns the rootCause.
	 * @return Throwable
	 */
	public Throwable getRootCause() {
		return rootCause;
	}

	/**
	 * Adds exceptions to the list
	 */
	public void addException(BaseException ex) {
		this.exceptions.add(ex);
	}


	/**
	 * Sets the messageArgs.
	 * @param messageArgs The messageArgs to set
	 */
	public void setMessageArgs(Object[] messageArgs) {
		this.messageArgs = messageArgs;
	}

	/**
	 * Sets the messageKey.
	 * @param messageKey The messageKey to set
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * Sets the rootCause.
	 * @param rootCause The rootCause to set
	 */
	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}
	
 /**
   *  Print both the normal and rootCause stack traces.
   */
  public void printStackTrace(PrintWriter writer) {
    super.printStackTrace(writer);
    if(getRootCause() != null) {
      getRootCause().printStackTrace(writer);
    }
    writer.flush();
  }

  /**
   *  Print both the normal and rootCause stack traces.
   */
  public void printStackTrace(PrintStream outStream) {
    printStackTrace(new PrintWriter(outStream));
  }

  /**
   *  Print both the normal and rootCause stack traces.
   */
  public void printStackTrace() {
    printStackTrace(System.err);
  }
	

}
