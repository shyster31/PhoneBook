<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp">
    <jsp:param name="user" value="${user}"/>
    <jsp:param name="title" value="Contact Book"/>
</jsp:include>

<div class="container contactConteiner" id='content'>
    <c:if test="${items!=null}">
        <c:forEach items="${items}" var="item">
            <div class="contentFormField">

                <div class="userInfo">
                    <span class="userData">name: ${item.firstName} ${item.lastName} ${item.patronymic}</span>
                    <span class="userData">phone: ${item.phone},  ${item.homePhone}</span>
                    <span class="userData">email: ${item.email}</span>
                    <span class="userData">adress: ${item.adress}</span>
                </div>

                <div class="toolsButton">
                    <a href="/PhoneBook/edit?id=${item.id}"><input class="buttonStyle formButton" type="submit" value="EDIT"></a>
                    <a href="/PhoneBook/delete?id=${item.id}"><input class="buttonStyle formButton" type="submit" value="DELETE"></a>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <div class="toolsButton">
        <a href="/PhoneBook/add"><input class="buttonStyle formButton" type="submit" value="ADD"></a>
    </div>


</div>
<jsp:include page="footer.jsp"></jsp:include> 
