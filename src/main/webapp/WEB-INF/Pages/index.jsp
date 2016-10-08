<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Index</title>
<head>
    <link href="<c:url value="/static/css/indexPage.css" />" rel="stylesheet" type="text/css" />
     <script type="text/javascript" src="/Simple_Backend/static/js/indexPage.js"></script>
</head>
<body>

     <div class="navBar">
        <ul>
          <li><a class="active" href="#Hello">Home</a></li>
          <li><a href="/Simple_Backend/playlist">Add Playlist</a></li>
          <li><a href="#contact">Bands</a></li>
          <li><a href="#about">About</a></li>
          <li><a href="#contact">Contact Us</a></li>
        </ul>
      </div>

     <a href="/Simple_Backend/loginForm">Login</a>

     <div class="dropdown">
      <button onclick="myFunction()" class="dropbtn">Register</button>
      <div id="myDropdown" class="dropdown-content">
        <a href="/Simple_Backend/form?type=1">User</a>
        <a href="/Simple_Backend/form?type=2">Band</a>
        <a href="/Simple_Backend/form?type=3">RadioChannel</a>
      </div>
    </div>


</body>
</html>
