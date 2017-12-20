
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>

<script language="JavaScript">

    function printReceipt() {
        window.print();
    }

</script>

<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

<TABLE width="550" border="0" cellpadding="5" cellspacing="5" align="center">
	<TBODY>
		<TR>
			<TH colspan="2"> 
				<fmt:message key="label.common.confirmcode" />: <c:out value="${confirmView.confirmationCode}" />
			</TH>
		</TR>
		<TR>
			<TD colspan="2" class="tableTitle">
				<fmt:message key="label.common.confirmdesc1"/>
				<fmt:message key="label.common.confirmdesc2"/>
				<fmt:message key="label.common.confirmdesc3"/>
				<fmt:message key="label.common.confirmdesc4"/>
				<fmt:message key="label.common.confirmdesc5"/>
				<fmt:message key="label.common.confirmdesc6"/>
				<fmt:message key="label.common.confirmdesc7"/>
			</TD>
		</TR>

		<TR>
			<TD colspan="2">
				
				<IMG class="HandPointer" 
					src="<fmt:message key="common.resource.image.print"/>" 
					name="aceptar" 
					onmouseover="MM_swapImage('aceptar','','<fmt:message key="common.resource.image.printON"/>',1);"
					onmouseout="MM_swapImgRestore();"					
					onclick="printReceipt();">				
				
			</TD>		
		</TR>



		
	</TBODY>
</TABLE>









