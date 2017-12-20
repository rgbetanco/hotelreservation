/*
 * Created on Jun 14, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.nicahost.common.config.bean.InitParameterMapBean;
import com.nicahost.common.creditcard.dto.AutResponseDTO;
import com.nicahost.common.creditcard.exception.CreditCardException;
import com.nicahost.common.creditcard.service.CreditCardService;
import com.nicahost.common.creditcard.service.IRealPay;
import com.nicahost.common.exception.SbeException;
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitParamBean;
import com.nicahost.module.hotelreserve.config.bean.HotelReserveInitParamDAO;
import com.nicahost.module.hotelreserve.dao.HotelReserveDAO;
import com.nicahost.module.hotelreserve.dto.ClientDTO;
import com.nicahost.module.hotelreserve.dto.ReserveDTO;
import com.nicahost.module.hotelreserve.dto.RoomDTO;
import com.nicahost.module.hotelreserve.dto.RoomReservationDTO;
import com.nicahost.module.hotelreserve.dto.Step01DTO;
import com.nicahost.module.hotelreserve.exception.EmptyResultException;
import com.nicahost.module.hotelreserve.exception.InsertUpdateSQLException;
import com.nicahost.module.hotelreserve.view.ConfirmView;
import com.nicahost.module.hotelreserve.view.PlacedReservationView;
import com.nicahost.module.hotelreserve.view.ReservedRoomView;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HotelReserveService {
	static Logger log = Logger.getLogger(HotelReserveService.class);
	private static HotelReserveService hotelReserveService = null;
	private static String NO_AVAILABLE_ROOMS = "error.noavailablerooms";
	private static String ERROR_GENERAL_KEY = "error.general";
	private static String ERROR_INSERTUPDATE_KEY = "error.insertupdate"; 
	private static String NO_PLACED_RESERVATIONS_KEY = "error.noplacedreservations";

	/**
	 * constructor por defecto. Es privado para permitir el singleton
	 *
	 */
	private HotelReserveService() { /*empty constructor*/
	}

	/**
	 * Implementacion del metodo getInstance() para obtener una
	 * instancia singleton
	 * @return HotelReserveService
	 */
	public static HotelReserveService getInstance() {

		if (hotelReserveService == null) {
			hotelReserveService = new HotelReserveService();
		}
		return hotelReserveService;
	}

	/**
	 * Esta clase retorna los tipos de rooms del hotel
	 * @return Un <code>Collection</code> de objetos de tipo RoomTypeView
	 * @throws Exception
	 */

	public Collection getRoomTypes() throws Exception {
		ArrayList result = new ArrayList();

		String element;
		Map roomTypes= HotelReserveInitParamDAO.getInstance().getRoomTypes();
		if (roomTypes == null) {
			throw new Exception("No room types");
		}
		Set ids = roomTypes.keySet();			
		for (Iterator iter = ids.iterator(); iter.hasNext();) {
			element = (String) iter.next();

			result.add(new OptionView((String) roomTypes.get(element), element));
		}
		
		Collections.sort(result);

		return result;

	}
	
	public String getRoomTypeName(String id) {
		return (String) HotelReserveInitParamDAO.getInstance().getRoomTypes().get(id);
	}

	public Collection getCountry() throws Exception {
		List result = new ArrayList();

		String element;
		Map countries = HotelReserveInitParamDAO.getInstance().getCountries();

		Set ids = countries.keySet();			
		for (Iterator iter = ids.iterator(); iter.hasNext();) {
			element = (String) iter.next();
			
			result.add(new OptionView((String) countries.get(element), element));
		}
		
		Collections.sort(result);
		
		return result;
	}

	
	public Collection getLanguage() throws Exception {
		List result = new ArrayList();

		String element;
		Map languages = HotelReserveInitParamDAO.getInstance().getLanguages();

		Set ids = languages.keySet();			
		for (Iterator iter = ids.iterator(); iter.hasNext();) {
			element = (String) iter.next();
			
			result.add(new OptionView((String) languages.get(element), element));
		}
		
		Collections.sort(result);
		
		return result;
	}	
	
	public String getCountryLanguage(String langSymbol) {
		return (String) HotelReserveInitParamDAO.getInstance().getCountryLanguage().get(langSymbol);
	}
	

	public Collection getEthnicity() throws Exception {
		List result = new ArrayList();

		String element;
		Map ethnicities = HotelReserveInitParamDAO.getInstance().getEthnicities();

		Set ids = ethnicities.keySet();			
		for (Iterator iter = ids.iterator(); iter.hasNext();) {
			element = (String) iter.next();
			result.add(new OptionView((String) ethnicities.get(element), element));	
		}
		
		Collections.sort(result);
		return result;
	}
	
	public int getDefaultNights() {
		int numNights = 2;
		try {
		
			String nights =	(String) HotelReserveInitParamBean.getInstance().getList().get(HotelReserveInitParamBean.DEFAULT_NIGHTS);
			numNights = Integer.parseInt(nights);	
		} catch (Exception ex) {/* Do nothing */}
		
		return numNights;
	}
	

	public Map getAvailableRooms(
		String roomTypeParm,
		Calendar checkInDateParm,
		Calendar checkOutDateParm)
		throws Exception, EmptyResultException {

		Map resultMap;
		Step01DTO step01 = new Step01DTO();
		step01.setRoomType(Integer.parseInt(roomTypeParm));
		step01.setDateTimeIn(this.parseDate(checkInDateParm).longValue());
		step01.setDateTimeOut(this.parseDate(checkOutDateParm).longValue());
		
		HotelReserveDAO hotelReserveDAO = new HotelReserveDAO();
		
		resultMap = hotelReserveDAO.getAvailability(step01);
		//TODO: convertir los dtos que vienen la colecion a views. HJ
		if (resultMap.isEmpty()) {
			throw new EmptyResultException(NO_AVAILABLE_ROOMS);
		}
		
		return resultMap;
	}
	
	public String daysDiff(Calendar initDate, Calendar endDate) {
		String result = convertMilliToDays(this.parseDate(initDate),this.parseDate(endDate));
		return result;
	}
	
	/**
	 * 
	 * @param intParam
	 * @return Collection with all the photos avilables for the available room 
	 */
	public Collection getPhotoGallery(String idRoomParm) throws Exception {
		Collection result;
		HotelReserveDAO hotelReserveDAO = new HotelReserveDAO();
		result = hotelReserveDAO.getGallery(idRoomParm);
		return result;
	}

	public Collection getReservation() throws Exception {
		Collection result;
		HotelReserveDAO hotelReserveDAO = new HotelReserveDAO();
		result = hotelReserveDAO.getRoomReservations();
		return result;
	}



	public ConfirmView processReservation(ReserveDTO reserveDTO) throws Exception {
		ArrayList roomsToReserve = new ArrayList();
		ClientDTO clientDTO = new ClientDTO();
		RoomReservationDTO roomReserveDTO;
				
		BeanUtils.copyProperties(clientDTO, reserveDTO);

		String[] roomIds = reserveDTO.getSelectedIdRooms();
		String roomId;
		
		ArrayList selectedRooms = (ArrayList) reserveDTO.getSelectedRooms();
		Map getPriceMap = new HashMap();
		RoomDTO element;
		for (Iterator iter = selectedRooms.iterator(); iter.hasNext();) {
			element = (RoomDTO) iter.next();			
			getPriceMap.put(Long.toString(element.getId()),element);
		}
		
		String daysDiff = this.daysDiff(reserveDTO.getInitDateCal(),reserveDTO.getEndDateCal());
		double total = 0;
		double price;
		double grandTotal = 0;
		for (int i = 0; i < roomIds.length; i++) {
			roomId = roomIds[i].toString();
			roomReserveDTO = new RoomReservationDTO();
			roomReserveDTO.setRoomId(roomId);
			roomReserveDTO.setCheckInDate(reserveDTO.getInitDateCal());
			roomReserveDTO.setCheckOutDate(reserveDTO.getEndDateCal());
			roomReserveDTO.setEmail1(reserveDTO.getEmail1());
			roomReserveDTO.setComment(reserveDTO.getComment());		
			//roomReserveDTO.setGuest(reserveDTO.getAdult());
			price = ((RoomDTO) getPriceMap.get(roomId)).getPrice();	
			total = this.computeTotal(daysDiff, price);
			grandTotal += total;			
			roomReserveDTO.setTotal(total);			
			roomsToReserve.add(roomReserveDTO);
		}		
		
		String tl = Double.toString(grandTotal);
		CreditCardService creditCardService = CreditCardService.getInstance();
		AutResponseDTO response = new AutResponseDTO();
		
		// Codigo para pagar usando el CGI
		InitParameterMapBean param = HotelReserveInitParamBean.getInstance().getList();
		String datFile = param.getValue(HotelReserveInitParamBean.REALPAY_DAT);
		try {
			
				response = creditCardService.verifyWithCGI(reserveDTO.getCardNumber(),reserveDTO.getCardMonth(),reserveDTO.getCardYear(),tl, datFile);
		} catch (CreditCardException ccex) {
			log.info(" RealPay error code: " + ccex.getMessageKey());
			//throw new CreditCardException(IRealPay.getKeyMessage(ccex.getMessageKey()));
		}
		
		// Codigo para pagar usando RealPay
		/*
		InitParameterMapBean param = HotelReserveInitParamBean.getInstance().getList();
		String merchantId = param.getValue(HotelReserveInitParamBean.MARCHANTID);
		String terminalId = param.getValue(HotelReserveInitParamBean.TERMINALID);
		
		try {
			response = creditCardService.verify(terminalId,merchantId,reserveDTO.getCardNumber(),reserveDTO.getCardMonth(),reserveDTO.getCardYear(),tl);
		} catch (CreditCardException ccex) {
			log.info(" RealPay error code: " + ccex.getMessageKey());
			throw new CreditCardException(IRealPay.getKeyMessage(ccex.getMessageKey()));
		}
		*/
		
		ArrayList reservedRoomsView = new ArrayList();
		String confirmCode = null;
		
/*		if (response.getResultCode().equals(IRealPay.ERRCODE_0000)) {
			confirmCode = response.getTransactionId();
*/
		if (true) {
			confirmCode = "123456789";
			insertOrUpdateClient(clientDTO);		
			reservedRoomsView = reserveRooms(roomsToReserve,confirmCode);
		
			ReservedRoomView view;
			RoomDTO roomDTO;
			
			for (Iterator iter = reservedRoomsView.iterator(); iter.hasNext();) {
				view = (ReservedRoomView) iter.next();
				confirmCode = view.getConfirmationId();
				roomDTO = (RoomDTO) getPriceMap.get(view.getRoomId());
				view.setPrice(roomDTO.getPrice());
				view.setDescription(roomDTO.getDescription());						
			}	
			
		} else { /* Si no se pudo autorizar generar una exception */
			log.info(response.getTransactionId());
			throw new CreditCardException(response.getTransactionId());
			
		}

		ConfirmView reserveView = new ConfirmView();
		reserveView.setAddress(reserveDTO.getAddress());
		reserveView.setCardNumberEnc(reserveDTO.getCardNumber());
		reserveView.setCardType(reserveDTO.getCardType());
		reserveView.setCity(reserveDTO.getCity());
		reserveView.setCountry(reserveDTO.getCountry());
		reserveView.setEmail(reserveDTO.getEmail1());
		reserveView.setEndDateCal(reserveDTO.getEndDateCal());
		reserveView.setExpDate(reserveDTO.getCardMonth() + "/" + reserveDTO.getCardYear());
		reserveView.setFirstName(reserveDTO.getFirstName());
		reserveView.setInitDateCal(reserveDTO.getInitDateCal());
		reserveView.setLastName(reserveDTO.getLastName());
		reserveView.setNumNights(daysDiff);
		//reserveView.setNumPersons(reserveDTO.getAdult());
		reserveView.setRoomTypeName(this.getRoomTypeName(reserveDTO.getRoomTypeId()));
		reserveView.setSelectedRooms(reservedRoomsView);
		reserveView.setZip(reserveDTO.getZip());
		reserveView.setConfirmationCode(confirmCode);
		
		return reserveView;
	}
	
	public boolean insertOrUpdateClient(ClientDTO dto) throws InsertUpdateSQLException, SbeException {
		HotelReserveDAO dao = new HotelReserveDAO();
		boolean success = false;
		try {
			success = dao.insertUpdateCliente(dto);
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage(),sqlex);
			SbeException sbex = new SbeException(ERROR_GENERAL_KEY);			
			throw sbex;
		}
		
		if (!success) {
			InsertUpdateSQLException iuex = new InsertUpdateSQLException(ERROR_INSERTUPDATE_KEY);
			throw iuex;
		}
				
		return success;
		
	}
	
	/**
	 * @deprecated
	 * @param list
	 * @return
	 * @throws SbeException
	 */
	public ArrayList reserveRooms(ArrayList list) throws SbeException {
		ArrayList result;
		HotelReserveDAO dao = new HotelReserveDAO();
		
		try {		
			result = dao.reserveRooms(list);
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage(),sqlex);
			SbeException sbex = new SbeException(ERROR_GENERAL_KEY);			
			throw sbex;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param list
	 * @param confirmationId
	 * @return
	 * @throws SbeException
	 */
	public ArrayList reserveRooms(ArrayList list, String confirmationId) throws SbeException {
		ArrayList result;
		HotelReserveDAO dao = new HotelReserveDAO();
		
		try {		
			result = dao.reserveRooms(list, confirmationId);
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage(),sqlex);
			SbeException sbex = new SbeException(ERROR_GENERAL_KEY);			
			throw sbex;
		}
		
		return result;
	}	
	
	public boolean cancelReservation(String email, String code) throws SbeException, InsertUpdateSQLException {
		boolean success = false;
		HotelReserveDAO dao = new HotelReserveDAO();
		try {
			success = dao.cancelReservation(email,code);
				
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage(),sqlex);
			SbeException sbex = new SbeException(ERROR_GENERAL_KEY);			
			throw sbex;
		}
		
			if (!success) {
				throw new InsertUpdateSQLException(ERROR_GENERAL_KEY);
			}
				
		return success;
	}
	
	public Collection getPlacedReservation(String email, String code) throws SbeException, EmptyResultException {
		ArrayList result = new ArrayList();
		HotelReserveDAO dao = new HotelReserveDAO();
		
		try {
			result = dao.getPlacedReservation(email,code);
			
			for (Iterator iter = result.iterator(); iter.hasNext();) {
				PlacedReservationView element = (PlacedReservationView) iter.next();
				element.setNumNights(this.daysDiff(element.getCheckInDate(),element.getCheckOutDate()));
				element.setRoomTypeName(this.getRoomTypeName(element.getRoomTypeId()));
			}
			
		} catch (SQLException sqlex) {
			log.error(sqlex.getMessage(),sqlex);
			SbeException sbex = new SbeException(ERROR_GENERAL_KEY);			
			throw sbex;
		}
		
		if (result.size() == 0) {
			throw new EmptyResultException(NO_PLACED_RESERVATIONS_KEY);
		}
				
		return result;
	}

	public double computeTotal(String days, String roomPrice) {
		int numDays = Integer.parseInt(days);
		double price = Double.parseDouble(roomPrice);		
		double result = numDays * price;
		
		return result;
	}

	public double computeTotal(String days, double roomPrice) {
		int numDays = Integer.parseInt(days);
				
		double result = numDays * roomPrice;
		
		return result;
	}


	private Long parseDate(Calendar dateParam) {

		long millis = dateParam.getTime().getTime();
		Long result = new Long(millis);

		return result;
	}

	
	private String convertMilliToDays(Long initDate, Long endDate) {
		long numFinParm = endDate.longValue();
		long numIniParm = initDate.longValue();
		
		long numNights = (numFinParm - numIniParm) / (1000 * 60 * 60 * 24);
		
		String result = Long.toString(numNights);
		
		return result;
	}

}