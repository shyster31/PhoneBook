<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="user" value="${user}"/>
    <jsp:param name="title" value="Authenticate Page"/>
</jsp:include>

<div class="container" id='content'>
    <form action="/PhoneBook/authenticate" method="POST">
        <div class="formField">
            <span>Login</span>
            <input name="login" required>
        </div>

        <div class="formField">
            <span>Password</span>
            <input type="password" name="password" required>
        </div>

        <input class="buttonStyle formButton" type="submit" value="SIGN IN">
    </form>
    <a href="/PhoneBook/registration" class="buttonStyle registerButton">SIGN UP</a>
</div>	

<jsp:include page="footer.jsp"></jsp:include> 