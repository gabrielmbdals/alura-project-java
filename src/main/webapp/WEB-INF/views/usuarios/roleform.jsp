<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
	
	<c:url value="/resources/css" var="cssPath" />
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
    <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
    
	<section id="id-form-usuario">
		<div class="container">
	        <h2><fmt:message key="usuario.cadastro.permissoes.para"/> ${usuario.nome}</h2>
	        
	        <form:form action="${s:mvcUrl('UC#adicionarRole').build() }" commandName="usuario" method="post" class="form-group">
	        	<input type="hidden" name ="email" value = "${usuario.email}"/>
	        	<fmt:message key="roles.permissoes"/> <form:checkboxes items="${allRoles}" path="roles" itemLabel="regra" itemValue="regra"/> 
	        	<button type="submit" class="btn btn-primary" style="width: 100px;">Atualizar</button>
	        </form:form>
	    </div>
	</section>
	
</tags:pageTemplate>