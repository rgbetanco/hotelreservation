/*
 * Created on Oct 30, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.config.init;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Timer;

import com.nicahost.common.config.bean.DaemonArrayBean;
import com.nicahost.common.config.bean.DaemonBean;
import com.nicahost.common.exception.InitException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DaemonInit implements IInitializer {
	private static final String DAEMON_INIT_ERROR_MESSAGE =
		"No Daemons configured.";
	private static final String THREAD_GROUP_NAME = "Nicahost Daemons";
	
	private static ArrayList daemons = new ArrayList();
	
	private ThreadGroup gThread;

	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IInitializer#init(java.lang.Object)
	 */
	public void init(Object o) throws InitException {		

		daemons = (DaemonArrayBean) o;
		if (daemons != null) {
			gThread = new ThreadGroup(THREAD_GROUP_NAME);
			//gThread.setMaxPriority(Thread.currentThread().getPriority()-1);
			long milliseconds;
			for (int i = 0; i < daemons.size(); i++) {
				milliseconds = 0;
				Thread t = null;
				try {
					DaemonBean bean = (DaemonBean) daemons.get(i);			
					
					if (!bean.loadOnBoot()) 
						continue;		
					
					Object c =  Class.forName(bean.getDaemonClass()).newInstance();					

					if (c instanceof IDaemon) {						
						IDaemon daemon = (IDaemon) c;
						daemon.init(bean.getInitParameters());												
						
						milliseconds = NumberFormat.getInstance().parse(bean.getTime()).longValue();
						if (milliseconds > 0) {							
							IDaemonTask daemonTask = (IDaemonTask) daemon;												
							Timer timer = new Timer();
							timer.schedule(daemonTask,0, milliseconds);
						} else {
							t = new Thread(gThread, daemon);
							t.setName(bean.getDaemonName());
							t.start();
						}
							
					} else if (c instanceof Runnable) {
						Runnable d = (Runnable) c;					
						t = new Thread(gThread, d);
						t.setName(bean.getDaemonName());
						t.start();												
					}

				} catch (ParseException pex) {
					throw new InitException(pex);
				} catch (IllegalAccessException iaex) {
					throw new InitException(iaex);
				} catch (ClassNotFoundException cnfex) {
					throw new InitException(cnfex);
				} catch (InstantiationException iex) {
					throw new InitException(iex);
				}
			}

		} else {
			throw new InitException(DAEMON_INIT_ERROR_MESSAGE);
		}

	}

}
