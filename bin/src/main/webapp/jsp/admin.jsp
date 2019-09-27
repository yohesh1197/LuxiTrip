<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html >
<head>
<script src="/css/Validation.js">
</script>
<link href="/css/StyleSheet.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
        <div style="display: in-line; float:right;">
        <img class ="luxitrip"  src="4339.png">
        </div>
	<div class="navsidebar navbar-block navdark-grey navanimate-left"
		style="display: in-line; float:right;" id="mySidebar">
		<button class="navbar-itemm navbutton navlarge" onclick="navClose()">&times;</button>
		<form action="createBus" method="GET">
			<button href="#" class="navbar-item navbutton" value="displayAll"
				name="operation">Register Buses</button>
		</form>
		<form action="" method="GET">
			<button href="#" class="navbar-item navbutton" value="displayClients"
				name="operation">Register Driver</button>
		</form>
		<form action="" method="post">
			<button href="#" class="navbar-item navbutton"
				value="Display Projects" name="operation">Route Entry</button>
		</form>
		<form action="logOut" method="POST">
			<button href="#" class="navbar-item navbutton" value="logout"
				name="operation">Logout</button>
		</form>
	</div>
	<div style="width: 60px;">
		<button class="navbutton navwhite navxxlarge" onclick="navOpen()">&#9776;</button>
	</div>
    <div class="display-margin">
      <c:forEach var="bus" items="${buses}">
        <div class="divbox">
          <fieldset class="divfieldset">
            <legend class="divfieldsetlegend">
              <i class="fa fa-bus"></i>
            </legend>
            <table cellpadding="5px" class="allemployee">
              <tr>
                <td>Bus No</td>
                <td>
                  <c:out value="${bus.busNumber}" />
                </td>
              <tr>
              <tr>
                <td>Capcity</td>
                <td>
                  <c:out value="${bus.capacity}" />
                </td>
              </tr>
              <tr>
              <td>Operator</td>
              <td>
                <c:out value="${bus.operator}" />
              </td>
              </tr>
              <tr>
                <td>Bus type</td>
                <td>
                  <c:out value="${bus.type}" />
                </td>
              </tr>
            </table>
              <center>
               <form action="displayAllBuses" method="get" style="display: inline-block;">
                <td> <input type="hidden" name="id" value= "${bus.id}" /></td>
                <button type="submit" value="delete" target="_self" class="button remove" >
                  <i class="fa fa-trash" aria-hidden="true"></i>
                </form>
                </button>
                <form action="displayAllBuses" method="get" style="display: inline-block;">
                <td> <input type="hidden" name="id" value= "${bus.id}" /></td>
                <button type="submit" value ="search" target="_self" class="button update" >
                  <i class="fa fa-pencil-square-o"></i></button>
                  </form>
                </button>
                <form action="displayAllBuses" method="get" style="display: inline-block;">
                <td> <input type="hidden" name="id" value= "${bus.id}" /></td>
                <button type="submit" value="display" target="_self" class="button display">
                  <i class="fa fa-eye"></i></button>
                 </form>
                </button>
              </center>
        </div>
        </fieldset>
      </c:forEach>
    </div>
</body>
</html>
