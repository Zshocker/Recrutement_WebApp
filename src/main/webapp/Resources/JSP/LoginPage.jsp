<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="Resources/lib/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container">
                <a class="navbar-brand" href="./">First</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" >Privacy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/User/Comment" >Comment</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="container">
        <main role="main" class="pb-3">
            <div class="col-md-4">
                <form method="post">
                    <input type="text" name="login" placeholder="Login" class="form-control" required/><br>
                    <input type="password" name="pass" placeholder="password" class="form-control"required /><br />
                    <input type="submit" value="Login" class="btn btn-primary" />
                </form>
            </div>
        </main>
    </div>

    <footer class="border-top footer text-muted">
        <div class="container">
            &copy; 2022 - Test - <a >Privacy</a>
        </div>
    </footer>

    <script src="Resources/lib/jquery/dist/jquery.min.js"></script>
    <script src="Resources/lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
