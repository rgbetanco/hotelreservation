
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<html:base/>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<!-- Aqui indico, el lugar donde est�n los archivos de propiedades para la internacionalizaci�n.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
	
	<table border="0" cellspacing="0" cellpadding="0" width="100%">

	  
	  <tr>	  
	    <td colspan="4" align="center"> 
	    	<table border="0" width="550" cellpadding="3" cellspacing="1" id="sessionTable">
		        <tr>
		          <th colspan="4">
	    	        Contrase�a regenerada
	        	  </th>
	        	</tr>
	        	<tr>
	        		<td colspan="4">
	        			Se ha enviado su nueva contrase�a a su correo electr�nico <a href="http://www.elcalachero.com/NicahostWeb/clasificados/showSignin.do"></a>
	        			
	        			<p>
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
