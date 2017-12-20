
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

<p>

<html:form action="step04.do" focus="firstName">





<TABLE border="0" cellpadding="5" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
				<TD colspan="4" class="daterror"><INPUT type="hidden"
					name="initDate"
					value="<fmt:formatDate value="${reserveForm.initDateCal.time}" pattern="dd/MM/yyyy" />">
				<INPUT type="hidden" name="endDate"
					value="<fmt:formatDate value="${reserveForm.endDateCal.time}" pattern="dd/MM/yyyy" />">
				<INPUT type="hidden" name="roomTypeId"
					value="<c:out value='${roomTypeId}' />"></TD>
			</TR>	
	
		<TR>
			<TH align="left" nowrap>
				<img src="/NicahostWeb/img/common/sir.gif" valign="middle">&nbsp;
				<fmt:message key="label.step03.personalInfo" />
			</TH>
			<TH align="right" colspan="2" nowrap>&nbsp;
			</TH>
				<TH align="right" nowrap>&nbsp;</TH>
			</TR>

		<TR>
				<TD colspan="4" align="center"><FONT color="red">*</FONT> <fmt:message
					key="label.common.required" /></TD>
			</TR>
		
		<TR>
				<TD class="daterror" colspan="4"><FONT color="red">
				<ul>
					<logic:messagesPresent>
						<html:messages id="error">
							<li><c:out value="${error}" /></li>
						</html:messages>
					</logic:messagesPresent>
				</ul>
				</FONT></TD>
			</TR>
		
		<TR valign="top"> 
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.firstname" />:<FONT
				color="red">*</FONT></TD>
			<TD><html:text property="firstName" size="20" maxlength="64" tabindex="1"/></TD>
			<TD class="bold" rowspan="2"><fmt:message key="label.step03.personalInfo.address" />:<FONT
					color="red"></FONT></TD>
				<TD rowspan="2" valign="top"><html:textarea property="address" cols="28" rows="2" tabindex="6"/></TD>
			</TR>

			<TR>
				<TD class="bold" align="left"><fmt:message
					key="label.step03.personalInfo.lastname" />:<FONT color="red">*</FONT></TD>
				<TD><html:text property="lastName" size="20" maxlength="64" tabindex="2"/></TD></TR>
			<TR>
				<TD class="bold" align="left"><fmt:message
					key="label.step03.personalInfo.email" />:<FONT color="red">*</FONT></TD>
				<TD><html:text property="email1" size="20" maxlength="150" tabindex="3"/></TD>
				<TD class="bold" ><fmt:message key="label.step03.personalInfo.city" />:<FONT
					color="red"></FONT></TD>
				<TD><html:text property="city" size="20" maxlength="64" tabindex="7"/></TD>
			</TR>
			<TR>
				<TD class="bold" align="left"><fmt:message
					key="label.step03.personalInfo.emailconfirm" />:<FONT color="red">*</FONT></TD>
				<TD><html:text property="email2" size="20" maxlength="150" tabindex="4"/></TD>
				<TD class="bold" ><fmt:message key="label.step03.personalInfo.zip" />:
					<FONT color="red"></FONT>
				</TD>
				<TD><html:text property="zip" size="20" maxlength="10" tabindex="9"/></TD>
			</TR>
			<TR>
				<TD class="bold" align="left"><fmt:message
					key="label.step03.personalInfo.phone" />:<FONT color="red"></FONT></TD>
				<TD><html:text property="phone" size="20" maxlength="25" tabindex="5"/></TD>
				<TD class="bold" ><fmt:message key="label.step03.personalInfo.country" />:<FONT color="red">*</FONT>
				</TD>
				<TD><SELECT name="country" tabindex="10">
					<OPTION value=""> -- <fmt:message
						key="label.step03.personalInfo.countryselect" /> -- </OPTION>
					<c:forEach items="${countries}" var="countryLocal">
						<OPTION value="<c:out value='${countryLocal.value}' />"><c:set
							var="count" value="${countryLocal.label}" /> <fmt:message
							key="${count}" /></OPTION>

					</c:forEach>
				</SELECT></TD>
			</TR>

			<TR>
				<TD></TD>
				<TD colspan="2" align="left"></TD>
				<TD></TD>
				
			</TR>

			<TR>
				<TD colspan="4" align="center">
				<TABLE id="sessionTable" style="border-width: 0.0pt">
					<TBODY>
					<TR>
						<TD class="bold"><fmt:message key="label.common.commenttext" /></TD>
					</TR>
					<TR>
						<TD>
							<html:textarea property="comment" cols="60" rows="5" tabindex="11"></html:textarea>
						</TD>
					</TR>
					</TBODY>
				</TABLE>
			</TR>
			<TR>
				<TD colspan="4">
				<DIV align="center"><INPUT type="image" class="HandPointer"
					src="<fmt:message key="common.resource.image.confirm"/>"
					name="continue"
					onmouseover="MM_swapImage('continue','','<fmt:message key="common.resource.image.confirmON"/>',1);"
					onmouseout="MM_swapImgRestore();" onclick=""></DIV>

				</TD>
			</TR>

	</TBODY>
</TABLE>


</html:form>

