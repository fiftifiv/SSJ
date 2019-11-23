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


<if test.getQuestions()??>
    <#list test.getQuestions()! as question>



    </#list>
</if>

    <button type="submit">Result</button>
</@c.page>