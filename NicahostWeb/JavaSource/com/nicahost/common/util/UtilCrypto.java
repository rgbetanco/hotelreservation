/*
 * Created on Apr 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.nicahost.common.config.bean.GlobalParametersBean;

/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UtilCrypto {


	/**
	 * Encripta el password utilizando el MessageDigest
	 * @param password clave sin encriptar
	 * @return clave encriptada
	 */
	public static String encrypt(String value){
		String pwd = null;
		try{
			String algorithm = GlobalParametersBean.getInstance().getValue(GlobalParametersBean.ENCRYPT_ALGORITHM);
			MessageDigest sha = MessageDigest.getInstance(algorithm);
			byte[] result =  sha.digest(value.getBytes());
			pwd = new String(hexEncode(result));
		}catch(NoSuchAlgorithmException  e){}
		return pwd;
	}


	/**
	 * Convierte bytes a su representacion de String en hexadecimal
	 * @param aInput input
	 * @return codigo hexadecimal
	 */
	static public String hexEncode(byte[] aInput){

		StringBuffer result = new StringBuffer();
		char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};

		for ( int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append( digits[ (b&0xf0) >> 4 ] );
			result.append( digits[ b&0x0f] );
		}

		return result.toString();
	}

	/**
	 * Convierte una representacion de String en hexadecimal a bytes
	 * @param hexCode hilera en hexadecimal
	 * @return arreglo de bytes
	 */
	public static byte[] hexDecode(String hexString) throws IllegalArgumentException {

		char[] hexStringCharArray = hexString.toCharArray();
		int byteArraySize = hexStringCharArray.length / 2;
		byte[] byteArray = new byte[byteArraySize];

		for (int i = 0; i < (byteArraySize); i++) {

			StringBuffer thisByteInHex = new StringBuffer();
			thisByteInHex.append(hexStringCharArray[i * 2]);
			thisByteInHex.append(hexStringCharArray[i * 2 + 1]);

			byte thisByte = (byte)Integer.parseInt(thisByteInHex.toString(), 16);
			byteArray[i] = thisByte;
		}

		return byteArray;
	}
	
	/**
	 * Codifica en base 64 la trama
	 * @param data trama sin codificar
	 * @return data codificada en base 64
	 */
	public static String base64Encode(String data){
		String result = null;
		BASE64Encoder base64Encoder = new BASE64Encoder();
		result = base64Encoder.encodeBuffer(data.getBytes());
		return result;
	}

	/**
	 * Decodifica en base64 la trama ya codificada
	 * @param data trama codificada
	 * @return data decodificada
	 */
	public static String base64Decode(String data){
		String result = null;

		try {
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] bytes = base64Decoder.decodeBuffer(data);
			String string = new String(bytes);
			result = string;
		}
		catch(Exception ex){
		   ex.printStackTrace();
		}

		return result;
	}
	
}
