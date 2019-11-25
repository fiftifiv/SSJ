<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

    <aside>
        <#if isAdmin>

            <div class="articles">


                <ul class="list-of-articles">
                    <h1></h1>
                    <#list test.getQuestions()! as question >
                        <li>
                            <a href="">${question.getQuestion()}</a>
                            <a href="/test/editQuestion/${question.getId()}/${test.getId()}">Edit</a>
                            <a href="/test/deleteQuestion/${test.getId()!}/${question.getId()!}">Delete</a>
                        </li>
                    </#list>

                    <Li><a href="/test/addQuestion/${(test.getId())!}">Add new question</a>


                    </li>
                </ul>

            </div>
            d
        </#if>

    </aside>



    <form action="/test/result/${test.getId()}" >
        <if test.getQuestions()??>
            <#list test.getQuestions()! as question>

                <h4>${question.getQuestion()}</h4>

                <#list question.getShuffleAnswers() as key,value>
                    <label><input type="checkbox" name="${value?string('right' , 'noright')}">${key!}</label>
                </#list>

            </#list>

        </if>

        <button type="submit">Result</button>
    </form>
</@c.page>