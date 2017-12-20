<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>




<LINK rel="stylesheet" href="/NicahostWeb/css/Master.css" type="text/css">

<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
	

<html:form action="confirmAddNewAd" enctype="multipart/form-data">

	<table border="0" cellspacing="0" cellpadding="0" width="100%">

	  
	  <tr>	  
	    <td colspan="4" align="center"> 
	    	<table border="0" width="550" cellpadding="3" cellspacing="1">


				<tr>
					<td class="daterror" colspan="4">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
	      
					</td>
				
				</tr>			
		        <tr>
		          <td class="tit" colspan=4>
	    	        <fmt:message key="label.classified.subtitle" /> 
	        	  </td>
	        	  <td> &nbsp;
	        	  </td>
	        	</tr>
	        	
	        	
		        <tr>
		        	<td class="dat"><fmt:message key="label.classified.titlename" /></td>
					<td class="dat" colspan="3"><html:text property="title" /></td>		        		

					<td>&nbsp;</td>			        
		        </tr>
		        <tr>
		        	<td class="dat"><fmt:message key="label.classified.description" /></td>
					<td class="dat" colspan="3"><html:textarea property="desc" cols="30" rows="5"/></td>		        		

					<td>&nbsp;</td>			        
		        </tr>		        
		        <tr>
		        	<td class="dat"><fmt:message key="label.classified.category" /></td>
					<td class="dat" colspan="3">
						<html:select property="category">
							<c:forEach items="${categories}" var="cat">
							
								<option value="<c:out value='${cat.catId}' />_<c:out value='${cat.catLabel}' />">
									<fmt:message key='${cat.catLabel}' />
								</option>
							</c:forEach>
						</html:select></td>		        		
					<td>&nbsp;</td>			        
		        </tr>
		        <tr>
		        	<td class="dat"><fmt:message key="label.classified.price" /></td>
					<td class="dat" colspan="3"><html:text property="price" /></td>		        		

					<td>&nbsp;</td>			        
		        </tr>		        
		        <tr>
		        	<td class="dat"><fmt:message key="label.classified.name" /></td>
					<td class="dat" colspan="3"><html:text property="name" /></td>		        		

					<td>&nbsp;</td>			        
		        </tr>		        
		        <tr>
		        	<td class="dat"><fmt:message key="label.classified.phone" /></td>
					<td class="dat"><html:text property="phone" /></td>		        		
					<td class="dat"><fmt:message key="label.classified.email" /></td>
					<td class="dat"><html:text property="email" /></td>
					<td>&nbsp;</td>		        
		        </tr>		        
		        <TR>
		        	<TD class="dat"><fmt:message key="label.classified.formfile" /></TD>
		        	<TD colspan="3">
		        		<html:file property="myFile" />
		        	</TD>
		        </TR>
		        
		        
				<tr >
					<td colspan="4" align=center>		
						<input type=submit value="<fmt:message key='button.continue' />"  />
					</td>
				</tr>
		        
		        				
	    	
	    	</table>
	    </td>
	   </tr>
	</table>
	

</html:form>



