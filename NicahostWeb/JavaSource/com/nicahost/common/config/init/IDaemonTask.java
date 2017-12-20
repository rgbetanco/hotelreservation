/*
 * Created on Nov 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.init;

import java.util.Map;
import java.util.TimerTask;

import com.nicahost.common.exception.InitException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class IDaemonTask extends TimerTask implements IDaemon {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	abstract public void run();
	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IDaemon#init(java.util.Map)
	 */
	abstract public void init(Map params) throws InitException;
}
