<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <aside>
        <div class="articles">
            <div>
                <h4>Article list</h4>
                <ul class="list-of-articles">

                    <#if isAdmin>
                        <#list articles! as article >
                            <li>
                                <a href="/main/${article.getId()!}">${article.getTitle()!}</a>
                                <a href="/article/${article.getId()!}">Edit</a>
                                <a href="/article/delete/${article.getId()!}">Delete</a>

                            </li>
                        </#list>

                    <#else>
                        <#list articles! as article>

                            <li><a href="/main/${article.getId()}">${article.getTitle()!}</a></li>

                        </#list>
                    </#if>

                    <li><a href="/article/add">Add new Article*******</a></li>

                </ul>
            </div>
        </div>

    </aside>

    <main class="main-section">
        <div class="article-title" align="CENTER">

            <a href="/test/${(article.getTest().getId())!}/${currentUserId}">Test</a>

            <h1>
                <span>${article.getTitle()!}</span>
            </h1>

        </div>
        <div>
            <h4>${article.getText()!}</h4>
        </div>
    </main>

<#--    article text and title-->

</@c.page>
