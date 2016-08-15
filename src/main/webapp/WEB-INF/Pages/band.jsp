<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Band Information</h2>
<form:form method="POST" action="/MavenProject/addBand">
   <table>
    <tr>
        <td><input type="text" name="bandName"> BandName</input></td>

    </tr>
    <tr>
      <td><input type="text" name="phoneNo"> PhoneNumber</input></td>
    </tr>

    <tr>
      <td><input type="text" name="email"> Email</input></td>
    </tr>

    <tr>
      <td><input type="text" name="musicGenre"> MusicGenre</input></td>
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