package com.nicahost.common.config.init;

import com.nicahost.common.exception.InitException;

/**
 * Interfaz requerida para las clases que necesiten ser inicializadas al ser iniciada
 * la aplicación.
 * @author hjiron. 
 * @version 1.0
 * Fecha: 16-09-04
 *
 */
public interface IInitializer{
	/**
	 * Inicializa la clase.
	 * @param obj objeto de inicialización.
	 * @throws <code>InitException</code>
	 */
	public void init(Object o) throws InitException;
}
