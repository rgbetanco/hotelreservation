/*
 * Created on Jul 8, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.module.hotelreserve.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.nicahost.common.dao.DBBaseDAO;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public final class HotelReserveInitDAO extends DBBaseDAO {
	static Logger log = Logger.getLogger(HotelReserveInitDAO.class);	
	private static final String DBASEKEY = "dsHotel";
	
	private static final String ROOMTYPES_SQL = "SELECT id, label FROM roomtypes";
	private static final String COUNTRY_SQL = "SELECT countryid, label FROM country";
	private static final String ETHNICITY_SQL = "SELECT ethnicityid, label FROM ethnicity";
	private static final String LANGUAGE_SQL = "SELECT langsymbol, langlabel FROM language WHERE active = 1";
	private static final String COUNTRY_LANGUAGE_SQL = "SELECT langsymbol, langcountry FROM language WHERE active = 1";	
	
	public Map getRoomTypes() throws SQLException {		
		Map result = new HashMap();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			conn = getPooledConnection(DBASEKEY);
			ps = conn.prepareStatement(ROOMTYPES_SQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				result.put(rs.getString(1),rs.getString(2));				
			}
			
		} finally {
			closeConnection(rs, ps, conn);
		}

		return result;
	}
	

	/**
	 * Este metodo retorna todos los paises que estan en la base de datos,
	 * para luego pintalo en un combo box
	 * @return
	 * @throws SQLException
	 */
		public Map getCountry() throws SQLException {
		
			Map result = new HashMap();
		
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
		
			try {
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(COUNTRY_SQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					result.put(rs.getString(1),rs.getString(2));
				}
			} finally{
				closeConnection(rs, ps, conn);
			}
			return result;
		}
		/**
		 * return the ethnicity to fill the checkbox
		 * @return
		 * @throws SQLException
		 */
		public Map getEthnicity() throws SQLException {
		
				Map result = new HashMap();
		
				Connection conn = null;
				ResultSet rs = null;
				PreparedStatement ps = null;
		
				try {
					conn = getPooledConnection(DBASEKEY);
					ps = conn.prepareStatement(ETHNICITY_SQL);
					rs = ps.executeQuery();
					while (rs.next()) {
						result.put(rs.getString(1),rs.getString(2));
					}
					
				} finally{
					closeConnection(rs, ps, conn);
				}
				return result;
			}	


	/**
	 * @return languages activated for multilingual display
	 * @throws SQLException
	 */
	public Map getLanguage() throws SQLException {
		
			Map result = new HashMap();
		
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
		
			try {
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(LANGUAGE_SQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					result.put(rs.getString(1),rs.getString(2));
				}
					
			} finally{
				closeConnection(rs, ps, conn);
			}
			return result;
		}		
		
	/**	 
	 * @return countries
	 * @throws SQLException
	 */
	public Map getCountryLanguage() throws SQLException {
		
			Map result = new HashMap();
		
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
		
			try {
				conn = getPooledConnection(DBASEKEY);
				ps = conn.prepareStatement(COUNTRY_LANGUAGE_SQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					result.put(rs.getString(1),rs.getString(2));
				}
					
			} finally{
				closeConnection(rs, ps, conn);
			}
			return result;
		}		
}
