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
    
	<section id="id-pedido">
		<div class="jumbotron">
			<h3>
				<a href="${s:mvcUrl('UC#cadastrar').build() }" rel="nofollow"><fmt:message key="usuario.novo"/></a>
			</h3>
			
			<h3><fmt:message key="usuario.lista"/></h3>
		
			<c:if test="${not empty message}">
				<div class="alert alert-secondary" role="alert">
				  ${message}
				</div>
			</c:if>
			<c:if test="${not empty messageError}">
				<div class="alert alert-danger" role="alert">
				  ${messageError}
				</div>
			</c:if>
		
			<table class="table table-bordered table-striped table-hover" style="with: 450px !important;">
				<tr>
					<th width="20%"><fmt:message key="usuario.nome"/></th>
					<th width="50%"><fmt:message key="usuario.email"/></th>
					<th width="60%"><fmt:message key="usuario.regras"/></th>
					<th width="10%"></th>
				</tr>
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td>${usuario.email }</td>
						<td>${usuario.stringRegras }</td>
						<td>
							<form:form action="${s:mvcUrl('UC#rolesForm').arg(0, usuario.email).build() }" method="POST">
								<input type="image" src="${contextPath }resources/imagens/adicionar.png" 
								alt="Adicionar Role" title="Adicionar Role" />
							</form:form>	
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	
</tags:pageTemplate>