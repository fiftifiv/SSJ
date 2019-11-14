<#import "parts/common.ftl" as c>

<@c.page>

    <#list articles! as article>
    <#--    list article menu-->
        <div ><a href="/main/${article.getId()}">${article.getTitle()}</a></div>
    </#list>


    <div align="CENTER"><h1>${article.getTitle()!}</h1></div>
    <div><h4>${article.getTextHTML()!}</h4></div>


<#--    article text and title-->

</@c.page>
