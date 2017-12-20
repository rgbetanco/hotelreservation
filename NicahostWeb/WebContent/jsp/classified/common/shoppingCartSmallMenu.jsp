
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
<c:choose>
<c:when test="${not empty itemsOrdered}">
<TABLE border="0" width="100%" cellpadding="0" cellspacing="0" id="leftMenuTable">
	<TBODY>
		<TR>
			<TH>Shopping Cart</TH>
		</TR>
		<TR>
			<TD nowrap="nowrap">
				<TABLE width="98%" id="smallShopTable" class="small" cellpadding="2" cellspacing="0">
					<TBODY>
						<TR class="small">
							<TH class="small">Qty</TH>
							<TH class="small">Item</TH>
							<TH class="small" style="text-align: right">Total</TH>
						</TR>
				<c:forEach items="${itemsOrdered}" var="adBean">
					   <tr class="small">
					   		<td align="right" class="small" width="25">
					   			<c:out value="${adBean.numItems}" />
					   		</td>
					   		<td class="small" width="45">
					   			<c:out value="${adBean.item.title}" />

					   			
					   		</td>
					   		<td align="right" class="small">
						   		<c:set var="totalCost" value="${adBean.item.cost * adBean.numItems}" />
						   		<fmt:formatNumber value="${totalCost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
						   		<c:set var="grandTotal" value="${totalCost + grandTotal}" />
					   		</td>
					   </tr>
				</c:forEach>		
						<tr>
							<td align="right" class="small" colspan="3" nowrap="nowrap">
							<strong>
								Sub-total: <fmt:formatNumber value="${grandTotal}" type="number" maxFractionDigits="2" minFractionDigits="2" />
							</strong>
							</td>
						</tr>				
					</TBODY>
				</TABLE>
				<A href="/NicahostWeb/clasificados/orderPage.do">View detail</a> | <A href="/NicahostWeb/clasificados/checkout.do">Checkout</a>
			</TD>
		</TR>
		
	</TBODY>
</TABLE>
</c:when>
</c:choose>
