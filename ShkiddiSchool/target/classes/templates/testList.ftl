<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

    <aside>

        <#if isAdmin>

            <div class="articles">
                <ul class="list-of-articles list-of-tests">

                    <#list test.getQuestions()! as question >
                        <li class="test-item">
                            <a href="">${question.getQuestion()}</a>
                            <div class="edit-block" <#--style="position: relative"-->>
                                <a href="/test/editQuestion/${question.getId()}/${test.getId()}"><img src="/static/edit-pencil.svg" width="20px"
                                                                height="20px" alt="edit"></a>

                                <a href="/test/deleteQuestion/${test.getId()!}/${question.getId()!}/${currentUserId}"><img src="/static/edit-recycle_bin.svg"
                                                                       width="20px" height="20px"
                                                                       alt="delete"></a>
                            </div>
                    </#list>
                        </li>
                    <div class="edit-plus">
                        <li><a href="/test/addQuestion/${(test.getId())!}/${currentUserId}"><img src="/static/edit-plus.svg" width="20px" height="20px"
                                                        alt="add article"></a></li>
                    </div>


                    </li>
                </ul>

            </div>

        </#if>

    </aside>


    <#if progres.isPresent()>
        <h1 class="test-user-text">Your best result is ${progres.get().getTestCompletionRate()}%</h1>
    <#else>
        <h1 class="test-user-text">Good luck!</h1>
    </#if>
    <main class="main-section">
        <div class="tests">
    <form class="" action="/test/result/${test.getId()}/${currentUserId}">
        <if test.getQuestions()??>
            <#list test.getQuestions()! as question>
                <div class="question">
                <span class="question-name">${question.getQuestion()!}</span>
                <#if question??>
                    <#list question.getShuffleAnswers()! as key,value>
                        <div class="label-with-checkbox">
                        <label class="label-with-checkbox"><input type="radio" name="${value?string('right' , 'noright')}">${key!}</label>
                        </div>
                    </#list>
                </#if>
                </div>
            </#list>

        </if>
        <button class="test-result" type="submit">Result</button></br>
    </form>
        </div>
    </main>
</@c.page>