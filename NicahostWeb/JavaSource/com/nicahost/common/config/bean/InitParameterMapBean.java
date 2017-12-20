package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.validator.GenericValidator;
/**
 * Mapa de parámetros de inicio.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 02-12-2004
 *
 */
public class InitParameterMapBean extends HashMap implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 7500767192951330796L;
	/** Separador de las secciones de los parámetros. */
	private static final String SEPARATOR = "."; //$NON-NLS-1$
	/**
	 * Constructor por defecto.
	 */
	public InitParameterMapBean() {
		super();
	}
	/**
	 * Agrega o reasigna un parámetro al mapa.
	 * @param name el nombre del parámetro.
	 * @param value el valor del parámetro.
	 */
	public void addParameter(String name, String value) {
		this.put(name, value);
	}
	/**
	 * Agrega o reasigna un parámetro al mapa.
	 * @param name el nombre del parámetro.
	 * @param country país para el que el parámetro aplica.
	 * @param application aplicación para la que el parámetro aplica.
	 * @param value el valor del parámetro.
	 * @throws java.lang.NullPointerException
	 */
	public void addParameter(String name, String country, String application, String value) {
		String paramName = null;
		if (!GenericValidator.isBlankOrNull(country)) {
			if (!GenericValidator.isBlankOrNull(application)) {
				// país y aplicación.
				paramName = name.concat(SEPARATOR).concat(country).concat(SEPARATOR).concat(application);
			}
			else {
				// sólo con país.
				paramName = name.concat(SEPARATOR).concat(country);
			}
		}
		else {
			if (!GenericValidator.isBlankOrNull(application)) {
				// sólo con aplicación.
				paramName = name.concat(SEPARATOR).concat(application);
			}
			else {
				// toma sólo el nombre del parámetro. 
				paramName = name;
			}
		}
		this.addParameter(paramName, value);
	}
	/**
	 * Obtiene el valor de un parámetro del mapa.
	 * @param name nombre del parámetro.
	 * @return valor del parámetro solicitado.
	 */
	public String getValue(String name) {
		String value = null;
		if (this.containsKey(name)) {
			value = (String) this.get(name);
		}
		return value;
	}
	/**
	 * Obtiene el valor de un parámetro. Este método solo se debe utilizar para parámetros que
	 * pueden variar dependiendo del país del usuario o aplicación que lo invoque. 
	 * @param name nombre del parámetro.
	 * @param country país para el que el parámetro aplica.
	 * @param application aplicación para la que el parámetro aplica.
	 * @return valor del parámetro solicitado.
	 * @see InitParameterMapBean#getValue(String)
	 * @throws java.lang.NullPointerException
	 */
	public String getValue(String name, String country, String application) {
		boolean found = false;
		String paramName = null;
		if (null != name && !GenericValidator.isBlankOrNull(country)) {
			if (!GenericValidator.isBlankOrNull(application)) {
				// busca con país y aplicación.
				paramName = name.concat(SEPARATOR).concat(country).concat(SEPARATOR).concat(application);
				found = this.containsKey(paramName);
			}
			if (!found) {
				// busca solo con país.
				paramName = name.concat(SEPARATOR).concat(country);
				found = this.containsKey(paramName);
			}
		}
		if (!found) {
			if (!GenericValidator.isBlankOrNull(application)) {
				// busca sólo con aplicación.
				paramName = name.concat(SEPARATOR).concat(application);
				found = this.containsKey(paramName);
			}
			if (!found) {
				// toma sólo el nombre del parámetro. 
				paramName = name;
			}
		}
		return this.getValue(paramName);
	}
}