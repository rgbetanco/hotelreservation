/*
 * Created on Nov 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.creditcard.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.nicahost.common.config.bean.GlobalParametersBean;
import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.creditcard.dto.AutRequestDTO;
import com.nicahost.common.creditcard.dto.AutResponseDTO;
import com.nicahost.common.creditcard.dto.SaleResponseDTO;
import com.nicahost.common.creditcard.exception.CreditCardException;
import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;
import com.nicahost.common.util.Tools;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitParamBean;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CGI {
	static Logger logger = Logger.getLogger(CGI.class);
	
	private static final String PARAM_DATPATH = "-P";
	private static final String SPACE = " ";
	private static final String AUT = "aut";
	private static final String SAL = "sal";
	private static final String DOUBLEQUOTE = "\"";
	
	/**
	 * 
	 */
	public CGI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutResponseDTO doAuth(AutRequestDTO request, String datFile) throws CreditCardException {
		
		
		AutResponseDTO prop = this.execCliAut(request.getCardNumber(),request.getMonth(),request.getYear(),request.getAmount(), datFile);

		return prop;
	}
	
	public SaleResponseDTO doSale(AutRequestDTO request, String datPath) throws CreditCardException {
		SaleResponseDTO result = new SaleResponseDTO();
		
		// Hago primero una autorizacion para obtener el transaction id
		AutResponseDTO prop = this.execCliAut(request.getCardNumber(),request.getMonth(),request.getYear(),request.getAmount(), datPath);
		
		//Hago en firme la transaccion
		if (!prop.getResultCode().equals(IRealPay.ERRCODE_0000)) {
			result = this.execCliSal(prop.getTransactionId(),prop.getAmount());
		}
			
		
		
		return result;
	}
	
	/**
	 * Realiza una autorizacion en RealPay utilizando el CGI
	 * @return Properties Resultado
	 */
	private AutResponseDTO execCliAut(String card, String month, String year, String value, String dat) throws CreditCardException {
	  Runtime rt = null;
	  value = Tools.replace(value, ".", "");
	  value = Tools.replace(value, ",", "");
	  
	  if (year.length() == 4) {
	  	year = year.substring(2);
	  }

	  AutResponseDTO result = new AutResponseDTO();
	  Process proc = null;
	  try {
		rt = Runtime.getRuntime();
		//System.out.println(pay_Constants.getCGIPath()+merchant+" "+terminal+" aut "+card+" "+month+" "+year+" "+value+" "+order);
		InitParameterMapBean param = GlobalParametersBean.getInstance().getList();
		String cgiPath = param.getValue(GlobalParametersBean.REALPAY_CGI);
		String datPath = dat;
		IPathConverter pathConverter = new PathConverter();
		cgiPath = pathConverter.getAbsolutePath(cgiPath);
		datPath = pathConverter.getAbsolutePath(datPath);
		
		StringBuffer command = new StringBuffer();
		command.append(cgiPath).append(SPACE);
		command.append(AUT).append(SPACE);
		command.append(card).append(SPACE);
		command.append(month).append(SPACE);
		command.append(year).append(SPACE);
		command.append(value).append(SPACE);
		//:TODO Investigar el tipo de sistema operativo. Henry Jiron
		command.append(PARAM_DATPATH).append(DOUBLEQUOTE).append(datPath);
		
		//proc = rt.exec(Constants.getCGIPath() + merchant + " " + terminal + " aut " + card + " " + month + " " + year + " " + value + " " + order);
		logger.debug(command.toString());
		proc = rt.exec(command.toString());
		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String input;
		while (true) {
		  try {
			int row = 0;
			while ((input = br.readLine()) != null) {
			  if (row == 0) {			
			  	logger.debug(input);  	
			  	result.setResultCode(input.substring(0, 4));
			  	result.setTransactionId(input.substring(13, input.length()));
			  }
			  row++;
			}
			br.close();
		  } catch (Exception e) {
			logger.error("CLI-AUT " + e.getMessage());
			throw new CreditCardException(e);
			//break;
		  }
		  //proc.destroy();
		  break;
		}
	  } catch (Exception e) {
		logger.error("tools.execCliAut.Exception " + e.getMessage());
		throw new CreditCardException(e);
	  } finally {
		rt = null;
		if (proc != null)
		  proc.destroy();
	  }
	  return result;
	}



	private SaleResponseDTO execCliSal(String tran, String amount) throws CreditCardException {
	  Runtime rt = null;
	  amount = Tools.replace(amount, ".", "");
	  amount = Tools.replace(amount, ",", "");
	  
	  SaleResponseDTO responseDTO = new SaleResponseDTO();

	  Process proc = null;
	  try {
		rt = Runtime.getRuntime();
		InitParameterMapBean param = GlobalParametersBean.getInstance().getList();
		String cgiPath = param.getValue(GlobalParametersBean.REALPAY_CGI);
		String datPath = param.getValue(HotelReserveInitParamBean.REALPAY_DAT);
		IPathConverter pathConverter = new PathConverter();
		cgiPath = pathConverter.getAbsolutePath(cgiPath);
		datPath = pathConverter.getAbsolutePath(datPath);
		
		StringBuffer command = new StringBuffer();
		command.append(cgiPath).append(SPACE);
		command.append(SAL).append(SPACE);
		command.append(tran).append(SPACE);
		command.append(amount).append(SPACE);
		//:TODO Investigar el tipo de sistema operativo. Henry Jiron
		command.append(PARAM_DATPATH).append(DOUBLEQUOTE).append(datPath);

		logger.debug(command.toString());
		proc = rt.exec(command.toString());

		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String input;
		while (true) {
		  try {
			int row = 0;
			while ((input = br.readLine()) != null) {			  
			  if (row == 0) {
			  	responseDTO.setResultCode(input.substring(0, 4));
				responseDTO.setTransactionId(input.substring(5, input.length()));				
			  }
			  row++;
			}
			br.close();
		  } catch (Exception e) {
			logger.error("CGI Fallo por " + e.getMessage());
			throw new CreditCardException(e);
			//break;
		  }

		  // proc.destroy();
		  break;
		}

	  } catch (Exception e) {
		logger.error("tools.execCliSal.Exception " + e.getMessage());
		responseDTO.setResultCode("FAILED");
		responseDTO.setTransactionId(tran);
		throw new CreditCardException(e);
	  } finally {
		rt = null;
		if (proc != null)
		  proc.destroy();
	  }
	  return responseDTO;
	}

}
