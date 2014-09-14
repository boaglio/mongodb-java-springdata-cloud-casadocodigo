<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>

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

 <c:choose>
 <c:when test="${msg =='update'}">
  <br/>
  <div class="alert alert-warning">Seriado alterado!</div>
 </c:when>

 <c:when test="${msg =='delete'}">
  <br/>
  <div class="alert alert-warning">Seriado removido!</div>
 </c:when>

 <c:otherwise>

   <div class="alert alert-success" role="alert">Alterar seriado</div>
   <form method="get" action="alterar">
   <p>
    <div class="input-group">
     <span class="input-group-addon">Nome</span>
     <input type="text" name="nome" id="nome" class="form-control" value="${seriado.nome}" placeholder="nome do seriado ?">
    </div>
    <div class="input-group">
     <span class="input-group-addon">Personagem 1</span>
     <input type="text" name="personagem1" id="personagem1" value="<c:if test="${totalDePersonagens>0}">${seriado.personagens[0]}</c:if>" class="form-control" placeholder="nome de um personagem ?">
    </div>
    <div class="input-group">
     <span class="input-group-addon">Personagem 2</span>
     <input type="text" name="personagem2" id="personagem2" value="<c:if test="${totalDePersonagens>1}">${seriado.personagens[1]}</c:if>" class="form-control" placeholder="nome de um personagem ?">
    </div>
    <div class="input-group">
     <span class="input-group-addon">Personagem 3</span>
     <input type="text" name="personagem3" id="personagem3" value="<c:if test="${totalDePersonagens>2}">${seriado.personagens[2]}</c:if>" class="form-control" placeholder="nome de um personagem ?">
    </div>
    <div class="input-group">
     <span class="input-group-addon">Personagem 4</span>
     <input type="text" name="personagem4" id="personagem4" value="<c:if test="${totalDePersonagens>3}">${seriado.personagens[3]}</c:if>" class="form-control" placeholder="nome de um personagem ?">
    </div>
        <div class="input-group">
     <span class="input-group-addon">Personagem 5</span>
     <input type="text" name="personagem5" id="personagem5" value="<c:if test="${totalDePersonagens>4}">${seriado.personagens[4]}</c:if>" class="form-control" placeholder="nome de um personagem ?">
    </div>
    <div class="input-group">
     <span class="input-group-addon">Personagem 6</span>
     <input type="text" name="personagem6" id="personagem6" value="<c:if test="${totalDePersonagens>5}">${seriado.personagens[5]}</c:if>" class="form-control" placeholder="nome de um personagem ?">
    </div>
    </p>
   <p>
    <input type="hidden" name="id" value="${seriado.id}"/>
    <input class="btn btn-primary btn-lg" type="submit" value="alterar !" />
   </p>
  </form>
  <form method="get" action="remover">
   <input type="hidden" name="id" value="${seriado.id}"/>
   <input class="btn btn-primary btn-lg" type="submit" value="remover !" />
  </form>

 </c:otherwise>
</c:choose>

  <form method="post" action="index.jsp">
   <input class="btn btn-primary btn-lg" type="submit" value="lista de seriados" />
  </form>

 </div>
</body>
</html>