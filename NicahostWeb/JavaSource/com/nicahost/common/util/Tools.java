package com.nicahost.common.util;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Tools {


	/**
	 * Devuelve un Arreglo de Strings conformado por
	 * los valores partidos por el <i>separador</i>
	 *
	 * @param string El string a procesar
	 * @param separador El separador
	 * @return El arreglo de valores
	 */
	public static String[] splitString(String string, char separador) {
		String[] salida = new String[string.length()];
		String[] tmp;
		int fin;
		int contador = 0;
		int indice = 0;
		while (indice >= 0) {
			fin = string.indexOf(separador, indice + 1);
			if (fin < 0)
				salida[contador++] = string.substring(indice);
			else
				salida[contador++] = string.substring(indice, fin);
			indice = fin < 0 ? fin : fin + 1;
		}
		tmp = new String[contador];
		for (int i = 0; i < contador; i++)
			tmp[i] = salida[i];
		return tmp;
	}


	public static boolean isNumber(String source) {
		if (source == null || source.equals(""))
			return true;
		boolean result = false;
		try {
			Double test = new Double(source);
			result = true;
		} catch (Exception e) {
			;
		}
		return result;
	}
	
	public static synchronized String replace(
		String source,
		String find,
		String newstring) {
		int ini = 0;
		int pos = -1;
		int skip = find.length();
		StringBuffer result = new StringBuffer();
		while ((pos = source.indexOf(find, ini)) > -1) {
			result.append(source.substring(ini, pos));
			result.append(newstring);
			ini = pos + skip;
		}
		result.append(source.substring(ini, source.length()));
		return result.toString();
	}	
	
	public static String right(String source, int index) {
		if (source == null)
			source = "";
		try {
			if (source.length() >= index)
				source =
					source.substring(source.length() - index, source.length());
		} catch (Exception e) {
		}
		return source;
	}	
	
}
