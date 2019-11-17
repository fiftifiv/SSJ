<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light temp">
    <div class="logo-container">
        <img class="logo" src="/static/clover-symbol.svg" alt="clever">
    </div>
    <a class="navbar-brand name-of-project" href="/">Shkiddi.School.Java</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse temp" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="">
                <a class="" href="/main">Main<span class="sr-only">(current)</span></a>
            </li>
            <#if isAdmin>

                <li class="">
                    <a class="" href="/user">List User <span class="sr-only">(current)</span></a>
                </li>
                <li class="">
                    <a class="" href="/article">List Article <span class="sr-only">(current)</span></a>
                </li>
            </#if>
        </ul>
        <div class="navbar-text user-name">${name}</div>
        <@l.logout />
    </div>
</nav>