
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
	

<script language="javascript">

function submit() {
	document.forms[0].submit();
}

</script>

<html:base/>

<P> 
	<table border="0" cellspacing="0" cellpadding="0" width="100%" id="homeLeftMenuTable">
	  <tr>
	  <td colspan="4" align="center">
	  	<font color="red">
  	      	<logic:messagesPresent property="GLOBAL_ERROR">
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>	      	
	      	</logic:messagesPresent>
	      </font>
	  </td>
	  </tr>
	  <tr>
	  	<th colspan="4">Lo más reciente</th>
	  </tr>
	  <tr>	 	  	
	    <td colspan="4" align="left"> 
	    	<table border="0" width="550" cellpadding="3" cellspacing="1">

	    		
	    		<c:set var="cont" value="0" />
	    		
	    		<c:forEach items="${picks}" var="adBean">
	    			<c:if test="${(cont %3) == 0}">
	    			  <tr>
	    			</c:if>
	    				<td colspan="4"  class="TitMenuNavCuartoNivel a:hover" align="center">
	    					<a href="/NicahostWeb/clasificados/search.do?criteria=<c:out value='${adBean.itemId}' />">
	   							<c:choose>
									<c:when test="${not empty adBean.myFileName}">
										 
										<IMG 
											src="<c:out value='${imgPath}'/>/<c:out value='${adBean.myFileName}' />"
											width="69" height="83" border="0" >	
										
								</c:when>
		   							<c:otherwise>
		   								<IMG src="<c:out value='${imgPath}'/>/noimage.gif" width="90" height="90" border="0">
		   							</c:otherwise>
		   							
		   						</c:choose>	    					
	    					</a>
	    					<br>
	    					<c:out value="${adBean.title}" />
							<br>
   								<c:if test="${adBean.cost > 0}">
   								<b>
   								<c:out value="${adBean.currency}" />$<fmt:formatNumber value="${adBean.cost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
   								</b>
   								<br>
   								</c:if>	    	
   												
	    					
	    				</td>
	    			
					  		<c:set var="cont" value="${cont + 1}" /> 
	
					<c:if test="${(cont % 3) == 0}">
             		  </tr>
             		  <c:set var="cont" value="0" />		
					</c:if>	    			
	    		
	    		</c:forEach>
   	
	    	</table>
	    </td>
	   </tr>
	</table>



