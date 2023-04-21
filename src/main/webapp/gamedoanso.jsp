<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Trò chơi đoán số</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="row mt-5">
    <div class="col-md-6 m-auto mt-5">
      <h3 class="text-center text-uppercase">trò chơi đoán số</h3>
      <div class="p-4 border mt-4">
        <% String contextPath = request.getContextPath(); %>
        <form action="<%=contextPath%>/doanso" method="post">
          <div class="form-group">
            <label>Tên người chơi</label>
            <%-- name phải trùng với parameter mới lấy được giá trị--%>
            <input type="text" class="form-control" name="tenNguoiChoi">
          </div>
          <div class="form-group">
            <label>Số đoán</label>
            <input type="number" class="form-control" name="soDoan">
          </div>
          <button type="submit" class="btn btn-primary">Lưu lại</button>
        </form>
      </div>
      <div class="mt-4">
        <table class="table table-bordered">
          <thead>
          <th scope="col">Tên người chơi</th>
          <th scope="col">Số lần đoán</th>
          <th scope="col">Số đoán đúng</th>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="nguoiChoi">
            <tr>
              <td>${nguoiChoi.tenNguoiChoi}</td>
              <td>${nguoiChoi.soLanDoan}</td>
              <td>${nguoiChoi.soDoan}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="alert"><p>${message}</p></div>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
