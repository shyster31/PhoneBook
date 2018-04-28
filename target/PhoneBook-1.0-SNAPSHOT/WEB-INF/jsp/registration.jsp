<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="user" value="${user}"/>
    <jsp:param name="title" value="Registration Page"/>
</jsp:include>

<div class="container" id='content'>

    <form action="/PhoneBook/registration" method="POST">
        <div class="formField">
            <span>First name</span>
            <input required name="firstName">
        </div>
        <div class="formField">
            <span>Last name</span>
            <input required name="lastName">
        </div>
        <div class="formField">
            <span>Patronymic</span>
            <input required name="patronymic">
        </div>
        <div class="formField">
            <span>Login</span>
            <input required name="login">
        </div>
        <div class="formField">
            <span>Password</span>
            <input type="password" required name="password1">
        </div>
        <div class="formField">
            <span>Confirm Password</span>
            <input type="password" required name="password2">
        </div>


        <input class="buttonStyle formButton" type="submit" value="SIGN UP">
    </form>
</div>	

<jsp:include page="footer.jsp"></jsp:include> 