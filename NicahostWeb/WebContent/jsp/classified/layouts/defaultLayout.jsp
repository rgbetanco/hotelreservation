
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<html:html>
<fmt:setBundle
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />

<HEAD>
	<TITLE>El Calachero - clasificados, ventas en linea, anuncios y mas</TITLE>
	<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META name="description" content="Anúnciese totalmente gratis en Nicaragua.  Realice sus compras y ventas en linea. Ponga su clasificado con imagen">
	<META name="keywords" content="el calachero, elcalachero, ventas, compras, clasificados, anuncios, Nicaragua, buy, buying, sell, selling, advertisement, casas, apartamentos, computadoras, electrodomesticos, tierras, servicios, carros, vehiculos">
	
	<LINK href="/NicahostWeb/css/clasificadosStyle.css" rel="stylesheet" type="text/css">	
</HEAD>

<BODY bgcolor="#eeeeee">
<TABLE width="95%" border="0" cellspacing="0" cellpadding="5">
	<TBODY>
		<TR>
			<TD colspan="3" align="center">
				<!-- Header -->
				<tiles:insert attribute="header.layout"/>
			</TD>
		</TR>
		<TR>
			<TD colspan="3" align="left">
				<!-- Sub-header -->
				<tiles:insert attribute="sub-header.layout" ignore="true"/>
			</TD>
		</TR>		
		<TR>
			<TD valign="top">
				<!-- Left Menu -->
				<tiles:insert attribute="left.layout" ignore="true"/>
			</TD>
			<TD align="left" valign="top">
				<!-- Body-content -->
				<tiles:insert attribute="body-content"/>
			</TD>
			<TD>
				<!-- Right Menu-->
				<tiles:insert attribute="right.layout" ignore="true" />
			</TD>
		</TR>
		<TR>
			<TD colspan="3" align="center">
				<!-- Footer-->
				<tiles:insert attribute="footer.layout"/>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>
