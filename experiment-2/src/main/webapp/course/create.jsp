<!doctype html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Struts</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <s:head/>
</head>
<body>
<div class="container">
    <div class="row">
        <h2 class="col-sm-12" style="padding-top: 50px"> 添加课程 </h2>
    </div>
    <s:actionerror/>
    <div class="row">
        <form action="<s:url namespace="/course" action="store"/>" method="POST"
              class="col-sm-12 form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">课程名</label>
                <div class="col-sm-10">
                    <s:textfield name="name" class="form-control" id="name" type="text"/>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">提交</button>
        </form>
    </div>
</div>
<s:debug/>
</body>
</html>