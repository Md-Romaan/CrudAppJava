<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="base.jsp"%>
</head>
<body>
	<div class="container mt-4">

		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1>Change product details</h1>

				<form action="${pageContext.request.contextPath}/handle-product"
					method="post">
					<div class="form-group">
						<label>Product ID</label> <input type="text" name="id"
							class="form-control" value="${product.id }" readonly>
					</div>

					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" name="name"
							value="${product.name }" aria-describedby="emailHelp"
							placeholder="Enter Product name here">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" name="description" id="description"
							placeholder="Enter Your Desccription about product">${product.description }</textarea>

					</div>

					<div class="form-group">
						<label for="price">Product price</label> <input type="text"
							class="form-control" name="price" value="${product.price }"
							id="price" placeholder="Enter Your price">
					</div>

					<div class="text-center">
						<a href="${pageContext.request.contextPath }/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>


				</form>






			</div>
		</div>







	</div>


</body>
</html>