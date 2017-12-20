<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>



<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>

	
		<TR>
			<TH colspan="2">

				<fmt:message key="label.step03.personalInfo" />
			</TH>

		</TR>
		
		<TR> 
			<TD class="bold" align="left"></TD>
			<TD>
				<c:out value="${reserveForm.firstName}" />
				<c:out value="${reserveForm.lastName}" />&nbsp;
				&lt;<c:out value="${reserveForm.email1}" />&gt;
			</TD>

		</TR>

		
		<c:if test="${not empty reserveForm.address}">
		<TR>
			<TD class="bold" align="left"></TD>
			<TD><c:out value="${reserveForm.address}" /></TD>
		</TR>		
		</c:if>
		
		<TR>
			<TD class="bold" align="left"></TD>
			<TD>
				<c:out value="${reserveForm.country}" />
				<c:if test="${not empty reserveForm.city}"><c:out value="${reserveForm.city}" /></c:if>						  		
				<c:if test="${not empty reserveForm.zip}"><c:out value="${reserveForm.zip}" /></c:if>				
			</TD>
		</TR>


		<c:if test="${not empty reserveForm.phone}">
		<TR>
			<TD class="bold" align="left"></TD>
			
			<TD>
				<fmt:message key="label.common.phone" />:
				<c:out value="${reserveForm.phone}" />
			</TD>
		</TR>
		</c:if>		
		
		<c:if test="${not empty reserveForm.comment}">
		<TR>
			<TD class="bold" align="left"></TD>
			<TD>
			  <c:out value="${reserveForm.comment}" />
			</TD>
		</TR>		
		</c:if>

		<TR>
			<TD colspan="2">&nbsp;</TD>
		</TR>		

	</TBODY>
</TABLE>