/*
 * Created on Jun 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.classified.daemon;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nicahost.common.config.init.IDaemonTask;
import com.nicahost.common.exception.InitException;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamDAO;
import com.nicahost.module.classified.dao.ClassifiedDAO;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClassifiedDaemon extends IDaemonTask {
	
	static Logger logger = Logger.getLogger(ClassifiedDaemon.class);

	private static final String MAX_REC = "maxRec";
	private static final String WEEKS = "weeks";

	private int suggestedWeeks = 1;
	private int maxAds = 5;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		ClassifiedDAO dao = new ClassifiedDAO();
		
		try {
			ClasificadosInitParamDAO.getInstance().setPicks(dao.getPicks(suggestedWeeks,maxAds));
			
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		} finally {
			dao.destroy();
		}

	}

	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IDaemon#init(java.util.Map)
	 */
	public void init(Map params) throws InitException {

	try {
	
		String maxRec = (String) params.get(MAX_REC);
		String weeks = (String) params.get(WEEKS);
				
		suggestedWeeks = NumberFormat.getInstance().parse(weeks).intValue();
		maxAds = NumberFormat.getInstance().parse(maxRec).intValue();
		
		
	} catch (ParseException pex) {
		throw new InitException(pex);
	}



	}

}
