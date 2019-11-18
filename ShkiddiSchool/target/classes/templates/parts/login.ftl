<#macro login path isRegiserForm>
    <form action="${path}" method="post">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> User Name :</label>
            <div class="col-sm-10">
                <input type="text" name="username"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password :</label>
            <div class="col-sm-10">
                <input type="password" name="password"/>
            </div>
        </div>
        <#if isRegiserForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"> Email :</label>
                <div class="col-sm-10">
                    <input type="email" name="email" class="form-control" placeholder="some@some.com"/>
                </div>
            </div>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <div>
            <button calss="btn btn-primary" type="submit"><#if isRegiserForm>Create<#else>Sing in</#if></button>
        </div>

        <#if !isRegiserForm> <a href="/registration">Add new user</a></#if>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<#--        <input type="submit" value="Sign Out"/>-->
        <input type="image" style="" src="" alt="Sign Out">
    </form>
</#macro>
