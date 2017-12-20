/*
 * Created on Nov 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.creditcard.service;

import com.nicahost.common.creditcard.dto.AutRequestDTO;
import com.nicahost.common.creditcard.dto.AutResponseDTO;
import com.nicahost.common.creditcard.dto.SaleResponseDTO;
import com.nicahost.common.creditcard.exception.CreditCardException;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CreditCardService {
	
	private static CreditCardService instance = null;
	
	private CreditCardService() {
	}
	
	public static CreditCardService getInstance() {
		if (instance == null ) {
			instance = new CreditCardService();
		}		
		return instance;		
	}
	
	/**
	 * 
	 * @param card
	 * @param month
	 * @param year
	 * @param amount
	 * @return
	 * @throws CreditCardException
	 */	
	public AutResponseDTO verifyWithCGI(String card, String month, String year, String amount, String datFile) throws CreditCardException {
		AutRequestDTO request = new AutRequestDTO();
		request.setCardNumber(card);
		request.setMonth(month);
		request.setYear(year);
		request.setAmount(amount);

		AutResponseDTO response = new AutResponseDTO();
		CGI cgi = new CGI();
		response = cgi.doAuth(request, datFile);	 
		//:TODO Uncomment me
		this.proccessError(response.getResultCode());
						
		return response;
	}
	
	/**
	 * 
	 * @param terminalId
	 * @param merchantId
	 * @param card
	 * @param month
	 * @param year
	 * @param amount
	 * @return
	 * @throws CreditCardException
	 */
	public AutResponseDTO verify(String terminalId, String merchantId, String card, String month, String year, String amount) throws CreditCardException {
		AutResponseDTO response = new AutResponseDTO();
		
		RealPayTransaction realPay = new RealPayTransaction();
		realPay.setMerchantID(merchantId);
		realPay.setTerminalID(terminalId);
		realPay.setCard(card);
		realPay.setMonth(month);
		realPay.setYear(year);
		realPay.setAmount(amount);
		realPay.setOrder("1");				//TODO:Todavia no se porque tiene que ser igual a 1
		
		if (realPay.doAuth()) {
			response.setTransactionId(realPay.getAutorizationID().substring(8));
			response.setResultCode(realPay.getAutorizationResult());			
		} else {
			
		}
		
		this.proccessError(response.getResultCode());
				
		return response;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws CreditCardException
	 */
	public boolean verifyWithCGI(AutRequestDTO request, String datFile) throws CreditCardException {

		return this.verifyWithCGI(request.getCardNumber(),request.getMonth(),request.getYear(),request.getAmount(), datFile).equals(IRealPay.ERRCODE_0000);
	}
	
	/**
	 * 
	 * @param terminalId
	 * @param merchantId
	 * @param request
	 * @return
	 * @throws CreditCardException
	 */
	public boolean verify(String terminalId, String merchantId, AutRequestDTO request) throws CreditCardException {
		
		return this.verify(terminalId,merchantId,request.getCardNumber(),request.getMonth(),request.getYear(),request.getAmount()).getResultCode().equals(IRealPay.ERRCODE_0000);
	}

	/**
	 * 
	 * @param card
	 * @param month
	 * @param year
	 * @param amount
	 * @return
	 * @throws CreditCardException
	 */
	public SaleResponseDTO charge(String card, String month, String year, String amount, String datFile) throws CreditCardException {
		AutRequestDTO request = new AutRequestDTO();
		request.setCardNumber(card);
		request.setMonth(month);
		request.setYear(year);
		request.setAmount(amount);

		CGI cgi = new CGI();
		SaleResponseDTO response = cgi.doSale(request, datFile);

		this.proccessError(response.getResultCode());
						
		return response;		
	}
	
	/**
	 * 
	 * @param terminalId
	 * @param merchantId
	 * @param card
	 * @param month
	 * @param year
	 * @param amount
	 * @return
	 * @throws CreditCardException
	 */
	public SaleResponseDTO charge(String terminalId, String merchantId, String card, String month, String year, String amount) throws CreditCardException {
		SaleResponseDTO response = new SaleResponseDTO();
		
		RealPayTransaction realPay = new RealPayTransaction();
		realPay.setMerchantID(merchantId);
		realPay.setTerminalID(terminalId);
		realPay.setCard(card);
		realPay.setMonth(month);
		realPay.setYear(year);
		realPay.setAmount(amount);
		realPay.setOrder("1");				//TODO:Todavia no se porque tiene que ser igual a 1
		
		if (realPay.doAuth()) {
			
			if (realPay.doSale()) {
				response.setTransactionId(realPay.getTransactionID());
				response.setResultCode(realPay.getSaleResult());				
			}
						
		} else {
			response.setResultCode(realPay.getAutorizationResult());
		}
		
		this.proccessError(response.getResultCode());
		
		return response;		
			
	}


	/**
	 * 
	 * @param request
	 * @return
	 * @throws CreditCardException
	 */
	public boolean charge(AutRequestDTO request, String datFile) throws CreditCardException {
		
		return this.charge(request.getCardNumber(),request.getMonth(),request.getYear(),request.getAmount(), datFile).getResultCode().equals(IRealPay.ERRCODE_0000);
	}
	
	/**
	 * 
	 * @param terminalId
	 * @param merchantId
	 * @param request
	 * @return
	 * @throws CreditCardException
	 */
	public boolean charge(String terminalId, String merchantId, AutRequestDTO request) throws CreditCardException {
		
		return this.charge(terminalId,merchantId,request.getCardNumber(),request.getMonth(),request.getYear(),request.getAmount()).getResultCode().equals(IRealPay.ERRCODE_0000);
	}
	
	
	private void proccessError(String errCode) throws CreditCardException {
		String rc = errCode;
		if (!rc.equals(IRealPay.ERRCODE_0000)) {
			throw new CreditCardException(errCode);	 
		}		
	}
}
