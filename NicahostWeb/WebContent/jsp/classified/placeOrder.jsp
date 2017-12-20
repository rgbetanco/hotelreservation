

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">


<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">orden de compra</SPAN> <SPAN
				class="checkoutSubTitle">| pagar</SPAN></TD>
		</TR>
		<TR>
			<TD>Por favor revise su orden de compra. El total para esta compra es de: 
			
<c:forEach items="${itemsOrdered}" var="adBean">
	<c:set var="invoiceTotal" value="${invoiceTotal + (adBean.item.cost * adBean.numItems)}"></c:set>
</c:forEach>			
				<strong>
					<fmt:formatNumber value="${(invoiceTotal * 1.15) + checkoutForm.map.shippingOption}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
				</strong> 
			</TD>
		</TR>

	</TBODY>
</TABLE>
<FORM><B>Esta orden será procesada hasta que presione este botón:</B> 
	<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/procesar_orden.gif" onclick="this.form.submit();" width="135" height="17">
</FORM>

<TABLE border="0">
	<TBODY>
		<TR>
			<TD><B>Tarjeta de crédito</B></TD>
			<TD>
				<html:form action="paymentinfo.do">
					<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/cambiar.gif" onclick="this.form.submit();" width="110" height="17">
				</html:form>
			</TD>
		</TR>
		<TR>
			<TD align="left">
			<TABLE border="0" align="left">
				<TBODY>
					<TR>
						<TD>							
							<c:out value="${checkoutForm.map.cardName}" />						
						</TD>
					</TR>
					<TR>
						<TD>
							<c:out value="${checkoutForm.map.cardType}" />
						</TD>
					</TR>
					<TR>
						<TD>
							<c:out value="${checkoutForm.map.cardNumber}" />
						</TD>
					</TR>
					<TR>
						<TD>
							exp: 
							<c:out value="${checkoutForm.map.cardMonth}" /> / <c:out value="${checkoutForm.map.cardYear}" />
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>


<html:form action="shippingaddress.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD><B>Entréguese a</B></TD>
			<TD><INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/cambiar.gif" onclick="this.form.submit();" width="110" height="17"></TD>
		</TR>
		<TR>
			<TD>
				<c:out value="${checkoutForm.map.name}" /><BR>
				<c:out value="${checkoutForm.map.address}" /><BR>
				<c:out value="${checkoutForm.map.city}" />, 
				<c:out value="${checkoutForm.map.state}" /> 
				<c:out value="${checkoutForm.map.zip}" />
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>

<html:form action="placeorder.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD valign="top">
				<html:radio property="shippingOption" value="5.99" onclick="this.form.submit()" />
			</TD>
			<TD>Entrega normal<BR>$5.99
			</TD>
		</TR>
		<TR>
			<TD valign="top">				
				<html:radio property="shippingOption" value="12.99"  onclick="this.form.submit()"/>
			</TD>
			<TD>Entrega de 3 días<BR>$12.99
			</TD>
		</TR>
		<TR>
			<TD valign="top">				
				<html:radio property="shippingOption" value="15.99" onclick="this.form.submit()"/>
			</TD>
			<TD>Entrega de 2 días<BR>$15.99
			</TD>
		</TR>
		<TR>
			<TD valign="top">				
				<html:radio property="shippingOption" value="29.99" onclick="this.form.submit()"/>
			</TD>
			<TD>Entrega en 24 horas<BR>$29.99
			</TD>
		</TR>

	</TBODY>
</TABLE>
</html:form>

<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="3">Artículos en su orden</TD>
			<TD colspan="2">
				<form action="/NicahostWeb/clasificados/orderPage.do" method="post">
					<INPUT type="hidden" name="checkout" value="true">
					<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/cambiar_cantidades.gif" onclick="this.form.submit();" width="135" height="17">
				</form>			
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>Descripción</TD>
			<TD>Cantidad</TD>
			<TD>Precio</TD>
			<TD>Total</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
			<TD></TD>
			<TD></TD>
			<TD></TD>
		</TR>
<c:choose>
<c:when test="${not empty itemsOrdered}">
	<c:forEach items="${itemsOrdered}" var="adBean">
	   <tr>
	   	<td>
	   							<c:choose>
									<c:when test="${not empty adBean.item.fileName}">
										<IMG
											src="<c:out value='${adBean.item.imgPath}'/>/<c:out value='${adBean.item.fileName}' />"
											width="69" height="83" border="0">
								</c:when>
		   							<c:otherwise>
		   								<IMG src="<c:out value='${adBean.item.imgPath}'/>/noimage.gif" width="90" height="90">
		   							</c:otherwise>
		   							
							</c:choose>	   	
	   	</td>
	   	<td>
	   		<c:out value="${adBean.item.desc}" />
	   	</td>

	   	<td align="center" nowrap="nowrap">
	   			<c:out value='${adBean.numItems}' />
	   	</td>
	   	
		<td align="right">
	   		<c:set var="unitCost" value="${adBean.item.cost}" />
	   		<fmt:formatNumber value="${unitCost}" type="number" maxFractionDigits="2" minFractionDigits="2" />	   				
		</td>
	   	
	   	<td align="right">
		   	<c:set value="${adBean.item.cost * adBean.numItems}" var="totalCost" />
			<fmt:formatNumber value="${totalCost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
	   		<c:set var="subTotal" value="${totalCost + subTotal}" />		   	
	   	</td>
	   	
	   </tr>
	</c:forEach>	

	  	<TR>
			<TD colspan="4" align="right">Sub-total: </TD>	  	
			<TD align="right"> 
				<fmt:formatNumber value="${subTotal}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>			
			</TD>	  	
		</TR>
	  	<TR>
			<TD colspan="4" align="right">Cargo por entrega: </TD>	  	
			<TD align="right"> 
				<c:set value="${checkoutForm.map.shippingOption}" var="shippingCost" />
				<fmt:formatNumber value="${shippingCost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>			
			</TD>	  	
		</TR>
	  	<TR>
			<TD colspan="4" align="right">Impuesto: </TD>	  	
			<TD align="right" > 
				<c:set value="${subTotal * 0.15}" var="taxCost" />
				<fmt:formatNumber value="${taxCost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>			
			</TD>	  	
		</TR>
	  	<TR>
			<TD colspan="4" align="right">Total: </TD>	  	
			<TD align="right"> 
				<c:set var="invoiceTotal" value="${subTotal+shippingCost+taxCost}" />
				<fmt:formatNumber value="${invoiceTotal}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>			
			</TD>	  	
		</TR>
		<TR>
			<TD COLSPAN="5">
			</TD>
		</TR>

		
		
</c:when>
<c:otherwise>
	<tr>
		<TD colspan="5"> <B>No hay artículos en su canasta</B>
		</TD>
	</tr>
</c:otherwise>	
	
</c:choose>		
		
	</TBODY>
	
</TABLE>



			<FORM><B>Esta orden será procesada hasta que presione este botón:</B> 
			<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/procesar_orden.gif" onclick="this.form.submit();" width="135" height="17">

