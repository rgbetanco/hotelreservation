

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
			<TD><SPAN class="checkoutTitle">ventas en línea</SPAN> <SPAN
				class="checkoutSubTitle">| crear cuenta de vendedor</SPAN></TD>
		</TR>
		<TR>
			<TD>
			Para vender sus artículos en línea a través de elcalachero.com, necesitamos que todos los miembros nos proporcionen:
			<UL>
				<LI>Una<B> tarjeta de crédito</B> nacional o internacional</LI>
				<LI>Una <B>cuenta en cualquier banco</B> del sistema financiero de <B>Nicaragua</B></LI>
			</UL>
			Solicitamos de esta información para:
			<UL>
				<LI>Acreditarle las compras realizadas en nuestro sitio</LI>
				<LI>Cuando un artículo es vendido por elcalachero.com, se le cobra una comisión desde C$15.00</LI>
			</UL>
			Este proceso se realiza sólo una vez y toma poco tiempo para completar. Toda su información es resguarda con confiabilidad por nuestros <U>servidores
			seguros</U> y por nuestra <U>política de privacidad</U>.
		</TD>
		</TR>
	</TBODY>
</TABLE>
<form action="/NicahostWeb/clasificados/selleronlinecreditcard.do" method="post">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2" class="daterror">
	      	<logic:messagesPresent property="GLOBAL_ERROR">
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>	      	
	      	</logic:messagesPresent>			
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>
				<p>&nbsp;</p>				
				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="this.form.submit();" width="90" height="17">			
			</TD>
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
