<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录成功</title>
</head>
<body>
<h1>
    欢迎 <s:property value="#session.Auth.username"/>
</h1>
</body>
</html>