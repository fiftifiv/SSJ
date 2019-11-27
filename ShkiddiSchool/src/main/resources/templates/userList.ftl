<#import "parts/common.ftl" as c>
<@c.page>
    List of Users
<#--    <table>-->


<#--        <tbody>-->
<#--        <tr>-->
<#--            <th>Name</th>-->
<#--            <th>Role</th>-->
<#--            <th></th>-->
<#--        </tr>-->
        <#list users ! "No search user!" as user>
            <tr>
                <td>${user.getUsername()}</td>
                <td><#list user.roles ! "No search role!" as role>${role}<#sep>, </#list></td>
                <div class="edit-block">
                    <td><a href="/user/${user.id}"></a></td>
                </div>

            </tr>



        </#list>
        </tbody>

    </table>

</@c.page>