<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
	
	<c:url value="/resources/css" var="cssPath" />
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
    <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
    
	<section id="id-form-usuario">
		<div class="container">
	        <h1>Cadastro de Usuário</h1>
	        <h3>${message }</h3>
	        <form:form action="${s:mvcUrl('UC#form').build() }" method="post" commandName="usuarioDTO" class="form-group">
	            <div class="form-group">
	                <label><fmt:message key="usuario.nome"/></label>
	                <input type="text" name="nome" class="form-control" style="width: 250px;"/>
	                <form:errors path="nome" />
	            </div>
	            <div class="form-group">
	                <label><fmt:message key="usuario.email"/></label>
	                <input type="text" name="email" class="form-control" style="width: 250px;"/>
	                <form:errors path="email" />
	            </div>
	            <div class="form-group">
	                <label><fmt:message key="usuario.password"/></label>
	                <input type="password" name="password" class="form-control" style="width: 250px;"/>
	                <form:errors path="password" />
	            </div>
	            <div class="form-group">
	                <label><fmt:message key="usuario.repassword"/></label>
	                <input type="password" name="repassword" class="form-control" style="width: 250px;"/>
	                <form:errors path="repassword" />
	            </div>
	            <button type="submit" class="btn btn-primary">Cadastrar</button>
	        </form:form>
	    </div>
	</section>
	
</tags:pageTemplate>