<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>头条资讯 - 牛客网</title>
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
                  <h3>头条资讯</h3>
            </div>

            <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">

                <ul class="nav navbar-nav navbar-right">
                    <#if user??><li class=""><a href="/explore">${user.username}</a></li></#if>
                    <#if user??><li class=""><a href="/explore">分享</a></li></#if>
                    <#if user??><li class=""><a href="/signin">站内信</a></li></#if>
                    <#if user??><li class="js-logout"><a href="javascript:void(0);">注销</a></li></#if>
                    <#if !user??><li class="js-login"><a href="javascript:void(0);">登陆</a></li></#if>
                </ul>

            </nav>
        </div>
    </header>

    <div id="main">

        <div class="container" id="daily">
            <div class="jscroll-inner">
                <div class="daily">
                </div>
                <h3 class="date">
                    <i class="fa icon-calendar"></i>
                    <span>头条资讯 &nbsp; 1996-3-9</span>
                </h3>
                <div class="post">
                    <div class="post">
                        <div class="votebar">
                            <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">123</span></button>
                            <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                            </button>
                        </div>
                        <div class="content" data-url="http://nowcoder.com/u/251205">
                            <div >
                                <img class="content-img" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x" alt="">
                            </div>
                            <div class="content-main">
                                <h3 class="title">
                                    <a target="_blank" rel="external nofollow" href="http://nowcoder.com/u/251205">震惊！几个教师轮番对小女孩布置作业</a>
                                </h3>
                                <div class="meta">
                                    http://nowcoder.com/u/251205
                                    <span>
                                        <i class="fa icon-comment"></i> 123
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="user-info">
                            <div class="user-avatar">
                                <a href="/user/123456/"><img width="32" class="img-circle" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x"></a>
                            </div>
                        </div>

                        <div class="subject-name">来自 <a href="/user/123456/">王子峰</a></div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <footer>
        <div class="container">
            <p class="text-center">© 2017-2020 头条八卦</p>
        </div>
    </footer>


</body>
</html>