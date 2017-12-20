
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>



<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<!-- Aqui indico, el lugar donde est�n los archivos de propiedades para la internacionalizaci�n.  -->
<fmt:setBundle
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
<TABLE border="0" width="100%">
	<TBODY>
		<TR>
			<TD colspan="2"><SPAN class="checkoutTitle">bienvenido <SPAN
				class="checkoutSubTitle">|</SPAN></SPAN><SPAN
				class="checkoutSubTitle"> ingreso</SPAN></TD></TR>
		<TR>
			<TD width="50%" colspan="2">

				<html:form action="signin.do" focus="email">
<TABLE border="0">
	<TBODY>
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
			<TD colspan="2">
			<c:choose>
				<c:when test="${empty userName}">
									<B>Cliente de regreso</B>
								</c:when>
				<c:otherwise>
									<B>Bienvenido de nuevo <c:out value="${userName}" /> </B>
								</c:otherwise>
			</c:choose>
			<BR>Complete los datos para ingresar
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="email"><span class="daterror">E-mail:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="email">E-mail:</logic:messagesNotPresent></B>				
			</TD>
			<TD>				
				<html:text property="email" size="35" />				
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="password" ><span class="daterror">Contrase�a:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="password">Contrase�a:</logic:messagesNotPresent></B>
			</TD>
			<TD><INPUT type="password" name="password" size="35"></TD>
		</TR>
		
		<TR>		
			<TD></TD>
			<TD>
				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/ingresar.gif" onclick="this.form.submit();" width="90" height="17">
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>�Olvid� su contrase�a? Presione <A href="/NicahostWeb/clasificados/showforgotpwd.do">aqu�</A>.<BR>
			�Ha cambiado su correo electr�nico?</TD>
		</TR>
	</TBODY>
</TABLE>
			
</html:form>
			
			
				
			</TD></TR>
		<TR>
			<TD width="50%"></TD>
			<TD width="50%"></TD>
		</TR>
		<TR>
			<TD width="50%" colspan="2">
			<p>
				<B>Para clientes nuevos</B><BR>Si nunca ha comprado en elcalachero.com, necesita <A
				href="/NicahostWeb/clasificados/createAccount.do">crear una nueva cuenta.</A>
			<BR>
			</p>
			
			</TD></TR>
		<TR>
			<TD width="50%" colspan="2">
			<p>Si tiene alguna duda, perm�tame ayudarle en nuestra secci�n de ayuda. Tambi�n me puede enviar un correo electr�nico o llamarme al (505) 848-4018. Nuestros especialiastes en atenci�n al cliente lo atender� las 24 horas del d�a los 7 d�as de la semana.
			
			</p>
			</TD></TR>
	</TBODY>
</TABLE>


