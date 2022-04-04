<%@ page import="ma.fstm.ilisi.recrutement.controller.MeggaController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Postulations</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <main role="main" class="pb-3">
            <div class="col-md-9">
                <table class="table table-hover table-bordered">
                    <thead>
                    <th>id</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Date de Postulation</th>
                    <th>CV</th>
                    <th>Lettre</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.posts}" var="poste">
                        <tr>
                            <td>${poste.id}</td>
                            <td>${poste.nom}</td>
                            <td>${poste.prenom}</td>
                            <td>${poste.datepost}</td>
                            <td><a href="<%=MeggaController.AppContext+MeggaController.Download%>?fileName=${poste.cv}">CV</a></td>
                             <td><a href="<%=MeggaController.AppContext+MeggaController.Download%>?fileName=${poste.lettre}">Lettre</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </main>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
<script src="${pageContext.request.contextPath}/Resources/lib/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</html>
