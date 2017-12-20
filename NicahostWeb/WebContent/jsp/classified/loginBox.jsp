

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2">
			<c:choose>
				<c:when test="${empty userName}">Returning Customer</c:when>
				<c:otherwise>Welcome back <c:out value="${userName}"/> </c:otherwise>
			</c:choose>
			<BR>
			Sign in below for fast checkout</TD>
		</TR>
		<TR>
			<TD align="right">E-mail address:</TD>
			<TD><INPUT type="text" name="email" size="35"></TD>
		</TR>
		<TR>
			<TD align="right">Password:</TD>
			<TD><INPUT type="password" name="password" size="35"></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD><INPUT type="submit" name="signin" value="Sign In"></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>Forgot your password? Click here...<BR>
			Has your e-mail address changed?</TD>
		</TR>
	</TBODY>
</TABLE>
