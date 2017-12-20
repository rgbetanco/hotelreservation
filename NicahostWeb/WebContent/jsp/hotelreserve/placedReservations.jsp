<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle 	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>

<script language="JavaScript">

    function printReceipt() {
        window.print();
    }

</script>


<TABLE width="80%" border="0" align="center" >
	<TBODY>
	<TR>
		<TD class="daterror" colspan="2">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
	      </TD>
	 </TR>
	 	
		<TR><TD class="tableTitle">
			<fmt:message key="label.common.reservationsmade"/>: <c:out value="${firstName}" /> <c:out value="${lastName}" />
			</TD>
		</TR>
	</TBODY>
</TABLE>
<P></P>

<TABLE width="80%" border="0" id="sessionTable" align="center">
	<TBODY>
		<TR>
			<TH> &nbsp;</TH>		
			<TH><fmt:message key="label.common.roomid"></fmt:message> </TH>
			<TH><fmt:message key="label.common.description"></fmt:message></TH>
			<TH><fmt:message key="label.common.roomstatus"></fmt:message></TH>
		</TR>
<c:forEach items="${placedReservations}" var="reservation" varStatus="pos">
		<TR>
			<TD><c:out value="${pos.count}" /> </TD>
			<TD>Room <c:out value="${reservation.roomId}" /> </TD>
			<c:set var="desc" value="${reservation.description}" />
			<TD><fmt:message key="${desc}" /> </TD>
			<TD><c:out value="${reservation.status}" /> </TD>
		</TR>

</c:forEach>
		
	</TBODY>
</TABLE>

<p></p>


<TABLE width="80%" border="0" cellpadding="0" cellspacing="0" id="sessionTable" align="center">
	<TBODY>
		<TR>
			<TH colspan="2"><fmt:message key="label.hotelreserve.reservation"/></TH>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.initdate"/>:</TD>
			<TD>
				<fmt:formatDate value="${initDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.enddate"/>:</TD>
			<TD>
				<fmt:formatDate value="${endDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.totalnights"/>:</TD>
			<TD>
				<c:out value="${numNights}"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.numguests"/>:</TD>
			<TD>
				<c:out value="${guest}"/> <fmt:message key="label.common.adult"/>
			</TD>
		</TR>

		
		<TR>
			<TD class="bold"><fmt:message key="label.common.roomtype"/>:</TD>
			<TD>
				<fmt:message key="${roomTypeName}" />
			</TD>
		</TR>
	</TBODY>
</TABLE>
<P></P>



<form action="cancelReservation.do" method="post" >
<TABLE width="80%" border="0" align="center">
	<TBODY>
		<TR>
			<TD colspan="2">
				<INPUT type="hidden" name="email" value="<c:out value="${email}"/> ">
				<INPUT type="hidden" name="code" value="<c:out value="${code}"/>">
			</TD>
		</TR>
		<TR>
			<c:if test="${status == 2}">
				<TD class="tableTitle" align="center">
					<input type="submit"  value="<fmt:message key='label.common.cancelreservation' />">
				</TD>
			</c:if>
				<TD>
					<input type="button" value="<fmt:message key='label.common.print' /> " onclick="printReceipt();">
				</TD>
		</TR>
	</TBODY>
</TABLE>
</form>
<P></P>

