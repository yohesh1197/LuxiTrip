<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
<script> 
          
            // Function to check Whether both passwords 
            // is same or not. 
            function checkPassword(form) { 
                password1 = form.password1.value; 
                password2 = form.password2.value; 
  
                // If password not entered 
                if (password == '') 
                    alert ("Please enter Password"); 
                      
                // If confirm password not entered 
                else if (ConformPassword == '') 
                    alert ("Please enter confirm password"); 
                      
                // If Not same return False.     
                else if (password != conformPassword) { 
                    alert ("\nPassword did not match: Please try again...") 
                    return false; 
                } 
  
                // If same return True. 
                else{ 
                    alert("Password Match: Welcome to GeeksforGeeks!") 
                    return true; 
                } 
            } 
        </script> 
   <meta charset="UTF-8" />
   <title>Luxitrip</title>
   <link rel = "icon" href = "4339.png" style = "width:100px">
   <link rel="stylesheet" type="text/css" href="../css/Style.css" />
   <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body>
   <div class="container">
      <button><img  class = "img" src = "../img/4339.png"></button>
      <header>
         <h1>Welcome Back</h1>
         <h1>Login to LUXITRIP</h1>
      </header>
      <section>
         <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
               <div id="login" class="animate form">
                  <form:form  action="mysuperscript.php" autocomplete="on">
                     <h1>Log in</h1>
                     <p> 
                        <form:label class="uname" >Email or Mobile </label>
                        <form:input id="username" name="username" required="required" type="text" placeholder="mymail@mail.com or xxxxxxxxxx"/>
                     </p>
                     <p> 
                        <label for="password" class="youpasswd">Password </label>
                        <form:input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                     </p>
                     <p class="login button"> 
                        <a href="http://cookingfoodsworld.blogspot.in/" target="_blank" ></a>
                     </p>
                     <p class="change_link">
                        Not a member yet ?
                        <a href="#toregister" class="to_register">Join us</a>
                     </p>
                  </form>
               </div>
               <div id="register" class="animate form">
                  <form  action="" autocomplete="on">
                     <h1> Sign up </h1>
                     <p> 
                        <form:label>Username</form:label>
                        <form:input required="required" path="name" type="text" placeholder="username690" />
                     </p>
                     <p> 
                        <form:label>Email</form:label>
                        <form:input required="required" path="emailId" type="email" placeholder="mysupermail@mail.com"/> 
                     </p>
                     <p> 
                        <form:label>Mobile Number</form:label>
                        <form:input type="tel" required="required" path="number" placeholder="xxxxxxxxxx"/> 
                     </p>
                     <form:label>Password </form:label>
                     <form:form:input required="required" path="password" type="password" placeholder="X8df!90EO"/>
                     <p> 
                        <form:label>Please confirm your password </form:label>
                        <form:input required="required" type="conformPassword" placeholder="eg. X8df!90EO"/>
                     </p>
                     <p>
                     
                     </p>
                     <p class="signin button"> 
                        <form:input type="submit" value="Sign up"/> 
                     </p>
                     <p class="change_link">  
                        Already a member ?
                        <a href="#tologin" class="to_register"> Go and log in </a>
                     </p>
                  </form>
               </div>
            </div>
         </div>
      </section>
   </div>
</body>
</html>
