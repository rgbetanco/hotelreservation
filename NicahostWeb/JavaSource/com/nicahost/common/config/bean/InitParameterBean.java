package com.nicahost.common.config.bean;
import java.io.Serializable;
/**
 * Representa un par nombre / valor.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 01-12-2004
 *
 */
public class InitParameterBean implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 1017679467657459088L;
	/** Nombre. */
	private String name;
	/** Valor. */
	private String value;
	/**
	 * Constructor por defecto.
	 */
	public InitParameterBean() {
	}
	/**
	 * Constructor de inicialización.
	 * @param newName nombre del parámetro.
	 * @param newValue valor del parámetro.
	 */
	public InitParameterBean(String newName, String newValue) {
		this.name = newName;
		this.value = newValue;
	}
	/**
	 * Obtiene el nombre del parámetro.
	 * @return nombre del parámetro.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Obtiene el valor del parámetro.
	 * @return valor del parámetro.
	 */
	public String getValue() {
		return value;
	}
	/**
	 * Asigna el nombre del parámetro.
	 * @param newName nombre del parámetro.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
	 * Asigna la clase de debe ser inicializada.
	 * @param newValue clase de debe ser inicializada.
	 */
	public void setValue(String newValue) {
		this.value = newValue;
	}
}
