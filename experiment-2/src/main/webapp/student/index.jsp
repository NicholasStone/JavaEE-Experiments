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
    <h2>欢迎 <s:property value="student.name"/></h2>
    <div class="panel panel-default">
        <header class="panel-heading">已选课程</header>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>课程名称</th>
                <th>代课老师</th>
                <th>上课地点</th>
                <th>上课教室</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="courses" status="i">
                <s:iterator value="timeAndLocation" status="j">
                    <tr>
                        <s:if test="#j.index == 0">
                            <s:set var="rowspan" value="timeAndLocation.size"/>
                            <td rowspan="<s:property value="rowspan"/>">
                                <s:property value="%{#i.index + 1}"/></td>
                            <td rowspan="<s:property value="rowspan"/>">
                                <s:url namespace="/course" action="index" var="courseIndex">
                                    <s:param name="id" value="uuid"/>
                                </s:url>
                                <s:a href="%{courseIndex}">
                                    <s:property value="name"/>
                                </s:a>
                            </td>
                            <td rowspan="<s:property value="rowspan"/>">
                                <s:property value="instructor.name"/>
                            </td>
                        </s:if>
                        <td><s:property value="key"/></td>
                        <td><s:property value="value"/></td>
                    </tr>
                </s:iterator>
            </s:iterator>
            <tr>
                <td colspan="5" align="center">
                    <s:a namespace="/course" action="select"> <i class="glyphicon glyphicon-plus"></i> </s:a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<s:debug/>
</body>
</html>