
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2"><SPAN class="checkoutTitle">orden de compra</SPAN><SPAN
				class="checkoutSubTitle"> | dirección de entrega</SPAN></TD></TR>
		<TR>
			<TD colspan="2">Por favor ingrese el nombre y la dirección del lugar donde le gustaría que su orden fuera entregada. Así mismo, indique si su dirección de cobro es distinta marcando en el cuadro correspondiente al final del formulario.</TD></TR>
	</TBODY>
</TABLE>

<c:if test="${not empty userProfile}">
<TABLE>
	<TBODY>
		
		<c:forEach items="${userProfile.shippingAddresses}" var="shippingBean" varStatus="stat">	
		
		<c:choose>
			<c:when test="${stat.first}"><!-- first --><tr></c:when>			
			<c:when test="${stat.index % 4 == 0}"><!-- neither --></tr><tr></c:when>
		</c:choose>
		
			<TD>
			
			<html:form action="placeorder.do">
				<TABLE border="0">	
					<TBODY>
						<TR>
							<TH>Entréguese a</TH>
						</TR>
						<TR>
							<TD>
								<c:out value="${shippingBean.name}"/><br>
								<c:out value="${shippingBean.address}" /><br>
								<c:out value="${shippingBean.city}" />,
								<c:out value="${shippingBean.state}" />
								<c:out value="${shippingBean.zip}" />
								<!-- hidden fields -->
								<INPUT type="hidden" name="name" value="<c:out value='${shippingBean.name}'/>">
								<INPUT type="hidden" name="address" value="<c:out value='${shippingBean.address}'/>">
								<INPUT type="hidden" name="city" value="<c:out value='${shippingBean.city}'/>">
								<INPUT type="hidden" name="state" value="<c:out value='${shippingBean.state}'/>">
								<INPUT type="hidden" name="zip" value="<c:out value='${shippingBean.zip}'/>">
								<INPUT type="hidden" name="phone" value="<c:out value='${shippingBean.phone}'/>">								
							</TD>
						</TR>
						<TR>
							<TD>
								<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/usar_esta.gif" onclick="this.form.submit();" width="110" height="17">
							</TD> 
						</TR>						
					</TBODY>
				</TABLE>
			</html:form>				
			
			</TD>
			<c:if test="${stat.last}"><!-- last --></tr></c:if>
		</c:forEach>
	</TBODY>
</TABLE>	
</c:if>



<html:form action="paymentinfo.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD align="right">			
				<logic:messagesPresent property="name"><strong><SPAN
						class="daterror">Nombre:*</SPAN></strong></logic:messagesPresent>			
				<logic:messagesNotPresent property="name">Nombre:</logic:messagesNotPresent>
			</TD>
			<TD>
				<html:text property="name" size="50" />
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="address"><strong><SPAN
						class="daterror">Dirección:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="address">Dirección:</logic:messagesNotPresent>
			</TD>
			<TD>
				<html:textarea property="address" rows="3" cols="41" />			
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="city"><strong><SPAN
						class="daterror">Ciduda:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="city">Ciudad:</logic:messagesNotPresent>
			</TD>
			<TD>				
				<html:text property="city" size="20" />
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="state"><strong><SPAN
						class="daterror">Departamento:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="state">Departamento:</logic:messagesNotPresent>
			</TD>
			<TD>				
				<html:text property="state" size="20" />
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="zip"><strong><SPAN class="daterror">Número de casa:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="zip">Número de casa:</logic:messagesNotPresent>
			</TD>
			<TD>
				<html:text property="zip" size="20" />
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="phone"><strong><SPAN
						class="daterror">Teléfono:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="phone">Teléfono:</logic:messagesNotPresent>
			</TD>
			<TD>				
				<html:text property="phone" size="20" />
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="country"><strong><SPAN
						class="daterror">País:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="country">País:</logic:messagesNotPresent>
			</TD>
			<TD><SELECT name="country">
				<OPTION value="Nicaragua" selected>Nicaragua</OPTION>
			</SELECT></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>				
				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/enviar_esta.gif" onclick="this.form.submit();" width="110" height="17">
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>

