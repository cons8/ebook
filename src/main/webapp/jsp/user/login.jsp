<%--
  Created by IntelliJ IDEA.
  User: 15262
  Date: 2025/5/18
  Time: 下午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户登录 - Ebook电子书阅读系统</title>
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
    <style>
        .login-container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #dee2e6;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .error-message {
            color: #dc3545;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-container">
        <h2 class="text-center mb-4">用户登录</h2>
        <!-- 错误提示 -->
        <c:if test="${not empty requestScope.loginError}">
            <div class="alert alert-danger">${requestScope.loginError}</div>
        </c:if>

        <!-- 登录表单 -->
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">用户名</label>
                <input type="text"
                       class="form-control"
                       id="username"
                       name="username"
                       required
                       autofocus>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">密码</label>
                <input type="password"
                       class="form-control"
                       id="password"
                       name="password"
                       required>
            </div>

            <button type="submit" class="btn btn-primary w-100">登录</button>
        </form>

        <div class="text-center mt-3">
            <a href="register.jsp" class="text-muted">没有账号？立即注册</a>
        </div>
    </div>
</div>

<script src="<c:url value="/static/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>
