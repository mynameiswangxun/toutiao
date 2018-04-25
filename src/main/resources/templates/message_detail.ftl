<#include "header.ftl">
<div id="main">
    <div class="container">
        <div class="post-comment-form">
            <span>回复</span>
            <form method="post" action="/message/create">
                <input name="toId" type="hidden" value="${otherId}">

                <div class="form-group text required comment_content">
                    <label class="text required sr-only">
                        <abbr title="required">*</abbr> 回复</label>
                    <textarea rows="5" class="text required comment-content form-control" name="content"
                              id="content"></textarea>
                </div>
                <div class="text-right">
                    <input type="submit" name="commit" value="提 交" class="btn btn-default btn-info">
                </div>
            </form>
        </div>

        <ul class="letter-chatlist">
            <#--<li id="msg-item-4009580">-->
                <#--<a class="list-head" href="/user/123">-->
                    <#--<img class="img-circle" width="50" src="http://img.toutiaojianxun.com/user/5.png">-->
                <#--</a>-->
                <#--<div class="tooltip fade right in">-->
                    <#--<div class="tooltip-arrow"></div>-->
                    <#--<div class="tooltip-inner letter-chat clearfix">-->
                        <#--<div class="letter-info">-->
                            <#--<p class="letter-time">2018-3-9</p>-->
                        <#--</div>-->
                        <#--<p class="chat-content">-->
                            <#--孙狗吃屎-->
                        <#--</p>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</li>-->
            <#--<li id="msg-item-4009580">-->
                <#--<a class="list-head" href="/user/123">-->
                    <#--<img class="img-circle" width="50" src="http://img.toutiaojianxun.com/user/5.png">-->
                <#--</a>-->
                <#--<div class="tooltip fade right in">-->
                    <#--<div class="tooltip-arrow"></div>-->
                    <#--<div class="tooltip-inner letter-chat-myself clearfix">-->
                        <#--<div class="letter-info">-->
                            <#--<p class="letter-time">2018-3-9</p>-->
                        <#--</div>-->
                        <#--<p class="chat-content">-->
                            <#--孙狗吃屎-->
                        <#--</p>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</li>-->
            <#list messageVoList as messageVo>
            <li>
                <a class="list-head" href="/user/detail/${messageVo.fromId}">
                    <img class="img-circle" width="50" src="${messageVo.senderHeadImg}">
                </a>
                <div class="tooltip fade right in">
                    <div class="tooltip-arrow"></div>
                    <div class="tooltip-inner letter-chat<#if messageVo.isSender>-myself</#if>  clearfix">
                        <div class="letter-info">
                            <p class="letter-time">${messageVo.createTime?string["yyyy-MM-dd HH:mm:ss"]}</p>
                        </div>
                        <p class="chat-content">
                            ${messageVo.content}
                        </p>
                    </div>
                </div>
            </li>
            </#list>
        </ul>

    </div>
<#include "footer.ftl">