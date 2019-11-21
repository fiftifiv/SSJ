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

                            <li><a href="/main/${article.getId()}">${article.getTitle()}</a></li>

                        </#list>
                    </#if>

                    <li><a href="/article/add">Add new Article*******</a></li>

                </ul>
            </div>
        </div>

        <#if isAdmin>

            <div class="articles">
                <div>
                    <h4>Questions test</h4>
                </div>

                <ul class="list-of-articles">

                    <#list (article.getTest().getQuestions())! as question >
                        <li><a href="">${question.getQuestion()}</a></li>
                    </#list>

                    <Li><a href="/test/addQuestion/${(article.getTest().getId())!}">Add new question</a></Li>
                </ul>

            </div>

        </#if>

    </aside>

    <main class="main-section">
        <div class="article-title" align="CENTER">
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
