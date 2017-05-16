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
    <s:if test="#session.Auth.identity == 'student'">
        <s:set var="selectable" value="1"/>
    </s:if>
    <h2>欢迎 <s:property value="%{session.Auth.name}"/></h2>
    <s:if test="hasActionMessages()">
        <div class="alert alert-success" role="alert">
            <s:actionmessage/>
        </div>
    </s:if>
    <form action="<s:url namespace="/course" action="select"/>" id="selected" method="post">
        <div class="panel panel-default">
            <div class="panel-heading">
                <p class="panel-title">课程列表</p>
                <button class="btn btn-primary pull-right">提交</button>
                <button class="btn btn-default pull-right">重置</button>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <s:if test="#selectable == 1">
                        <th>选择</th>
                    </s:if>
                    <th>#</th>
                    <th>课程名称</th>
                    <th>代课老师</th>
                    <th>上课时间</th>
                    <th>上课地点</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="courses" status="i">
                    <s:iterator value="timeAndLocation" status="j">
                        <tr>
                            <s:if test="#j.index == 0">
                                <s:set var="rowspan" value="timeAndLocation.size"/>
                                <s:if test="#selectable == 1">
                                    <td rowspan="<s:property value='rowspan'/>">
                                        <div class="checkbox">
                                            <label>
                                                <input class="checkbox" type="checkbox" name="selected"
                                                       value="<s:property value='uuid'/>">
                                            </label>
                                        </div>
                                    </td>
                                </s:if>
                                <td rowspan="<s:property value='rowspan'/>">
                                    <s:property value="%{#i.index + 1}"/>
                                </td>
                                <td rowspan="<s:property value='rowspan'/>">
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
                </tbody>
            </table>
        </div>
    </form>
    <s:debug/>
</div>
</body>
</html>