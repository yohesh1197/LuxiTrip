<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addStop" method="GET" >
  <input type="text" name="name" maxlength="30">
  <button  value="add" name="operation">add</button>
  </form>
  
<form action="displayStop" method="GET" >
  <input type="text" name="id" maxlength="30">
  <button  value="display" name="operation">display</button>
  </form>
  
  <form action="deleteStop" method="GET" >
  <input type="text" name="id" maxlength="30">
  <button  value="delete" name="operation">delete</button>
  </form>
  <form action="displayAllStop" method="GET" >
  <button  value="displayAll" name="operation">displayAll</button>
  </form>
</body>
</html>
