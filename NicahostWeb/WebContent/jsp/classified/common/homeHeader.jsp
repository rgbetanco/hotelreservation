<style type="text/css">
<!--
BODY { font-family: verdana,arial,helvetica,sans-serif; font-size: x-small; background-color: #FFFFFF; color: #000000; margin-top: 0px; }
TD, TH { font-family: verdana,arial,helvetica,sans-serif; font-size: x-small; }
a:link { font-family: verdana,arial,helvetica,sans-serif; color: #003399; }
a:visited { font-family: verdana,arial,helvetica,sans-serif; color: #996633; }
a:active { font-family: verdana,arial,helvetica,sans-serif; color: #FF9933; }
.serif { font-family: times,serif; font-size: small; }
.sans { font-family: verdana,arial,helvetica,sans-serif; font-size: small; }
.small { font-family: verdana,arial,helvetica,sans-serif; font-size: x-small; }
.h1 { font-family: verdana,arial,helvetica,sans-serif; color: #CC6600; font-size: small; }
.h3color { font-family: verdana,arial,helvetica,sans-serif; color: #CC6600; font-size: x-small; }
.tiny { font-family: verdana,arial,helvetica,sans-serif; font-size: xx-small; }
.listprice { font-family: arial,verdana,helvetica,sans-serif; text-decoration: line-through; }
.attention { background-color: #FFFFD5; }
.price { font-family: arial,verdana,helvetica,sans-serif; color: #990000; }
.tinyprice { font-family: verdana,arial,helvetica,sans-serif; color: #990000; font-size: xx-small; }
.highlight { font-family: verdana,arial,helvetica,sans-serif; color: #990000; font-size: x-small; } 
.alertgreen { color: #009900; font-weight: bold; }
.alert { color: #FF0000; font-weight: bold; }
.topnav { font-family: verdana,arial,helvetica,sans-serif; font-size: 12px; text-decoration: none; }
.topnav a:link, .topnav a:visited { color: #003399; }
.topnav a:hover { color: #CC6600; }
.topnav-active a:link, .topnav-active a:visited { font-family: verdana,arial,helvetica,sans-serif; font-size: 12px; color: #CC6600; text-decoration: none; }
.eyebrow { font-family: verdana,arial,helvetica,sans-serif; font-size: 10px; font-weight: bold;text-transform: uppercase; text-decoration: none; color: #FFFFFF; }
.eyebrow a:link { text-decoration: none; }
.popover-tiny { font-size: xx-small; font-family: verdana,arial,helvetica,sans-serif; }
.popover-tiny a, .popover-tiny a:visited { text-decoration: none; color: #003399; }
.popover-tiny a:hover { text-decoration: none; color: #CC6600; }
.tabon a:hover, .taboff a:hover { text-decoration: underline; }
.tabon div, .taboff div { margin-top: 7px; margin-left: 9px; margin-bottom: 5px; }
.tabon a, .tabon a:visited  { font-size: 10px; color: #FFCC66; font-family: verdana,arial,helvetica,sans-serif; text-decoration: none; text-transform: uppercase; font-weight: bold; line-height: 10px; }
.taboff a, .taboff a:visited { font-size: 10px; color: #000000; font-family: verdana,arial,helvetica,sans-serif; text-decoration: none; text-transform: uppercase; font-weight: bold; line-height: 10px; }
.indent { margin-left: 1em; }
.half { font-size: .5em; }
.list div { margin-bottom: 0.25em; text-decoration: none; }
.hr-center { margin: 15px; border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: dotted; border-right-style: none; border-bottom-style: none; border-left-style: none; border-top-color: #999999; border-right-color: #999999; border-bottom-color: #999999; border-left-color: #999999; }
.horizontal-search { font-weight: bold; font-size: x-small; color: #FFFFFF; font-family: verdana,arial,helvetica,sans-serif; }
.horizontal-websearch { font-size: xx-small; font-family: verdana,arial,helvetica,sans-serif; padding-left: 12px; }
.big { font-size: x-large; font-family: verdana,arial,helvetica,sans-serif; }
.amabot_right .h1 { color: #c60; font-size: .92em; }
.amabot_right .amabot_widget {  padding-top: 8px;  padding-bottom: 8px;  padding-left: 8px;  padding-right: 8px;  border-bottom: 1px solid #ADD2E2;   border-left: 1px solid #ADD2E2;  border-right: 1px solid #ADD2E2;  border-top: 1px solid #ADD2E2; }
.amabot_left .h1 { color: #c60; font-size: .92em; }
.amabot_left .amabot_widget {  padding-top: 8px;  padding-bottom: 8px;  padding-left: 8px;  padding-right: 8px;  border-bottom: 1px solid #ADD2E2;   border-left: 1px solid #ADD2E2;  border-right: 1px solid #ADD2E2;  border-top: 1px solid #ADD2E2; }
.amabot_center {  font-size: 12px; }
.amabot_right {  font-size: 12px; }
.amabot_left {  font-size: 12px; }
.rightArrow { color: #c60; font-weight: bold; padding-right: 6px; }


--></style>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<SCRIPT language="JavaScript" src="/NicahostWeb/js/popup.js"></SCRIPT>

<!-- Aqui indico, el lugar donde est�n los archivos de propiedades para la internacionalizaci�n.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />

<html:base/>

<TABLE width="100%" border="0" cellpadding="5" cellspacing="0">
	<TBODY>
		<TR>
			<TD width="20%"><img src="/NicahostWeb/img/common/common/ghost.gif" width="1" height="1" ></TD>
			<td align="right" class="topnav" height="80%"> 			
			<a href="/NicahostWeb/clasificados/anuncieseformat.do">An�nciese</A>  | <A href="/NicahostWeb/clasificados/orderPage.do"><IMG border="0"
				src="../../../img/clasificados/topnav-cart.gif" width="19"
				height="16"> Carrito</A> | 
			
			<a onclick="vtn('/html/classified/webChat.htm',635,385);" style="cursor: pointer; color: #003399;"><u>Chat</u></a> 
			<c:if test="${not empty userProfile}">
				| <A href="/NicahostWeb/clasificados/signout.do">Sign out</a>
			</c:if>
			
			</td>
		</TR>
		<TR>
			<TD rowspan="2" valign="bottom">
				<A href="/NicahostWeb/clasificados/default.do">
					<IMG border="0"	src="../../../img/clasificados/mainlogo.gif" width="284" height="43">
				</A>			
			</TD>
			<TD><img src="/NicahostWeb/img/common/common/ghost.gif" width="1" height="1" ></TD>
		</TR>
		<TR>
			<TD align="right">
			<TABLE bgcolor="#4c94ba" border="0" style="color: white; font-weight: bold; font-size: x-small;">
	    		<tr>
					<TD>					
					<html:form action="browse.do">&nbsp;�Qu&eacute; est&aacute;s buscando? >> &nbsp; <html:text property="criteria" size="20"></html:text><input type=submit value="Buscar"  /></html:form>	    			
	    			</td>
	    		</tr>

			</TABLE>		
		
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>