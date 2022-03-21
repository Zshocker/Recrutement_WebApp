<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <main role="main" class="pb-3">
            <div class="col-md-4">
                <form method="post">
                    <input type="text" name="login" placeholder="Login" class="form-control" required/><br>
                    <input type="password" name="pass" placeholder="password" class="form-control"required /><br />
                    <input type="text" name="name" placeholder="Name" class="form-control" required/><br>
                    <input type="text" name="email" placeholder="Email" class="form-control" required/><br>

                    <input type="submit" value="Inscrit" class="btn btn-primary" />
                </form>
            </div>
        </main>
    </div>
    <jsp:include page="footer.jsp"/>

    <script src="${pageContext.request.contextPath}/Resources/lib/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
