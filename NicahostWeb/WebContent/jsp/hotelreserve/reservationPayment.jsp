
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />
<html:base/>
<html:form action="step05.do">
<TABLE width="80%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TD class="daterror" colspan="4"><FONT color="red">
				<ul>
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
				</ul></FONT>			
			</TD>
		</TR>
	
		<TR>
			<TH align="left" nowrap="nowrap" colspan="3">
				<img src="/NicahostWeb/img/common/sir.gif" valign="middle">&nbsp;
				<fmt:message key="label.common.paymentmethod"/>
			</TH>
			

			<TH align="right">
				<a href="#">&nbsp;</a>
			</TH>
		</TR>

		<TR>
			<TD nowrap><fmt:message key="label.common.cardtype"/>:</TD>
			
			<TD colspan="3">
				<html:select property="cardType"> 
					<option value="">-- <fmt:message key="label.common.select"/> --</option>
					<html:options collection="cardTypes" property="value" labelProperty="label"/>
				</html:select></TD>
		</TR>
		<TR>
			<TD nowrap><fmt:message key="label.common.cardholder" />:</TD>
			<TD><html:text property="cardHolder" size="32" maxlength="96" /></TD>
			<TD colspan="2" rowspan="2"><IMG border="0"
					src="../../../img/common/www_header_logo.gif" width="150" height="59"></TD>
		</TR>

			<TR>
				<TD nowrap><fmt:message
					key="label.common.cardnumber" />:</TD>
				<TD><html:text
					property="cardNumber" size="32" maxlength="25" /></TD>

			</TR>
			<TR>
			<TD nowrap><fmt:message key="label.common.expirationdate" />:</TD>
			<TD colspan="3">
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
			<TD colspan="4">&nbsp;</TD>
		</TR>

		<TR>			
			<TD colspan="4">
				<html:checkbox property="policyCancelation">
					<fmt:message key="label.common.cancelationpolicy"/>
				</html:checkbox>			
			</TD>
		</TR>

	</TBODY>
</TABLE>


<br/>

<DIV align="center">
			<INPUT type="image" class="HandPointer" 
					src="<fmt:message key="common.resource.image.accept"/>" 
					name="aceptar" 
					onmouseover="MM_swapImage('aceptar','','<fmt:message key="common.resource.image.acceptOn"/>',1);"
					onmouseout="MM_swapImgRestore();">
</DIV>

</html:form>



