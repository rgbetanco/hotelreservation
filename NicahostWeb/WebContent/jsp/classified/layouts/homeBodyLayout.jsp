<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<fmt:setBundle
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />

<table border="0" cellpadding="0" cellspacing="0">
	<tr><td><div class="menuCategoryTitle"><tiles:insert attribute="nav1" ignore="true"/></div></td></tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
	<tr><td><div class="menuCategoryTitle"><tiles:insert attribute="nav2" ignore="true"/></div></td></tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
	<tr><td><div class="menuCategoryTitle"><tiles:insert attribute="nav3" ignore="true"/></div></td></tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
		
</table>
