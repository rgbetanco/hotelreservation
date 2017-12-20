<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${empty userName}">
		<strong>Bienvenido!</strong> si eres un cliente nuevo, <A href="/NicahostWeb/clasificados/createAccount.do"
			>empiece por aquí</A>. ¿Tiene una cuenta? 
		<A href="/NicahostWeb/clasificados/showSignin.do">Ingrese aquí</A>.
	</c:when>
	<c:otherwise>
		<strong>Bienvenido!</strong> si no es <c:out value="${userName}" />, por 
		favor <A href="/NicahostWeb/clasificados/showSignin.do">ingrese aquí</a>.
	</c:otherwise>
</c:choose>

<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
var how_many_ads = 1;
var now = new Date()
var sec = now.getSeconds()
var ad = sec % how_many_ads;
ad +=1;
if (ad==1) {
txt="Anteojos";
url="#";
alt="Anteojos";
banner="/NicahostWeb/img/clasificados/uploaded/banneranteojos.jpg";
width="77";
height="130";
}

document.write('<center>');
//document.write('<a href=\"' + url + '\" target=\"_blank\">');
document.write('<img src=\"' + banner + '\" ');
document.write(' ');
document.write('alt=\"' + alt + '\" border=0><br>');
//document.write('<small>' + txt + '</small></a>');
document.write('</center>');
// End -->
</SCRIPT>