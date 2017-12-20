
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<SCRIPT language="JavaScript" src="/NicahostWeb/js/popup.js"></SCRIPT>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />


<TABLE border="0" width="100%" cellpadding="0" cellspacing="0" id="leftMenuTable">
	<TBODY>
		<TR>
			<TH>Otros Vínculos</TH>
		</TR>
		<TR>
			<TD nowrap="nowrap"><a href="/NicahostWeb/clasificados/anuncieseformat.do">An&uacute;nciese</a></TD>
		</TR>
		<tr>
			<TD>
				<a onclick="vtn('/html/classified/webChat.htm',635,385);" style="cursor: pointer;">Web Chat</a>
				
			</TD>
		</tr>
		
	</TBODY>
</TABLE>

<P><IMG border="0" src="../../../img/common/poweredByLogo_112x22.gif"
	width="112" height="22"></P>