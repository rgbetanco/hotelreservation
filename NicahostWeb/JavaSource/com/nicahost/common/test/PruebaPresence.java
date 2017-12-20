/*
 * Created on Mar 16, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PruebaPresence {

	public static void main(String[] args) throws IOException {
		String[] command;
		command = new String[] {"ping","localhost"};
		//command = new String[] {"cmd","/c", "dir"};
		//command = new String[] {"cmd","/c","telnet.exe","localhost","80"};
		command = new String[] {"cmd","/c","netstat","-b"};
		//command = new String[] {"telnet.exe"};
		final Process proc = Runtime.getRuntime().exec(command);
		
		//si le quiero pasar parametros una vez que este corriendo el prog externo, obtengo el inputstream
		/*OutputStream os = proc.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write("GET HTTP/1.0 index.html");
		osw.write("\n\n");
		*/
		//aqui obtengo el output stream del commando
		InputStream is =  proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);

		String line;
		
		while ((line = bfr.readLine())!= null) {
			System.out.println(line);
		}

		
		try {
			if (proc.waitFor() != 0 ) {
				System.err.println("exit value =" + proc.exitValue());
			}
		} catch (InterruptedException ex) {
			System.err.println(ex);
		}
		
		final Timer t = new Timer();
		t.schedule(new TimerTask() {

			public void run() {
				proc.destroy();	
				System.out.println("proc destroyed!!!");
				t.cancel();			
			}

		}, 5000L);				
		
		
	}
}
