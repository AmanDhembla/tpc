<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Cell_Member.CellMember" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.s{
    border: 3px solid #808080;
    background-color: #f2f2f2;
    text-align:center;
    
    margin-left:100px;
    margin-right:100px;
    padding:20px;
}

</style>
</head>
<body>
<h1>STUDENT INFORMATION:</h1>
<div class="s">
<%
	//out.println(session.getAttribute("s"));
	CellMember c=(CellMember)session.getAttribute("c");
	out.println("ROLL NUMBER OF STUDENT : " +c.getId());
	out.println("</br>");
	out.println("</br>");
	out.println("NAME OF STUDENT : "+c.getName());
	out.println("</br>");
	out.println("</br>");
	out.println("EMAIL ID OF STUDENT : "+c.getEmailId());
	out.println("</br>");
	out.println("</br>");	
	out.println("CONTACT-NUMBER :"+c.getContactNumber());
	out.println("</br>");
	out.println("</br>");
	out.println("CATEGORY : "+c.getCategory());
	out.println("</br>");
	out.println("</br>");
	out.println("GENDER : "+c.getGender());
	out.println("</br>");
	out.println("</br>");
	out.println("YEAR : "+c.getBatch());
	
	//student s=new student();
		//	s.getdata("15ucs017");
	//		out.println(s.sid);
%>
</div>
</body>
</html>