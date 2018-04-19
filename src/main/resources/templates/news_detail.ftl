<#include "header.ftl">
<div id="main">
    <div class="container">
        <div class="post detail">

            <div class="votebar">
                <button class="click-like up" data-id="${newsVo.id}" title="赞同"><i class="vote-arrow"></i><span
                        class="count">${newsVo.likeCount}</span></button>
                <button class="click-dislike down" data-id="${newsVo.id}" title="反对"><i class="vote-arrow"></i></button>
            </div>

            <div class="content">
                <div class="content-img">
                    <img class="content-img" src="${newsVo.mainImage}" alt="">
                </div>
                <div class="content-main">
                    <h3 class="title">
                        ${newsVo.title}
                    </h3>
                    <div class="meta">
                        <span>
                                  <i class="fa icon-comment"></i> ${newsVo.commentCount}
                              </span>
                    </div>
                </div>
            </div>
            <div class="user-info">
                <div class="user-avatar">
                    <a href="/user/detail/${newsVo.userId}"><img width="32" class="img-circle"
                                                                 src="${newsVo.headImage}"></a>
                </div>
            </div>

            <div class="subject-name">来自 <a href="/user/detail/${newsVo.userId}">${newsVo.username}</a></div>
        </div>
        <br/>
        <br/>
        <div>${newsVo.content}</div>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="post-comment-form">
            <#if user??>
            <span>评论</span>
            <form method="post" action="/comment/add">
                <input name="newsId" type="hidden" value="${newsVo.id}">

                <div class="form-group text required comment_content">
                    <label class="text required sr-only">
                        <abbr title="required">*</abbr> 评论</label>
                    <textarea rows="5" class="text required comment-content form-control" name="content"
                              id="content"></textarea>
                </div>
                <div class="text-right">
                    <input type="submit" name="commit" value="提 交" class="btn btn-default btn-info">
                </div>
            </form>
            <#else>
            <div style="text-align: center">
                <a class="btn btn-success js-login">登录后评论</a>
            </div>
            </#if>
        </div>
        <#list recentCommentVo as commentVo>
        <div id="comments" class="comments">
            <div class="media">
                <a class="media-left" href="/user/detail/${commentVo.userId}">
                    <img src="${commentVo.headImage}">
                </a>
                <div class="media-body">
                    <h4 class="media-heading">
                        <small class="date">${commentVo.createTime?string["yyyy-MM-dd"]}
                        </small>
                    </h4>
                    <div>${commentVo.content}</div>
                </div>
            </div>
        </div>
        </#list>
    </div>
    <script type="text/javascript" src="/scripts/main/site/detail.js"></script>
</div>
<#include "footer.ftl">