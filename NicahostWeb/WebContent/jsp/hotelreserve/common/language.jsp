
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<fmt:setBundle
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<html:form action="switchLang.do">
<TABLE border="0" cellpadding="5" cellspacing="5">
	<TBODY>

		<TR>
			<TD>

				<html:select property="lang" onchange="this.form.submit()">
				<c:forEach items="${languages}" var="langLocal">
					<c:out value="${languageForm.lang}" />
						<option value="<c:out value='${langLocal.value}' />"							
							<c:if test="${langLocal.value == languageForm.lang}" >
								selected="selected"
							</c:if>
						>
							<fmt:message key='${langLocal.label}' />
						</option>
				</c:forEach>				
				</html:select>
											
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>
