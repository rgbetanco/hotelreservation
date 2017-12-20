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
				class="checkoutSubTitle">| cambiar</SPAN></TD>
		</TR>
		<TR>
			<TD>Ingrese su vieja contraseña y nueva contraseña en este formulario para actualizar sus datos.</TD>
		</TR>
	</TBODY>
</TABLE>

<html:form action="/changepwd">
	<TABLE border="0" id="sessionTable" align="center">
		<TBODY>
			<TR>				
				<TD colspan="2"><html:hidden property="email" /></TD>
			</TR>
			<TR>
				<TD>
				<logic:messagesPresent property="oldPassword" ><span class="daterror">Contraseña actual:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="oldPassword">Contraseña actual:</logic:messagesNotPresent></B>
				
				</TD>
				<TD>
					<input type="password" name="oldPassword" size="35" value="">
				</TD>
			</TR>
			<TR>
				<TD>
				<logic:messagesPresent property="password" ><span class="daterror">Contraseña nueva:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="password">Contraseña nueva:</logic:messagesNotPresent></B>
				
				</TD>
				<TD>
					<input type="password" name="password" size="35" value="">
				</TD>
			</TR>
			<TR>
				<TD><b>Re-escriba nueva contraseña: </b></TD>
				<TD>
					<input type="password" name="retypepassword" size="35" value="">	
				</TD>
			</TR>
		<TR>
			<td colspan="2" class="daterror">
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
			
			<TR>
				<TD><INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif"></TD>
				<TD></TD>
			</TR>
		</TBODY>
	</TABLE>
</html:form>
