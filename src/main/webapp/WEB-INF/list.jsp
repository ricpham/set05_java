<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>List Employee</h3>


<form method="POST" action="<c:url value="/delete"/>">
    <table class="table" border="1" style="margin-bottom: 8px;">
        <thead>
        <tr>
            <th>Deleted</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="item">
            <tr>
                <td>
                    <input type="checkbox" name="ids" value="${item.id}">
                </td>
                <td>${item.productname}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <div>
        <input type="submit" value="Delete">
    </div>
</form>
</body>
</html>
