<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<table border="0" cellpadding="0" cellspacing="0">

	<tr>
		<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr><td><tiles:insert name="commonMenu"/></td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
	<tr><td><div class="menuCategoryTitle"><tiles:insert name="commonPublicity"/></div></td></tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
	<tr><td><div class="menuCategoryTitle"><tiles:insert name="commonLanguage"/></div></td></tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>


<tr><td><div class="menuCategoryTitle"><tiles:insert name="commonSystem"/></div></td></tr>	
		
</table>
