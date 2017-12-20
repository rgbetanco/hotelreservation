
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

<TABLE width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
	<TBODY>		
		<TR>
			<TD class="tableTitle">
				<fmt:message key="label.common.service" />
			</TD>
		</TR>
	</TBODY>
</TABLE>	
<br/>

<CENTER>
<html:form action="step04.do">
<TABLE border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH align="left">
				<img src="/NicahostWeb/img/common/sir.gif" valign="middle">&nbsp;
				<fmt:message key="label.common.service" />
			</TH>
		</TR>
		<TR>
			<TD>&nbsp;
			</TD>
		</TR>
		<TR>
			<TD >
<DIV align="center">
			<INPUT type="image" class="HandPointer" 
					src="<fmt:message key="common.resource.image.accept"/>" 
					name="aceptar" 
					onmouseover="MM_swapImage('aceptar','','<fmt:message key="common.resource.image.acceptOn"/>',1);"
					onmouseout="MM_swapImgRestore();">
</DIV>
			
			</TD>
		</TR>
		
	</TBODY>
</TABLE>
</html:form>
</CENTER>