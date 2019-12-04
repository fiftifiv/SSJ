<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg">
    <div class="logo-container">
        <img class="logo" id="logo" src="/static/clover-symbol.svg" alt="clever">
    </div>
    <a class="name-of-project" href="/">Shkiddi.School.Java</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse temp" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">


            <#if isAdmin>

                <li class="">
                    <a class="" href="/user">List User <span class="sr-only">(current)</span></a>
                </li>

                <#else>
            </#if>
        </ul>
        <dialog>
            <p id="shkiddi-close">Thank you, Shkitskiy</p>
            <audio id="audio_1">
                <source src="/static/ukraine.mp3" type="audio/mp3" />
            </audio>
        </dialog>
        <div class="navbar-text user-name">${name}</div>

        <@l.logout />
    </div>
</nav>