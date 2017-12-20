
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle 
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<LINK rel="stylesheet" href="/NicahostWeb/css/datepickerStyle.css" type="text/css">
<LINK rel="stylesheet" href="/NicahostWeb/css/Master.css" type="text/css">


<SCRIPT language=JavaScript src="/NicahostWeb/js/datepicker.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/hotelreserve.js"></SCRIPT>

<html:html>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>Confirmation</TITLE>
</HEAD>

<BODY>
<c:set var="totalC" value="0"/>
<TABLE width="70%" align="center" border="1" cellpadding="0" cellspacing="0" id="sessionTable">
	<TH><fmt:message key="label.changesCommit.admin.Confirmations"/></TH>
	
	<c:forEach items="${ConfirmedAttributes}" var="confirmed">	
		<c:set var="totalC" value="${totalC+1}"/>
	</c:forEach>
	<TH align="left"><c:out value="${totalC}"/></TH>
</TABLE>


<c:set var="totalA" value="0"/>
<TABLE width="70%" align="center" border="1" cellpadding="0" cellspacing="0" id="sessionTable">
	<TH><fmt:message key="label.changesCommit.admin.Annulations"/></TH>
	<c:forEach items="${AnnulledAttributes}" var="anulled">
		<c:set var="totalA" value="${totalA+1}"/>
	</c:forEach>
	<TH align="left" ><c:out value="${totalA}"/></TH>
</TABLE>


<c:set var="totalN" value = "0"/>
<TABLE width="70%" align="center" border="1" cellpadding="0" cellspacing="0" id="sessionTable">
	<TH><fmt:message key="label.changeCommit.admin.notConfirmed"/></TH>
	<c:forEach items="${notConfirmedAttributes}" var="notConfirmed">	
		<c:set var="totalN" value="${totalN+1}"/>
	</c:forEach>
	<TH align="left"><c:out value="${totalN}"/></TH>
</TABLE>

</BODY>
</html:html>
