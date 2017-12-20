<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>

<html:base/>


<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">manejo de contraseña</SPAN> <SPAN
				class="checkoutSubTitle">| regenerar</SPAN></TD>
		</TR>
		<TR>
			<TD>Ingrese su correo electrónico para enviarle por correo su nueva contraseña.</TD>
		</TR>
	</TBODY>
</TABLE>

<html:form action="/forgotpwd">
	<TABLE border="0" id="sessionTable" align="center">
		<TBODY>
			<TR>	
			<TD align="right">
				<logic:messagesPresent property="email"><span class="daterror">E-mail:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="email">E-mail:</logic:messagesNotPresent></B>				
			</TD>						
			<TD>
				<html:text property="email" size="35"/>
			</TD>
			<TD><INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif"></TD>			
			</TR>
		<TR>
			<td colspan="3" class="daterror">
			<logic:messagesNotPresent property="GLOBAL_ERROR">
				<logic:messagesPresent>
					Favor corrija los campos indicados
				</logic:messagesPresent>
			</logic:messagesNotPresent>	

	      	<logic:messagesPresent property="GLOBAL_ERROR">
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>	      	
	      	</logic:messagesPresent>			
			</td>
		</TR>
			
		</TBODY>
	</TABLE>
</html:form>
