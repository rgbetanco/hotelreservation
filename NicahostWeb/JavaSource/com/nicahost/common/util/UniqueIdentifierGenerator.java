package com.nicahost.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Permite generar valores únicos para el sistema, con una longitud de 20 carateres
 * @author hjiron
 * @version 1.0
 * Fecha: 01-10-2004
 */
public class UniqueIdentifierGenerator {
	/** Valor de host por defecto. */
    private static final String DEFAULT_HOST = "999"; //$NON-NLS-1$
	/** Inicio de la secuencia. */
    private static final int SEQUENCE_START = 1000;
	/** Fin de la secuencia. */
	private static final int SEQUENCE_END = 9999;
	/** Largo máximo del identificador generado. */
	private static final int MAX_SIZE = 20;
	/** Generador de números aleatorios. */
    protected static Random generador = new Random(System.currentTimeMillis());
    /** Número de secuencia. */
	private static int sequence = SEQUENCE_START;
	
	/**
	 * Constructor por defecto.
	 */
	private UniqueIdentifierGenerator() {
		super();		
	}

	/**
	 * Genera un número único de 20 carateres para el sistema. 
	 * @return <code>String</code> con el código.
	 */
	public static String generateCode() {
		String returnValue = null;
		String host = null;
		
		if (sequence >= SEQUENCE_END){
		  sequence = SEQUENCE_START;
		}
		
		try {
			host = DEFAULT_HOST.concat(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			//Se asigan un valor por default
			host = DEFAULT_HOST;
		} catch (Exception e) {
			host = DEFAULT_HOST;
		}
		
		StringBuffer valor = new StringBuffer(Integer.toHexString(sequence));
		
		valor.append(Long.toHexString(System.currentTimeMillis()));
	
		int size = host.length();
		valor.append(host.substring(size - 3, size));

		valor =
			valor.append(Long.toHexString(generador.nextLong()).substring(0, 3));


		if (valor.length() > MAX_SIZE) {
			returnValue = valor.substring(0, MAX_SIZE - 1);
		} else {
			returnValue = valor.toString();
		}
		
		sequence++;

		return returnValue;
	}
}
