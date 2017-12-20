

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
			<TD><SPAN class="checkoutTitle">orden de compra</SPAN> <SPAN
				class="checkoutSubTitle">| informaci�n sobre el pago</SPAN></TD>
		</TR>
		<TR>
			<TD>Cas� terminamos! Solamente digite la informaci�n correspondiente a su tarjeta de cr�dito en este formulario. (Esto es completamente seguro - he aqu� el porqu�). Si prefiere, llamenos y denos su n�mero de tarjeta, y simplemente s�lo ingrese los �ltimos cincos n�meros de la tarjeta. Luego de haber confirmado su orden, ll�menos al (505) 848-4018.</TD>
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
			
			<html:form action="placeorder.do">
				<TABLE border="0">	
					<TBODY>
						<TR>
							<TH>Informaci�n sobre su tarjeta</TH>
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




<html:form action="placeorder.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD colspan="2">Tarjeta de cr�dito</TD></TR>
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
			&nbsp;&nbsp;&nbsp;&nbsp;<IMG border="0"
				src="/NicahostWeb/img/clasificados/credit_card_logos.gif" width="155"
				height="17">
				
				
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="cardNumber">
					<B><SPAN class="daterror">N�mero de tarjeta:*</SPAN></B>
				</logic:messagesPresent>
				<logic:messagesNotPresent property="cardNumber">N�mero de tarjeta:</logic:messagesNotPresent>
			</TD>
			<TD>				
				<html:text property="cardNumber" size="32" />
			</TD>
		</TR>
		<TR>
			<TD align="right"><SPAN class="daterror"> <logic:messagesPresent
					property="cardMonth">
					Fecha de expiraci�n:*
				</logic:messagesPresent> </SPAN><logic:messagesNotPresent property="cardMonth">
					<logic:messagesPresent property="cardYear"><strong><SPAN
							class="daterror">Fecha de expiraci�n:*</SPAN></strong></logic:messagesPresent>
					Fecha de expiraci�n<logic:messagesNotPresent property="cardYear">:</logic:messagesNotPresent>					
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
<P><BR>Si tiene alguna duda,  vea nuestra secci�n de ayuda.
</P>
