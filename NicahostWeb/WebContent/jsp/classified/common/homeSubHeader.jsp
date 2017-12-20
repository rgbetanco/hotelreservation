<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${empty userName}">
		<strong>Bienvenido!</strong> si eres un cliente nuevo, <A href="/NicahostWeb/clasificados/createAccount.do"
			>empiece por aqu�</A>. �Tiene una cuenta? 
		<A href="/NicahostWeb/clasificados/showSignin.do">Ingrese aqu�</A>.
	</c:when>
	<c:otherwise>
		<strong>Bienvenido!</strong> si no es <c:out value="${userName}" />, por 
		favor <A href="/NicahostWeb/clasificados/showSignin.do">ingrese aqu�</a>.
	</c:otherwise>
</c:choose>

