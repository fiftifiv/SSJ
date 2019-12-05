<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <#if Session.SPRING_SECURITY_LAST_EXCEPTION.message == "User is disabled">
            <div class="alert alert-danger" role="alert">
                User is not activated
            </div>
        <#else>
            <div class="alert alert-danger" role="alert">
                ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
            </div>
        </#if>


    </#if>
    <#if badMessage??>
        <div class="alert alert-danger" role="alert">
            ${badMessage}
        </div>
    </#if>
    <#if goodMessage??>
        <div class="alert alert-success" role="alert">
            ${goodMessage}
        </div>
    </#if>


    <@l.login "/login" false />

</@c.page>
