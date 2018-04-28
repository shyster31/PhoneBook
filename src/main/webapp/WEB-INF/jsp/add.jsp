<jsp:include page="header.jsp">
    <jsp:param name="user" value="${user}"/>
    <jsp:param name="title" value="Add Page"/>
</jsp:include>

<div class="container" id='content'>

    <form action="/PhoneBook/add" method="POST">
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
            <span>Phone</span>
            <input required name="phone">
        </div>
        <div class="formField">
            <span>Home phone</span>
            <input name="homePhone">
        </div>
        <div class="formField">
            <span>Email</span>
            <input name="email">
        </div>
        <div class="formField">
            <span>Adress</span>
            <input name="adress">
        </div>

        <input class="buttonStyle formButton" type="submit" value="ADD">
    </form>
</div>	

<jsp:include page="footer.jsp"></jsp:include> 