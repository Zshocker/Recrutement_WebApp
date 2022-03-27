<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Postulate</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
    <main role="main" class="pb-3">
        <div class="col-md-4">
            <form method="post" enctype="multipart/form-data" >
                <input type="text" name="nom" placeholder="nom" class="form-control" required/><br>
                <input type="text" name="prenom" placeholder="prenom" class="form-control" required /><br />
                <input type="text" name="email" placeholder="Email" class="form-control" required /><br />
                <div class="mb-3">
                    <label for="CV" class="form-label">CV</label>
                    <input id="CV" type="file" name="cv" placeholder="CV" class="form-control" required/><br>
                </div>
                <div class="mb-3">
                    <label for="letter" class="form-label">Lettre de motivation</label>
                    <input id="letter" type="file" name="letter" class="form-control" /><br>
                </div>
                <input type="submit" value="postuler" class="btn btn-primary" />
            </form>
        </div>
    </main>
</div>
<jsp:include page="footer.jsp"/>

<script src="${pageContext.request.contextPath}/Resources/lib/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
