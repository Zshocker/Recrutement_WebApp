<%@ page import="ma.fstm.ilisi.recrutement.model.servise.LoginProc" %>
<%@ page import="ma.fstm.ilisi.recrutement.controller.MeggaController" %>
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
                        <a class="nav-link text-dark" href="<%=MeggaController.AppContext+MeggaController.OffersU%>" >Home</a>
                    </li>
                    <% if(new LoginProc().verifieAuth(request)){ %>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="<%=MeggaController.AppContext+MeggaController.CreateP%>">Create an Offer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="<%=MeggaController.AppContext+MeggaController.LogoutT%>" >Logout</a>
                    </li>
                    <% }else{ %>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="<%=MeggaController.AppContext+MeggaController.LoginT%>" >Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="<%=MeggaController.AppContext+MeggaController.Inscrip%>" >Inscription</a>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>
    </nav>
</header>
