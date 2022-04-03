<%@ page import="java.util.List" %>
<%@ page import="ma.fstm.ilisi.recrutement.controller.MeggaController" %>
<%@ page import="ma.fstm.ilisi.recrutement.model.servise.LoginProc" %>
<%@ page import="ma.fstm.ilisi.recrutement.model.dao.DAOoffer" %>
<%@ page import="ma.fstm.ilisi.recrutement.model.bo.Offer" %>
<%@ page import="ma.fstm.ilisi.recrutement.model.bo.Postulation" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    DAOoffer daOoffer=DAOoffer.getInstance();
    int id = (int) request.getAttribute("id");
    Offer of=daOoffer.findByid(id);
    Set<Postulation> post = of.getPostulations();
    request.setAttribute("posts",post);

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Comment</title>
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
                    <th>Profile</th>
                    <th>Description</th>
                    <th>Type</th>
                    <th>Delete</th>
                    <th>Update</th>
                    <th>Offers</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.posts}" var="poste">
                        <tr>
                            <td>${poste.id}</td>
                            <td>${poste.datepost}</td>
                            <td>${poste.nom}</td>
                            <td>${poste.prenom}</td>
                            <td>${poste.nom}</td>
                             <td>${poste.prenom}</td>
                            <td><a href="<%=MeggaController.AppContext+MeggaController.Offers%>.do">Delete</a></td>

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
