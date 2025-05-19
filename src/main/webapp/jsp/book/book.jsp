<%--
  Created by IntelliJ IDEA.
  User: 15262
  Date: 2025/5/19
  Time: 下午4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${book.title} - Ebook电子书阅读系统</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/css/custom.css"/>" rel="stylesheet">
    <!-- 自定义样式 -->
    <style>
        /* 详情页专属样式 */
        .book-detail {
            background: white;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            padding: 30px;
            margin-bottom: 30px;
        }

        .book-cover {
            height: 400px;
            object-fit: cover;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }

        .book-meta {
            color: #6c757d;
            margin-bottom: 20px;
        }

        .chapter-list {
            max-height: 400px;
            overflow-y: auto;
            border-left: 2px solid #dee2e6;
            padding-left: 15px;
        }

        .comment-item {
            border-bottom: 1px solid #dee2e6;
            padding: 15px 0;
        }

        @media (max-width: 768px) {
            .book-cover {
                height: 300px;
            }
        }
    </style>
</head>
<body>

<!-- 统一导航栏 -->
<nav class="navbar navbar-expand-lg navbar-custom">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Ebook电子书阅读系统</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index">← 返回首页</a>
                </li>
            </ul>

            <!-- 统一搜索表单 -->
            <form class="d-flex search-form" action="search" method="get">
                <input class="form-control me-2 search-input" type="search" placeholder="搜索书籍" name="keyword">
                <button class="btn btn-outline-primary search-btn" type="submit">搜索</button>
            </form>

            <!-- 统一用户菜单 -->
            <div class="dropdown ms-3">
                <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownUser" data-bs-toggle="dropdown">
                    ${sessionScope.user.username} (${sessionScope.user.role})
                </button>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownUser">
                    <li><a class="dropdown-item" href="logout">退出登录</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<!-- 主体内容 -->
<div class="container my-4">
    <!-- 书籍详情主体 -->
    <div class="book-detail row">
        <!-- 封面区域 -->
        <div class="col-md-4">
            <img src="${book.coverImage}" alt="${book.title}" class="book-cover img-fluid rounded">
        </div>

        <!-- 信息区域 -->
        <div class="col-md-8">
            <h1 class="mb-3">${book.title}</h1>

            <div class="book-meta mb-4">
                <p><strong>作者：</strong>${book.author}</p>
                <p><strong>分类：</strong>${book.categoryId}</p>
<%--                <p><strong>评分：</strong>--%>
<%--                    <span class="badge bg-warning text-dark">${book.rating}/5.0</span>--%>
<%--                    <span class="text-muted ms-2">(${book.reviewCount}人评价)</span>--%>
<%--                </p>--%>
            </div>

            <div class="book-summary mb-5">
                <h5>内容简介</h5>
                <p>${book.description}</p>
            </div>

            <!-- 操作按钮 -->
            <div class="d-flex gap-2 mb-5">
                <a href="#" class="btn btn-primary btn-lg">开始阅读</a>
                <a href="#" class="btn btn-outline-secondary btn-lg">加入书架</a>
            </div>
        </div>
    </div>

    <!-- 目录和评论 -->
    <div class="row mt-5">
        <!-- 目录 -->
<%--        <div class="col-md-8">--%>
<%--            <h3>目录</h3>--%>
<%--            <div class="chapter-list">--%>
<%--                <c:forEach var="chapter" items="${book.chapters}">--%>
<%--                    <div class="chapter-item">--%>
<%--                        <h5>${chapter.order}. ${chapter.title}</h5>--%>
<%--                        <p class="text-muted small">${chapter.summary}</p>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>

        <!-- 评论 -->
<%--        <div class="col-md-4">--%>
<%--            <div class="card">--%>
<%--                <div class="card-header bg-light">--%>
<%--                    <h5 class="mb-0">读者评论 (${book.reviewCount})</h5>--%>
<%--                </div>--%>
<%--                <div class="card-body">--%>
<%--                    <div class="comments-section">--%>
<%--                        <c:forEach var="comment" items="${book.reviews}">--%>
<%--                            <div class="comment-item">--%>
<%--                                <div class="d-flex justify-content-between">--%>
<%--                                    <h6>${comment.username}</h6>--%>
<%--                                    <small>${comment.createTime}</small>--%>
<%--                                </div>--%>
<%--                                <p>${comment.content}</p>--%>
<%--                                <div class="stars">--%>
<%--                                        ${comment.rating}/5.0--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
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
</body>
</html>
