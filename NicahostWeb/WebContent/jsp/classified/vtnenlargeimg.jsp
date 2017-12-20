
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
<HEAD>
<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<TITLE>Imagen</TITLE>
</HEAD>

<BODY>


<TABLE >
	<TBODY>
		<TR>
			<TD>
				
			</TD>
		</TR>
		<TR>
			<TD>
				<img src="/NicahostWeb/img/clasificados/uploaded/<c:out value='${param.fileName}' />">		
			</TD>
		</TR>
	</TBODY>
</TABLE>
					
</BODY>
</html:html>
