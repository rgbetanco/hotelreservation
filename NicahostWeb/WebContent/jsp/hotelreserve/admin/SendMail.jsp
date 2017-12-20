<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>SendMail.jsp</TITLE>
</HEAD>
<BODY>
<BLOCKQUOTE>
<P align="center"><B>Send an email to the client</B></P>
</BLOCKQUOTE>
<P></P>
<P><INPUT type="text" value="${emailParm}" name="email" size="40"><BR>
<INPUT type="text"
	name="subject" size="40" value="from the hotel"><BR>
<TEXTAREA rows="4"
	cols="40" name="mailbody"></TEXTAREA><BR>
<INPUT type="submit" name="submit" value="Send"><INPUT type="reset"
	value="Clean"></P>
</BODY>
</HTML>
