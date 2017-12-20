/*
 * Created on Jul 16, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dbase.wrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.module.hotelreserve.dto.ClientDTO;

/**
 * @author Henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ClientInsertWrapper  extends DBBaseDAO {
	//<-- Primary key
	private String email1;
	// Primary key -->
	private String firstName;
	private String lastName;
	private String address;
	private int ethnicity;
	private int country;
	private String city;
	private String zip;
	private String phone;	
	private String creditCard;
	private String cardHoldername;
	private String dueDate;
	//Fields' size
	private static final int FIRSTNAME_SZ = 64;
	private static final int LASTNAME_SZ = 64;
	private static final int ADDRESS_SZ = 128;
	private static final int PHONE_SZ = 16;
	private static final int EMAIL_SZ = 96;
	private static final int CITY_SZ = 28;
	private static final int ZIP_SZ = 10;

	static Logger log = Logger.getLogger(ClientInsertWrapper.class);
	
	private static final String DBASEKEY = "dsHotel";
	private static final String INSERT_CLIENTE_SQL =
		//						1		2		 3			4		5			6			7		8			  9		10	11	  12
		"insert into clientes (email,firstname,lastname,countryid,ethnicityid,creditcard,duedate,cardholdername,address,city,zip,phone)" +
		" values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
	private static final String UPDATE_CLIENTE_SQL =
			//						1		2		 3			4		5			6			7		8			  9		10	11	  12
		"update clientes set firstname=?,lastname=?,countryid=?,ethnicityid=?,creditcard=?,duedate=?,cardholdername=?,address=?,city=?,zip=?,phone=? " +
		" where email = ?";
		
	private static final String SELECTCOUNT_CLIENTE_SQL =
		"select count(*) as tupla from clientes where email = ?";
			
	/**
	 * 
	 */
	public ClientInsertWrapper() {
		super();
		initialize();

	}
	
	public ClientInsertWrapper(ClientDTO clientDto) {
		this();
		setAddress(clientDto.getAddress());
		setCity(clientDto.getCity());
		setCountry(clientDto.getCountry());
		setEmail1(clientDto.getEmail1());
		//setEthnicity(clientDto.getEthnicity());
		setFirstName(clientDto.getFirstName());
		setLastName(clientDto.getLastName());
		setPhone(clientDto.getPhone());
		setZip(clientDto.getZip());
		setCardHoldername(clientDto.getCardHolder());
		setCreditCard(clientDto.getCardNumber());
		setDueDate(clientDto.getCardMonth()+ "/" + clientDto.getCardYear());		
	}
	
	protected int executeSQLCount() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(SELECTCOUNT_CLIENTE_SQL);
			ps.setString(1,email1);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			try {
				closeConnection(ps,conn);
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error(ex.getMessage());
			}
		}
		
		return result;
	}
	
	protected boolean executeSQLUpdate() throws SQLException {
		PreparedStatement ps = null;	
		Connection conn = null;
		
		boolean result=false;

		try {			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(UPDATE_CLIENTE_SQL);				

			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setInt(3,country);
			ps.setInt(4,ethnicity);
			ps.setString(5,creditCard);
			ps.setString(6,dueDate);
			ps.setString(7,cardHoldername);
			ps.setString(8,address);
			ps.setString(9,city);
			ps.setString(10,zip);
			ps.setString(11,phone);
			ps.setString(12,email1);
			result = ps.executeUpdate()>0?true:false;
		} finally {
			try {				
				closeConnection(ps,conn);
			} catch (Exception ex) {
					
			}
		}

		
		return result;		
	}
	
	protected boolean executeSQLInsert() throws SQLException {

		PreparedStatement ps = null;	
		Connection conn = null;
		
		boolean result=false;
		

			try {			
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(INSERT_CLIENTE_SQL);				
				ps.setString(1,email1);
				ps.setString(2,firstName);
				ps.setString(3,lastName);
				ps.setInt(4,country);
				ps.setInt(5,ethnicity);
				ps.setString(6,creditCard);
				ps.setString(7,dueDate);
				ps.setString(8,cardHoldername);
				ps.setString(9,address);
				ps.setString(10,city);
				ps.setString(11,zip);
				ps.setString(12,phone);
				result = ps.executeUpdate()>0?true:false;

			} finally {
				try {				
					closeConnection(ps,conn);
				} catch (Exception ex) {
					
				}
			}

		
		return result;
	}

	public boolean execute() throws SQLException {

		boolean result=false;
		
		if (validate()) {
			if (executeSQLCount()>0) {
				result = executeSQLUpdate();
			} else {
				result = executeSQLInsert();
			}
			
		} else {

		}
		
		return result;		
	}


    public boolean execute(ClientDTO clientDto ) throws SQLException {

		ClientInsertWrapper wrapper = new ClientInsertWrapper(clientDto);
		return wrapper.execute();
	}

	protected void initialize() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.ethnicity = 0;
		this.country = 0;
		this.city = "";
		this.zip = "";
		this.phone = "";
		this.email1 = "";
		
	}
	
	protected boolean validate() {
		boolean isOK = false;
		firstName = firstName.length() > FIRSTNAME_SZ?firstName.substring(0,FIRSTNAME_SZ):firstName;
		lastName = lastName.length() > LASTNAME_SZ?lastName.substring(0,LASTNAME_SZ):lastName;
		address = address.length() > ADDRESS_SZ?address.substring(0,ADDRESS_SZ):address;
		phone = phone.length() > PHONE_SZ?phone.substring(0,PHONE_SZ):phone;
		city = city.length() > CITY_SZ?city.substring(0,CITY_SZ):city;
		zip = zip.length() >ZIP_SZ?zip.substring(0,ZIP_SZ):zip;
		
		//no puede truncar el correo.  Si no es del tamanho correcto entonces no
		//va a poder actualizar
		isOK = email1.length()> EMAIL_SZ?false:true;
		
		 return isOK;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getCardHoldername() {
		return cardHoldername;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return
	 */
	public int getCountry() {
		return country;
	}

	/**
	 * @return
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * @return
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @return
	 */
	public String getEmail1() {
		return email1;
	}

	/**
	 * @return
	 */
	public int getEthnicity() {
		return ethnicity;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param string
	 */
	public void setCardHoldername(String string) {
		cardHoldername = string;
	}

	/**
	 * @param string
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param i
	 */
	public void setCountry(int i) {
		country = i;
	}
	
	public void setCountry(String i) {
		try {
			
			country = Integer.parseInt(i);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @param string
	 */
	public void setCreditCard(String string) {
		creditCard = string;
	}

	/**
	 * @param string
	 */
	public void setDueDate(String string) {
		dueDate = string;
	}

	/**
	 * @param string
	 */
	public void setEmail1(String string) {
		email1 = string;
	}

	/**
	 * @param i
	 */
	public void setEthnicity(int i) {
		ethnicity = i;
	}
	
	public void setEthnicity(String i) {
		try {			
			if (i.length()>0 && !i.trim().endsWith("")) 
				ethnicity = Integer.parseInt(i);
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	/**
	 * @param string
	 */
	public void setFirstName(String string) {
		firstName = string;
	}

	/**
	 * @param string
	 */
	public void setLastName(String string) {
		lastName = string;
	}

	/**
	 * @param string
	 */
	public void setPhone(String string) {
		phone = string;
	}

	/**
	 * @param string
	 */
	public void setZip(String string) {
		zip = string;
	}

}
