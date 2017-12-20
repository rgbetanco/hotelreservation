

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />
<TABLE border="0" align="center" width="550">
	<TBODY>
		<TR>
			<TD valign="top"><tiles:insert attribute="msgHeader"/></TD>			
		</TR>	
		<TR>
			<TD valign="top"><tiles:insert attribute="sessionSelectedDates"/></TD>
			
		</TR>
		<TR>
			<TD valign="top"><tiles:insert attribute="sessionSelectedRooms"/></TD>			
		</TR>
		<TR>
			<TD valign="top"><tiles:insert attribute="sessionSelectedGuestInfo"/></TD>

		</TR>
		<TR>
			<TD valign="top"><tiles:insert attribute="sessionSelectedCardInfo"/></TD>			
		</TR>
		<TR>
			<TD><tiles:insert attribute="dataInput"/></TD>
		</TR>	
		<TR>
			<TD valign="top"><tiles:insert attribute="msgFooter"/></TD>			
		</TR>	
		
	</TBODY>
</TABLE>




