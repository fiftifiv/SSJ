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
    <main class="main-section">
        <div class="article">
            <#if article??>
            <h1>
                <span>${article.getTitle()!}</span>
            </h1>
            <div class="article-main">
            <div class="article-text">
                <pre class="main-text">${article.getText()!}
            <div class="wrapper-test">
<#--            <section class="test" style="">-->
                <button class="test-result" type="submit" style="width: 100%"><a class="button-to-test" href= "/test/${(article.getTest().getId())!}/${currentUserId}">Get test</a></button>

<#--            </section>-->
            </div>
                </pre>
            </div>

            </div>
        </div>
        </#if>

    </main>
    </div>
</@c.page>
