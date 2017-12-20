<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>

<fmt:setBundle 
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<TITLE>History</TITLE>
<H1 align="center"><fmt:message key="labelAdmin.table.header1" /></H1>

<c:forEach items="${History}" var="reserve">

<TABLE width="80%" align="center" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY align="center">
		
		<TR class="tableTitle">
			<TH><fmt:message key="labelAdmin.table.row1" /></TH>
			<TH><fmt:message key="labelAdmin.table.row2" /></TH>
			<TH><fmt:message key="labelAdmin.table.row3" /></TH>
			<TH><fmt:message key="labelAdmin.table.row4" /></TH>
			<TH><fmt:message key="labelAdmin.table.row5" /></TH>
		</TR>
		<TR>
			<INPUT type="hidden" name="idRemote"  value="<c:out value="${reserve.id}"/>">
			<TD><c:out value="${reserve.roomNumV}"/></TD>
			<TD><a href="/NicahostWeb/jsp/hotelreserve/admin/SendMail.jsp?emailParm=<c:out value="${reserve.emailV}"/>" target="_blank"><c:out value="${reserve.emailV}"/></a></TD>
			<TD><c:out value="${reserve.firstNameV}"/></TD>
			<TD><c:out value="${reserve.lastNameV}"/></TD>
			<TD><c:out value="${reserve.reservationDateV}"/></TD>
		</TR>
		<TR class="tableTitle">
			<TH><fmt:message key="labelAdmin.table.row6" /></TH>
			<TH><fmt:message key="labelAdmin.table.row7" /></TH>
			<TH><fmt:message key="labelAdmin.table.row9a" /></TH>
			<TH><fmt:message key="labelAdmin.table.row10a" /></TH>
			<TH><fmt:message key="labelAdmin.table.row11" /></TH>
		</TR>
		<TR>
			<TD><c:out value="${reserve.checkinDateV}"/></TD>
			<TD><c:out value="${reserve.checkoutDateV}"/></TD>
			<TD><c:out value="${reserve.statusV}"/></TD>
			<TD><c:out value="${reserve.totalV}"/></TD>
			<TD><c:out value="${reserve.commentV}"/></TD>
		</TR>
		
	</TBODY>
</TABLE>
<P></P>
</c:forEach>