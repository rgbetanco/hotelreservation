<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/clasificadosStyle.css" type="text/css">
<html:base/>
<script language="javascript">
var val = true;
var val2 = true;

function toggleRadio(value) { 
	
	var ele = document.forms["sellItemForm"].elements["states"];
	for(i=0;i<ele.length;i++) {
		if (value) {
			ele[i].checked = !value;
			document.forms["sellItemForm"].elements["statesall"].checked = !value;
			val = value;			
		}
		ele[i].disabled = value;
		document.forms["sellItemForm"].elements["statesall"].disabled = value;
	}
	
	var ele2 = document.forms["sellItemForm"].elements["regions"];
	for(i=0;i<ele2.length;i++) {
		if (value) {
			ele2[i].checked = !value;
			document.forms["sellItemForm"].elements["worldwide"].checked = !value;
			val2 = value;
		}
		ele2[i].disabled = value;
		document.forms["sellItemForm"].elements["worldwide"].disabled = value;
		
	}	
}


function selectAll() {
	var ele = document.forms["sellItemForm"].elements["states"];
	for(i=0;i<ele.length;i++) {
		ele[i].checked = val;
	}
	val = !val;
}


function selectAllWorld() {
	var ele = document.forms["sellItemForm"].elements["regions"];
	for(i=0;i<ele.length;i++) {
		ele[i].checked = val2;
	}
	val2 = !val2;
}

</script>

<TABLE border="0">
	<TBODY>
		<TR>
			<TD><SPAN class="checkoutTitle">vender artículo</SPAN> <SPAN
				class="checkoutSubTitle">| métodos de entrega</SPAN></TD>
		</TR>
		<TR>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>

<html:form action="sellitemconfirm.do">
<TABLE width="90%" border="0" cellspacing="5" id="sessionTable">
	<TBODY>
		<TR>
			<TH colspan="5">Lugares de entrega</TH>
		</TR>
		<TR>
			<TD colspan="5">
				<html:radio property="shipLocation" value="Nicaragua" onclick="toggleRadio(false);">Se enviará  a los siguientes destinos:</html:radio>
			</TD>
		</TR>
		<TR>
			<TD colspan="5">
			<CENTER>
			<TABLE width="50%" border="0" cellspacing="5" id="sessionTable">
				<TBODY>
					<TR valign="top">
						<TD colspan="4" nowrap="nowrap" valign="top">
							<input type="checkbox" name="statesall" value="" onclick="selectAll();">Todo <b>Nicaragua</b>
						</TD>
					</tr>
					<TR valign="top">
						<TD nowrap="nowrap" valign="top" rowspan="5" colspan="5"></TD>
					</TR>
					
		<c:forEach items="${nicaraguaRegions}" var="bean" varStatus="stat">			
			<c:choose>
				<c:when test="${stat.first}"><!-- first --><tr></c:when>			
				<c:when test="${stat.index % 5 == 0}"><!-- neither --></tr><tr></c:when>
			</c:choose>
					<TD nowrap><html:multibox property="states"><c:out value="${bean.regionName}" /></html:multibox><c:out value="${bean.regionName}" /> </TD>
				<c:if test="${stat.last}"><!-- last --></tr></c:if>
		</c:forEach>
		
				</TBODY>
			</TABLE>
			</CENTER>
			</TD>
		</TR>
		
		
		<TR>
			<TD colspan="5">
			<CENTER>
			<TABLE width="50%" border="0" cellspacing="5" id="sessionTable">
				<TBODY>
					<TR valign="top">
						<TD colspan="5" nowrap="nowrap" valign="top">
							<input type="checkbox" name="worldwide" value="" onclick="selectAllWorld();">Todo el <b>mundo</b>
						</TD>
					</tr>
					<TR valign="top">
						<TD nowrap="nowrap" valign="top" rowspan="5" colspan="5"></TD>
					</TR>
					
		<c:forEach items="${worldwideRegions}" var="beanS" varStatus="stat">			
			<c:choose>
				<c:when test="${stat.first}"><!-- first --><tr></c:when>			
				<c:when test="${stat.index % 5 == 0}"><!-- neither --></tr><tr></c:when>
			</c:choose>
					<TD nowrap><html:multibox property="regions"><c:out value="${beanS.regionName}" /></html:multibox><c:out value="${beanS.regionName}" /> </TD>
				<c:if test="${stat.last}"><!-- last --></tr></c:if>
		</c:forEach>
		
				</TBODY>
			</TABLE>
			</CENTER>
			</TD>
		</TR>		
		
		
		
		
		
		<TR>
			<TD colspan="5">
			<html:radio property="shipLocation" value="Sin entrega" onclick="toggleRadio(true);">No se eviará - solamente entrega local</html:radio>
			</TD>
		</TR>
	</TBODY>
</TABLE>
<p>&nbsp;</p>
<TABLE width="90%" border="0" cellspacing="5" id="sessionTable">
	<TBODY>
		<TR>
			<TH colspan="5">Cargos por entrega</TH>
		</TR>
		<TR>
			<TD colspan="5">
				Indique un costo fijo por cada servicio de entrega ofrecido u obtenga los costos calculados autmaticamente según el 
				paquete o la dirección del comprador.
			</TD>
		</TR>
		<TR>
			<TD colspan="4">
				<layout:skin includeScript="true" />
				<layout:tabs width="100%">
					<layout:tab key="Fijo" width="25%">
						<layout:row>
							<layout:column>
							<layout:row>
								<layout:column>							
							Entrega doméstica (hasta 3 tipos de servicios)<br>
							<html:select property="localShippingMethod1">
								<html:option value="Servicio Básico estándard"></html:option>
								<html:option value="Servicio Pack Express (24 hrs)"></html:option>
								<html:option value="Servicio Pack Express (48 hrs)"></html:option>
								<html:option value="Servicio Pack Express (72 hrs)"></html:option>								
								<html:option value="EMS Express Mail Service (24 hrs)"></html:option>
								<html:option value="EMS Express Mail Service (48 hrs)"></html:option>
								<html:option value="EMS Express Mail Service (72 hrs)"></html:option>
								<html:option value="Valija Serca Express (24 hrs)"></html:option>
								<html:option value="Valija Serca Express (48 hrs)"></html:option>
								<html:option value="Valija Serca Express (72 hrs)"></html:option>
								<html:option value="Entrega personal (24 hrs)"></html:option>
								<html:option value="Entrega personal (48 hrs)"></html:option>
								<html:option value="Entrega personal (72 hrs)"></html:option>
								<html:option value="Otro"></html:option>								
							</html:select>
							 &nbsp;&nbsp;Precio: <html:text property="localShippingPrice1" size="5"/>
							<html:radio property="localShippingCurrency1" value="USD">USD</html:radio> 
							<html:radio property="localShippingCurrency1" value="COR">COR</html:radio>
							</layout:column>
							</layout:row>
				<!-- 2 -->							
						<layout:row>
							<layout:column>
				
							<html:select property="localShippingMethod2">
								<option value=""> -- Seleccione una 2 -- </option>
								<html:option value="Servicio Básico estándard"></html:option>
								<html:option value="Servicio Pack Express (24 hrs)"></html:option>
								<html:option value="Servicio Pack Express (48 hrs)"></html:option>
								<html:option value="Servicio Pack Express (72 hrs)"></html:option>								
								<html:option value="EMS Express Mail Service (24 hrs)"></html:option>
								<html:option value="EMS Express Mail Service (48 hrs)"></html:option>
								<html:option value="EMS Express Mail Service (72 hrs)"></html:option>
								<html:option value="Valija Serca Express (24 hrs)"></html:option>
								<html:option value="Valija Serca Express (48 hrs)"></html:option>
								<html:option value="Valija Serca Express (72 hrs)"></html:option>
								<html:option value="Entrega personal (24 hrs)"></html:option>
								<html:option value="Entrega personal (48 hrs)"></html:option>
								<html:option value="Entrega personal (72 hrs)"></html:option>
								<html:option value="Otro"></html:option>								
							</html:select>
							 &nbsp;&nbsp;Precio: <html:text property="localShippingPrice2" size="5"/>
							<html:radio property="localShippingCurrency2" value="USD">USD</html:radio> 
							<html:radio property="localShippingCurrency2" value="COR">COR</html:radio>				
							</layout:column>							
							</layout:row>
				<!-- 3 -->				
						<layout:row>
							<layout:column>
							
							<html:select property="localShippingMethod3">
								<option value=""> -- Seleccione una -- </option>
								<html:option value="Servicio Básico estándard"></html:option>
								<html:option value="Servicio Pack Express (24 hrs)"></html:option>
								<html:option value="Servicio Pack Express (48 hrs)"></html:option>
								<html:option value="Servicio Pack Express (72 hrs)"></html:option>								
								<html:option value="EMS Express Mail Service (24 hrs)"></html:option>
								<html:option value="EMS Express Mail Service (48 hrs)"></html:option>
								<html:option value="EMS Express Mail Service (72 hrs)"></html:option>
								<html:option value="Valija Serca Express (24 hrs)"></html:option>
								<html:option value="Valija Serca Express (48 hrs)"></html:option>
								<html:option value="Valija Serca Express (72 hrs)"></html:option>
								<html:option value="Entrega personal (24 hrs)"></html:option>
								<html:option value="Entrega personal (48 hrs)"></html:option>
								<html:option value="Entrega personal (72 hrs)"></html:option>
								<html:option value="Otro"></html:option>								
							</html:select>
							 &nbsp;&nbsp;Precio: <html:text property="localShippingPrice3" size="5"/>
							<html:radio property="localShippingCurrency3" value="USD">USD</html:radio> 
							<html:radio property="localShippingCurrency3" value="COR">COR</html:radio>				
						</layout:column>
						</layout:row>
							
							
						</layout:column>
						<layout:column styleClass="sessionTable" >
							<a href="http://www.correos.com.ni" target="_blank">
							<IMG border="0" src="/NicahostWeb/img/clasificados/logoCorreos.gif" width="128" height="99">
							<br>Más info...
							</a>
						</layout:column>
					</layout:row>						
					
					<layout:row>
						<layout:column styleClass="sessionTable">
							Tiempo apróximado para entrega locales<br>
							<html:select property="localShippingTime">
								<option value=""> -- Seleccione tiempo -- </option>
								<html:option value="1 dia habil"></html:option>
								<html:option value="2 dias habiles"></html:option>
								<html:option value="3 dias habiles"></html:option>
								<html:option value="4 dias habiles"></html:option>
								<html:option value="5 dias habiles"></html:option>
								<html:option value="10 dias habiles"></html:option>
								<html:option value="15 dias habiles"></html:option>
								<html:option value="20 dias habiles"></html:option>
							</html:select>
						
						</layout:column>					
					</layout:row>
						
					</layout:tab>
					<layout:tab key="Calculado" width="25%">
						<layout:select property="destinationRegion1">
							<layout:options collection="nicaraguaRegions" property="regionName" labelProperty="regionName" sourceOf="destinationStates1" />								
						</layout:select>
						<layout:select property="destinationStates1" size="3" key="" multiple="true">							
							<layout:optionsDependent collection="states" dependsFrom="destinationRegion1" property="stateName" labelProperty="stateName" />
						</layout:select>
					</layout:tab>
				</layout:tabs>			
			</TD>									
		</TR>
	</TBODY>
</TABLE>


<INPUT type="image" name="continue" src="/NicahostWeb/img/clasificados/continuar.gif" onclick="this.form.submit();" width="90" height="17">	

</html:form>