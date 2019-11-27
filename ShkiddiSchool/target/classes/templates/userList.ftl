<#import "parts/common.ftl" as c>
<@c.page>
    List of Users
        <#list users ! "No search user!" as user>
            <div>
                <div>
                    ${user.getUsername()}
                    <#list user.roles ! "No search role!" as role>${role}<#sep>, </#list>
                </div>
                <h4>Progres test</h4>
                <div class="progress">
                    <div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width: ${usersService.userProgresTest(user)}%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">${usersService.userProgresTest(user)}%</div>
                </div>

                <div>
                    <a href="/user/${user.id}">Edit</a>
                    <a href="/user/delete/${user.id}">Delete</a>
                </div>
            </div>

        </#list>


</@c.page>