<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">



<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>


<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH width="60%"><fmt:message key="label.common.description" /></TH>
			<TH width="20%"><fmt:message key="label.common.totalnights" /></TH>
			<TH width="20%"><fmt:message key="label.common.pricepernight" /></TH>
			<TH><fmt:message key="label.common.subtotal" /></TH>
		</TR>
		<c:set var="total" value="0"/>
<c:forEach items="${reserveForm.selectedRooms}" var="roomCheckedBean">		
		<TR>
			<c:set var="desc" value="${roomCheckedBean.description}"/>
			<TD nowrap="nowrap"><fmt:message key="${desc}"/></TD>
			<TD align="center"><c:out value="${numNights}"/></TD>
			<TD align="right">
				<fmt:formatNumber value="${roomCheckedBean.price}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
			</TD>			
			<TD align="right">				
				<c:set var="subtotal" value="${numNights * roomCheckedBean.price}"/>		
				<fmt:formatNumber value="${subtotal}" type="number" maxFractionDigits="2" minFractionDigits="2"/>				
				<c:set var="total" value="${subtotal + total}"/>
			</TD>
		</TR>
		<TR>
			<TD colspan="4">
				<INPUT type="hidden" name="roomId<c:out value='${roomCheckedBean.id}'/>" value="on">
			</TD>
		</TR>
					
</c:forEach>
		<TR>
			<TD colspan="2">&nbsp;</TD>
			<TD align="right"><fmt:message key="label.common.total" />:</TD>
			<TD align="right" nowrap="nowrap">
				<fmt:message key="label.common.currency"/>			
				<fmt:formatNumber value="${total}" type="number" maxFractionDigits="2" minFractionDigits="2"/>							
			</TD>	
		</TR>
		<TR>
			<TD colspan="4">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>