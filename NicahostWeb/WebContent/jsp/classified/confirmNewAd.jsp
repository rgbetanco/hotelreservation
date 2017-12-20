
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<html:base/>



<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
	
<html:form action="anunciese.do">

<table border="0" cellpadding="5" cellspacing="1" id="sessionTable">
				<tr>
					<td colspan="4">
Favor revise los datos antes de publicarlo.  Sus datos apareceran en la categoría <font size="+1"> <fmt:message key='${categoryName}' /> </font>
por un periodo de <font size="+1"><c:out value='${anuncieseForm.map.duration}' />	semanas </font>
					
					</td>
				</tr>

</table>

	    	<table border="0" width="550" cellpadding="5" cellspacing="1" id="sessionTable" align="center">
	    	
				<tr>
					<td colspan="4">
						<html:hidden property="title"/>
						<html:hidden property="desc"/>
						<html:hidden property="category"/>
						<html:hidden property="name"/>
						<html:hidden property="phone"/>
						<html:hidden property="email"/>
						<html:hidden property="price"/>
						<html:hidden property="currency"/>
						<html:hidden property="duration" />
						<html:hidden property="myFileName" />	
						<html:hidden property="hideEmail" />					
					</td>
				
				</tr>
				<tr>
					<td colspan="4" class="daterror">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
					</td>
				</tr>
				

	   					<tr>
		   					<td colspan="3" valign="bottom">
			   					<b><c:out value="${anuncieseForm.map.title}" /></b>						
		   					</td>
	   					</tr>
	   					<tr>
	   						<td  valign="top" align="center" nowrap="nowrap">
	   							<c:choose>
									<c:when test="${not empty anuncieseForm.map.myFileName}">
										<a href="#"> 
										<IMG
											src="<c:out value='${imgPath}'/>/<c:out value='${anuncieseForm.map.myFileName}' />"
											width="69" height="83" border="0" >
	
								</c:when>
		   							<c:otherwise>
		   								<IMG src="<c:out value='${imgPath}'/>/noimage.gif" width="90" height="90">
		   							</c:otherwise>
		   							
		   						</c:choose>
	   							
	   						</TD>	   					
	   						<td  width="100%">
	   							
   								<c:out value="${anuncieseForm.map.desc}" /><br><br>
   								<i>Precio:</i> 
	   								<c:out value="${anuncieseForm.map.currency}"/>&nbsp;
   									<c:out value="${anuncieseForm.map.price}" /><br>
   							</td>

  							<td nowrap="nowrap">
  							
  							</td>
   						</tr>
   						<tr>
   							
   							<td colspan="3">
   								<b><fmt:message key="label.classified.name" />:</b> <c:out value="${anuncieseForm.map.name}" />&nbsp;
	   							<b><fmt:message key="label.classified.phone" />:</b> <c:out value="${anuncieseForm.map.phone}" /><br>
	   							<c:if test="${anuncieseForm.map.hideEmail ne 'on'}">
   								<b><fmt:message key="label.classified.email" />:</b><c:out value="${anuncieseForm.map.email}" />   							
   								</c:if>
   							</td>

   						</tr>

				<tr >
					<td colspan="4" align=center>							
					<INPUT TYPE="hidden" name="dispatch" value="error"/> 		
					<SCRIPT>function set(target) {document.forms[0].dispatch.value=target;document.forms[0].submit();}</SCRIPT>					

					<INPUT type="image" src="/NicahostWeb/img/clasificados/aceptar.gif" onclick="set('add');" width="90" height="17">																					
					<INPUT type="image" src="/NicahostWeb/img/clasificados/editar.gif" onclick="set('delete');" width="90" height="17">																					
					
					</td>
				</tr>
   						
		</table>



</html:form>

