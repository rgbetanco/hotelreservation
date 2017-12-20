
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<fmt:setBundle basename="com.nicahost.framework.FrameworkMessageResources" />
<LINK rel="stylesheet" href="/NicahostWeb/css/Master.css" type="text/css"> 

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">

<P>Place header.jsp's content here.</P>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
    <td class="fontusrsuc">&#160;
      <!-- RUTA NAVEGACION -->
      <c:forEach items="${headerForm.navigationItems}" var="navigationItem">
          <c:if test="${empty navigationItem.URLReference}">
              <c:out value="${navigationItem.text}" />
          </c:if>
          <c:if test="${not empty navigationItem.URLReference}">
              <a href="<c:out value="${navigationItem.URLReference}" />"><c:out value="${navigationItem.text}"/></a>&nbsp;&gt;
          </c:if>
      </c:forEach>
      <!-- /RUTA NAVEGACION --></td>
</tr>
</table>



