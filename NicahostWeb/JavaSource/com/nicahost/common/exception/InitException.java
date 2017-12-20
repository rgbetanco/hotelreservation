/*
 * Created on Sep 9, 2004
 * Excepción para los procesos de inicialización de clases
 */
package com.nicahost.common.exception;

/**
 * Excepción para los procesos de inicialización de clases
 * @author hjiron
 * @version 1.0
 * Fecha: 09-09-2004
 */
public class InitException extends SbeException {	

	/**
	 * Constructor por defecto
	 */
	public InitException() {
		super();
	}

	/**
	 * Construye un excepción a partir de otra.
	 * @param exception excepción previa.
	 */
	public InitException(Exception exception) {
//		super(exception);
	}

	/**
	 * Construye una excepción con el mensaje de error
	 * @param msg Mensaje de error
	 */	
	public InitException(String msg) {
		super(msg);
	}
}
