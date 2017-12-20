/*
 * Created on Jul 13, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.nicahost.framework.common.validator;

import java.io.Serializable;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.Resources;




/**
 * @author henry
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ValidatorFramework implements Serializable {

	public static boolean validateTwoFields(
		Object bean,
		ValidatorAction va, 
		Field field,
		ActionMessages errors,
		HttpServletRequest request) {

		String value = ValidatorUtils.getValueAsString(
			bean, 
			field.getProperty());
		String sProperty2 = field.getVarValue("secondProperty");
		String value2 = ValidatorUtils.getValueAsString(
			bean, 
			sProperty2);

		if (!GenericValidator.isBlankOrNull(value)) {
		   try {
			  if (!value.equals(value2)) {
				 errors.add(field.getKey(),Resources.getActionMessage(request,va,field));
				 

				 return false;
			  }
		   } catch (Exception e) {
				 errors.add(field.getKey(),Resources.getActionMessage(request,va,field));
				 return false;
		   }
		}

		return true;
	}
	
	public static boolean validateMaxFileSize (
	Object bean,
	ValidatorAction va, 
	Field field,
	ActionMessages errors,
	HttpServletRequest request) {
		
		//DynaActionForm es la superclass de DynaValidatorForm por tanto se puede usar tanto un DynaActionForm como un DynaValidatorForm. HJ
		DynaActionForm form = (DynaActionForm) bean;
		Map m = form.getMap();

		FormFile myFile = (FormFile) m.get(field.getProperty());
		
		String maxFileSize = field.getVarValue("maxSize") == null? "0":field.getVarValue("maxSize");
		
		int maxSize = Integer.parseInt(maxFileSize);
		
		if (myFile.getFileSize() > maxSize) {				
			errors.add(field.getKey(),Resources.getActionMessage(request,va,field));
			return false;
		}
		
		return true;
	}
	
	public static boolean validateFileFormat (
	Object bean,
	ValidatorAction va, 
	Field field,
	ActionMessages errors,
	HttpServletRequest request) {

		DynaActionForm form = (DynaActionForm) bean;
		Map m = form.getMap();

		FormFile myFile = (FormFile) m.get(field.getProperty());
		if (GenericValidator.isBlankOrNull(myFile.getFileName())) return true;
		String fileType = myFile.getContentType().toLowerCase();
		String types = field.getVarValue("fileTypes") == null? "0":field.getVarValue("fileTypes");
		StringTokenizer st = new StringTokenizer(types,",");
		while (st.hasMoreTokens()) {			
			if (fileType.endsWith(st.nextToken().toLowerCase())) return true;	
		}
		
		errors.add(field.getKey(),Resources.getActionMessage(request,va,field));
		return false;
	}	
	
}
