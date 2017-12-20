<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<html:base/>


<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">vender artículo</SPAN> <SPAN
				class="checkoutSubTitle">| fotos</SPAN></TD>
		</TR>
		<TR>
			<TD>Agregue fotos para este artículo:
			<ul>
				<li> Los formatos permitidos son JPEG, GIF y PNG</li>
				<li> El tamaño de las fotos no debe de sobrepasar los 256Kb por foto</li>
				<li> Para una mejor resolución, someta fotos no mayor a 200x200 pixeles	</li>		
			</ul>
			</TD>
		</TR>
	</TBODY>
</TABLE>

<html:form action="sellitempayment.do" enctype="multipart/form-data">

	<CENTER>
	<TABLE border="0" cellpadding="5" cellspacing="0" id="sessionTable"
		width="90%">
		<THEAD>
				<tr>
					<td class="daterror" colspan="2">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
	      
					</td>				
				</tr>				  	     	  	     
		</THEAD>		
		<TBODY>
			<TR>
				<TD align="center" colspan="2">

				</TD>
			</TR>		
			<TR>
				<TD align="left">Foto 1 (Gratis):</TD>
				<TD>
					<html:file property="myFile1" size="45" />
				</TD>
			</TR>
			<TR>
				<TD align="left">Foto 2 (cargo $0.5)</TD>
				<TD><html:file property="myFile2" size="45" /></TD>
			</TR>
			<TR>
				<TD align="left">Foto 3 (cargo $0.5)</TD>
				<TD><html:file property="myFile3" size="45" /></TD>
			</TR>
			
			<TR>
				<TD align="left"></TD>
				<TD></TD>
			</TR>
			<TR>
				<TD align="left" colspan="2">Opciones:<BR>
				<html:checkbox property="showNew">Agregar New!</html:checkbox>
				</TD></TR>
			<TR>
				<TD align="center" colspan="2">
					<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="this.form.submit();" >				
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	</CENTER>

</html:form>