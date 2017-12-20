
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<LINK rel="stylesheet" href="/NicahostWeb/css/Master.css" type="text/css">

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
	<table border="0" cellspacing="0" cellpadding="0" width="100%">
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
	    <td colspan="4" align="center"> 
	    	<table border="0" width="550" cellpadding="3" cellspacing="1">

	    		
	    		<c:set var="cont" value="0" />
	    		
	    		<c:forEach items="${categories}" var="category">
	    			<c:if test="${(cont %2) == 0}">
	    			  <tr>
	    			</c:if>
	    				<td colspan="4"  class="TitMenuNavCuartoNivel a:hover" width="50%">
	    					<a href="/NicahostWeb/clasificados/browse.do?criteria=&catId=<c:out value='${category.catId}' />">
	    						<img border="0" src="../../../img/<c:out value='${category.catIcon}'/>" width="57" height="50" align="middle">
	    						<fmt:message key="${category.catLabel}" />
	    					</a>
	    				</td>
	    			
					  		<c:set var="cont" value="${cont + 1}" /> 
	
					<c:if test="${(cont % 2) == 0}">
             		  </tr>
             		  <c:set var="cont" value="0" />		
					</c:if>	    			
	    		
	    		</c:forEach>
   	
	    	</table>
	    </td>
	   </tr>
	</table>



