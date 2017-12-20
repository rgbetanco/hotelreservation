package com.nicahost.common.config.bean;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Información de inicialización para el InitPlugin.
 * @author hjiron.
 * @version 1.0 
 * Fecha: 01-12-2004
 *
 */
public class InitPluginBean implements Serializable {
	/** Automatically generated javadoc for: serialVersionUID */
	private static final long serialVersionUID = 1206345038491746490L;
	/** Mapa de parámetros de inicialización. */
	private InitParameterMapBean initParameters;
	/** Lista de módulos de inicialización. */
	private ArrayList modules;
	/**
	 * Constructor por defecto.
	 */
	public InitPluginBean() {
		this.initParameters = new InitParameterMapBean();
		this.modules = new ArrayList();
	}
	/**
	 * Obtiene los parámetros de inicialización.
	 * @return parámetros de inicialización.
	 */
	public InitParameterMapBean getInitParameters() {
		return this.initParameters;
	}
	/**
	 * Asigna los parámetros de inicialización.
	 * @param value parámetros de inicialización.
	 */
	public void setInitParameters(InitParameterMapBean value) {
		this.initParameters = value;
	}
	/**
	 * Agrega un módulo de inicialización (<code>InitModuleBean</code>).
	 * @param bean módulo de inicialización.
	 */
	public void addModule(InitModuleBean bean) {
		this.modules.add(bean);
	}
	/**
	 * Obtiene el <code>InitModuleBean</code> en la posición especificada.
	 * @param index la posición del módulo.
	 * @return el <code>InitModuleBean</code> solicitado.
	 * @throws java.lang.IndexOutOfBoundsException
	 */
	public InitModuleBean getModule(int index) {
		return (InitModuleBean) this.modules.get(index);
	}
	/**
	 * The ammount of modules in the collection.
	 * @return the ammount of modules in the collection.
	 */
	public int getModuleCount() {
		return this.modules.size();
	}
}
