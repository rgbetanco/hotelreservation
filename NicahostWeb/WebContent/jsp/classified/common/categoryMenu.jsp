
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />


<TABLE border="0" width="100%" cellpadding="0" cellspacing="0" id="leftMenuTable">
	<TBODY>
		<TR>
			<TH>Categorias</TH>
		</TR>
		
		<c:forEach items="${categories}" var="category">
			<TR>
				<TD nowrap="nowrap">
					<A href="/NicahostWeb/clasificados/browse.do?criteria=&catId=<c:out value='${category.catId}' />">
						<fmt:message key="${category.catLabel}" /> (<c:out value='${category.hits}' />)
					</A>
				</TD>
			</TR>		
		</c:forEach>
		
	</TBODY>
</TABLE>

