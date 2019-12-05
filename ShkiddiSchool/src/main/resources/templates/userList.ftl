<#import "parts/common.ftl" as c>
<@c.page>
    <div class="list-of-users">
    <h1>List of Users</h1>
        <#list users ! "No search user!" as user>
            <div class="list-of-users-item">
                <img src="/static/man-placeholder.svg" width="50px" height="50px" alt="placeholder">
                <div class="user-text">
                    <div class="list-user-name">${user.getUsername()}</div>
                    <div class="user-roles">
                    <#list user.roles ! "No search role!" as role>${role}<#sep>, </#list>
                    </div>
                </div>
                <div class="progress-test">
                    <h4>Progress test</h4>
                    <div class="progress-bar-wrapper">
                         <div class="progress-bar progress-bar-striped bg-success" role="progressbar" style="width:${usersService.userProgresTest(user)}%; color: #50000e; font-size: 1.1rem; font-weight: bolder" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">${usersService.userProgresTest(user)}%</div>
                    </div>
                </div>
            <div class="edit-block-wrapper">
            <div class="edit-block" <#--style="position: relative"-->>
                <a href="/user/${user.id}"><img src="/static/edit-pencil.svg" width="20px"
                                                            height="20px" alt="edit"></a>

                <a href="/user/delete/${user.id}"><img src="/static/edit-recycle_bin.svg"
                                                                   width="20px" height="20px"
                                                                   alt="delete"></a>
            </div>
            </div>
            </div>

        </#list>
    </div>

</@c.page>