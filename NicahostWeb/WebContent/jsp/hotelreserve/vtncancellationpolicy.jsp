
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<html:html>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<TITLE></TITLE>
</HEAD>

<BODY>
<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

<TABLE id="sessionTable" style="border-width: 0.0pt">
	<TBODY>
		<TR>
			<TD class="footer">
				<fmt:message key="label.common.cancelationpolicytitle"/>
			</TD>
		</TR>
		<TR>
			<TD>
					<fmt:message key="label.common.cancelationpolicy1"/>.&nbsp;
					<fmt:message key="label.common.cancelationpolicy2"/>.&nbsp;
					<fmt:message key="label.common.cancelationpolicy3"/>.&nbsp;
					<fmt:message key="label.common.cancelationpolicy4"/>.			
			</TD>
		</TR>
	</TBODY>
</TABLE>
					
</BODY>
</html:html>
