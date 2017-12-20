
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<script language="JavaScript">

    function printReceipt() {
        window.print();
    }

</script>

<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

<TABLE width="550" border="0" cellpadding="5" cellspacing="5" align="center">
	<TBODY>
		<TR>
			<TH colspan="2"> 
				<fmt:message key="label.common.confirmcode" />: <c:out value="${confirmView.confirmationCode}" />
			</TH>
		</TR>
		<TR>
			<TD colspan="2" class="tableTitle">
				<fmt:message key="label.common.confirmdesc1"/>
				<fmt:message key="label.common.confirmdesc2"/>
				<fmt:message key="label.common.confirmdesc3"/>
				<fmt:message key="label.common.confirmdesc4"/>
				<fmt:message key="label.common.confirmdesc5"/>
				<fmt:message key="label.common.confirmdesc6"/>
				<fmt:message key="label.common.confirmdesc7"/>
			</TD>
		</TR>
		
		<TR>
			<TD colspan="2">
<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable" style="border-width: 0px">
	<TBODY>

	
		<TR>
			<TH colspan="2">

				<fmt:message key="label.step03.personalInfo" />
			</TH>

		</TR>
		
		<TR> 
			<TD class="bold" align="left"></TD>
			<TD class="bold">
				<c:out value="${confirmView.firstName}" /> <c:out value="${confirmView.lastName}" /> 
				&lt;<c:out	value="${confirmView.email}" />&gt;
			</TD>

		</TR>

		<TR>
			<TD class="bold" align="left"></TD>
			<TD><c:out value="${confirmView.address}" /></TD>
		</TR>		
		
		<TR>
			<TD class="bold" align="left"></TD>
			<TD><c:out value="${confirmView.city}" /><c:out
				value="${confirmView.country}" /></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"></TD>
			<TD><c:out value="${confirmView.zip}" /></TD>
		</TR>
		
		<TR>
			<TD class="bold" align="left"></TD>
			<TD></TD>
		</TR>

		<TR>
			<TD class="bold" align="left"></TD>
			<TD></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"></TD>
			<TD></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"></TD>
			<TD></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"></TD>
			<TD></TD>
		</TR>


		<TR>
			<TD colspan="2">&nbsp;</TD>
		</TR>		

	</TBODY>
</TABLE>
			
			</TD>
		</TR>
		
		<TR>
			<TD colspan="2">
<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable" style="border-width: 0px">
	<TBODY>
		<TR>
			<TH colspan="2"><fmt:message key="label.hotelreserve.reservation"/></TH>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.initdate"/>:</TD>
			<TD>
				<fmt:formatDate value="${confirmView.initDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.enddate"/>:</TD>
			<TD>
				<fmt:formatDate value="${confirmView.endDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.totalnights"/>:</TD>
			<TD>
				<c:out value="${confirmView.numNights}"/>
			</TD>
		</TR>
		
		<TR>
			<TD class="bold"><fmt:message key="label.common.roomtype"/>:</TD>
			<TD>
				<fmt:message key="${confirmView.roomTypeName}" />
			</TD>
		</TR>
	</TBODY>
</TABLE>
			
			</TD>
			
		</TR>

		<TR>
			<TD colspan="2">
<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable" style="border-width: 0px">
	<TBODY>
		<TR>
			<TH width="60%"><fmt:message key="label.common.description" /></TH>
			<TH width="20%"><fmt:message key="label.common.totalnights" /></TH>
			<TH width="20%"><fmt:message key="label.common.pricepernight" /></TH>
			<TH><fmt:message key="label.common.subtotal" /></TH>
		</TR>
		<c:set var="total" value="0"/>
<c:forEach items="${confirmView.selectedRooms}" var="roomCheckedBean">		
		<TR>
			<TD nowrap="nowrap"><c:out value="${roomCheckedBean.description}"/></TD>
			<TD align="center"><c:out value="${confirmView.numNights}"/></TD>
			<TD align="right">
				<fmt:formatNumber value="${roomCheckedBean.price}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
			</TD>			
			<TD align="right">				
				<c:set var="subtotal" value="${confirmView.numNights * roomCheckedBean.price}"/>		
				<fmt:formatNumber value="${subtotal}" type="number" maxFractionDigits="2" minFractionDigits="2"/>				
				<c:set var="total" value="${subtotal + total}"/>
			</TD>
		</TR>
		<TR>
			<TD colspan="4">
				<INPUT type="hidden" name="roomId<c:out value='${roomCheckedBean.roomId}'/>" value="on">
			</TD>
		</TR>
					
</c:forEach>
		<TR>
			<TD class="footer" colspan="2">&nbsp;</TD>
			<TD class="footer" align="right"><fmt:message key="label.common.total" />:</TD>
			<TD class="footer" align="right" nowrap="nowrap">
				<fmt:message key="label.common.currency"/>			
				<fmt:formatNumber value="${total}" type="number" maxFractionDigits="2" minFractionDigits="2"/>							
			</TD>	
		</TR>
		<TR>
			<TD colspan="4">&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
			
			</TD>		
		</TR>

		<TR>
			<TD colspan="2">
			
			</TD>		
		</TR>

		<TR>
			<TD colspan="2">
<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable" style="border-width: 0px">
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
		<TR>
			<TD colspan="4" align="center">
			
				<IMG class="HandPointer" 
					src="<fmt:message key="common.resource.image.print"/>" 
					name="aceptar"
					width="70" height="20" 
					onmouseover="MM_swapImage('aceptar','','<fmt:message key="common.resource.image.printON"/>',1);"
					onmouseout="MM_swapImgRestore();"					
					onclick="printReceipt();">
		
			</TD>
		</TR>	 		
				
	</TBODY>
</TABLE>
			
			</TD>		
		</TR>



		
	</TBODY>
</TABLE>









