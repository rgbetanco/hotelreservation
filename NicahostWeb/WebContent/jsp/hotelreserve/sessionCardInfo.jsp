<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>


<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH colspan="4"><fmt:message key="label.common.paymentmethod"/></TH>
		</TR>
		<TR>
			<TD class="bold" align="left"><fmt:message key="label.common.creditcard"/>:</TD>
			<TD colspan="3"><c:out value="${reserveForm.cardType}" /></TD>
		</TR>
		<TR>
			<TD class="bold" align="left"><fmt:message key="label.common.cardholder"/>:</TD>
			<TD colspan="3"><c:out value="${reserveForm.cardHolder}" /></TD>
		</TR>

		
		<TR>
			<TD class="bold" align="left"><fmt:message key="label.common.cardnumber"/>:</TD> 
			<TD><c:out value="${reserveForm.cardNumber}" /></TD> 
			<TD class="bold" align="left"><fmt:message key="label.common.expirationdate"/>:</TD> 
			<TD><c:out value="${reserveForm.cardMonth}" /> / <c:out value="${reserveForm.cardYear}" /></TD> 
	 	</TR>

		<TR>
			<TD></TD> 
			<TD></TD> 
			<TD></TD> 
			<TD></TD> 
	 	</TR>

	 	<TR>
			<TD></TD> 
			<TD></TD> 
			<TD></TD> 
			<TD></TD> 
	 	</TR>		
				
	</TBODY>
</TABLE>
