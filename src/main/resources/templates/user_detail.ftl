<#include "header.ftl">
<div id="head_image" style="text-align: center">
    <br><br>
    <img width="200" src="${user.headImage}">
</div>
<div id="detail" style="text-align: center">
    <br><br>
    <h1>用户名:${user.username}</h1><br><br>
    <h1>创建日期:${user.createTime?string["yyyy-MM-dd"]}</h1><br><br>
</div>
<#include "footer.ftl">