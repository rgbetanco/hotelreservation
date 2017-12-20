
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />



<TABLE width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
	<TBODY>
		<!-- /RUTA NAVEGACION -->
		<TR valign="middle">
			<TD class="linkNavBar"> 
				<c:forEach items="${headerForm.navigationItems}" var="navigationItem" varStatus="position">
				<c:if test="${empty navigationItem.URLReference}">
				
					<c:set var="eth" value="${navigationItem.text}" />
					<fmt:message key="${eth}" />				
										
		        </c:if>
				<c:if test="${not empty navigationItem.URLReference}">
					<A href='<c:out value="${navigationItem.URLReference}" />'>
						<c:set var="eth" value="${navigationItem.text}" />
						<fmt:message key="${eth}" />										
					</A>
	
          		</c:if>

				<c:if test="${!position.last}">
					&nbsp;&gt;
				</c:if>		          		
				</c:forEach> 
			</TD>
		</TR>
	</TBODY>
</TABLE>


