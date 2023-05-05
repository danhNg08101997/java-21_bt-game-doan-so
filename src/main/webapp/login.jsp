<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
      <div class="p-4 border mt-4">
        <% String contextPath = request.getContextPath(); %>
        <form action="<%=contextPath%>/login" method="post">
          <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" name="email" value="${email}"/>
          </div>
          <div class="form-group">
            <label>Mật khẩu</label>
            <input type="password" class="form-control" name="password" value="${password}"/>
          </div>
          <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="checkboxLoginId" name="checkboxLoginName">
            <label class="form-check-label" for="checkboxLoginId">Ghi nhớ mật khẩu?</label>
          </div>
          <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
