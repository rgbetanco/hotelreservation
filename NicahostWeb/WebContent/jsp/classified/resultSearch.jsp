
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>



<SCRIPT language="JavaScript" src="/NicahostWeb/js/popup.js"></SCRIPT>
<script type="text/javascript" src="/NicahostWeb/js/popupBox.js"></script>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />

	<table border="0" cellspacing="0" cellpadding="0" width="100%">

	  
	  <tr>	  
	    <td colspan="4" align="center"> 

   				<tr>
   					<td colspan="4">
	   					<table width="550" border="0" cellpadding="5" cellspacing="0" id="sessionTable">
	   					<tr>
		   					<td colspan="3" valign="bottom">
			   					<b><c:out value="${adBean.title}" /></b>						
		   					</td>
	   					</tr>
	   					<tr>
	   						<td valign="top" align="center" nowrap="nowrap">
	   							<c:choose>
									<c:when test="${not empty adBean.myFileName}">
										 
										<IMG 
											src="<c:out value='${imgPath}'/>/<c:out value='${adBean.myFileName}' />"
											width="69" height="83" border="0" 
											onMouseOver="return show_hide_imgbox(this,200,270,'2px dotted')" 
											onMouseOut="return show_hide_imgbox(this,200,270,'2px dotted')"
											onclick="vtn('/jsp/classified/vtnenlargeimg.jsp?imgPath=<c:out value='${imgPath}'/>&fileName=<c:out value='${adBean.myFileName}' />',635,385);" 
											style="cursor: pointer; color: #003399;"
											>	
										
								</c:when>
		   							<c:otherwise>
		   								<IMG src="<c:out value='${imgPath}'/>/noimage.gif" width="90" height="90">
		   							</c:otherwise>
		   							
		   						</c:choose>
	   							
	   						</TD>	   					
	   						<td width="100%">
	   							
   								<c:out value="${adBean.desc}" /><br><br>
   								<c:if test="${adBean.cost > 0}">
   								<i>Precio:</i> 
									<c:out value="${adBean.currency}" /> $ &nbsp;   								
	   								<fmt:formatNumber value="${adBean.cost}" type="number" maxFractionDigits="2" minFractionDigits="2"></fmt:formatNumber>
   								<br>
   								</c:if>
   								
   								<c:if test="${not empty adBean.email}">
   								<FORM action="/NicahostWeb/clasificados/sendemailform.do" method="post">
   									<INPUT type="hidden" name="toEmail" value="<c:out value='${adBean.email}' />" >
									<INPUT type="hidden" name="productDescription" value="<c:out value='${adBean.title}' />">
									<INPUT type="hidden" name="name" value="<c:out value='${adBean.name}'/>" >
									<!--INPUT type="submit" value="Enviar e-mail"-->
									<INPUT type="image" src="/NicahostWeb/img/clasificados/enviaremail.gif" width="90" height="17" alt="Enviar e-mail">
   								</FORM>
   								</c:if>
							</td>

  							<td nowrap="nowrap" valign="bottom">
  								<FORM action="/NicahostWeb/clasificados/orderPage.do" method="post">
  									<INPUT type="hidden" name="itemId" value="<c:out value='${adBean.itemId}' />">  									
  									<c:choose>
  									<c:when test="${adBean.cart}">
  										<INPUT type="image" src="/NicahostWeb/img/clasificados/comprar.gif" onclick="this.form.submit();" width="90" height="17">
  									</c:when>
  									<c:otherwise>
  										<img src="/NicahostWeb/img/clasificados/comprar.gif" alt="Próximamente...">
  									</c:otherwise>
  									</c:choose>
  								</form>   								
  							</td>
   						</tr>
   						<tr>
   							
   							<td colspan="3">
   								<b><fmt:message key="label.classified.name" />:</b> <c:out value="${adBean.name}" />&nbsp;
	   							<b><fmt:message key="label.classified.phone" />:</b> <c:out value="${adBean.phone}" />&nbsp;
	   							<c:if test="${not empty adBean.postedDate}">
	   							<b>Fecha:</b><fmt:formatDate value="${adBean.postedDate.time}" dateStyle="short"/><br>
	   							</c:if>
	
	   							<c:if test="${adBean.hideEmail ne 'on'}">
	   								<b><fmt:message key="label.classified.email" />:</b><c:out value="${adBean.email}" />   							
   								</c:if>
   							</td>

   						</tr>
   						</table>
   					</td>
   				</tr>
	</table>



