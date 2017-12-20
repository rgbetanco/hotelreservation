
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />







<H1 align="center"><fmt:message key="title.hotelname"/>  </H1>
<table width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
<tr>
    <td class="linkNavBar">&#160;
      <!-- RUTA NAVEGACION -->
      <c:forEach items="${headerForm.navigationItems}" var="navigationItem" >
          <c:if test="${empty navigationItem.URLReference}">
              <c:out value="${navigationItem.text}" />&nbsp;&gt;
          </c:if>
          <c:if test="${not empty navigationItem.URLReference}">
              <a href="<c:out value="${navigationItem.URLReference}" />"><c:out value="${navigationItem.text}"/></a>&nbsp;&gt;
          </c:if>
      </c:forEach>
      <!-- /RUTA NAVEGACION --></td>
</tr>
</table>



