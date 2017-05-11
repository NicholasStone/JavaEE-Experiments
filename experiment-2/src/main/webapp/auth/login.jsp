<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  Auth: nicholas
  Date: 5/10/17
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <h1>登录</h1>
    <form action="<s:url namespace="/auth" action="auth"/>" method="post"
          class="col-md-4 col-md-offset-4 form-group form-horizontal">
        <div class="form-group form-inline">
            <div class="col-sm-3">
                <label for="username">用户名</label>
            </div>
            <s:textfield name="username" class="form-control col-sm-9" id="username" type="text"/>
        </div>
        <div class="form-group form-inline">
            <div class="col-sm-3">
                <label for="password">密码</label>
            </div>
            <s:textfield name="password" class="form-control col-sm-9" id="password" type="password"/>
        </div>
        <div class="form-group form-inline">
            <div class="col-sm-3">身份:</div>
            <div class="col-sm-9">
                <label>
                    <s:textfield name="identity" class="radio" type="radio" value="teacher"/> 教师
                </label>
                <label>
                    <s:textfield name="identity" class="radio" type="radio" value="student"/> 学生
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn">登录</button>
    </form>
    <div class="row">
        <div class="col-sm-12 panel panel-default">
            <div class="panel-body">
                <s:debug/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
