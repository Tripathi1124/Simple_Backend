<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Index</title>
<head>
    <link href="<c:url value="/static/css/playlist.css" />" rel="stylesheet" type="text/css" />
     <script type="text/javascript" src="/Simple_Backend/static/js/playlist.js"></script>
</head>
<body>

<c:choose>
    <c:when test="${not empty lists}">
       		<ul>
       			<c:forEach var="listValue" items="${lists}">
       				<li><a href="/Simple_Backend/playSong?song_id=${listValue}"/></li>
       			</c:forEach>
       		</ul>
    </c:when>
    <c:otherwise>
        <ul class = "list">
          <li><a href="/Simple_Backend/addPlaylist?phone=${phone}&song_id=1">Ishq Mastana</a></li>
          <li><a href="/Simple_Backend/addPlaylist?phone=${phone}&song_id=2">Jaago</a></li>
          <li><a href="/Simple_Backend/addPlaylist?phone=${phone}&song_id=3">Udja</a></li>
          <li><a href="/Simple_Backend/addPlaylist?phone=${phone}&song_id=4">Manzar</a></li>
        </ul>
    </c:otherwise>
</c:choose>

<a href="/Simple_Backend/myPlaylist?phone=${phone}">Show My Playlist</a>
</body>
</html>