package com.nicahost.common.config.bean;
import java.io.Serializable;
/**
 * Bean que contiene información de una fuente de datos.
 * @author hjiron
 * @version 1.0
 
 */
public class DataSourceBean implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 6599281755207462502L;
	/** El JNDI de la fuente de datos */
	private String jndi;
	/** El nombre de la fuente */
	private String name;
	/** La aplicación que utiliza la fuente */
	private String application;
	/**
	 * Constructor por defecto.
	 */
	public DataSourceBean() {
	}
	/**
	 * Constructor de inicialización.
	 * @param newJndi el JNDI de la fuente de datos.
	 * @param newName el nombre de la fuente de datos.
	 * @param newCountry el país asociado a la fuente de datos.
	 * @param newApplication la aplicación que utiliza la fuente.
	 */
	public DataSourceBean(String newJndi, String newName, String newApplication) {
		this.jndi = newJndi;
		this.name = newName;

		this.application = newApplication;
	}

	/**
	 * Obtiene el JNDI de la fuente de datos.
	 * @return el JNDI de la fuente de datos.
	 */
	public String getJndi() {
		return this.jndi;
	}
	/**
	 * Obtiene el nombre de la fuente de datos.
	 * @return el nombre de la fuente de datos.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Gets the associated application of the DataSource.
	 * @return associated application of the DataSource.
	 */
	public String getApplication() {
		return this.application;
	}

	/**
	 * Asigna el JNDI de la fuente de datos.
	 * @param newJndi JNDI de la fuente de datos.
	 */
	public void setJndi(String newJndi) {
		this.jndi = newJndi;
	}
	/**
	 * Asigna el nombre de la fuente de datos.
	 * @param newName nombre de la fuente de datos.
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
	 * Sets the associated application of the DataSource.
	 * @param newApplication associated application of the DataSource.
	 */
	public void setApplication(String newApplication) {
		this.application = newApplication;
	}
}
