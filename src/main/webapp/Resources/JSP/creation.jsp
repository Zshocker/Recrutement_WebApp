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

        <div class="row">
            <div class="col-md-4">
                <form method="post">

                    <div class="form-group">
                        <label class="control-label" >Description:</label>
                        <input type="text" class="form-control" name="description" value="John" />

                    </div>
                    <div class="form-group">
                        <label class="control-label" >Profile:</label>
                        <input type="text" class="form-control" name="profile" value="Profile" />

                    </div>
                   
                    <div class="form-group">
                        <input type="radio" id="cdd" name="cdd" value="cdd">
                        <label for="cdd">CDD</label><br>
                        <input type="radio" id="cdi" name="cdi" value="cdi">
                        <label for="cdi">CDI</label><br>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Create" class="btn btn-primary" />
                    </div>
                </form>
            </div>
        </div>

            </main>
</div>
<jsp:include page="footer.jsp"/>
</body>
<script src="${pageContext.request.contextPath}/Resources/lib/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</html>
