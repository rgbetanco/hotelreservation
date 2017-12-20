
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<TABLE border="0" cellpadding="5" cellspacing="5">
	<TBODY>
		<TR>
			<TD nowrap="nowrap" class="linkA"><a href="/NicahostWeb/hotelreserve/reserve.do"><fmt:message key="common.publicity.hotelsystem"/></a></TD>
		</TR>

		<TR>
			<TD nowrap="nowrap" class="linkA"><a href="/NicahostWeb/hotelreserve/reservations.do"><fmt:message key="common.label.administration"/></a></TD>
		</TR>


	</TBODY>
</TABLE>

