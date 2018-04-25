<#include "header.ftl">
    <div id="main">
        <div class="container">
            <ul class="letter-list">
                <#list conversationVoList as conversationVo>
                <li>
                    <a class="letter-link" href="/message/conversation/detail/${conversationVo.otherId}"></a>
                    <div class="letter-info">
                        <span class="l-time">${conversationVo.createTime?string["yyyy-MM-dd"]}</span>
                        <div class="l-operate-bar">
                            <a href="/message/conversation/detail/${conversationVo.otherId}">
                                共${conversationVo.messageNum}条对话
                            </a>
                        </div>
                    </div>
                    <div class="chat-headbox">
                        <a href="/user/detail/${conversationVo.otherId}">
                            <img alt="头像" width="50" class="img-circle" src="${conversationVo.otherHeadImg}">
                        </a>
                    </div>
                    <div class="letter-detail">
                        <a class="letter-name">
                            ${conversationVo.otherName}
                        </a>
                        <p class="letter-brief">
                        </p>
                    </div>
                </li>
                </#list>
            </ul>
        </div>
    </div>
<#include "footer.ftl">