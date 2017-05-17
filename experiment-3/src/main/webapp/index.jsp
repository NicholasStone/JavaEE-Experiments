<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <s:head/>
    <style>
        * {
            margin: 0;
        }

        html, body {
            height: 100vh;
            width: 100vw;
        }

        fieldset {
            margin: 20vh 42vw 0;
            padding: 10px;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>登录</legend>
    <s:form namespace="/" action="auth" method="POST">
        <s:textfield name="username" label="用户名" id="username" type="username"/>
        <s:textfield name="password" label="密码" id="password" type="password"/>
        <s:submit/>
    </s:form>
</fieldset>
</body>
</html>
