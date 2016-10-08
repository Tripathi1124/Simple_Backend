<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Login</h2>
<form:form method="POST" action="/Simple_Backend/login">
   <table>

    <tr>
      <td><input type="text" name="phone"> PhoneNumber</input></td>
    </tr>
    <tr>
        <td><input type="text" name="otp"> OTP</input></td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>