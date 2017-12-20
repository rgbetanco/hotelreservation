
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>


<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH colspan="2"><fmt:message key="label.hotelreserve.reservation"/></TH>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.roomtype" />:</TD>
			<TD>
				<fmt:message key="${roomTypeName}" />
			</TD>
		</TR>		
		<TR>
			<TD class="bold"><fmt:message key="label.common.initdate"/>:</TD>
			<TD>
				<fmt:formatDate value="${reserveForm.initDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.enddate"/>:</TD>
			<TD>
				<fmt:formatDate value="${reserveForm.endDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD>&nbsp;</TD>
			<TD>&nbsp;</TD>
		</TR>
	
</TBODY>
</TABLE>