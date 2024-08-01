
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
<div class="container">
	<h1>List Products</h1>

	<table>
		<tr>
			<th>S.N.</th>
			<th>Name</th>
			<th>Image</th>
			<th>Price</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="product" items="${products}" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${product.name}</td>
				<td><img src="ImageRetrieve?fileName=${product.image}"
					alt="${product.name}"></td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				<td><a href="edit?id=${product.id}" class="edit-btn">Edit</a> <a
					href="delete?id=${product.id}" class="delete-btn">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="footer.jsp" />
