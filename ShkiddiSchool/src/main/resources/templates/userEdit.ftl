<#import "parts/common.ftl" as c>
<@c.page>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.getUsername()}">
        <#list roles!"No roles" as role>
            <div>
                <label><input type="checkbox" name="${role!"No role"}" ${user.roles?seq_contains(role)?string("checked","")}>${role!"No role"}</label>
            </div>
        </#list>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="hidden" value="${user.getId()}" name="userId">
        <button type="submit">Save</button>
    </form>
</@c.page>