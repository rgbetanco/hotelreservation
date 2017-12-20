/*
 * Created on Nov 1, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.daemon;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nicahost.common.config.init.IDaemonTask;
import com.nicahost.common.exception.InitException;
import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DelTempFileDaemon extends IDaemonTask {

	static Logger logger = Logger.getLogger(DelTempFileDaemon.class);

	private static final String PATH_TO_DIR = "pathToDir";
	private static final String TIME_TO_LIVE = "timeToLive";
	
	private String pathTempFiles = "";
	private long deleteTime = -1;
	private File tempDir = null;
	private String[] lista = null;		

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		logger.info("Deleting temp files... started!");
		try {		
			tempDir = new File(pathTempFiles);		
			if(!tempDir.exists() || !tempDir.isDirectory() || !tempDir.canRead()) {
				logger.error("Temp files can't be deleted: " + pathTempFiles);
			} else {
				lista = tempDir.list();
				File tempFile;
				for(int i = 0; i < lista.length; i++) {
					tempFile = new File(pathTempFiles + File.separator + lista[i]);
					if (System.currentTimeMillis() - tempFile.lastModified() >= deleteTime) {
						tempFile.delete();
					}
				}
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		} finally {
			
		}
		
		logger.info("Deleting temp files... completed!");
	}

	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IDaemon#init(java.util.Map)
	 */
	public void init(Map params) throws InitException {
		
		try {
		
			IPathConverter pathConverter = new PathConverter();
			pathTempFiles = (String) params.get(PATH_TO_DIR);
			pathTempFiles = pathConverter.getAbsolutePath(pathTempFiles);
		
			String timeToLive = (String) params.get(TIME_TO_LIVE);
			deleteTime = NumberFormat.getInstance().parse(timeToLive).longValue();
			
		} catch (ParseException pex) {
			throw new InitException(pex);
		}
			

	}

}
