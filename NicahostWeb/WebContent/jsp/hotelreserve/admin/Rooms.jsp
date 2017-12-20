<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">
<LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css">

<SCRIPT language="JavaScript" src="/NicahostWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/NicahostWeb/js/utils.js"></SCRIPT>

<fmt:setBundle 
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />
	
<TITLE>ROOMS TABLE</TITLE>

<H1 align="center"><fmt:message key="labelAdmin.table.header1" /></H1>

<BODY>
<FORM action="/NicahostWeb/hotelreserve/updateRooms.do">
<TABLE width="80%" align="center" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH>id</TH>
			<TH>type</TH>
			<TH>maxpeople</TH>
			<TH>description</TH>
			<TH>price</TH>
			<TH>blocked</TH>
		</TR>
	<c:forEach items="${rooms}" var="roomsToShow">	
		<TR>
			<TD><INPUT type="text" size = "2" name="idRoom" value="<c:out value="${roomsToShow.id}"/>"/></TD>
			<TD><select name="roomType">
					<option value=""></option>
					<c:forEach items="${roomTypes}" var="room">		
						<option value="<c:out value='${room.value}' />"
						<c:if test="${room.value==roomsToShow.roomType}">
						selected
						</c:if>>
							<fmt:message key='${room.label}' />
						</option>
					</c:forEach>					
				</select>
				<c:set var="desc" value="${roomsToShow.description}"/>
			<TD align="center"><INPUT type="text" size=2 name="maxPeople" value="<c:out value="${roomsToShow.maxPeople}"/>"></TD>
			<TD><INPUT type="text" readonly="readonly" size = 25 name="description" value="<fmt:message key='${desc}'/>"/></TD>
			<TD><INPUT type="text" size = 8 name="price" value="<c:out value="${roomsToShow.price}"/>"/></TD>
			<TD><select name="blocked">
				<option value="N"
				<c:if test="${roomsToShow.blocked=='N'}">selected</c:if>>No
				</option>
				<option value="Y"
				<c:if test="${roomsToShow.blocked=='Y'}">selected</c:if>>Yes
				</option>
				</select>
			</TD>
		</TR>
	</c:forEach>
	<TR>
		<TD colspan="6" align="center"><INPUT type="submit" value="Accept"></TD>
	</TR>	
	</TBODY>
</TABLE>
</FORM>

<FORM action="/NicahostWeb/hotelreserve/insertRoom.do">
<TABLE width="80%" align="center" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH>id</TH>
			<TH>Type</TH>
			<TH>MaxPeople</TH>
			<TH>Description</TH>
			<TH>Price</TH>
			<TH>Blocked</TH>
		</TR>
		<TR>
			<TD><INPUT type="text" name="idRoomToInsert" size="2"></TD>
			<TD><select name="roomTypeToInsert">
					<c:forEach items="${roomTypes}" var="room1">		
						<option value="<c:out value='${room1.value}' />">
							<fmt:message key='${room1.label}' />
						</option>
					</c:forEach>					
				</select></TD>
			<TD align="center"><INPUT type="text" name="maxPeopleToInsert" size="2"></TD>
			<TD><INPUT type="text" name="descriptionToInsert" size="25"></TD>
			<TD><INPUT type="text" name="priceToInsert" size="8"></TD>
			<TD><select name="blockedToInsert">
				<option value="N">
					No
				</option>
				<option value="Y">
					Yes
				</option>
			</TD>
		</TR>
		<TR>
			<TD colspan="6" align="center"><INPUT type="submit" value="Add"></TD>
		</TR>
	</TBODY>
</TABLE>

</FORM>


</BODY>
