<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="stu.student" %>
<html>
<head>

<title>
STUDENT INFO
</title>
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
	student stu =(student)session.getAttribute("s");
	out.println("ROLL NUMBER OF STUDENT : " +stu.sid);
	out.println("</br>");
	out.println("</br>");
	out.println("NAME OF STUDENT : "+stu.sname);
	out.println("</br>");
	out.println("</br>");
	out.println("CPI OF STUDENT : "+stu.cpi);
	out.println("</br>");
	out.println("</br>");
	out.println("EMAIL ID OF STUDENT : "+stu.sEmailId);
	out.println("</br>");
	out.println("</br>");	
	out.println("PLACEMENT STATUS OF STUDENT :"+stu.status);
	out.println("</br>");
	out.println("</br>");
	out.println("PLACED COMPANY : "+stu.company);
	out.println("</br>");
	out.println("</br>");
	out.println("STUDENT SALARY : "+stu.salary);
	//student s=new student();
		//	s.getdata("15ucs017");
	//		out.println(s.sid);
%>
</div>
</body>
</html>