
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">


<script language="javascript">
var LIMITE = 1000;

function Num(evt,flg){	
	var key=nav4 ? evt.which : evt.keyCode;
	if(flg) return ((key <= 13) || (key >= 48 && key <= 57));
	if((key <= 13) || (key >= 48 && key <= 57)) return true;
	return false;
}

function Contar(evt) {
	var suma=actualice() + 1;
	if(suma > LIMITE) {
		alert("Hey! la cantidad máxima de caracteres por mensaje es de " + LIMITE + ".");
		return false;
	}
	return true;
}

function actualice() {
	var f=document.emailForm;
	var suma=f.body.value.length;
	f.contador.value=suma;
	return suma;
}
</script>


<TABLE border="0" id="sessionTable">
	<TBODY>
		<TR>
			<TD colspan="2"><SPAN class="checkoutTitle">mis mensajes</SPAN><SPAN
				class="checkoutSubTitle"> | enviar correo electrónico</SPAN></TD></TR>
		<TR>
			<TD colspan="2">Envíele un correo electrónico al vendedor de este producto para más información.</TD></TR>
	</TBODY>
</TABLE>

<TABLE border="0" id="sessionTable">
	<TBODY>
		<TR>
			<TD>
			<html:form action="sendemail.do">
			<TABLE border="0" cellpadding="0" cellspacing="0" id="sessionTable">
				<TBODY>
					<TR>
						<TD>
				<logic:messagesPresent property="toEmail"><strong><SPAN
						class="daterror">Para:*</SPAN></strong></logic:messagesPresent>			
				<logic:messagesNotPresent property="toEmail">Para:</logic:messagesNotPresent>
						</TD>
						<TD>
							<html:hidden property="toEmail"/>
							<html:hidden property="name"/>
							<strong><c:out value="${emailForm.name}"/></strong>
						</TD>
					</TR>
					<TR>
						<TD>
				<logic:messagesPresent property="fromEmail"><strong><SPAN
						class="daterror">Tu e-mail:*</SPAN></strong></logic:messagesPresent>			
				<logic:messagesNotPresent property="fromEmail">Tu e-mail:</logic:messagesNotPresent>

						</TD>
						<TD>
							<html:text property="fromEmail" size="32"></html:text>
						</TD>
					</TR>
					<TR>
						<TD>
				<logic:messagesPresent property="productDescription"><strong><SPAN
						class="daterror">Producto:*</SPAN></strong></logic:messagesPresent>			
				<logic:messagesNotPresent property="productDescription">Producto:</logic:messagesNotPresent>

						</TD>
						<TD>						
							<html:hidden property="productDescription" />	
							<c:out value="${emailForm.productDescription}"/>
						</TD>
					</TR>
					<TR>
						<TD>
				<logic:messagesPresent property="subject"><strong><SPAN
						class="daterror">Asunto:*</SPAN></strong></logic:messagesPresent>			
				<logic:messagesNotPresent property="subject">Asunto:</logic:messagesNotPresent>

						</TD>
						<TD>
							<html:text property="subject" size="32"></html:text>
						</TD>
					</TR>
					<TR>
						<TD colspan="2">
				<logic:messagesPresent property="body"><strong><SPAN
						class="daterror">Ingrese su pregunta:*</SPAN></strong>
				</logic:messagesPresent>			<br>
						
							<html:textarea property="body" 
										cols="47" rows="5"
										onkeypress="return Contar(event);" 
										onkeyup="actualice();"							
							>
								Ingrese aquí su pregunta								
							</html:textarea><br>
							<input type="text" 
									name="contador" 
									value="<c:out value='${param.contador}' />" 
									readonly="readonly" 
									style="color: #154a84; border-width: 0px;"
									size="2"> de 1,000 caracteres máximos.  No incluya tags HTML.
						</TD>
					</TR>					
					<tr>
						<td colspan="2">
						<p>
						elcalachero.com enviará su mensaje a <strong><c:out value="${emailForm.name}"/></strong>
						</p>
						<p>
						<html:checkbox property="hideEmail">Ocultar mi E-mail</html:checkbox>
						<br>
						<html:checkbox property="copyEmail">Enviar una copia a mi E-mail</html:checkbox>
						</p>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<html:submit value="Enviar"></html:submit>
							<html:button property="Cancelar" value="Cancelar" onclick="location.href='browse.do';"></html:button>

						</td>
					</tr>
				</TBODY>
			</TABLE>
			
			</html:form>
			
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>