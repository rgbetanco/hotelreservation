package com.nicahost.common.exception;
import com.nicahost.common.util.UniqueIdentifierGenerator;
/**
 * Excepción padre para todas las excepciones de SBE
 * @author hjiron
 * @version 1.0
 * Fecha: 07-09-2004
 */
public class SbeException extends Exception {
	/** Código de excepción. */
	protected String exceptionCode = null;
	/** Código de la excepción ligada. */
	protected String linkExceptionCode = null;
	/** Código de error de la excepción. */
	protected static final String SBE_ERROR_CODE = "sbe";
	/**
	 * Constructor por defecto. 
	 */
	public SbeException() {
		super();
		this.setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Construye una excepción con el mensaje de error
	 * @param msg Mensaje de error
	 */
	public SbeException(String msg) {
		super(msg);
		this.setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Construye una excepción con el mensaje de error y la excepción asociada
	 * @param message mensaje de error.
	 * @param cause <code>Throwable</code> con la excepción origen
	 */
	public SbeException(String message, Throwable cause) {
//super(message, cause);
		this.fillInStackTrace();
		if (cause instanceof SbeException) {
			this.setLinkExceptionCode(((SbeException) cause).getExceptionCode());
		}
		setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Construye una excepción a partir de otra excepción y encadena sus códigos
	 * de excepción
	 * @param exception excepción previa.
	 */
	public SbeException(Exception exception) {
//super(exception);
		this.fillInStackTrace();
		if (exception instanceof SbeException) {
			this.setLinkExceptionCode(((SbeException) exception).getExceptionCode());
		}
		setExceptionCode(UniqueIdentifierGenerator.generateCode());
	}
	/**
	 * Retorna el código de excepción
	 * @return <code>String</code>
	 */
	public String getExceptionCode() {
		return this.exceptionCode;
	}
	/**
	 * Retorna la excepción ligada
	 * @return <code>String</code>
	 */
	public String getLinkExceptionCode() {
		return this.linkExceptionCode;
	}
	/**
	 * Asigna el código de excepción
	 * @param value con el código de excepción
	 */
	public void setExceptionCode(String value) {
		this.exceptionCode = value;
	}
	/**
	 * Asigna la excepción ligada
	 * @param value Código de excepción ligada
	 */
	public void setLinkExceptionCode(String value) {
		this.linkExceptionCode = value;
	}
	/**
	 * Retorna el código de error específico de la excepción
	 * @return String, el código de error de la excepción
	 */
	public String getErrorCode(){
		return SBE_ERROR_CODE;
	}
}
