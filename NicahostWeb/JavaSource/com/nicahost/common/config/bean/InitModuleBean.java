package com.nicahost.common.config.bean;
import java.io.Serializable;
/**
 * Bean que contiene los datos de un módulo de inicialización.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 01-12-2004
 */
public class InitModuleBean implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = -6828541206440014394L;
	/** La clase de debe ser inicializada. */
	private String configClass;
	/** Indica si la clase de configuración es un Singleton. */
	private boolean singleton;
	/** La ruta del archivo de inicialización. */
	private String configFile;
	/** Reglas de parseo para el archivo de configuración. */
	private String configRulesKey;
	/** La ruta del archivo con el descriptor de MBeans. */
	private String mBeanFile;
	/**
	 * Constructor por defecto.
	 */
	public InitModuleBean() {
		this.singleton = false;
		this.mBeanFile = null;
	}
	/**
	 * Obtiene la clase de debe ser inicializada.
	 * @return clase de debe ser inicializada.
	 */
	public String getConfigClass() {
		return this.configClass;
	}
	/**
	 * Obtiene el archivo de inicialización.
	 * @return archivo de inicialización.
	 */
	public String getConfigFile() {
		return this.configFile;
	}
	/**
	 * Obtiene el identificador para las reglas de parseo del archivo de configuración.
	 * @return identificador para las reglas de parseo del archivo de configuración.
	 */
	public String getConfigRulesKey() {
		return this.configRulesKey;
	}
	/**
	 * Obtiene la ruta del archivo descriptor de MBean.
	 * @return ruta del archivo descriptor de MBean.
	 */
	public String getMBeanFile() {
		return this.mBeanFile;
	}
	/**
	 * Indica si la clase de configuración es un singleton o no.
	 * @return <code>true</code> si la clase de configuración es Singleton.
	 */
	public boolean isSingleton() {
		return singleton;
	}
	/**
	 * Asigna la clase de debe ser inicializada.
	 * @param value clase de debe ser inicializada.
	 */
	public void setConfigClass(String value) {
		this.configClass = value;
	}
	/**
	 * Asigna el archivo de inicialización.
	 * @param value archivo de inicialización.
	 */
	public void setConfigFile(String value) {
		this.configFile = value;
	}
	/**
	 * Sets the key for parsing the configuration file.
	 * @param value key for parsing the configuration file.
	 */
	public void setConfigRulesKey(String value) {
		this.configRulesKey = value;
	}
	/**
	 * Asigna la ruta del archivo descriptor de MBean.
	 * @param value ruta del archivo descriptor de MBean.
	 */
	public void setMBeanFile(String value) {
		this.mBeanFile = value;
	}
	/**
	 * Asigna si la clase de configuración es un singleton o no.
	 * @param value <code>true</code> si la clase de configuración es Singleton.
	 */
	public void setSingleton(boolean value) {
		this.singleton = value;
	}
	/**
	 * Asigna si la clase de configuración es un singleton o no.
	 * @param isSingleton <code>true</code> si la clase de configuración es Singleton.
	 */
	public void setSingleton(Boolean isSingleton) {
		if (null != isSingleton) {
			this.singleton = isSingleton.booleanValue();
		}
	}
}
