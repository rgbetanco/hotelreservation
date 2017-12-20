<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>

<html:base/>


<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">vender artículo</SPAN> <SPAN
				class="checkoutSubTitle">| descripción del artículo</SPAN></TD>
		</TR>
		<TR>
			<TD>descripción del artículo</TD>
		</TR>
	</TBODY>
</TABLE>




<html:form action="sellitemimages.do">

	<CENTER>
	<TABLE border="0" cellspacing="5" cellpadding="0" id="sessionTable"
		width="90%">
		<TBODY>
			<TR>
				<TH colspan="4">Descripción</TH>
			</TR>
			<TR>
				<TD>Título:</TD>
				<TD colspan="3"><html:text property="title" size="55"
					titleKey="test" /></TD>
			</TR>
			<TR>
				<TD colspan="4"></TD>
			</TR>
			<TR>
				<TD colspan="4">Describa las características de su artículo, los beneficios y las condiciones. Asegúrese de incluir: la condición (nuevo, usado, etc), precio en el mercado, las dimensiones o tamaño. Indique cualquier otra característica que sea de importancia.</TD>
			</TR>
			<TR>
				<TD class="dat" colspan="4" align="left">
					<html:textarea
						property="description" cols="72" rows="10" 
						onkeyup=" return Contar(this.form,'description','contador',1000)" />
					<br>Le quedan <INPUT type="text" name="contador" readonly="readonly" style="color: #154a84; border-width: 0px;" size="2" value="1000"> carácteres.</TD>
			</TR>
			
		</TBODY>
	</TABLE>
	</CENTER>
	<P>&nbsp;</P>
	<CENTER>
	<TABLE border="0" cellspacing="0" cellpadding="0" id="sessionTable" width="90%">
		<TBODY>
			<TR>
				<TH colspan="4">Precio y duración</TH>
			</TR>

			<TR>
				<TD>Precio:</TD>
				<TD colspan="3"><html:text property="price" /> <html:radio
					property="currency" value="USD">USD</html:radio> <html:radio
					property="currency" value="COR">COR</html:radio></TD>
			</TR>
			<TR>
				<TD>Cantidad:</TD>
				<TD colspan="3"><html:text property="quantity" value="1" size="4" /></TD>
			</TR>
			<TR>
				<TD>Condición:</TD>
				<TD colspan="3">
					<html:select property="condition">
						<html:option value=""></html:option>
						<html:option value="new">Nuevo</html:option>
						<html:option value="used">Usado</html:option>
					</html:select> 
				</TD>
			</TR>
			<TR>
				<TD>Duraci&oacute;n del anuncio:</TD>
				<TD colspan="3"><html:select property="duration">
					<html:option value="2">2 semanas</html:option>
					<html:option value="3">3 semanas</html:option>
					<html:option value="4">1 mes</html:option>
					<html:option value="5">+1 mes (cargo $0.40)</html:option>
				</html:select></TD>
			</TR>

		</TBODY>
	</TABLE>
	</CENTER>

<p>&nbsp;</p>
	<CENTER>
	<TABLE id="sessionTable" width="90%">
		<TBODY>
			<TR>
				<TH>Ubicación del artículo</TH>
			</TR>
			<c:set var="hasAddress" value="" />
			<c:if test="${not empty userProfile}">
				<c:forEach items="${userProfile.shippingAddresses}"
					var="shippingBean" varStatus="stat">

					<c:if test="${shippingBean.isSellerDefault}">
						<TR>
							<TD><html:form action="placeorder.do">
								<TABLE border="0">
									<TBODY>

										<TR>
											<TD><c:out value="${shippingBean.name}" /><BR>
											<c:out value="${shippingBean.address}" /><BR>
											<c:out value="${shippingBean.city}" />, <c:out
												value="${shippingBean.state}" /> <c:out
												value="${shippingBean.zip}" /> <!-- hidden fields --> <INPUT
												type="hidden" name="name"
												value="<c:out value='${shippingBean.name}'/>"> <INPUT
												type="hidden" name="address"
												value="<c:out value='${shippingBean.address}'/>"> <INPUT
												type="hidden" name="city"
												value="<c:out value='${shippingBean.city}'/>"> <INPUT
												type="hidden" name="state"
												value="<c:out value='${shippingBean.state}'/>"> <INPUT
												type="hidden" name="zip"
												value="<c:out value='${shippingBean.zip}'/>"> <INPUT
												type="hidden" name="phone"
												value="<c:out value='${shippingBean.phone}'/>"></TD>
										</TR>
										<TR>
											<TD><INPUT type="image" name="continue"
												src="/NicahostWeb/img/clasificados/usar_esta.gif"
												onclick="this.form.submit();" width="110" height="17"></TD>
										</TR>
									</TBODY>
								</TABLE>
							</html:form></TD>
						</TR>
						<c:set var="hasAddress" value="true" />
					</c:if>
				</c:forEach>
			</c:if>

			<c:if test="${empty hasAddress}">
				<TR>
					<TD>
					<TABLE border="0" id="sessionTable">
						<TBODY>
							<TR>
								<TD align="right"><logic:messagesPresent property="name">
									<STRONG><SPAN class="daterror">Nombre contacto:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="name">Nombre contacto:</logic:messagesNotPresent></TD>
								<TD><html:text property="name" size="50" /></TD>
							</TR>
							<TR>
								<TD align="right"><logic:messagesPresent property="address">
									<STRONG><SPAN class="daterror">Dirección:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="address">Dirección:</logic:messagesNotPresent></TD>
								<TD><html:textarea property="address" rows="3" cols="41" /></TD>
							</TR>
							<TR>
								<TD></TD>
								<TD></TD>
							</TR>
							<TR>
								<TD align="right"><logic:messagesPresent property="city">
									<STRONG><SPAN class="daterror">Ciduda:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="city">Ciudad:</logic:messagesNotPresent></TD>
								<TD><html:text property="city" size="20" /></TD>
							</TR>
							<TR>
								<TD align="right"><logic:messagesPresent property="state">
									<STRONG><SPAN class="daterror">Departamento:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="state">Departamento:</logic:messagesNotPresent></TD>
								<TD><html:text property="state" size="20" /></TD>
							</TR>
							<TR>
								<TD align="right"><logic:messagesPresent property="zip">
									<STRONG><SPAN class="daterror">Número de casa:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="zip">Número de casa:</logic:messagesNotPresent></TD>
								<TD><html:text property="zip" size="20" /></TD>
							</TR>
							<TR>
								<TD align="right"><logic:messagesPresent property="phone">
									<STRONG><SPAN class="daterror">Teléfono:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="phone">Teléfono:</logic:messagesNotPresent></TD>
								<TD><html:text property="phone" size="20" /></TD>
							</TR>
							<TR>
								<TD align="right"><logic:messagesPresent property="country">
									<STRONG><SPAN class="daterror">País:*</SPAN></STRONG>
								</logic:messagesPresent> <logic:messagesNotPresent
									property="country">País:</logic:messagesNotPresent></TD>
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
								<TD></TD>
							</TR>
						</TBODY>
					</TABLE>
					</TD>
				</TR>

			</c:if>
		</TBODY>
	</TABLE>
	</CENTER>

	<p>&nbsp;</p>
	<CENTER>
	<TABLE id="sessionTable" width="90%">
		<TBODY>
			<TR>
				<TD>
					
				 </TD>
				<TD>
					<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="document.forms['sellItemForm'].submit();" >				
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</html:form>