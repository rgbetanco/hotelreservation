
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<TABLE border="0" cellpadding="0" cellspacing="0" id="leftMenuTable" width="100%">
	<TBODY>
		<TR>
			<TH></TH>
			<TH nowrap="nowrap"><fmt:message key="common.menu.reservation"/> </TH>
		</TR>
		<TR>
			<TD></TD>
			<TD>
				<a href="/NicahostWeb/hotelreserve/reservations.do"><fmt:message key="common.menu.noconfirmed"/></a>
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD><a href="/NicahostWeb/hotelreserve/confirmedAnulled.do"><fmt:message key="common.menu.confirmed"/></a></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD><a href="/NicahostWeb/hotelreserve/history.do"><fmt:message key="common.menu.historial"/></a></TD>
		</TR>
		<TR>
			<TH></TH>
			<TH><fmt:message key="common.menu.main"/></TH>
		</TR>
		<TR>
			<TD></TD><TD><a href="/NicahostWeb/hotelreserve/rooms.do"><fmt:message key="common.menu.main.addeditroom"/></a></TD>
		</TR>

		<TR>
			<TD></TD><TD>&nbsp;</TD>
		</TR>
		<TR>
			<TD></TD><TD><a href="/NicahostWeb/hotelreserve/logout.do"><fmt:message key="common.menu.logout"/></a></TD>
		</TR>		
		
	</TBODY>
</TABLE>

