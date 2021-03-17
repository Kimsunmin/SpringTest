<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Simple Page Index  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<script type="text/javascript">
	location.href = "/index";
</script>
</body>
</html>
