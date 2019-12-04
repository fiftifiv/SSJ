<#macro login path isRegiserForm>
    <div class="parent-login-form">
    <form class="login-form" action="${path}" method="post">
        <div class="login-panel">
        <div class="user-name">
            <label class="label-username login-label"> User Name :</label>
            <div class="input-username">
                <input type="text" name="username"/>
            </div>
        </div>

        <div class="form-group user-password">
            <label class="label-userpassword login-label"> Password :</label>
            <div class="input-password">
                <input type="password" name="password"/>
            </div>
        </div>
        <#if isRegiserForm>
            <div class="form-group user-email">
                <label class=""> Email :</label>
                <div class="input-email">
                    <input type="email" name="email" class="form-control" placeholder="some@some.com"/>
                </div>
            </div>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="btn-signin-wrapper">
            <div class="btn-signin">
            <button class="btn-signin" type="submit">
                <#if isRegiserForm>Create<#else>Sing in</#if>
            </button>
            </div>
            </div>
            <div class="btn-register">
        <#if !isRegiserForm> <a href="/registration">Register</a></#if>
            </div>
            </div>
    </form>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input class="btn-inout" type="submit" value="Sign Out"/>
    </form>
</#macro>
