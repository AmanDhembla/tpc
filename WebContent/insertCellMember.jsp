<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Cell Member</title>
<style>
.s{
    border: 3px solid #808080;
    background-color: #f4f4f4;
    text-align:center;
    margin-top:75px;
    margin-left:200px;
    margin-right:200px;
    padding: 20px;
}
</style>
</head>
<body>
<div class="s">
	<form method="post" action="CellMemberServlet">
		NAME:<input type ="text" placeholder="NAME" name="name">
		
		<br/><br>
		
		USER ID: <input type ="text" placeholder="User ID" name="userID">
		<br><br>

		EMAIL-ID:<input type ="text" placeholder="EMAIL ID" name="emailID">
		<br><br>
		CATEGORY: <input type ="text" placeholder="CATEGORY" name="category">
		<br><br>
		CONTACT-NUMBER: <input type ="text" placeholder="CONTACT NUMBER" name="contact">
		<br><br>
		PASSWORD:<input type ="text" placeholder="PASSWORD" name="password">
		<br><br>
		GENDER:<input type ="text" placeholder="GENDER" name="gender">
		<br><br>
		YEAR:<input type ="text" placeholder="YEAR" name="year">
		<br><br>		
		<input type="submit" value="submit" style="background-color:#4CAF50">
	</form>
</div>	
</body>
</html>



