<%@ page import="java.util.List" %>
<%@ page import="ma.fstm.ilisi.recrutement.model.dao.DAOoffer" %>
<%@ page import="ma.fstm.ilisi.recrutement.controller.MeggaController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    DAOoffer daOoffer=DAOoffer.getInstance();
    request.setAttribute("offers",daOoffer.Retrieve());
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
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.offers}" var="offer">
                        <tr>
                            <td>${offer.id}</td>
                            <td>${offer.profile}</td>
                            <td>${offer.description}</td>
                            <td>${offer.type.type}</td>
                            <td><a href="<%=MeggaController.AppContext+MeggaController.DeleteP%>/${offer.id}.do">delete</a></td>
                            <td><a href="<%=MeggaController.AppContext+MeggaController.UpdateP%>/${offer.id}.do">Update</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                    <input type="submit" value="Add to cart" class="btn btn-primary" />
                </form>
            </div>
        </main>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
<script src="${pageContext.request.contextPath}/Resources/lib/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</html>
