
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />
<TABLE width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
	<TBODY>		
		<TR>
			<TD class="tableTitle">
				<fmt:message key="label.common.reserveconfirmation" />
			</TD>
		</TR>
	</TBODY>
</TABLE>	
<br/>





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
			<TH align="left" nowrap="nowrap">
				<img src="/NicahostWeb/img/common/sir.gif" valign="middle">&nbsp;
				<fmt:message key="label.common.paymentmethod"/>
			</TH>
			

			<TH align="right" colspan="3">
				<a href="#"><fmt:message key="label.common.useragreement" /></a>
			</TH>
		</TR>
		<TR>
			<TD colspan="4" class="bold">
				<html:radio property="paymentMethod" value="card"><fmt:message key="label.common.creditcard"/></html:radio></TD>
		</TR>
		<TR>
			<TD colspan="4">
			<font color="red"><fmt:message key="label.step05.creditcardwarning"/></font>
			</TD>
		</TR>
		<TR>
			<TD><fmt:message key="label.common.type"/></TD>
			
			<TD colspan="3">
				<html:select property="cardType"> 
					<html:options collection="cardTypes" property="value" labelProperty="label"/>
				</html:select></TD>
		</TR>
		<TR>
			<TD><fmt:message key="label.common.cardnumber"/></TD>
			<TD><html:text property="cardNumber" size="25" maxlength="25" /> </TD>
			<TD colspan="2"><IMG border="0"
					src="../../img/common/www_header_logo.gif" width="150" height="59"></TD>
		</TR>

		<TR>
			<TD><fmt:message key="label.common.expirationdate" /></TD>
			<TD colspan="3">
				<html:select property="cardMonth">
					<html:options collection="cardMonths" property="value" labelProperty="label"/>
				</html:select>

				<html:select property="cardYear">
					<html:options collection="cardYears" property="value" labelProperty="label"/>
				</html:select>				
			</TD>
		</TR>

		<TR>
			<TD><fmt:message key="label.common.cardholder"/></TD>
			<TD colspan="3"><html:text property="cardHolder"  size="32" maxlength="96" /></TD>
		</TR>


		<TR>
			<TD colspan="4" class="bold">
				- <fmt:message key="label.common.or"/> -
			</TD>
		</TR>

		
		<TR>
			<TD class="bold">
				<html:radio property="paymentMethod" value="billMeLater"><fmt:message key="label.common.billmelater"/></html:radio>
			</TD>
			<TD valign="bottom" align="center"><IMG border="0" src="../../img/common/BML_logo2.gif" width="197"
					height="63"></TD>
			<TD colspan="2" class="bold">
				<fmt:message key="label.billme.buyfast"/><br/>
				<a href="#"><fmt:message key="label.billme.whatis"/></a>
			</TD>
		</TR>

	</TBODY>
</TABLE>
<br/>

<TABLE width="80%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH align="left">
				<img src="/NicahostWeb/img/common/sir.gif" valign="middle">&nbsp;
				<fmt:message key="label.common.cancelationpolicytitle"/>
			</TH>
		</TR>
		<TR>
			<TD>
				<html:checkbox property="policyCancelation">
					<fmt:message key="label.common.cancelationpolicy1"/>.&nbsp;
					<fmt:message key="label.common.cancelationpolicy2"/>.&nbsp;
					<fmt:message key="label.common.cancelationpolicy3"/>.&nbsp;
					<fmt:message key="label.common.cancelationpolicy4"/>.
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



