<#include "header.ftl">
<div id="head_image" style="text-align: center">
    <br><br>
    <img width="200" src="${other_user.headImage}">
</div>
<div id="detail" style="text-align: center">
    <br><br>
    <h1>用户名:${other_user.username}</h1><br><br>
    <h1>创建日期:${other_user.createTime?string["yyyy-MM-dd"]}</h1><br><br>
    <br><br>
<#if user?? && user.id!=other_user.id>
    <form method="get" action="/message/conversation/detail/${other_user.id}" style="text-align: center">
        <input type="submit" value="私信" class="btn btn-default btn-info">
    </form>
</#if>
</div>
<#include "footer.ftl">