
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<SCRIPT language="JavaScript" src="/NicahostWeb/js/popup.js"></SCRIPT>
<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<html:base/>

<TABLE border="0" cellpadding="3" cellspacing="0" id="leftMenuTable" width="100%">
	<TBODY>
		<TR>
			<TH></TH>
			<TH nowrap="nowrap"><fmt:message key="common.menu.links"/> </TH>
		</TR>
		<TR>
			<TD><IMG border="0" src="../../../img/common/icon03.gif" width="18" height="15"></TD>
			<TD>
				<a onclick="vtn('/chat/webChat.htm',635,385);" style="cursor: pointer;"><fmt:message key="common.menu.webchat"/></a>
				
			</TD>
		</TR>

		<TR>
			<TD><IMG border="0" src="../../../img/common/care_lock.gif" width="18" height="15"></TD>
			<TD>
				<a href="#"><fmt:message key="common.menu.privacysecurity"/></a>
			</TD>
		</TR>
		<TR>
			<TD><IMG border="0"
				src="../../../img/common/care_scroll.gif" width="18" height="15"></TD>
			<TD><a href="#"><fmt:message key="common.menu.useragreement"/></a></TD>
		</TR>
		<TR>
			<TD><IMG border="0"
				src="../../../img/common/care_secure.gif" width="18" height="15"></TD>
			<TD><a href="#"><fmt:message key="common.menu.creditcard"/></a></TD>
		</TR>
		<TR>
			<TD><IMG border="0"
				src="../../../img/common/care_person.gif" width="18" height="15"></TD>
			<TD><a href="/NicahostWeb/hotelreserve/reservations.do"><fmt:message key="common.menu.administration"/></a></TD>
		</TR>
		<TR>
			<TD><IMG border="0" 
				src="../../../img/common/care_reservation_comput.gif" width="18"
				height="15"></TD><TD><a href="/NicahostWeb/hotelreserve/showLogin.do"><fmt:message key="common.menu.viewcancelreservation"/></a></TD>
		</TR>

		
	</TBODY>
</TABLE>

