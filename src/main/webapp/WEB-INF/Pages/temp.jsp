<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Index</title>
<head>
    <link href="<c:url value="/static/css/playlist.css" />" rel="stylesheet" type="text/css" />
     <script type="text/javascript" src="/Simple_Backend/static/js/playlist.js"></script>
</head>
<body>

	<c:if test="${not empty lists}">

		<ul class = "list">
			<c:forEach var="listValue" items="${lists}">
				<li><a href="/Simple_Backend/playSong?song_id=${listValue}">Song</a></li>
			</c:forEach>
		</ul>

	</c:if>

</body>
</html>