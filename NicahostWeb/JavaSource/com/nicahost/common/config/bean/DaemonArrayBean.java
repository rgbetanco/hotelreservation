/*
 * Created on Oct 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DaemonArrayBean extends ArrayList implements Serializable {
	/**
	 * 
	 * Constructor vacio
	 */
	public DaemonArrayBean() {
		super();
	}
	
	/**
	 * 
	 * @param bean
	 */
	public void addDaemonBean(DaemonBean bean) {
		this.add(bean);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public DaemonBean getDaemonBean(int index) {
		return (DaemonBean) this.get(index);
	}
	
}
