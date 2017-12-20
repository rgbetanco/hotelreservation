
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<TABLE border="0" width="100%" cellpadding="0" cellspacing="0" id="leftMenuTable">
	<TBODY>
		<TR>
			<TD nowrap="nowrap"><a href="/NicahostWeb/hotelreserve/reserve.do"><fmt:message key="common.menu.home"/></a></TD>
		</TR>
		<TR>
			<TD nowrap="nowrap" ><a href="#"><fmt:message key="common.menu.abouthotel"/></a></TD>
		</TR>
		<TR>
			<TD nowrap="nowrap" ><a href="#"><fmt:message key="common.menu.rooms"/></a></TD>
		</TR>
		<TR>
			<TD nowrap="nowrap" ><a href="#"><fmt:message key="common.menu.services"/></a></TD>
		</TR>
		<TR>
			<TD nowrap="nowrap" ><a href="#"><fmt:message key="common.menu.contact"/></a></TD>
		</TR>
	</TBODY>
</TABLE>

