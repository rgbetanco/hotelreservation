

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<fmt:setBundle basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />


<TABLE border="0" >
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">anúnciese</SPAN> <SPAN
				class="checkoutSubTitle">| seleccione el formato de su anuncio</SPAN></TD>
		</TR>
		<TR>
			<TD>Antes de empezar, escoja un formato y presione en el botón <B>Continuar</B>. Favor asegúrese que su artículo  esté entre los productos <U>
			permitidos</U> por elcalachero.com.</TD>
		</TR>
	</TBODY>
</TABLE>
<form action="/NicahostWeb/clasificados/anuncieseoption.do" method="post">
<TABLE border="0" align="center" cellspacing="8">
	<TBODY>
		<tr>
			<TD colspan="2" class="daterror" align="center">

	      	<logic:messagesPresent property="GLOBAL_ERROR">
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>	      	
	      	</logic:messagesPresent>

	      	
			</TD>
		</tr>
	
		<TR>
			<TD valign="top">			
			<INPUT type="radio" name="formatOption" value="sellerOnly" checked>
			</td>
			<td><B>Anúncieme GRATIS!!</B><BR>
			<FONT size="-2">(Servicio totalmente gratuito). <U>Más
			información</U></FONT>.
			</TD>
		</TR>
		<TR>
			<TD valign="top">			
			<INPUT type="radio" name="formatOption" value="sellerOnline" >
			</td>
			<td><B>Quiero vender en línea mi producto</B>.<BR>
			<FONT size="-2">(Su producto será vendido en línea a un precio establecido por usted). <U>Más
			información</U></FONT>.
			</TD>
		</TR>		
		<TR>
			<TD valign="top">			
			<INPUT type="radio" name="formatOption" value="sellerOnlineStore" >
			</td>
			<td><B>Quiero vender mi producto en mi propia tienda virtual</B>.<BR>
			<FONT size="-2">(Obtenga su propia tienda virtual en elcalachero.com). <U>Más
			información</U></FONT>.
			</TD>
		</TR>		
		<TR>
			<TD valign="top">			
			<INPUT type="radio" name="formatOption" value="buyerOnly" >
			</td>
			<td><B>Soy un comprador y quiero que me contacten por el producto o
			servicio que busco.</B><BR>
			<FONT size="-2">(Será contactado si un producto cumple sus requerimientos). <U>Más
			información</U></FONT>.
			</TD>
		</TR>		
		
		<TR>
			<TD>				
							
			</TD>
			<TD>
				<p>&nbsp;</p>				
				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="this.form.submit();" width="90" height="17">
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>

</form>

<TABLE border="0">
	<TBODY>
		<TR>
			<TD>Si tiene alguna duda, permítame ayudarle en nuestra sección de ayuda. También me puede enviar un correo electrónico o llamarme al (505) 848-4018. Nuestros especialistas en atención al cliente lo atenderá las 24 horas del día los 7 días de la semana.</TD>
		</TR>
	</TBODY>
</TABLE>
