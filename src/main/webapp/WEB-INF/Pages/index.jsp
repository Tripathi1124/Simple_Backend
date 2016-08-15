<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Index</title>
<head>
    <link href="<c:url value="/static/css/indexPage.css" />" rel="stylesheet" type="text/css" />
     <script type="text/javascript" src="/MavenProject/static/js/indexPage.js"></script>
</head>
<body>

    <header class="page-header">
     <div class="navBar">
        <ul>
          <li><a class="active" href="#Hello">Home</a></li>
          <li><a href="#news">Radio Channels</a></li>
          <li><a href="#contact">Bands</a></li>
          <li><a href="#about">About</a></li>
        </ul>
      </div>
     <div class="dropdown">
      <button onclick="myFunction()" class="dropbtn">Register</button>

      <div id="myDropdown" class="dropdown-content">
        <a href="/MavenProject/form?type=1">User</a>
        <a href="/MavenProject/form?type=2">Band</a>
        <a href="/MavenProject/form?type=3">RadioChannel</a>
      </div>
    </div>
    </header>
</body>
</html>
