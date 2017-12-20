package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Vector de parámetros de inicialización.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 02-12-2004
 */
public class InitParameterArrayBean extends ArrayList implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = -4306795561740500633L;
	/**
	 * Constructor por defecto.
	 */
	public InitParameterArrayBean() {
		super();
	}
	/**
	 * Agrega un parámetro al vector.
	 * @param name el nombre del parámetro.
	 * @param value el valor del parámetro.
	 */
	public void addParameter(String name, String value) {
		this.add(new InitParameterBean(name, value));
	}
	/**
	 * Obtiene un parámetro del vector.
	 * @param index posición del parámetro.
	 * @return <code>InitParameterBean</code> con el parámetro solicitado.
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	public InitParameterBean getParameter(int index) {
		return (InitParameterBean) this.get(index);
	}
}
