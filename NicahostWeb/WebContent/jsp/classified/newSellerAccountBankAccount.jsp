

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<html:base/>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">nueva cuenta de vendedor</SPAN> <SPAN
				class="checkoutSubTitle">| cuenta bancaria</SPAN></TD>
		</TR>
		<TR>
			<TD>Ingrese los datos correspondientes a su cuenta bancaria en este formulario. A esta cuenta se harán los depósitos de todas las ventas realizadas a través de elcalachero.com. (Esto es completamente seguro - he <U>aquí</U> el porqué)</TD>
		</TR>
	</TBODY>
</TABLE>




<html:form action="selleronlinesellingfee.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2" class="daterror">
			<logic:messagesNotPresent property="GLOBAL_ERROR">
				<logic:messagesPresent>
					Favor corrija los campos indicados
				</logic:messagesPresent>
			</logic:messagesNotPresent>				
			
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="bankName">
					<B><SPAN class="daterror">Nombre del Banco:*</SPAN></B>
				</logic:messagesPresent>	
				<logic:messagesNotPresent property="bankName">Nombre del Banco:</logic:messagesNotPresent>
				
			</TD>
			<TD>

				<html:select property="bankName"> 
					<option value="">-- <fmt:message key="label.common.select"/> --</option>
					<html:options collection="banks" property="value" labelProperty="label"/>
				</html:select>			
			&nbsp;&nbsp;&nbsp;&nbsp;</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="bankAccount">
					<B><SPAN class="daterror">Número de cuenta bancaria:*</SPAN></B>
				</logic:messagesPresent>
				<logic:messagesNotPresent property="bankAccount">Número de cuenta bancaria:</logic:messagesNotPresent>
			</TD>
			<TD>				
				<html:text property="bankAccount" size="32" />
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="bankAccountHolder"><strong><SPAN
						class="daterror">Dueño de la cuenta:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="bankAccountHolder">Dueño de la cuenta:</logic:messagesNotPresent>
				
			</TD>
			<TD>
				<html:text property="bankAccountHolder" size="32" />
				<br></TD>
		</TR>
		<TR>
			<TD align="right"></TD>
			<TD>

				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/usar_esta.gif" onclick="this.form.submit();" width="110" height="17">
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>
<P><BR>Si tiene alguna duda,  vea nuestra sección de ayuda.
</P>
