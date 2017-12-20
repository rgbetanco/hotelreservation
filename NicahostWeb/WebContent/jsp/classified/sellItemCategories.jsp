<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">

<fmt:setBundle 
	basename="com.nicahost.module.classified.resource.ClassifiedMessageResource" />


<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">vender artículo</SPAN> <SPAN
				class="checkoutSubTitle">| categoría</SPAN></TD>
		</TR>
		<TR>
			<TD>Seleccione la categoría y subcategoría del artículo.  </TD>
		</TR>
	</TBODY>
</TABLE>

<layout:skin includeScript="true" />

<layout:form action="sellitemdescribe.do" align="center">
  <layout:row>
  	<layout:column>
	   	<layout:column>
  			<layout:message key="label.common.category"/>
	  	</layout:column>  	
		<layout:select property="categoryName" size="12" key="" isRequired="true">
			<layout:options collection="categories" property="catId" labelProperty="catDesc" sourceOf="subCategoryName"/>	
		</layout:select>
   	</layout:column>
   	
   	<layout:column>
	   	<layout:column>
  			<layout:message key="label.common.subcategory"/>
	  	</layout:column>     	
		<layout:select property="subCategoryName" size="12" maxlength="20" key="" >				
			<layout:optionsDependent collection="subCategories" dependsFrom="categoryName" property="id" labelProperty="name"/>
		</layout:select>
	</layout:column>
 </layout:row>

 <layout:row>
 		<layout:image src="/NicahostWeb/img/clasificados/continuar.gif"></layout:image>	
</layout:row>
	
</layout:form>
