<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ebook电子书在线阅读系统</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/css/custom.css"/>" rel="stylesheet">
    <!-- 自定义样式 -->
    <style>


        /* 自定义导航栏样式 */
        .navbar-custom {
            background-color: #ffffff !important; /* 白色背景 */
            border-bottom: 1px solid #dee2e6; /* 底部边框 */
        }

        /* 导航栏文字颜色 */
        .navbar-custom .navbar-brand,
        .navbar-custom .nav-link,
        .navbar-custom .dropdown-item {
            color: #000000 !important; /* 黑色文字 */
        }

        /* 鼠标悬停效果 */
        .navbar-custom .nav-link:hover,
        .navbar-custom .dropdown-item:hover {
            color: #343a40 !important; /* 深灰色悬停 */
        }

        /* 搜索框样式 */
        .search-form {
            margin-left: auto;
            max-height: 40px;
            min-width: 300px;  /* 确保容器最小宽度 */
        }

        .search-input {
            height: 38px;
            padding: 0.375rem 0.75rem;
            line-height: 1.5;
            border-radius: 4px 0 0 4px;
        }

        .book-card {
            transition: transform 0.3s;
            height: 100%;
        }
        .book-card:hover {
            transform: translateY(-5px);
        }

        .navbar-brand {
            font-weight: bold;
        }
        .footer {
            margin-top: 50px;
            padding: 20px 0;
            background-color: #f8f9fa;
        }

        /* 响应式调整 */
        @media (max-width: 768px) {
            .search-form {
                flex-direction: column;
                align-items: stretch;
            }

            .search-btn {
                width: 100%;
                border-radius: 4px;
            }
        }
    </style>
</head>
<body>

<!-- 导航栏 -->
<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container">
        <a class="navbar-brand" href="#">Ebook电子书阅读系统</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">首页</a>
                </li>
                <c:if test="${sessionScope.user.role eq 'admin'}">
                    <li class="nav-item">
                        <a class="nav-link" href="admin/upload.jsp">上传书籍</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin/bookList.jsp">管理书籍</a>
                    </li>
                </c:if>
            </ul>

            <!-- 搜索表单 -->
            <form class="d-flex search-form" action="search" method="get">
                <input class="form-control me-2 search-input"
                       type="search"
                       placeholder="搜索书籍"
                       name="keyword">
                <button class="btn btn-outline-primary search-btn"
                        type="submit">
                    搜索
                </button>
            </form>
            <!-- 用户菜单 -->
            <div class="ms-3">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <!-- 已登录状态 -->
                        <div class="dropdown">
                            <button class="btn btn-outline-primary dropdown-toggle"
                                    type="button"
                                    id="dropdownUser"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                    ${sessionScope.user.username} (${sessionScope.user.role})
                            </button>
                            <ul class="dropdown-menu dropdown-menu-end"
                                aria-labelledby="dropdownUser">
                                <li><a class="dropdown-item" href="logout">退出登录</a></li>
                            </ul>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <!-- 未登录状态 -->
                        <a href="/jsp/user/login.jsp" class="btn btn-outline-primary">登录/注册</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</nav>

<!-- 主体内容 -->
<div class="container my-4">
    <div class="row mb-4">
        <div class="col-12">
            <div class="d-flex justify-content-between align-items-center">
                <h2>最新书籍</h2>
                <a href="browseAll" class="btn btn-primary">浏览全部</a>
            </div>
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <!-- 书籍卡片循环 -->
                <c:forEach var="book" items="${books.items}">
                    <div class="col">
                        <div class="card book-card h-100">
                            <div class="card-body">
                                <h5 class="card-title">${book.title}</h5>
                                <p class="card-text text-muted">作者：${book.author}</p>
                                <p class="card-text">${book.description.substring(0, 10)}...</p>
                            </div>
                            <div class="card-footer bg-transparent">
                                <a href="book?id=${book.bookId}"
                                   class="btn btn-sm btn-outline-primary">看看</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <!-- 热门书籍区块 -->
    <div class="row mb-4">
        <div class="col-12">
            <div class="d-flex justify-content-between align-items-center">
                <h2>热门书籍</h2>
            </div>
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <!-- 相似书籍卡片结构 -->
            </div>
        </div>
    </div>
</div>

<!-- 页脚 -->
<footer class="footer">
    <div class="container text-center">
        <p>© 2025 Ebook电子书阅读系统 | 陈志航版权所有</p>
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="<c:url value="/static/js/bootstrap.bundle.min.js"/>"></script>
<script></script>
</body>
</html>