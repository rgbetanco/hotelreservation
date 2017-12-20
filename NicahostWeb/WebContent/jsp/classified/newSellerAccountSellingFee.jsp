

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
				class="checkoutSubTitle">| pago de comisi�n</SPAN></TD>
		</TR>
		<TR>
			<TD>Favor indique c�mo quiere pagar las comisiones por ventas. Estas comisiones son solamente cargadas cuando se realiza una venta de su producto a trav�s de elcalachero.com. En caso de  tener un cargo adicional, �ste es retirado autom�ticamente de su tarjeta de cr�dito. Puede chequear el balance  o modificar los cargos por comisi�n en <U>Su
			Cuenta</U>.<BR>
			</TD>
		</TR>
	</TBODY>
</TABLE>




<html:form action="selleronlineagree.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2" class="daterror">
			<logic:messagesNotPresent property="GLOBAL_ERROR">
				<logic:messagesPresent>
					Favor seleccione una opci�n
				</logic:messagesPresent>
			</logic:messagesNotPresent>				
			
			</TD>
		</TR>
		<TR>
			<TD valign="top">
				<html:radio property="sellingFee" value="1">
				</html:radio>	
			</TD>
			<TD>			
			elcalachero.com cobra un % del precio del producto autom�ticamente al realizarse una venta.  
					<ul>
						<li>USD$ 0.86 si el precio del producto es menor o igual a USD$30.00</li>
						<li>3% si el precio del producto es mayor a USD$30.00</li>
						<li>No se har�n cargos a su tarjeta de cr�dito</li>
					</ul>
					

			</TD>
		</TR>
		<TR>
			<TD valign="top">
				<html:radio property="sellingFee" value="2">
				</html:radio>	
			
			</TD>
			<TD>
				elcalachero.com siempre cargar� a la siguiente tarjeta de cr�dito:<BR>
				<c:out value="${newSellerAccountForm.map.cardName}"/><br>
					<c:out value="${newSellerAccountForm.map.cardType}" /><br>
					<c:out value="${newSellerAccountForm.map.cardNumber}" /><br>
					exp: <c:out value="${newSellerAccountForm.map.cardMonth}" /> / <c:out value="${newSellerAccountForm.map.cardYear}" />
			
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

				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="this.form.submit();" >
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>
<P><BR>Si tiene alguna duda,  vea nuestra secci�n de ayuda.
</P>
