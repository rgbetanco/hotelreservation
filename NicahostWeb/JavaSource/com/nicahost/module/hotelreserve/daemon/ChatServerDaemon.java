/*
 * Created on Oct 31, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.daemon;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

import server.ChannelManager;
import server.ConfigParser;
import server.LlamaChatServer;

import com.nicahost.common.config.init.IDaemon;
import com.nicahost.common.exception.InitException;
import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;


/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChatServerDaemon extends LlamaChatServer implements IDaemon {
 
 	private static final String SERVER_CONFIG_FILE_RELATIVE_PATH = "serverConfigFile";
 
	/**
	 * Default Constructor
	 */
	public ChatServerDaemon() {
		super();

	}

	/* (non-Javadoc)
	 * @see com.nicahost.common.config.init.IDaemon#init(java.util.Map)
	 */
	public void init(Map params) throws InitException {
		connectingUsers = new LinkedList();
		connectedUsers = new Hashtable();
		channels = new ChannelManager();
		channelFiles = new Hashtable();		
		
		serverConfigFile = (String) params.get(SERVER_CONFIG_FILE_RELATIVE_PATH);
		
		IPathConverter pathConverter = new PathConverter();
		serverConfigFile = pathConverter.getAbsolutePath(serverConfigFile);
		
		try {
			DefaultHandler handler = new ConfigParser(this);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File(serverConfigFile), handler);
		} catch (Throwable t) {
			System.err.println("error parsing " + serverConfigFile);
			running = false;
		}

		try {
			File file = new File(sysLogFile);
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			sysLogOut = new PrintWriter(bos);

			
		} catch (FileNotFoundException e) {
			System.err.println(sysLogFile + " not found.");
			running = false;
		} catch (IOException ioe) {
			System.err.println(sysLogFile + " IO Exception");
			running = false;
		}

		updateUserExport();



	}

}
