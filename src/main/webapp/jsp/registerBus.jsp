<!DOCTYPE html>
<html>
  <head>
    <title>Travel Booking Form</title>
    <link rel="stylesheet" href="/css/register.css"> 
  </head>
  <body>
    <div class="testbox">
    <form action="registerBus">
      <div class="banner">
        <h1>Bus Registration Form</h1>
      </div>
      <div class="item">
        <p>Bus Number</p>
        <div class="name-item">
          <input type="text" name="busNumber" placeholder="busNumber" 
                 pattern = "^[A-Z]{2} [0-9]{2} [A-Z] [0-9]{4}$" />
        </div>
      </div>
      <div class="item">
        <p>Capacity</p>
      <div class="name-item">
        <input type="number" name="capacity"/>
      </div>
      </div>
      <div class="item">
        <p>Operator</p>
        <div class="name-item">  
          <input type="text" name="operator"/>
        </div>
      </div>
      <div class="item">
        <p>Type</p>
        <div class="name-item">
          <select required name="type">
            <option selected value="--select--" disabled></option>
            <option value="AC">AC</option>
            <option value="Non AC">Non-AC</option>
          </select>
        </div>
      </div>
      
        <div class="btn-block">
          <button type="submit">Register</button>
        </div>
    </form>
    </div>
  </body>
</html>
