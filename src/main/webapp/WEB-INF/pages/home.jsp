<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
 <head>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
 <br/>
 <div class="container">
  <div class="class="btn btn-primary btn-lg" role="alert"></div>
  <img src="${pageContext.request.contextPath}/resources/tv.png" alt="logo" width="100"/>
  <h1>Meus seriados preferidos</h1>
  <br/>

  <c:forEach var="seriado" items="${seriados}">
     <a class="alert alert-success" href="detalhe?id=<c:out value="${seriado.id}"/>">
      <c:out value="${seriado.nome}" />
     </a>
  </c:forEach>

  <br/><br/>
  <a href="novo" class="btn btn-primary btn-lg" type="submit" >novo seriado</a>
 </div>
</body>
</html>