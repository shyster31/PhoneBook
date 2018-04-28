<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${param.title}</title>
    </head>

    <style>
        *{
            margin: 0;
            padding: 0;
        }

        a {
            text-decoration: none;
        }

        body {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            background-color: #f2f2f2;

            height: 100%;
        }


        header{
            width: 100%;
            height: 100px;
            background-color: white;

            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            justify-content: space-between;
            align-items: center;

            border-bottom: 1px solid #9b9c9f;
        }


        .headerTitle {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;

            margin: auto;
            color: #272822;
            font-size: 65px;
            font-family: Tahoma;
            text-transform: uppercase;
        }

        .headerTitle img {
            width: 100px;
            height: 100px;

        }
        .buttonStyle {
            text-decoration: none;
            margin-right: 20px;

            width: 60px;
            height: 40px;
            font-size: 15px;
            font-family: Tahoma;
            border-radius: 5px;
            background-color: #272822;
            color: #fff;
            text-align: center;
            line-height: 38px;
        }


        .container {
            width: 25%;
            height: 50%;
            font-family: Tahoma;
            margin-bottom: 45px;
        }

        .contactConteiner{
            width: 100%;
            margin-bottom: 0;
        }

        .contactConteiner form{
            width: 100%;
        }


        .formField {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            flex-wrap: wrap;
            align-items: center;
            margin-top: 20px;
        }

        .contentFormField {
            width: 100%;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;

            border-bottom: 1px solid #88898a;
            padding-bottom: 10px;
        }

        .userInfo {
            height: 100%;
            width: 25%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: flex-start;

        }

        .userData {
            margin-top: 10px;
        }

        .toolsButton{
            margin-left: 50px;
        }


        .formButton{
            margin: auto;
            width: 100px;
            display: block;
            margin-top: 20px;
        }


        footer {
            height: 40px;
            width: 100%;
            background: #9b9c9f;
            font-family: Tahoma;
            border-top: 1px solid black;

            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .footerAbsolute{
            position: fixed;
            bottom: 0;
        }


        .registerButton {
            display: block;
            margin: 0 auto;
            margin-top: 20px;
            width: 100px;
        }
    </style>

    <body>
        <header>
            <a href="/PhoneBook/main" class="headerTitle">
                <img src="http://i.piccy.info/i9/3b2708e1ff161e43a13a0a424e6d9f45/1524253853/67744/1238229/depositphotos_128185664_stock_illustration_phone_book_pictogram_icon_image.jpg" alt="">
                <span class="headerTitle">
                    Phone book
                </span>
            </a>

            <c:if test = "${user != null}">
                <a href="/PhoneBook/main?exit=true" class="buttonStyle">EXIT</a>
            </c:if>

        </header>