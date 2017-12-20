
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<html:base/>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />
	
	<table border="0" cellspacing="0" cellpadding="0" width="100%" id="sessionTable">
	<TBODY>
	  <TR>
	  	<TD colspan="5" align="left">
	  		
	  	<IMG border="0"
				src="/NicahostWeb/img/clasificados/shop-cart-header-blue.gif" width="218"
				height="31"></TD>	  
	  </TR>
	  <tr>	  
	    <td colspan="5" align="left">
	    	
	    </td>
	   </tr>


	   <tr>
	   	<th colspan="2" align="left">Artículos</th>
	   	<th align="right">Precio</th>
	   	<th align="center">Cantidad</th>
	   	<th align="right">Total</th>
	   </tr>
<c:choose>
<c:when test="${not empty itemsOrdered}">
	<c:forEach items="${itemsOrdered}" var="adBean">
	   <tr>
	   	<td width="90">
	   							<c:choose>
									<c:when test="${not empty adBean.item.fileName}">
										<IMG
											src="<c:out value='${adBean.item.imgPath}'/>/<c:out value='${adBean.item.fileName}' />"
											width="69" height="83" border="0">
								</c:when>
		   							<c:otherwise>
		   								<IMG src="<c:out value='${adBean.item.imgPath}'/>/noimage.gif" width="90" height="90">
		   							</c:otherwise>
		   							
							</c:choose>	   	
	   	</td>
	   	<td width="40%" >
	   		<c:out value="${adBean.item.desc}" />
	   	</td>
	   	<td align="right" >
	   		<c:set var="unitCost" value="${adBean.item.cost}" />
	   		<fmt:formatNumber value="${unitCost}" type="number" maxFractionDigits="2" minFractionDigits="2" />	   	
	   	</td>
	   	<td align="center" nowrap="nowrap">

	   		<FORM action="/NicahostWeb/clasificados/orderPage.do" method="post">
	   			<INPUT type="hidden" name="itemId" value="<c:out value='${adBean.item.itemId}' />">
	   			<INPUT type="text" name="numItems" value="<c:out value='${adBean.numItems}' />" size="4">
	   			<INPUT type="hidden" name="checkout" value="<c:out value='${checkout}'/>">
	   			
				<INPUT type="image" src="/NicahostWeb/img/clasificados/actualizar.gif" onclick="this.form.submit();" width="90" height="17">
	   			
	   		</FORM>

	   	
	   	</td>
	   	<td align="right">
	   		<c:set var="totalCost" value="${adBean.item.cost * adBean.numItems}" />
	   		<fmt:formatNumber value="${totalCost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
	   		<c:set var="grandTotal" value="${totalCost + grandTotal}" />
	   	</td>
	   </tr>
	</c:forEach>	

	  	<TR>
			<TD colspan="4" align="right" class="footer">Sub-total: </TD>	  	
			<TD align="right" class="footer"> 
				<fmt:formatNumber value="${grandTotal}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>			
			</TD>	  	
		</TR>

	<tr>
		<TD colspan="5" align="center">
		<c:choose>
	   	<c:when test="${not empty checkout}">
			<html:form action="placeorder.do">
				
				<INPUT type="image" src="/NicahostWeb/img/clasificados/regresar.gif" onclick="this.form.submit();" width="135" height="17">				
			</html:form>	   	
		</c:when>
		<c:otherwise>
			<FORM action="/NicahostWeb/clasificados/checkout.do" method="post">
				<INPUT type="image" src="/NicahostWeb/img/clasificados/proceder_pagar.gif" onclick="this.form.submit();" width="135" height="17">				
			</FORM>		
		</c:otherwise>
		</c:choose>
			

		</TD>
	</tr>
		
</c:when> 
<c:otherwise>
	<tr>
		<TD colspan="5"> No hay artículos en su canasta
		</TD>
	</tr>
</c:otherwise>	
	
</c:choose>
	<tr>
		<td colspan="5" align="center"> 
			<html:form action="browse.do">
				<INPUT type="image" src="/NicahostWeb/img/clasificados/seguir_comprando.gif" onclick="this.form.submit();" width="135" height="17">						
			</html:form>
		</td>
	</tr>

	</TBODY>
	</table>


