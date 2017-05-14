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
    <h2>欢迎 <s:property value="instructor.name"/></h2>
    <div class="col-sm-12">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>课程名称</th>
                <th>课程时间</th>
                <th>课程地点</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="instructor.coursesEntities" status="i">
                <s:iterator value="timeAndLocation" status="j">
                    <tr>
                        <s:if test="#j.index == 0">
                            <td rowspan="<s:property value="timeAndLocation.size"/>"><s:property
                                    value="%{#i.index + 1}"/></td>
                            <td rowspan="<s:property value="timeAndLocation.size"/>">
                                <s:url namespace="/course" action="index" var="courseIndex">
                                    <s:param name="id" value="uuid"/>
                                </s:url>
                                <s:a href="%{courseIndex}">
                                    <s:property value="name"/>
                                </s:a>
                            </td>
                        </s:if>
                        <td><s:property value="key"/></td>
                        <td><s:property value="value"/></td>
                    </tr>
                </s:iterator>
            </s:iterator>
            <tr>
                <td colspan="4" align="center">
                    <s:a namespace="/course" action="create"> <i class="glyphicon glyphicon-plus"></i> </s:a>
                </td>
            </tr>
            </tbody>
        </table>
        <s:debug/>
    </div>
</div>
</body>
</html>