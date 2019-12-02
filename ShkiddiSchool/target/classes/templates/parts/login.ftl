<#macro login path isRegiserForm>
    <div class="parent-login-form">
        <form class="login-form" action="${path}" method="post">
            <div class="login-panel">
                <div class="user-name">
                    <label class=""> User Name :</label>
                    <div class="">
                        <input type="text"
                               name="username"
                               class="form-control ${(usernameError??)?string('is-invalid','')}"
                               placeholder="User name"
                               value="<#if user??>${user.username}</#if>"
                        />
                        <#if usernameError??>
                            <div class="invalid-feedback ">
                                ${usernameError}
                            </div>
                        </#if>
                    </div>
                </div>

                <div class="form-group user-password">
                    <div class="">
                        <label class=""> Password :</label>
                        <input type="password" name="password"
                               class="form-control ${(passwordError??)?string('is-invalid','')}"
                               placeholder="Password"/>
                        <#if passwordError??>
                            <div class="invalid-feedback ">
                                ${passwordError}
                            </div>
                        </#if>
                    </div>
                </div>


                <#if isRegiserForm>

                    <div class="form-group user-password">
                        <div class="">
                            <label class=""> Password :</label>
                            <input type="password" name="password2"
                                   class="form-control ${(password2Error??)?string('is-invalid','')}"
                                   placeholder="Retype password"/>
                            <#if password2Error??>
                                <div class="invalid-feedback ">
                                    ${password2Error}
                                </div>
                            </#if>
                        </div>
                    </div>

                    <div class="form-group user-email">
                        <label class=""> Email :</label>
                        <div class="">
                            <input type="email"
                                   name="email"
                                   class="form-control ${(emailError??)?string('is-invalid','')}"
                                   placeholder="some@some.com"
                                   value="<#if user??>${user.email}</#if>"
                            />
                            <#if emailError??>
                                <div class="invalid-feedback ">
                                    ${emailError}
                                </div>
                            </#if>
                        </div>
                    </div>

                    <div>
                        <div class="g-recaptcha" data-sitekey="6LfcpsUUAAAAAOBq-XsXiFpCvCYDg2VpTOWSrtY4"></div>
                        <#if captchaError??>
                            <div>
                                <div class="alert alert-danger" role="alert">
                                    ${captchaError}
                                </div>

                            </div>
                        </#if>
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
        <input type="submit" value="Sign Out"/>

    </form>
</#macro>
