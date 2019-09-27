<form action="update" class="form-container">
              <label><b>User Id</b></label>
              <input class="form-control" type="text" value="${user.id}" name="userId" readonly>
              <label><b>Name</b></label>
              <input class="form-control" type="text" value="${user.name}" name="name" >
              <label><b>Mobile Number</b></label>
              <input class="form-control" type="tel" value="${user.number}" name="mobileNumber" >
              <label><b>Email</b></label>
              <input class="form-control" type="email" value="${user.emailId}" name="mobileNumber" > 
              <button type="submit" class="btn">Edit</button>
              <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
            </form>
