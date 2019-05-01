<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout title="Homepage">
    <jsp:body>
        <div class="row">
            <div class="col">
            </div>
            <div class="col-8">
                <div class="alert alert-primary project-list-header" role="alert" >
                    <span class="header-text">Project List!</span>
                    <span class="header-button">
                        <button onclick="location.href='/projetos/criar'" type="button" class="btn btn-success btn-sm"> Novo Projeto </button>
                    </span>
                </div>
                <c:forEach items="${projetos}" var="projeto" varStatus="status">
                    <t:projeto projeto="${projeto}"/>
                </c:forEach>
            </div>
            <div class="col">
            </div>
        </div>
    </jsp:body>
</t:layout>