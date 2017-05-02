<%@ page import="java.util.List" %>
<%@ page import="com.messageboard.dean.Message" %>
<%@ page import="com.messageboard.factory.MessageBoardDAOFactory" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: nicholas
  Date: 17-4-18
  Time: 上午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List messages = null;
    try {
        messages = MessageBoardDAOFactory.getMessageBoardInstance().findAll();
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>Message Board</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            width: auto;
            height: auto;
        }

        html, body {
            width: 100%;
            display: flex;
            justify-content: center;
        }

        .flex {
            display: flex;
        }

        .flex-column {
            flex-direction: column;
        }

        .container {
            height: 100%;
            width: 70%;
            justify-content: space-around;
            align-items: stretch;
        }

        .message-board {
            flex: 2;
        }

        .messages {
            height: 100vh;
            width: 100%;
            list-style: none;
            overflow: auto;
        }

        .message {
            padding: 0.5em;
        }

        .title > small {
            font-weight: normal;
        }

        .text {
            text-indent: 2em;
        }

        .time {
            text-align: right;
            color: darkgrey;
        }

        input, textarea {
            border: solid 1px darkgrey;
            border-radius: 3px;
            padding: 5px 5px 5px 20px;
        }

        .form {
            flex: 1;
            width: 100%;
            padding: 20px;
        }

        .form-group {
            margin: 1em 0;
        }

        .title {
            margin-right: 0.5em;
            width: 60%;
        }

        .from {
            width: 34%;
        }

        .text-input {
            min-height: 150px;
            width: 95%;
            margin-top: 4em;
            justify-content: flex-start;
        }

        .error {
            color: brown;
        }

        button {
            padding: 0.2em 0.5em;
        }
    </style>
</head>
<body>
<div class="container flex flex-column">
    <ul class="message-board messages flex flex-column">
        <%
            Iterator<Message> iterator = messages.iterator();
            Message message;
            while (iterator.hasNext()) {
                message = iterator.next();
        %>
        <li class="message">
            <h3 class="title"><%=message.getTitle()%>
                <small><%=message.getFrom()%>
                </small>
            </h3>
            <p class="text">
                <%=message.getMessage()%>
            </p>
            <p class="time">
                <%=message.getTime()%>
            </p>
        </li>
        <%
            }
        %>
    </ul>
    <form action="/board" method="post" class="form flex flex-column">
        <div class="form-group flex">
            <div class="title flex flex-column">
                <label for="title">主题:</label>
                <input type="text" name="title" id="title" value="${param.title}">
                <p class="error">${requestScope.err_title}</p>
            </div>
            <div class="from flex flex-column">
                <label for="from">发布人:</label>
                <input type="text" name="from" id="from" value="${param.from}">
                <p class="error">${requestScope.err_from}</p>
            </div>
        </div>
        <div class="form-group text-input flex flex-column"><label for="text">留言:</label>
            <textarea name="message" id="text" cols="15" rows="10">${param.message}</textarea>
            <p class="error">${requestScope.err_message}</p>
        </div>
        <div>
            <button type="submit">提交</button>
            <button type="reset">清空</button>
        </div>
    </form>
</div>

</body>
</html>
