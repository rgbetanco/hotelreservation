package com.nicahost.module.classified.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;
import com.nicahost.common.util.UniqueIdentifierGenerator;
import com.nicahost.common.util.UtilCrypto;
import com.nicahost.framework.common.view.OptionView;
import com.nicahost.module.classified.bean.AddressBean;
import com.nicahost.module.classified.bean.AdvertisementBean;
import com.nicahost.module.classified.bean.BankAccountBean;
import com.nicahost.module.classified.bean.CountryBean;
import com.nicahost.module.classified.bean.PaymentInfoBean;
import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.bean.RegionBean;
import com.nicahost.module.classified.bean.StateBean;
import com.nicahost.module.classified.dto.AccountDTO;
import com.nicahost.module.classified.dto.CategoryDTO;
import com.nicahost.module.classified.exception.InvalidLoginException;
import com.nicahost.module.classified.exception.NewUserException;
import com.nicahost.module.classified.exception.SellerAccountException;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ClassifiedDAO extends DBBaseDAO {

static Logger log = Logger.getLogger(ClassifiedDAO.class);

private static final String DBASEKEY = "dsClass";			 //El identificador para una conexion con pool
public static final String STATUS_NEWPASSWORD = "3";		//
public static final String STATUS_OK = "0";

	public Map getCategories() throws SQLException {
		Map res = new HashMap();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
/*				
		String sql = "SELECT c.catId, c.catDescription, c.catLabel, c.catIcon, s.id as subId, s.description " +					 "FROM categories c " +					 "LEFT JOIN subcategories s on c.catid = s.catid";
*/
		String sql = "select c.catId, c.catDescription, c.catLabel, c.catIcon, count(a.adCat) as hits, s.id as subId, s.description " +					 "from categories c " +					 "left join ads a on c.catId = a.adCat " +					 "left join subcategories s on c.catid = s.catid " +					 "group by c.catid,s.id, s.description";		
		try { 

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			CategoryDTO catDTO;
			String prev = "";
			String catId;
			while (rs.next()) {
				catId = rs.getString(1);
				
				if (prev.equals(catId)) {					
					((CategoryDTO) res.get(catId)).addSubCategory(rs.getString(6),rs.getString(7));
				} else {
					catDTO = new CategoryDTO();				
					catDTO.setCatId(catId);
					catDTO.setCatDesc(rs.getString(2));
					catDTO.setCatLabel(rs.getString(3));
					catDTO.setCatIcon(rs.getString(4));
					catDTO.setHits(rs.getString(5));
					catDTO.addSubCategory(rs.getString(6),rs.getString(7));
					prev = catId;
					res.put(catDTO.getCatId(),catDTO);
				}
				
					
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}

	public Collection getShippingLocations() throws SQLException {
		List countries = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "SELECT r.regionid, r.regionname, s.stateid, s.statename, c.countryId, c.countryName " +					 "FROM states s, countries c, regions r " +					 "JOIN regionstates rs ON rs.regionid = r.regionid " +					 "WHERE s.stateid = rs.stateid AND c.countryId = r.countryid";
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			String regionId, regionName, stateId, stateName,countryId,countryName;
			CountryBean countryBean = new CountryBean();
			RegionBean regionBean = new RegionBean();
			StateBean stateBean = new StateBean();
			Map regionsTemp = new HashMap(), countriesTemp = new HashMap(), statesTemp = new HashMap(); 
			
			while (rs.next()) {
				regionId = rs.getString(1);
				regionName = rs.getString(2);
				stateId = rs.getString(3);
				stateName = rs.getString(4);
				countryId = rs.getString(5);
				countryName = rs.getString(6);
				
				if (!countriesTemp.containsKey(countryId)) {
					countryBean = new CountryBean(countryId,countryName);
					countriesTemp.put(countryId,countryBean);			
				} else {
					countryBean = (CountryBean) countriesTemp.get(countryId);
				}
				
				if (!regionsTemp.containsKey(regionId)) {
					regionBean = new RegionBean(regionId,regionName);
					regionsTemp.put(regionId,regionBean);
				} else {
					regionBean = (RegionBean) regionsTemp.get(regionId);
				}
				
				if (!statesTemp.containsKey(stateId)) {
					stateBean = new StateBean(stateId,stateName);
					statesTemp.put(stateId,stateBean);
				} else {
					stateBean = (StateBean) statesTemp.get(stateId);
				}
				
				//
				if (!countries.contains(countryBean)) {
					countries.add(countryBean);
				}
				if (!countryBean.getRegions().contains(regionBean)) {
					regionBean.addState(stateBean);
					stateBean.addRegion(regionBean);
					countryBean.addRegion(regionBean);
					if (!countryBean.getStates().contains(stateBean))
						countryBean.addState(stateBean);
				} else {
										
					if (!stateBean.getRegions().contains(regionBean))
						stateBean.addRegion(regionBean);
					
					if (!regionBean.getStates().contains(stateBean))
						regionBean.addState(stateBean);
					
					if (!countryBean.getStates().contains(stateBean))
						countryBean.addState(stateBean);
				}
			}
			
			if (!countries.isEmpty()) {			
				for (Iterator iter = countries.iterator(); iter.hasNext();) {
					CountryBean element = (CountryBean) iter.next();
					Collections.sort(element.getStates());
					Collections.sort(element.getRegions());				
				}			
				Collections.sort(countries);
			}
			
			
		} finally {
			closeConnection(rs, ps, conn);
		}
				
		return countries;
	}

	public Collection getCountries2() throws SQLException {
		List res = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT c.countryId, c.countryName, s.stateid, s.statename " +					 "FROM countries c JOIN states s ON c.countryId = s.countryId " +					 "ORDER BY c.countryName, s.statename";
		
		try { 

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			CountryBean bean = null;
			String prev = "";
			String id;
			while (rs.next()) {
				id = rs.getString(1);
				
				if (prev.equals(id)) {					
					bean.addState(rs.getString(3),rs.getString(4));
				} else {
					bean = new CountryBean(id,rs.getString(2));
					bean.addState(rs.getString(3),rs.getString(4));
					prev = id;
					res.add(bean);
				}
				
					
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}
	
	
	public Collection getNicaraguaBanks() throws SQLException {
		ArrayList banks = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT desbank,codbank from banks";
		
		try { 

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			banks = new ArrayList();
			while (rs.next()) {
				OptionView view = new OptionView(rs.getString(1), rs.getString(2));
				banks.add(view);
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
				
		
		return banks;
	}
	

	public Collection getShippingAddresses(String _emailKey) throws SQLException {
		ArrayList res = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT name,address,city,state,zip,phone,country,isSellerDefault from addresses where email = ?";
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);
			rs = ps.executeQuery();

			while (rs.next()) {
				AddressBean bean = new AddressBean();
				bean.setName(rs.getString(1));
				bean.setAddress(rs.getString(2));
				bean.setCity(rs.getString(3));
				bean.setState(rs.getString(4));
				bean.setZip(rs.getString(5));
				bean.setPhone(rs.getString(6));
				bean.setCountry(rs.getString(7));
				bean.setSellerDefault(rs.getBoolean(8));
				res.add(bean);			
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
		
	}

	public Collection getCreditCards(String _emailKey) throws SQLException {
		ArrayList res = new ArrayList();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT cardType,cardNumber,cardMonth,cardYear,cardName, cardCCV, cardId from creditcards where email = ?";
		
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);
			rs = ps.executeQuery();

			while (rs.next()) {
				PaymentInfoBean bean = new PaymentInfoBean();
				bean.setCardType(rs.getString(1));
				bean.setCardNumber(rs.getString(2));
				bean.setCardMonth(rs.getString(3));
				bean.setCardYear(rs.getString(4));
				bean.setCardName(rs.getString(5));
				bean.setCardCCV(rs.getString(6));
				bean.setCardId(rs.getString(7));
				res.add(bean);			
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
		
	}


	public String getUserName(String _emailKey) throws SQLException {
		String res = new String();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT userName from users where email = ?";
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);
			rs = ps.executeQuery();

			if (rs.next()) {
				res = rs.getString(1);
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
		
	}
	
	private String getPassword(String _emailKey) throws SQLException {
		String res = new String();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT password from users where email = ?";
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);
			rs = ps.executeQuery();

			if (rs.next()) {
				res = rs.getString(1);
			}
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
		
	}	


	public ProfileBean getProfile(String _emailKey, String _uname) throws SQLException {
		ProfileBean res = new ProfileBean();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sql = "SELECT sellerAccount, status from users where email = ?";
						
		try {
			res.setEmail(_emailKey);
			if (_uname == null || _uname.equals("")) {	
				res.setUserName(this.getUserName(_emailKey));
			} else {
				res.setUserName(_uname);
			}
			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				res.setSellerAccount(rs.getString(1));
				res.setStatus(rs.getString(2));
			}
			
			res.setShippingAddresses(this.getShippingAddresses(_emailKey));
			res.setCreditCards(this.getCreditCards(_emailKey));
			
		} finally {
			closeConnection(rs,ps,conn);
		}
		
		return res;
		
	}
	
	public boolean authenticate(String _emailKey, String _password) throws SQLException, InvalidLoginException {
		boolean res = false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "SELECT email, password from users where email = ?";
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);
			rs = ps.executeQuery();

			if (rs.next()) {
				String pwdencrypted = UtilCrypto.encrypt(_password);
				if (pwdencrypted.equals(rs.getString(2)))
					res = true;
			}
			
			if (!res) 
				throw new InvalidLoginException();
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}
	
	public boolean changePwd(String _email, String _oldPassword, String _newPassword) throws SQLException, InvalidLoginException {
		boolean res = false;
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		String pwdencrypted = UtilCrypto.encrypt(_newPassword);
		String oldpwdencrypted = UtilCrypto.encrypt(_oldPassword);

		if (!oldpwdencrypted.equals(this.getPassword(_email))) {
			throw new InvalidLoginException();							
		}
						
		String sql = "UPDATE users SET status = ?, password = ? WHERE email = ?";		
		try {
			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
									
			ps.setString(1, STATUS_OK);
			ps.setString(2,pwdencrypted);
			ps.setString(3,_email);

			ps.executeUpdate();
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}	
	
	public String generateTempPwd(String _email) throws SQLException {
		String _password = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "UPDATE users SET status = ?, password = ? WHERE email = ?";
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			
			_password = UniqueIdentifierGenerator.generateCode().substring(0,8);
			String pwdencrypted = UtilCrypto.encrypt(_password);
			
			ps.setString(1, STATUS_NEWPASSWORD);
			ps.setString(2,pwdencrypted);
			ps.setString(3,_email);

			ps.executeUpdate();
				
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return _password;
	}
	
	public int addNewUser(AccountDTO dto) throws SQLException, NewUserException {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "insert into users (email,username,password) values (?,?,?)";
		
		try {
			
			if (this.duplicateEmail(dto.getEmail()))
				throw new NewUserException();
			
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			String pwdencrypted = UtilCrypto.encrypt(dto.getPassword());			
			ps.setString(1,dto.getEmail());
			ps.setString(2,dto.getUserName());
			ps.setString(3,pwdencrypted);			
			res = ps.executeUpdate();

				
		} finally {
			closeConnection(rs, ps, conn);
		}		
		
		return res;	
	}
	
	public int activateSellerAccount(String _email) throws Exception {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		String userSQL = "UPDATE users set sellerAccount = ? where email = ?"; 
		
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(userSQL);
			
			ps.setBoolean(1, true);
			ps.setString(2,_email);
			
			res = ps.executeUpdate();
			
		} finally {
			closeConnection(rs,ps,conn);
		}
		
		return res;		
	}
	
	public int addNewSellerAccount(PaymentInfoBean creditcards, BankAccountBean bankaccount, ProfileBean user, String sellingFee) throws SellerAccountException, Exception {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		String email = user.getEmail();
		
		String userSQL = "UPDATE users set sellingFee = ? where email = ?"; 
		
		if (this.addOrUpdateCreditCard(creditcards,email,true) < 0 ) {
			throw new SellerAccountException();
		}
		
		if (this.setCreditCardSellerDefault(email,creditcards.getCardId()) < 0 ) {
			throw new SellerAccountException();
		}
		
		if (this.addBankAccount(bankaccount,email) < 0 ) {
			throw new SellerAccountException(); 
		}
		
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(userSQL);
			
			ps.setString(1, sellingFee);
			ps.setString(2,user.getEmail());
			
			res = ps.executeUpdate();
			
			if (res < 0) {
				throw new SellerAccountException();
			}
 			
		} finally {
			closeConnection(rs,ps,conn);
		}
		
		return res;
	}
	
	public int addBankAccount(BankAccountBean bean, String _email) throws Exception {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		String newBankAccountSQL = "INSERT INTO bankaccounts (email, bankAccountHolder, bankCode, bankAccount) " +			"VALUES (?,?,?,?)";
		
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(newBankAccountSQL);
			ps.setString(1,_email);
			ps.setString(2,bean.getBankAccountHolder());
			ps.setString(3, bean.getBankName());
			ps.setString(4, bean.getBankAccount());
			
			res = ps.executeUpdate();
			
		} finally {
			closeConnection(rs,ps,conn);
		}

		return res;		
	}
	
	public int addOrUpdateCreditCard(PaymentInfoBean bean, String _email, boolean isSellerDefault) throws Exception {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		String newCardSQL = "INSERT INTO creditcards (cardType, cardNumber, cardMonth, cardYear, cardName, email, cardCCV, isSellerDefault) " +			"VALUES (?,?,?,?,?,?,?,?)";
		String updateCardSQL = "UPDATE creditcards set cardType=?, cardNumber=?, cardMonth=?, cardYear=?, cardName=?, email=?, cardCCV=? " +			"WHERE cardId=?";
					
		try {
			conn = getPooledConnection(DBASEKEY);			
						
			if (bean.getCardId() != null && !bean.getCardId().equals("")) { //osea ya existe, hacer un update
				ps = conn.prepareStatement(updateCardSQL);
				ps.setString(8,bean.getCardId());
			} else {// no existe, hacer un add
				ps = conn.prepareStatement(newCardSQL);
				ps.setBoolean(8,isSellerDefault);
			}
			ps.setString(1,bean.getCardType());
			//aqui deberia venir logica para encriptar el numero de tarjeta;
			ps.setString(2,bean.getCardNumber());
			ps.setString(3,bean.getCardMonth());
			ps.setString(4,bean.getCardYear());
			ps.setString(5,bean.getCardName());
			ps.setString(6,_email);
			ps.setString(7,bean.getCardCCV());
			
			res = ps.executeUpdate();
						
		} finally {
			closeConnection(rs, ps, conn);
		}
		
		return res;
	}
	
	public int setCreditCardSellerDefault(String _email, String _cardId) throws Exception {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		String resetAllCardsSQL = "UPDATE creditcards set isSellerDefault=? WHERE email = ?";
		String updateCard = "UPDATE creditcards set isSellerDefault=? WHERE cardId=?";
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(resetAllCardsSQL);
			ps.setBoolean(1,false);
			ps.setString(2,_email);
			ps.executeUpdate();
			//ahora poner por default
			ps2 = conn.prepareStatement(updateCard);
			ps2.setBoolean(1,true);
			ps2.setString(2,_cardId);
			res = ps2.executeUpdate();
			
		} finally {
			closeConnection(rs, ps, conn);
			closeConnection(rs,ps2,conn);
		}

		return res;		
	}

	public int doInsert(AdvertisementBean adBean) throws Exception {
		int res = -1 ;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "INSERT INTO ads (adTitle, adDescription, adCat, adName, adPhone, adEmail, adFileName, adVisible, adCost, adCurrency, adDuration, adPosted, adCart, adHideEmail)" +									"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		System.out.println("Entrando al doInsert del dao");
		
		try {
			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			long currentDate = getCurrentDate();
			ps.setString(1,adBean.getTitle());
			ps.setString(2,adBean.getDesc());
			ps.setString(3,adBean.getCategory());
			ps.setString(4,adBean.getName());
			ps.setString(5,adBean.getPhone());
			ps.setString(6,adBean.getEmail());
			ps.setString(7,adBean.getMyFileName());
			ps.setBoolean(8,false);
			ps.setDouble(9,adBean.getCost());
			ps.setString(10,adBean.getCurrency());
			ps.setString(11,adBean.getDuration());
			ps.setLong(12,currentDate);
			ps.setBoolean(13,adBean.isCart());
			ps.setString(14,adBean.getHideEmail());
			res = ps.executeUpdate();
				
		} finally {
			closeConnection(rs, ps, conn);
		}		
		
		return res;		
	}

	
	private boolean duplicateEmail(String _emailKey) throws SQLException {
		boolean res = false;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		String sql = "select count(*) from users where email = ?";
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setString(1,_emailKey);			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				res = rs.getInt(1)>0?true:false;				
			}
				
		} finally {
			closeConnection(rs, ps, conn);
		}		
		
		return res;
	}
	
	private String makeSearchCriteria(String criteria) {
		StringBuffer res = new StringBuffer();
		StringTokenizer st = new StringTokenizer(criteria);
		String token;
		boolean flag = true;
		
		res.append("A.adDescription like '%");
		
		while (st.hasMoreTokens()) {
			token = st.nextToken();


			if (token.equalsIgnoreCase("AND")) {
				res.append(" and A.adDescription like '%");
				flag = true;
				
			} else if (token.equalsIgnoreCase("OR"))	{
				res.append(" or A.adDescription like '%");		
				flag = true;
				} else {
					if (!flag) {
						res.append(" and A.adDescription like '%");
					} 
				
					res.append(token).append("%' ");							
					flag = false;
				}
				
		}
		
		return res.toString();
	}
	
	
	public List searchCriteria(String criteria) throws SQLException {
		List res = null;
		String sql = "Select A.adId, A.adTitle, A.adDescription, B.catDescription, A.adName, A.adPhone, A.adEmail, A.adFileName, A.adCost, A.adPosted, A.adCart,A.adCurrency,A.adHideEmail";
		sql += " from ads A, categories B WHERE";
		sql += " A.adCat = B.catId AND ";
		sql += makeSearchCriteria(criteria);
		sql += " ORDER BY A.adPosted desc";
	
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
		log.info(sql);
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
						
			res = prepareResult(rs);
		} finally {
			closeConnection(rs,ps,conn);
		}
				
			
		return res;
	}	
		
	public List getResultByCatId(String catId) throws SQLException {
		List res = null;
		String sql = "Select A.adId, A.adTitle, A.adDescription, B.catDescription, A.adName, A.adPhone, A.adEmail, A.adFileName, A.adCost, A.adPosted, A.adCart, A.adCurrency, A.adHideEmail";
		sql += " from ads A, categories B WHERE";
		sql += " A.adCat = B.catId AND B.catId = "+ Integer.valueOf(catId);
		sql += " ORDER BY A.adPosted desc";
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		log.info(sql);
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

						
			res = prepareResult(rs);
		} finally {
			closeConnection(rs,ps,conn);
		}
		
		return res;
		
	}
	
	public Collection getPicks(int pastWeeks, int maxAds) throws SQLException {
		int topWeeks = 24;
		ArrayList res = new ArrayList();		
		List tempRes = null;
		// 1: obtengo todos los ads que tengan menos de n semanas, si son menores a maxAds entonces aumento la semana			  
		while ((tempRes = getAdsByWeeks(pastWeeks++)).size() < maxAds) {
			if (pastWeeks == topWeeks) break;	 
		}
		
		Collections.shuffle(tempRes);

			
		for (int i = 0;i < maxAds; i++) {
			res.add((AdvertisementBean) tempRes.get(i));
		}		
		
		return res;
	}
	
	public List getAdsByWeeks(int pastWeeks) throws SQLException {
		List res = null;
		long aWeek = 604800000l;		
		long currentDate = getCurrentDate();
		long previousDate = currentDate - (aWeek * pastWeeks);
		
		String sql = "Select A.adId, A.adTitle, A.adDescription, B.catDescription, A.adName, A.adPhone, A.adEmail, A.adFileName, A.adCost, A.adPosted, A.adCart, A.adCurrency, A.adHideEmail " +					"from ads A, categories B " +					"where A.adPosted <= ? and A.adPosted >= ? and A.adCat = B.catId " +					"group by adCat, adPosted " +					"order by adCat, adPosted desc ";
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		log.info(sql);
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setLong(1,currentDate);
			ps.setLong(2,previousDate);
			rs = ps.executeQuery();
			res = prepareResult(rs);
		} finally {
			closeConnection(rs,ps,conn);
		}		
		
		return res;		
	}
	
	public AdvertisementBean getItem(String itemId) throws SQLException {
		AdvertisementBean result = null;

		//String sql = "Select A.adId, A.adTitle, A.adDescription, A.adName, A.adPhone, A.adEmail, A.adFileName, A.adCost";
		
		String sql = "Select A.adId, A.adTitle, A.adDescription, B.catDescription, A.adName, A.adPhone, A.adEmail, A.adFileName, A.adCost, A.adPosted, A.adCart, A.adCurrency, A.adHideEmail " +							
		 			" from ads A, categories B " +		 			" WHERE A.adCat = B.catId " +		 			" AND A.adId = ?";

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
	
		log.info(sql);
		
		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(itemId).intValue());
			rs = ps.executeQuery();
			
			result = (AdvertisementBean) prepareResult(rs).get(0);
						
			
		} finally {
			closeConnection(rs,ps,conn);
		}


		return result;
	}
	
	
	private static List prepareResult(ResultSet rs) throws SQLException {
	    ArrayList list = new ArrayList();
	    long postedDate;
	    
    	while(rs.next()) {
	      int i = 1;
	      AdvertisementBean adBean = new AdvertisementBean();
	      adBean.setItemId(rs.getString(i++));
	      adBean.setTitle(rs.getString(i++));
	      adBean.setDesc(rs.getString(i++));
	      adBean.setCategory(rs.getString(i++));
	      adBean.setName(rs.getString(i++));
	      adBean.setPhone(rs.getString(i++));
	      adBean.setEmail(rs.getString(i++));
	      adBean.setMyFileName(rs.getString(i++));
	      adBean.setCost(rs.getDouble(i++));
	      postedDate = rs.getLong(i++);
	      if (postedDate > 0) {
			Calendar cal = Calendar.getInstance();
		  	cal.setTime(new Date(postedDate));
			adBean.setPostedDate(cal); 
	      }
	      adBean.setCart(rs.getBoolean(i++));
	      adBean.setCurrency(rs.getString(i++));
	      adBean.setHideEmail(rs.getString(i++));
	      
	      list.add(adBean);
    	}
    	
    	return list;
	}

	private long getCurrentDate() {
		long result = System.currentTimeMillis();
		
		return result;
	}
	
}
