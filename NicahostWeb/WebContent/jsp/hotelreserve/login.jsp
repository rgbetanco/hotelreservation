<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle 	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>

<SCRIPT language=Javascript1.1 type=text/javascript>
<!--

var submitCount = 0;


//-->
</SCRIPT>

<html:form action="showPlacedReservation.do" focus="user">
<TABLE align="center" width="80%" border="0" cellpadding="5" cellspacing="5" id="sessionTable">
	<TBODY>
	<TR>
		<TD class="daterror" colspan="2">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
	      </TD>
	 </TR>
		<TR>
			<TD><fmt:message key="label.common.email" /> </TD>
			<TD>
				<html:text property="user"></html:text>
			</TD>
		</TR>
		<TR>
			<TD><fmt:message key="label.common.confirmcode" /> </TD>
			<TD><input type="text" name="pass" > </TD>
		</TR>
		<TR>
			<TD colspan="2" align="center">
			<INPUT type="image" class="HandPointer" 
					src="<fmt:message key="common.resource.image.accept"/>" 
					name="continue" 
					onmouseover="MM_swapImage('continue','','<fmt:message key="common.resource.image.acceptOn"/>',1);"
					onmouseout="MM_swapImgRestore();"					
					onclick="singleSubmit(this.form)">			
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>