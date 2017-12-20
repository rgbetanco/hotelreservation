

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<html:base/>
<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">nueva cuenta de vendedor</SPAN> <SPAN
				class="checkoutSubTitle">| tarjeta de crédito</SPAN></TD>
		</TR>
		<TR>
			<TD>Ingrese los datos correspondientes a su tarjeta de crédito en este formulario. No se harán cargos a su tarjeta sin su debida autorización. (Esto es completamente seguro - he <U>aquí</U> el porqué). </TD>
		</TR>
	</TBODY>
</TABLE>

<c:if test="${not empty userProfile}">
<TABLE>
	<TBODY>
		
		<c:forEach items="${userProfile.creditCards}" var="bean" varStatus="stat">	
		
		<c:choose>
			<c:when test="${stat.first}"><!-- first --><tr></c:when>			
			<c:when test="${stat.index % 4 == 0}"><!-- neither --></tr><tr></c:when>
		</c:choose>
		
			<TD>
			
			<html:form action="selleronlinebank.do">
				<TABLE border="0">	
					<TBODY>
						<TR>
							<TH>Información sobre su tarjeta</TH>
						</TR>
						<TR>
							<TD>
								<c:out value="${bean.cardName}"/><br>
								<c:out value="${bean.cardType}" /><br>
								<c:out value="${bean.cardNumber}" /><br>
								exp: <c:out value="${bean.cardMonth}" /> / <c:out value="${bean.cardYear}" />
								<!-- hidden fields -->
								<INPUT type="hidden" name="cardName" value="<c:out value='${bean.cardName}'/>">
								<INPUT type="hidden" name="cardType" value="<c:out value='${bean.cardType}'/>">
								<INPUT type="hidden" name="cardNumber" value="<c:out value='${bean.cardNumber}'/>">
								<INPUT type="hidden" name="cardMonth" value="<c:out value='${bean.cardMonth}'/>">
								<INPUT type="hidden" name="cardYear" value="<c:out value='${bean.cardYear}'/>">
								<INPUT type="hidden" name="cardId" value="<c:out value='${bean.cardId}'/>">
								<INPUT type="hidden" name="cardCCV" value="<c:out value='${bean.cardCCV}'/>">

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




<html:form action="selleronlinebank.do">
<TABLE border="0" cellspacing="10">
	<TBODY>
		<TR>
			<TD colspan="2" class="daterror">
			<logic:messagesNotPresent property="GLOBAL_ERROR">
				<logic:messagesPresent>
					Favor corrija los campos indicados
				</logic:messagesPresent>
			</logic:messagesNotPresent>				
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="cardType">
					<B><SPAN class="daterror">Tipo de tarjeta:*</SPAN></B>
				</logic:messagesPresent>
				<logic:messagesNotPresent property="cardType">Tipo de tarjeta:</logic:messagesNotPresent>
				
			</TD>
			<TD>

				<html:select property="cardType"> 
					<option value="">-- <fmt:message key="label.common.select"/> --</option>
					<html:options collection="cardTypes" property="value" labelProperty="label"/>
				</html:select>			
			&nbsp;&nbsp;&nbsp;&nbsp;</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="cardNumber">
					<B><SPAN class="daterror">Número de tarjeta:*</SPAN></B>
				</logic:messagesPresent>
				<logic:messagesNotPresent property="cardNumber">Número de tarjeta:</logic:messagesNotPresent>
			</TD>
			<TD>				
				<html:text property="cardNumber" size="32" />
			</TD>
		</TR>
			<TR>
				<TD align="right">
				<logic:messagesPresent property="cardCCV">
					<B><SPAN class="daterror">Número de verificación:*</SPAN></B>
				</logic:messagesPresent>
				<logic:messagesNotPresent property="cardCCV">Número de verificación:</logic:messagesNotPresent>
					
				</TD>
				<TD>
					<html:text property="cardCCV" size="4" />
				<IMG border="0" src="/NicahostWeb/img/clasificados/visaAmTwo_102x31.gif"
					width="102" height="31">

				<font size="-2">
				<br>
				Este es el número de 3 digítos que aparecen al reverso de la tarjeta
				<br>
				Para tarjetas American Express, use el número de 4 dígitos que aparecen en el frente
				</font>
			</TD>
			</TR>
			<TR>
			<TD align="right"><SPAN class="daterror"> 
			<logic:messagesPresent 	property="cardMonth">
					Fecha de expiración:*
			</logic:messagesPresent> </SPAN>
			
			<logic:messagesNotPresent property="cardMonth">
					<logic:messagesPresent property="cardYear">
						<strong><SPAN class="daterror">Fecha de expiración:*</SPAN></strong>
					</logic:messagesPresent>
					
					<logic:messagesNotPresent property="cardYear">
						Fecha de expiración:
					</logic:messagesNotPresent>					
			</logic:messagesNotPresent>
				
			</TD>
			<TD>
				<html:select property="cardMonth">
					<OPTION value=""> -- </OPTION>
					<html:options collection="cardMonths" property="value" labelProperty="label"/>
				</html:select> / 
				<html:select property="cardYear">
					<OPTION value=""> -- </OPTION>
					<html:options collection="cardYears" property="value" labelProperty="label"/>
				</html:select>	
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="cardName"><strong><SPAN
						class="daterror">Nombre en la tarjeta:*</SPAN></strong></logic:messagesPresent>
				<logic:messagesNotPresent property="cardName">Nombre en la tarjeta:</logic:messagesNotPresent>
				
			</TD>
			<TD>
				<html:text property="cardName" size="32" />
				<br></TD>
		</TR>
		<TR>
			<TD align="right"></TD>
			<TD>

				<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/usar_esta.gif" onclick="this.form.submit();" width="110" height="17">
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>
<P><BR>Si tiene alguna duda,  vea nuestra sección de ayuda.
</P>
