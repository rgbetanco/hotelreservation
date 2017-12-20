

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">


<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">bienvenido</SPAN> <SPAN
				class="checkoutSubTitle">| cree una nueva cuenta</SPAN></TD>
		</TR>
		<TR>
			<TD>Para poder comprar, primeramente necesita crear un cuenta del calachero.com ingresando los datos requeridos en este formulario.</TD>
		</TR>
	</TBODY>
</TABLE>
<html:form action="newAccount.do" focus="name">
<TABLE border="0">
	<TBODY>
		<tr>
			<TD colspan="2" class="daterror" align="center">
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
	      	
	      	<p>&nbsp;</p>
			</TD>
		</tr>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="name"><strong class="daterror">Su nombre:*</strong></logic:messagesPresent>
				<logic:messagesNotPresent property="name">Su nombre:</logic:messagesNotPresent>
				
			</TD>
			<TD><html:text property="name" size="32" /></TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="email"><strong class="daterror">Ingrese su correo electrónico:*</strong></logic:messagesPresent>
				<logic:messagesNotPresent property="email">Ingrese su correo electrónico:</logic:messagesNotPresent>
				
			</TD>
			<TD><html:text property="email" size="32"/> 
			<br>(Necesitamos esto para poderle enviar la confirmación de su orden de compra)
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="password"><strong class="daterror">Cree una contraseña:*</strong></logic:messagesPresent>
				<logic:messagesNotPresent property="password">Cree una contraseña:</logic:messagesNotPresent>
			</TD>
			<TD><html:password property="password" size="32"/></TD>
		</TR>
		<TR>
			<TD align="right">Confirme la contraseña:</TD>
			<TD>
				<INPUT type="password" name="confirmpwd" size="32">
				<BR>(Necesitará una contraseña para poder ver el estado de su orden de compra)
			</TD>
		</TR>
		<TR>
			<TD>				
				<html:hidden property="checkout"/>	
				<html:hidden property="nextview"/>		
			</TD>
			<TD>				
				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/ingresar.gif" onclick="this.form.submit();" width="90" height="17">
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>

</html:form>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD>Si tiene alguna duda, permítame ayudarle en nuestra sección de ayuda. También me puede enviar un correo electrónico o llamarme al (505) 848-4018. Nuestros especialiastes en atención al cliente lo atenderá las 24 horas del día los 7 días de la semana.</TD>
		</TR>
	</TBODY>
</TABLE>
