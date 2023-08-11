<!DOCTYPE html>
<html>
<head>
  <title>Registration form</title>
  <script>
        function validateForm() {
            var login = document.forms["myForm"]["login"].value;
            var password = document.forms["myForm"]["password"].value;
            var email = document.forms["myForm"]["email"].value;
            if (login == "") {
                alert("Please input login");
                return false;
            }
            if (password == "") {
                alert("Please input password");
                return false;
            }
            if (email == "") {
                alert("Please input email");
                return false;
            }
        }
    </script>
</head>
<body>
<h2>Registration</h2>
<form name="myForm" onsubmit="return validateForm()" method="post">
  <label for="login">Login:</label>
  <input type="text" id="login" name="login"><br><br>
  <label for="password">Password:</label>
  <input type="text" id="password" name="password"><br><br>
  <label for="email">Email:</label>
  <input type="text" id="email" name="email"><br><br>
  <input type="submit" value="Send">
</form>
</body>
</html>