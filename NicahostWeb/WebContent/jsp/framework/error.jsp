
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<fmt:setBundle 
	basename="com.nicahost.framework.common.resource.FrameworkMessageResources" />

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">



        <table border='0' align='center' cellspacing='1' cellpadding='3' width="70%" id="sessionTable">
            <tr>
                <th colspan='2'><fmt:message key="label.error.request"/></th>
            </tr>
       <c:if test="${not empty errorForm.reference}">
            <tr>
                <td width="10%" class="bold"><fmt:message key="label.error.reference"/>:</td>
                <td >
                    <c:out value="${errorForm.reference}" />
                </td>
            </tr>
        </c:if>
       <c:if test="${not empty errorForm.code}">
            <tr>
                <td width="10%" class="bold"><fmt:message key="label.error.code"/>:</td>
                <td >
                    <c:out value="${errorForm.code}" />
                </td>
            </tr>
        </c:if>
        
        
            <tr>
                <th colspan='2'><fmt:message key="label.error.response"/></th>
            </tr>
		<c:choose>
			<c:when  test="${not empty errorForm.code}">
            <tr>
                <td class="bold"><fmt:message key="label.error.description"/>:</td>
                <td>
                    <font style='font-SIZE 12px'>
                        <fmt:message key="${errorForm.text}" />
                    </font>
                </td>
            </tr>
            </c:when>
            <c:otherwise>
            <tr>
                <td class="bold"><fmt:message key="label.error.description"/>:</td>
                <td>
                    <font style='font-SIZE 12px'>
                        <c:out value="${errorForm.text}" />
                    </font>
                </td>
            </tr>            
            </c:otherwise>
        </c:choose>
        </table>
 <p>&nbsp;</p>