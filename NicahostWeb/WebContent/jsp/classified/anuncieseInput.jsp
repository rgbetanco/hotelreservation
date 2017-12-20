<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css"></HEAD>




<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />


<html:form action="anuncieseconfirmation" enctype="multipart/form-data" focus="name">

	<table border="0" cellspacing="0" cellpadding="0" id="sessionTable">
		<THEAD>
				<tr>
					<td class="daterror" colspan="4">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
	      
					</td>				
				</tr>				  	     	  	     
		</THEAD>
		<TBODY>
			<TR>
				<Th colspan="4">
					Datos de contacto
				</Th>
			</tr>
		        <tr>
		        	<td>Su nombre:</td>
					<td colspan="3"><html:text property="name" size="45"/></td>		        		
		        </tr>		        
		        <tr>
		        	<td>Tel&eacute;fono:</td>
					<td colspan="3"><html:text property="phone" /></td>		        		
				<tr>
					<td>E-mail:</td>
					<td colspan="3">
						<html:text property="email" size="30"/><br>
						<html:checkbox property="hideEmail">Ocultar mi e-mail.</html:checkbox>
					</td>					
		        </tr>
			<TR>
				<Th colspan="4">
					Datos del anuncio
				</Th>
			</tr>
		        <tr>
		        	<td>Título:</td>
					<td colspan="3"><html:text property="title" size="52"/></td>		        		
		        </tr>
		        <tr>
		        	<td class="dat">Descripción:</td>
					<td class="dat" colspan="3">
						<html:textarea property="desc" cols="45" rows="5"/>
					</td>		        		
		        </tr>		        
		        <tr>
		        	<td>Debe aparecer en la categor&iacute;a:</td>
					<td>
						<html:select property="category">
							<c:forEach items="${categories}" var="cat">
							
								<option value="<c:out value='${cat.catId}' />">
									<fmt:message key='${cat.catLabel}' />
								</option>
							</c:forEach>
						</html:select>
					</td>		  
					<td>Duraci&oacute;n del anuncio:
					</td>
					<TD>
						<html:select property="duration">
							<html:option value="2">2 semanas</html:option>
							<html:option value="3">3 semanas</html:option>
							<html:option value="4">4 semanas</html:option>
						</html:select>
					</TD>      							
		        </tr>
		        <tr>
		        	<td>Precio:</td>
				<td colspan="3"><html:text property="price" /> <html:radio
					property="currency" value="USD">USD</html:radio> <html:radio
					property="currency" value="COR">COR</html:radio></td>
			</tr>		        
		        
		        <TR>
		        	<TD class="dat">Subir imagen:</TD>
		        	<TD colspan="3">
		        		<html:file property="myFile" size="45"/><br>
		        		   (Tamaño max: 250k)
		        	</TD>
		        </TR>			
				<tr >
					<td colspan="4" align=center>		
					<br>
						<input type="hidden" name="o" value="confirm">
						<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="this.form.submit();" width="90" height="17">	
					</td>
				</tr>
		        
		  </TBODY>
	</table>

</html:form>



