
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

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

<p>

<html:form action="step03.do" focus="firstName">





<TABLE border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TD colspan="3" class="daterror">
			<INPUT type="hidden" name="initDate" value="<fmt:formatDate value="${reserveForm.initDateCal.time}" pattern="dd/MM/yyyy" />" >
			<INPUT type="hidden" name="endDate" value="<fmt:formatDate value="${reserveForm.endDateCal.time}" pattern="dd/MM/yyyy" />" >		
			<INPUT type="hidden" name="roomTypeId" value="<c:out value='${roomTypeId}' />" >		
			
			
			</TD>
		</TR>	
	
		<TR>
			<TH align="left">
				<img src="/NicahostWeb/img/common/sir.gif" valign="middle">&nbsp;
				<fmt:message key="label.step03.personalInfo" />
			</TH>
			<TH align="right" colspan="2">
				<a href="#"><fmt:message key="label.common.privacypolicy" /></a>
			</TH>
		</TR>

		<TR>
			<TD colspan="3" align="center">
				<FONT color="red">*</FONT>
				<fmt:message key="label.common.required"/>				
			</TD>
		</TR>
		
		<TR>
			<TD class="daterror" colspan="3"><FONT color="red">
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
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.firstname" />:<FONT
				color="red">*</FONT></TD>
			<TD><html:text property="firstName" size="32" maxlength="64"/></TD>
			<TD rowspan="10">
			
			<IMG border="0" src="../../img/common/trustEclick.gif" width="91"
				height="73"></TD>
		</TR>

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.lastname" />:<FONT
				color="red">*</FONT></TD>
			<TD><html:text property="lastName" size="32" maxlength="64"/></TD>
		</TR>		
		
		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.address" />:<FONT
				color="red"></FONT></TD>
			<TD><html:textarea property="address" cols="32" rows="3" /></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.ethnicity" />:</TD>
			<TD>
			<SELECT name="ethnicity">
				<OPTION value=""></OPTION>
				<c:forEach items="${ethnicities}" var="ethnicityLocal">
					<OPTION value="<c:out value='${ethnicityLocal.value}' />">
					<c:set var="eth" value="${ethnicityLocal.label}" />
					<fmt:message key="${eth}" />
					</OPTION>
				</c:forEach>
			</SELECT></TD>
		</TR>
		
		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.country" />:<FONT
				color="red">*</FONT></TD>
			<TD>
			<SELECT name="country">
				<OPTION value=""><fmt:message key="label.step03.personalInfo.countryselect"/></OPTION>
				<c:forEach items="${countries}" var="countryLocal">					
					<OPTION value="<c:out value='${countryLocal.value}' />">
						<c:set var="count" value="${countryLocal.label}" />
						 <fmt:message key="${count}" />

					</OPTION>
						
				</c:forEach>
			</SELECT>
			</TD>
		</TR>

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.city" />:<FONT
				color="red"></FONT></TD>
			<TD><html:text property="city" size="32" maxlength="64"/></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.zip" />:<FONT
				color="red"></FONT></TD>
			<TD><html:text property="zip" size="10" maxlength="10"/></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.phone" />:<FONT
				color="red"></FONT></TD>
			<TD><html:text property="phone" size="22" maxlength="25"/></TD>
		</TR>		

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.email" />:<FONT
				color="red">*</FONT></TD>
			<TD><html:text property="email1" size="32" maxlength="150"/></TD>
		</TR>

		<TR>
			<TD class="bold" align="left"><fmt:message key="label.step03.personalInfo.emailconfirm" />:<FONT
				color="red">*</FONT></TD>
			<TD><html:text property="email2" size="32" maxlength="150"/></TD>
		</TR>
		<TR>
			<TD colspan="3">&nbsp;</TD>
		</TR>		

		<TR>
			<TD colspan="3">
<DIV align="center">
			<INPUT type="image" class="HandPointer" 
					src="<fmt:message key="common.resource.image.confirm"/>" 
					name="continue" 
					onmouseover="MM_swapImage('continue','','<fmt:message key="common.resource.image.confirmON"/>',1);"
					onmouseout="MM_swapImgRestore();"					
					onclick="">
</DIV>
			
			</TD>
		</TR>

	</TBODY>
</TABLE>


</html:form>

