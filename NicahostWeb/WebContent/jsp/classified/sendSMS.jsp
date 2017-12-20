
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<script language="javascript">
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
	var f=document.sms;
	var suma=f.msg.value.length;
	f.contador.value=suma;
	return suma;
}
</script>

<TABLE border="0" id="sessionTable">
	<TBODY>
		<TR>
			<TD colspan="2"><SPAN class="checkoutTitle">mis mensajes</SPAN><SPAN
				class="checkoutSubTitle"> | enviar SMS</SPAN></TD></TR>
		<TR>
			<TD colspan="2">Envíele un mensaje de texto SMS al celular del vendedor de este producto para obtener más información.</TD></TR>
	</TBODY>
</TABLE>

<html:form action="sendsms.do">
<TABLE border="0" id="sessionTable">
	<TBODY>
		<TR>
			<TD>

				<html:textarea rows="3" property="msg" cols="14" 
						style="font-family: Verdana; font-size: 10px; background-color: #FFFFCC; border: 1 solid #666666; scrollbar-base-color:#666666;" 
						onkeypress="return Contar(event);" 
						onkeyup="actualice();">
				</html:textarea>
			</TD>
		</TR>
		<TR>
			<TD>
			<font size="1" face="Verdana, Arial, Helvetica, sans-serif">&nbsp;
				<html:text property="contador" style="font-family: Verdana; font-size: 10px; background-color: #FFFFCC; border: 1 solid #000080" 
					   size="3" maxlength="150" readonly="true" />
				<font color="#FF6600">de 120</font>
			</font>			
			</TD>
		</TR>
		<TR>
			<TD>
			<font face="Arial" size="1">Enviar al celular:</font><br>
				<html:text property="movil" onkeypress="return Num(event);"  
						size="12" style="font-family: Verdana; font-size: 10px; background-color: #FFFFCC; border: 1 solid #000080" 
						maxlength="8"/>			
			</TD>
		</TR>
		<TR>
			<TD>
				<font face="Arial" size="1">De parte de:</font><br>
				<html:text property="nombre" size="12" 
					style="font-family: Verdana; font-size: 10px; background-color: #FFFFCC; border: 1 solid #000080" />								
			</TD>			
		</TR>
		<TR>
			<td>
				<html:submit value="Enviar" ></html:submit>
			</td>
		</TR>
	</TBODY>
</TABLE>
</html:form>

			