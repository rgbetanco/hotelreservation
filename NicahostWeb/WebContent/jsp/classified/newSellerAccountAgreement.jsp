

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
				class="checkoutSubTitle">| autorizaci�n</SPAN></TD>
		</TR>
		<TR>
			<TD>Al aceptar el siguiente acuerdo, usted se somete a las pol�ticas aqu� descrita por elcalachero.com. Favor revise los datos y presione <B>Autorizar</B><BR>
			</TD>
		</TR>
	</TBODY>
</TABLE>




<html:form action="selleronlineadd.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2" class="daterror">
			<logic:messagesNotPresent property="GLOBAL_ERROR">
				<logic:messagesPresent property="Iagree">
					Debe de estar de acuerdo con la pol�tica para poder continuar
				</logic:messagesPresent>
			</logic:messagesNotPresent>				
			
			</TD>
		</TR>
		<TR>
			<TD colspan="2">				
				<TEXTAREA cols="90" rows="10" readonly="readonly" >
Autorizaci�n de pagos:  Al entrar con mi usuario y contrase�a durante el proceso de creaci�n de una cuenta de vendedor, Yo consiento su uso como una firma digital equivalente a mi firma manuscrita igual como se aplicase bajo las leyes de Nicaragua.  Esta firma electronica se aplica solamente a este T�rmino de Referencia.  
Al seleccionar:
<c:choose>
<c:when test="${newSellerAccountForm.map.sellingFee == '1'}">
"Porcentaje de comisi�n sobre el precio que Yo establezco sobre el producto a vender"
</c:when>
<c:otherwise>
"Cargar siempre a la siguiente tarjeta: <c:out value="${newSellerAccountForm.map.cardNumber}" />" 
</c:otherwise>
</c:choose>

Yo autorizo a elcalachero.com que haga los d�bitos necesarios de la venta; los cargos por membresia u otro cargo que pueda incurrir en mi cuenta desde la ultima fecha de corte.  Esto incluye cualquier balance que tenga en mi cuenta.				

Entiendo que soy responsable por todos los gastos de ventas en conjunto con mi cuenta de elcalachero.com ya sean hechos por mi u otro usuario, y Yo autorizo que se hagan deducciones ya sea de mi tarjeta de cr�dito o pagos sobre la venta del producto segun la opci�n que he seleccionado.  Entiendo que las notificaciones relacionadas con esta autorizaci�n pueden ser enviadas a mi correo electr�nico.  

elcalachero.com se compromete a acreditar mesualmente o por el periodo establecido en mutuo acuerdo a la siguiente cuenta bancaria:

Banco:	<c:out value="${newSellerAccountForm.map.bankName}"/>
N�mero de cuenta:	<c:out value="${newSellerAccountForm.map.bankAccount}"/>
Nombre de la cuenta:	<c:out value="${newSellerAccountForm.map.bankAccountHolder}"/>


				</TEXTAREA>
			</TD>
		</TR>
		
		<TR>
			<TD valign="top" align="right">
				<html:checkbox property="Iagree"></html:checkbox>
			
			</TD>
			<TD>
			Estoy de acurdo con estas pol�ticas
			</TD>
		</TR>
		<TR>
			<TD align="right">
				
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD align="right"></TD>
			<TD align="center">

				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/autorizar.gif" onclick="this.form.submit();" >
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>
<P><BR>Si tiene alguna duda,  vea nuestra secci�n de ayuda.
</P>
