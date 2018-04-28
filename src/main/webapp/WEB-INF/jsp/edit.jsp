<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="user" value="${user}"/>
    <jsp:param name="title" value="Edit Page"/>
</jsp:include>

<div class="container" id='content'>

    <form action="/PhoneBook/edit?id=${item.id}" method="POST">
        <div class="formField">
            <span>First name</span>
            <input required name="firstName" value="${item.firstName}">
        </div>
        <div class="formField">
            <span>Last name</span>
            <input required name="lastName" value="${item.lastName}">
        </div>
        <div class="formField">
            <span>Patronymic</span>
            <input required name="patronymic" value="${item.patronymic}">
        </div>
        <div class="formField">
            <span>Phone</span>
            <input required name="phone" value="${item.phone}">
        </div>
        <div class="formField">
            <span>Home phone</span>
            <input name="homePhone" value="${item.homePhone}">
        </div>
        <div class="formField">
            <span>Email</span>
            <input name="email" value="${item.email}">
        </div>
        <div class="formField">
            <span>Adress</span>
            <input name="adress" value="${item.adress}">
        </div>


        <input class="buttonStyle formButton" type="submit" value="EDIT">
    </form>
</div>	

<jsp:include page="footer.jsp"></jsp:include> 