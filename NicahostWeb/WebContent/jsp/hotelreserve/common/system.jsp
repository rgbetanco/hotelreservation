
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
var how_many_ads = 4;
var now = new Date()
var sec = now.getSeconds()
var ad = sec % how_many_ads;
ad +=1;
if (ad==1) {
txt="Ron Flor de Caña Centenario";
url="#";
alt="Cambiabanners..com";
banner="../../..../../../img/pub/cat_pro_03a.gif";
width="77";
height="130";
}

if (ad==2) {
txt="Muchas Ron Flor de Caña Centenario";
url="#";
alt="MundoJavascript.com";
banner="../../../img/pub/cat_pro_03b.gif";
width="150";
height="130";
}

if (ad==3) {
txt="Gran Reserva"; 
url="#";
alt="Haz amigos";
banner="../../../img/pub/cat_pro_03c.gif";
width="40";
height="130";
}

if (ad==4) {
txt="Muchas Gran Reservas!!!!"; 
url="#";
alt="Haz amigos";
banner="../../../img/pub/cat_pro_03d.gif";
width="150";
height="130";
}



document.write('<center>');
//document.write('<a href=\"' + url + '\" target=\"_blank\">');
document.write('<img src=\"' + banner + '\" width=')
document.write(width + ' height=' + height + ' ');
document.write('alt=\"' + alt + '\" border=0><br>');
//document.write('<small>' + txt + '</small></a>');
document.write('</center>');
// End -->
</SCRIPT>