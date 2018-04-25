<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>头条简讯</title>
    <link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/styles/font-awesome.min.css">
    <link rel="stylesheet" media="all" href="/styles/style.css">

    <script type="text/javascript" src="/scripts/jquery.js"></script>
    <script type="text/javascript" src="/scripts/main/base/base.js"></script>
    <script type="text/javascript" src="/scripts/main/base/util.js"></script>
    <script type="text/javascript" src="/scripts/main/base/event.js"></script>
    <script type="text/javascript" src="/scripts/main/base/upload.js"></script>
    <script type="text/javascript" src="/scripts/main/component/component.js"></script>
    <script type="text/javascript" src="/scripts/main/component/popup.js"></script>
    <script type="text/javascript" src="/scripts/main/component/popupLogin.js"></script>
    <script type="text/javascript" src="/scripts/main/component/upload.js"></script>
    <script type="text/javascript" src="/scripts/main/component/popupUpload.js"></script>
    <script type="text/javascript" src="/scripts/main/util/action.js"></script>
    <script type="text/javascript" src="/scripts/main/site/home.js"></script>
</head>

<body class="welcome_index">
<header class="navbar navbar-default navbar-static-top bs-docs-nav" id="top" role="banner">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand logo">
                <h1>头条简讯</h1>
                <h3>你关心的才是头条</h3>
            </a>
        </div>

        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">

            <ul class="nav navbar-nav navbar-right">
            <#if user??><li class=""><a href="/user/detail/${user.id}">${user.username}</a></li></#if>
            <#if user??><li class="js-share"><a href="javascript:void(0);">分享</a></li></#if>
            <#if user??><li class=""><a href="/message/conversation">站内信</a></li></#if>
            <#if user??><li class="js-logout"><a href="javascript:void(0);">注销</a></li></#if>
            <#if !user??><li class="js-login"><a href="javascript:void(0);">登陆</a></li></#if>
            </ul>

        </nav>
    </div>
</header>