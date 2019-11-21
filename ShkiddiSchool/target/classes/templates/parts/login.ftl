<#macro login path isRegiserForm>
    <div class="parent-login-form">
    <form class="login-form" action="${path}" method="post">
        <div class="login-panel">
        <div class="user-name">
            <label class=""> User Name :</label>
            <div class="">
                <input type="text" name="username"/>
            </div>
        </div>

        <div class="form-group user-password">
            <label class=""> Password :</label>
            <div class="">
                <input type="password" name="password"/>
            </div>
        </div>
        <#if isRegiserForm>
            <div class="form-group user-email">
                <label class=""> Email :</label>
                <div class="">
                    <input type="email" name="email" class="form-control" placeholder="some@some.com"/>
                </div>
            </div>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button class="btn-signin" type="submit"><#if isRegiserForm>Create<#else>Sing in</#if></button>
            <div>
        <#if !isRegiserForm> <a href="/registration">Add new user</a></#if>
            </div>
            </div>
    </form>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<#--        <input type="submit" value="Sign Out"/>-->
        <input type="image" style="" src="" alt="Sign Out">
    </form>
</#macro>
