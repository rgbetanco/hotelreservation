
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<html:html>
<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<HEAD>

<TITLE><fmt:message key="title.hotelname"/></TITLE>
</HEAD>

<BODY bgcolor="#eeeeee">



	<!--Table central-->
	<table width="90%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff" align="center">
    <tr>             
		<td width="100%" align="center" valign="middle">
			<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="top"> 
                  <td width="1" bgcolor="#B3AEAB"> <h3><img src="/NicahostWeb/img/common/common/ghost.gif" width="1" height="1" align="absmiddle"></h3></td>
                  <td>
                  					<!--Header-->
						<tiles:insert attribute="header.layout"/>	
				  </td>				  
                  <td width="1" bgcolor="#B3AEAB"> <h3><img src="/NicahostWeb/img/common/ghost.gif" width="1" height="1" align="absmiddle"></h3></td>
				</tr>
			</table>
		</td>
	</tr>
	
    <tr>             
		<td width="100%" align="center" valign="middle" bgcolor="#d4d0c8">
			<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle"> 
                  <td width="1" bgcolor="#B3AEAB"> <h3><img src="/NicahostWeb/img/common/ghost.gif" width="1" height="1" align="absmiddle"></h3></td>
                  <td width="180">&nbsp;</td>
                  <td>
                  			<!--Place menu header here-->
						<tiles:insert name="navBar" />                  			
                  </td>
                  <td width="1" bgcolor="#B3AEAB"> <h3><img src="/NicahostWeb/img/common/ghost.gif" width="1" height="1" align="absmiddle"></h3></td>
				</tr>
			</table>
		</td>
	</tr>
     
    <tr>             
		<td width="100%" height="100%" align="center" valign="middle">
			<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
				<tr align="left" valign="top"> 
                  <td width="1" bgcolor="#B3AEAB"> <h3><img src="/NicahostWeb/img/common/ghost.gif" width="1" height="1" align="absmiddle"></h3></td>
                  <td width="180" bgcolor="#eeeeee" nowrap="nowrap">
							<!-- LEFT MENU-->
						<tiles:insert name="left.layout" />                  
                  </td>
                  <td>

							<!--Body-content-->	
						<p>&nbsp;</p>
							<tiles:insert attribute="body-content"/>                  

                  </td>
                  <td width="1" bgcolor="#B3AEAB"> <h3><img src="/NicahostWeb/img/common/ghost.gif" width="1" height="1" align="absmiddle"></h3></td>
				</tr>
			</table>
		</td>
	</tr>
	
    <tr> 
        <td width="100%" height="44" align="center" valign="middle" > 
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr> 
                  <td width="30%" align="left" valign="middle"><img src="/NicahostWeb/img/common/botleft.gif" width="384" height="44" align="absmiddle"></td>                  
                  <td width="100%" valign="bottom" height="25" bgcolor="#eeeeee">
                  	<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr> 
                           <td height="2" align="center" valign="middle" bgcolor="#B3AEAB"><img src="img/ghost.gif" width="1" height="1" align="bottom"></td>
                        </tr>
                  	</table>
                  </td>
                  <td width="30%" align="right" valign="middle"><img src="/NicahostWeb/img/common/botright.gif" width="384" height="44" align="absmiddle"></td>
                </tr>
            </table>
        </td>
    </tr>


	</table>


</BODY>
</html:html>

