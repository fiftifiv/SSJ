<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

    <aside>

        <#if isAdmin>

            <div class="articles">
                <ul class="list-of-articles">

                    <#list test.getQuestions()! as question >
                        <li>
                            <a href="">${question.getQuestion()}</a>
                            <a href="/test/editQuestion/${question.getId()}/${test.getId()}">Edit</a>
                            <a href="/test/deleteQuestion/${test.getId()!}/${question.getId()!}/${currentUserId}">Delete</a>
                        </li>
                    </#list>

                    <Li><a href="/test/addQuestion/${(test.getId())!}/${currentUserId}">Add new question</a>


                    </li>
                </ul>

            </div>

        </#if>

    </aside>


    <#if progres.isPresent()>
        <h1>Ваш самый лучшый результат теста на ${progres.get().getTestCompletionRate()}%</h1>
    <#else>
        <h1>Успехов в здаче теста</h1>
    </#if>

    <form action="/test/result/${test.getId()}/${currentUserId}">
        <if test.getQuestions()??>
            <#list test.getQuestions()! as question>

                <h4>${question.getQuestion()!}</h4>

                <#if question??>
                    <#list question.getShuffleAnswers()! as key,value>
                        <label><input type="checkbox" name="${value?string('right' , 'noright')}">${key!}</label>
                    </#list>
                </#if>

            </#list>

        </if>

        <button type="submit">Result</button>
    </form>
</@c.page>