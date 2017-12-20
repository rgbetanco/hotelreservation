package com.nicahost.common.creditcard.service;
/**
 * Clase para hacer transacciones de RealPay
 * @author Ricardo Soto
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.nicahost.common.config.bean.GlobalParametersBean;
import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.util.Tools;

public class RealPayTransaction {
	private String amount = "";
	private static final byte AUTH = 0xB;
	private String autID = "";
	private String autResult = "";
	private int batch = 0;
	private static final byte BATCH = 0xF;
	private String batchNum = ""; //6 caracteres
	private String batResult = "";
	private String card = "";
	private static final long DELAY = 500;
	private Exception e = null;
	private boolean Failed;
	private static final String INTERFACE_VERSION = "11";
	private String merchantID = "";
	private String month = "";
	private String order = "";
	private String realPayAddress = "";
	private int realPayPort = 1400;
	private String requestID = "";
	private static final byte SALE = 0x1;
	private String salResult = "";
	private String terminalID = "";
	private boolean TimedOut;
	private static final int TIMEOUT = 60000;
	private String traID = "";
	private String year = "";

	static Logger logger = Logger.getLogger(RealPayTransaction.class);

	/**
	 * Constructor por defecto
	 *
	 */
	public RealPayTransaction() {
		try {
			InitParameterMapBean param = GlobalParametersBean.getInstance().getList();
			this.realPayAddress = param.getValue(GlobalParametersBean.REALPAY_HOST);
			String port = param.getValue(GlobalParametersBean.REALPAY_PORT);
			this.realPayPort = Integer.valueOf(port).intValue();

		} catch (Exception e) {
			logger.error("No se pudo encontrar la conexion para RealPay");
		}
	}
	
	/**
	 * 
	 * @param str
	 * @param srcBegin
	 * @param srcEnd
	 * @param dst
	 * @param dstBegin
	 */	
	private void addBytes(String str,int srcBegin,int srcEnd,byte dst[],int dstBegin) {
		byte bytes[] = str.getBytes();
		System.arraycopy(bytes, srcBegin, dst, dstBegin, srcEnd - srcBegin);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean doAuth() {
		logger.info("Entro a doAuth");
		if (getException() != null) {
			logger.error(e.getMessage());
			logger.error(e.toString());
			logger.error(e);
			return false;
		}
		logger.info("No hay excepciones");
		byte send[];
		String receive[];
		String RequestID = getRequestID();
		send = new byte[276];
		receive = new String[374];
		short size = 274;
		byte first = (byte) (size >> 8);
		byte second = (byte) size;
		send[0] = first;
		send[1] = second;
		send[2] = 0x70;
		send[3] = 0x00;
		send[4] = 0x00;
		send[5] = 0x00;
		send[6] = 0x00;
		//header
		addBytes(INTERFACE_VERSION, 0, INTERFACE_VERSION.length(), send, 7);
		addBytes(merchantID, 0, merchantID.length(), send, 10);
		addBytes(terminalID, 0, terminalID.length(), send, 26);
		addBytes(requestID, 0, requestID.length(), send, 35);
		//send[62] = 11;
		send[62] = AUTH;
		addBytes(card, 0, card.length(), send, 63);
		addBytes(amount, 0, amount.length(), send, 83);
		addBytes(month, 0, month.length(), send, 96);
		addBytes(year, 0, year.length(), send, 99);
		addBytes(order, 0, order.length(), send, 228);
		int i;
		try {

			logger.info(
				"Tratando de hacer el socket: "
					+ realPayAddress
					+ ","
					+ realPayPort);
			Socket sockete = new Socket(realPayAddress, realPayPort);
			sockete.setSoTimeout(TIMEOUT);
			logger.info("sending...");
			//logBytes(send);
			OutputStream out = sockete.getOutputStream();
			InputStream in = sockete.getInputStream();
			out.write(send);			
			logger.info("receiving");
			if (in != null) {
				int x = -1;
				for (i = 0;(x = in.read()) != -1; i++) {
					if (i == receive.length)
						break;
					receive[i] = getChar(x);
				}
			}
			in.close();
			out.close();
			sockete.close();
		} catch (Exception e) {
			setException(e);
			System.out.println("doAuth " + e.getMessage());
			logger.error("doAuth " + e.getMessage());
			logger.error(e);
		}
		autID = "";
		for (i = 63; i < 84; i++) {
			if (receive[i] == null)
				break;
			autID += receive[i];
		}
		logger.info("AutorizationID: " + autID);
		autResult = "";
		for (i = 97; i < 101; i++) {
			if (receive[i] == null)
				break;
			autResult += receive[i];
		}
		String ResultText = "";
		for (i = 107; i < receive.length; i++) {
			if (receive[i] == null)
				break;
			ResultText += receive[i];
		}
		
		logger.info("AUTH " + ResultText);
		logger.info("AUTHResult " + autResult);
		return autResult.equals("0000");
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean doBatch() {
		if (getException() != null) {
			return false;
		}
		String[] receive = new String[354]; //353
		requestID = getRequestID();
		byte[] send = new byte[85]; //83
		short size = 83;
		byte first = (byte) (size >> 8);
		byte second = (byte) size;
		send[0] = first;
		send[1] = second;
		send[2] = 0x70;
		send[3] = 0x00;
		send[4] = 0x00;
		send[5] = 0x00;
		send[6] = 0x00;
		//header
		addBytes(INTERFACE_VERSION, 0, INTERFACE_VERSION.length(), send, 7);
		addBytes(merchantID, 0, merchantID.length(), send, 10);
		addBytes(terminalID, 0, terminalID.length(), send, 26);
		addBytes(requestID, 0, requestID.length(), send, 35);
		send[62] = BATCH;
		addBytes(batchNum, 0, batchNum.length(), send, 63);
		int i;
		try {
			Socket sockete = new Socket(realPayAddress, realPayPort);
			sockete.setSoTimeout(TIMEOUT);
			//System.out.println("sending...");
			//logBytes(send);
			OutputStream out = sockete.getOutputStream();
			InputStream in = sockete.getInputStream();
			out.write(send);
			//System.out.println("receiving...");
			if (in != null) {
				int x = -1;
				for (i = 0;(x = in.read()) != -1; i++) {
					if (i == receive.length)
						break;
					receive[i] = getChar(x);
					//System.out.print(i+"-"+receive[i]);
				}
			}
			in.close();
			out.close();
			sockete.close();
		} catch (Exception e) {
			setException(e);
			System.out.println("doBatch " + e.getMessage());
		}
		traID = "";
		for (i = 63; i < 84; i++) {
			if (receive[i] == null)
				break;
			traID += receive[i];
		}
		batResult = "";
		for (i = 91; i < 96; i++) {
			if (receive[i] == null)
				break;
			batResult += receive[i];
		}
		String ReasonCode = "";
		for (i = 96; i < 101; i++) {
			if (receive[i] == null)
				break;
			ReasonCode += receive[i];
		}
		//System.out.println("ReasonCode: "+ReasonCode);
		String ResultText = "";
		for (i = 101; i < receive.length; i++) {
			if (receive[i] == null)
				break;
			ResultText += receive[i];
		}
		//System.out.println("Batch: "+ResultText);
		return batResult.equals("0000");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean doSale() {
		logger.info("haciendo doSale");
		setException(null);
		byte send[];
		String receive[];
		requestID = getRequestID();
		send = new byte[179];
		receive = new String[361];
		short size = 177;
		byte first = (byte) (size >> 8);
		byte second = (byte) size;
		send[0] = first;
		send[1] = second;
		send[2] = 0x70;
		send[3] = 0x00;
		send[4] = 0x00;
		send[5] = 0x00;
		send[6] = 0x00;
		//header
		logger.info("haciendo header");
		addBytes(INTERFACE_VERSION, 0, INTERFACE_VERSION.length(), send, 7);
		addBytes(merchantID, 0, merchantID.length(), send, 10);
		addBytes(terminalID, 0, terminalID.length(), send, 26);
		addBytes(requestID, 0, requestID.length(), send, 35);
		send[62] = SALE;
		addBytes(this.autID, 0, this.autID.length(), send, 63);
		addBytes(this.amount, 0, this.amount.length(), send, 84);
		int i;
		try {
			logger.info(
				"haciendo sockete a: " + realPayAddress + "," + realPayPort);
			Socket sockete = new Socket(realPayAddress, realPayPort);
			sockete.setSoTimeout(TIMEOUT);
			logger.info("sending...");
			OutputStream out = sockete.getOutputStream();
			InputStream in = sockete.getInputStream();
			out.write(send);
			//logBytes(send);
			logger.info("receiving...");
			if (in != null) {
				int x = -1;
				for (i = 0;(x = in.read()) != -1; i++) {
					if (i == receive.length) {
						break;
					}
					receive[i] = getChar(x);
					//System.out.print(receive[i]);
				}
			}
			in.close();
			out.close();
			sockete.close();
		} catch (Exception e) {
			setException(e);			
			logger.error("doSale " + e.getMessage());
			logger.error(e);
		}
		traID = "";
		for (i = 63; i < 84; i++) {
			if (receive[i] == null)
				break;
			traID += receive[i];
		}
		salResult = "";
		for (i = 97; i < 101; i++) {
			if (receive[i] == null)
				break;
			salResult += receive[i];
		}
		String ResultText = "";
		for (i = 107; i < receive.length; i++) {
			if (receive[i] == null)
				break;
			ResultText += receive[i];
		}
		//System.out.println("Sale "+salResult+"-"+ResultText);	
		logger.info("Sale " + salResult + "-" + ResultText);
		return salResult.equals("0000");
	}
	
	
	/**
	 * 
	 * @param str
	 * @param max
	 * @return
	 */
	private String fillWithZeros(String str, int max) {
		if (str.length() < max) {
			for (int i = str.length(); i < max; i++)
				str = "0" + str;
		}
		return str;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAutorizationID() {
		return autID;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAutorizationResult() {
		return autResult;
	} 
	
	/**
	 * 
	 * @return
	 */
	public String getBatchResult() {
		return batResult;
	}
	
	/**
	 * 
	 * @param ascc
	 * @return
	 */
	private String getChar(int ascc) {
		if (ascc == 0) {
			return null;
		} else {
			return (new Character((char) ascc)).toString();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Exception getException() {
		return this.e;
	}
	
	/**
	 * 
	 * @return
	 */
	private String getRequestID() {
		String reqid = "";
		for (int i = 0; i < 26; i++)
			reqid = reqid + String.valueOf(Math.round(Math.random() * 10D));
		return reqid;
	} 
	
	/**
	 * 
	 * @return
	 */
	public String getSaleResult() {
		return salResult;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTransactionID() {
		return traID;
	}
	
	/**
	 * 
	 * @param bytes
	 */
	private void logBytes(byte bytes[]) {
		int x = 0;
		byte tempbytes[] = new byte[16];
		for (int i = 2; i < bytes.length; i++) {
			tempbytes[x] = bytes[i];
			x++;
			String temp = Integer.toHexString(bytes[i]);
			if (temp.length() == 1)
				temp = "0" + temp;
			if (x == 8 || x == 16) {
				if (x == 8) {
					System.out.print(temp + " - ");
				} else {
					System.out.print(temp + " ");
					x = 0;
					System.out.print("[");
					for (int y = 0; y < 16; y++)
						System.out.print(
							(new Character((char) tempbytes[y])).toString());
					System.out.println("]");
				}
			} else {
				System.out.print(temp + " ");
			}
		}
		System.out.print("[");
		for (int y = 0; y < 16; y++)
			System.out.print((new Character((char) tempbytes[y])).toString());
		System.out.println("]");
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void setAmount(String amount) {
		if (amount == null
			|| !Tools.isNumber(amount)
			|| amount.length() > 12) {
			setException(new Exception("Error en el monto"));
		} else {
			amount = Tools.replace(amount, ",", "");
			if (!Tools.isNumber(amount)) {
				amount = "00";
			} else {
				int decimalPos = amount.indexOf(".");
				if (decimalPos == -1) {
					amount += "00";
				} else {
					int cantDec = (amount.length() - 1) - decimalPos;
					if (cantDec > 2) {
						amount = amount.substring(0, decimalPos + 3);
					}
					if (cantDec < 2) {
						for (int i = cantDec; i < 2; i++) {
							amount += "0";
						}
					}
					amount = Tools.replace(amount, ".", "");
				}
			}
			this.amount = fillWithZeros(amount, 12);
		}
	} 
	
	/**
	 * 
	 * @param autID
	 */
	public void setAutorizationID(String autID) {
		if (autID != null) {
			this.autID = autID;
		}
	} 
	
	/**
	 * 
	 * @param batch
	 */
	public void setBatch(int batch) {
		this.batch = batch;
		this.batchNum = fillWithZeros(String.valueOf(this.batch), 6);
	}
	
	/**
	 * 
	 * @param card
	 */
	public void setCard(String card) {
		if (card == null || card.length() > 20) {
			setException(new Exception("Error en número de tarjeta"));
		} else {
			this.card = card;
		}
	} 
	
	/**
	 * 
	 * @param e
	 */
	private void setException(Exception e) {
		this.e = e;
	} 
	
	/**
	 * 
	 * @param merchantID
	 */
	public void setMerchantID(String merchantID) {
		if (merchantID == null || merchantID.length() > 16) {
			setException(new Exception("Error en el MerchantID"));
		} else {
			this.merchantID = merchantID;
		}
	} 
	
	/**
	 * 
	 * @param month
	 */
	public void setMonth(String month) {
		if (month == null || month.length() > 2 || !Tools.isNumber(month)) {
			setException(new Exception("Error en el mes"));
		} else {
			this.month = fillWithZeros(month, 2);
		}
	} 
	
	/**
	 * 
	 * @param order
	 */
	public void setOrder(String order) {
		if (order != null) {
			this.order = Tools.right(order, 20);
		}
	} 
	
	
	/**
	 * 
	 * @param terminalID
	 */
	public void setTerminalID(String terminalID) {
		if (terminalID == null || terminalID.length() > 9) {
			setException(new Exception("Error en el terminalID"));
		} else {
			this.terminalID = terminalID;
		}
	} 
	
	/**
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		
		if (year.length() == 4) {
			year = year.substring(2);
		}
		
		if (year == null || year.length() > 2 || !Tools.isNumber(year)) {
			setException(new Exception("Error en el año"));
		} else {
			this.year = fillWithZeros(year, 2);
		}
	}
}
