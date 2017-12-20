
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
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE></TITLE>
</HEAD>

<BODY><P><jsp:include page="header.jsp" /></P>

<TABLE border="1">
	<TBODY>
		<TR>
			<c:forEach items="${photoGallery}" var="photos">
			<TD><P><IMG border="0" src="/img/hotelPhotoGallery/<c:out value='${photos.picName}'/>"></P></TD>
			</c:forEach>
		</TR>
		
	</TBODY>
</TABLE>
</BODY>
</html:html>
