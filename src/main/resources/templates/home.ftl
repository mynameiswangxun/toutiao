<#include "header.ftl">
    <div id="main">

        <div class="container" id="daily">
            <div class="jscroll-inner">
                <div class="daily">
                </div>
                <#list recentNewsVo as newsVo>
                 <h3 class="date">
                    <i class="fa icon-calendar"></i>
                    <span>头条简讯 &nbsp; ${newsVo.createTime?string["yyyy-MM-dd"]}</span>
                 </h3>
                <div class="post">
                    <div class="post">
                        <div class="votebar">
                            <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">${newsVo.likeCount}</span></button>
                            <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                            </button>
                        </div>
                        <div class="content">
                            <div >
                                <img class="content-img" src="${newsVo.mainImage}" alt="">
                            </div>
                            <div class="content-main">
                                <h3 class="title">
                                    <a target="_blank" rel="external nofollow" href="/news/detail/${newsVo.id}">${newsVo.title}</a>
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
                                <a href="/user/detail/${newsVo.userId}"><img width="32" class="img-circle" src="${newsVo.headImage}"></a>
                            </div>
                        </div>

                        <div class="subject-name">来自 <a href="/user/detail/${newsVo.userId}/">${newsVo.username}</a></div>
                    </div>
                </div>
                </#list>
            </div>
        </div>

    </div>

<#include "footer.ftl">