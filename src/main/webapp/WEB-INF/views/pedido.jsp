<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">

	<section id="id-pedido">
		<c:if test="${not empty pedidos }">
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th><fmt:message key="pedido.id"/></th>
					<th><fmt:message key="pedido.valor"/></th>
					<th><fmt:message key="pedido.data"/></th> 
					<th><fmt:message key="pedido.titulos"/></th>
				</tr>
				<c:forEach items="${pedidos }" var="pedido">
					<tr>
						<td>${pedido.id }</td>
						<td>${pedido.valor }</td>
						<td>${pedido.dataPedido }</td>
						<td>${pedido.titulos }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</section>
	
</tags:pageTemplate>