
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<html:base/>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
	
	<table border="0" cellspacing="0" cellpadding="0" width="100%">

	  
	  <tr>	  
	    <td colspan="4" align="center"> 
	    	<table border="0" width="550" cellpadding="3" cellspacing="1" id="sessionTable">
		        <tr>
		          <th colspan="4">
	    	        <fmt:message key="label.classified.thankyou" /> 
	        	  </th>
	        	</tr>
	        	<tr>
	        		<td colspan="4">
	        			Su cuenta de vendedor ha sido activada <B>satisfactoriamente</B>.<BR>
				<BR>
				Puede modificar los datos en <U>su cuenta</U><p>
	        			Gracias por visitar: <a href="http://www.elcalachero.com/NicahostWeb/clasificados/default.do">www.elcalachero.com</a>
	        			</p>
	        			<p>
	        			Comentarios: <a href="mailto:webmaster@elcalachero.com">webmaster@elcalachero.com</a>
	        			</p>
	        			
	        		</td>
	        	</tr>
   	
	    	</table>
	    </td>
	   </tr>
	</table>
