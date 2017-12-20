

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<html:html>

<fmt:setBundle basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />


<TABLE border="0">
	<TBODY>
		<TR>
			<TD>checkout | shipping options</TD>
		</TR>
		<TR>
			<TD>Please select a shipping method from the list below. If you have any questions about this shipping options, read about our shipping rates and information.</TD>
		</TR>
	</TBODY>
</TABLE>

<logic:messagesPresent>
	<strong>Please select a shipping option</strong>
</logic:messagesPresent>

<html:form action="placeorder.do">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD valign="top">
				<html:radio property="shippingOption" value="5.99" />
			</TD>
			<TD>Standard Shipping<BR>$5.99
			</TD>
		</TR>
		<TR>
			<TD valign="top">				
				<html:radio property="shippingOption" value="12.99"  />
			</TD>
			<TD>3-Day Shipping<BR>$12.99
			</TD>
		</TR>
		<TR>
			<TD valign="top">				
				<html:radio property="shippingOption" value="15.99" />
			</TD>
			<TD>2-Day Shipping<BR>$15.99
			</TD>
		</TR>
		<TR>
			<TD valign="top">				
				<html:radio property="shippingOption" value="29.99" />
			</TD>
			<TD>Overnight Shipping<BR>$29.99
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>
				<html:submit property="action">
					<bean:message key="button.placeorder"/>
				</html:submit>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>

<P><BR>If you have any questions, let our help section guide you
</P>

</html:html>
