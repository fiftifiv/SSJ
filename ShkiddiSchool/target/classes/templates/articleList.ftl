<#import "parts/common.ftl" as c>

<@c.page>
    List of article
    <div>
        <form method="get" action="/article/add">
            <input type="text" name="title" placeholder="Enter title article"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit ">Add new article</button>
        </form>
    </div>
    <table>


        <tbody>
        <tr>
            <th>Title</th>
            <th></th>
            <th></th>
        </tr>
        <#list articles!  as article>
            <tr>
                <td>${article.getTitle()!}</td>
                <td><a href="/article/${article.getId()}"><img src="/static/clover-symbol.svg" width="20px" height="20px" alt="edit"></a></td>
                <td><a href="/article/delete/${article.getId()}"><img src="/static/clover-symbol.svg" width="20px" height="20px" alt="delete"></a></td>
            </tr>
        </#list>
        </tbody>

    </table>

</@c.page>