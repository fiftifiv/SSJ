<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <div class="global-div">
    <aside>
        <div class="articles">
            <h4>Article list</h4>
            <ul class="list-of-articles">

                <#if isAdmin>
                    <#list articles! as article >
                        <li>
                            <a href="/main/${article.getId()!}">${article.getTitle()!}</a>
                            <div class="edit-block">
                                <a href="/article/${article.getId()!}"><img src="/static/edit-pencil.svg" width="20px"
                                                                            height="20px" alt="edit"></a>

                                <a href="/article/delete/${article.getId()!}"><img src="/static/edit-recycle_bin.svg"
                                                                                   width="20px" height="20px"
                                                                                   alt="delete"></a>
                            </div>
                        </li>
                    </#list>

                <#else>
                    <#list articles! as article>

                        <li><a href="/main/${article.getId()}">${article.getTitle()!}</a></li>

                    </#list>
                </#if>

`                <#if isAdmin>
                    <div class="edit-plus">
                        <li><a href="/article/add"><img src="/static/edit-plus.svg" width="20px" height="20px"
                                                        alt="add article"></a></li>
                    </div>

                </#if>

            </ul>
        </div>

    </aside>
    <main>
        <div class="div-of-main">
        <section class="article">
            <h1 class="article-title">
            <#if article??>
            <a href="/test/${(article.getTest().getId())!}/${currentUserId}">Test</a>
            </h1>
            <h1>
                <span>${article.getTitle()!}</span>
            </h1>
            <div class="article-text">
                <pre>${article.getText()!}</pre>
            </div>
        </section>
            <section class="test" style="">
                <a class="button-to-test" href= "/test/${(article.getTest().getId())!}/${currentUserId}">Get test ☺</a>
            </section>
        </div>
        </#if>

    </main>
    </div>


</@c.page>
