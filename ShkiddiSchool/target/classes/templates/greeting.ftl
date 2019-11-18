<#import "parts/common.ftl" as c>

<@c.page>
    <aside>
        <div class="articles">
            <div>
                <h4>Article list</h4>
        <ul class="list-of-articles">
    <#list articles! as article>
    <#--    list article menu-->
        <li><a href="/main/${article.getId()}">${article.getTitle()}</a></li>
    </#list>
        </ul>
            </div>
        </div>
    </aside>

    <main class="main-section">
        <div class="article-title" align="CENTER">
            <h1>
                <span>${article.getTitle()!}</span>
            </h1>
        </div>
    <div>
        <h4>${article.getTextHTML()!}</h4>
    </div>
    </main>

<#--    article text and title-->

</@c.page>
