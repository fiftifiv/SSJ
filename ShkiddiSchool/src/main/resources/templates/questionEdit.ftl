<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <div class="main-section">
    <form method="get" class="question-edit" action="/test/updateQuestion/${question.getId()}/${test.getId()}/${currentUserId}">
        <h5>Question</h5>
        <input type="text" name="question" value="${question.getQuestion()}">

        <h5>True answer</h5>
        <input type="text" name="trueAnswer" value="${question.getTrueAnswer()!}">

        <h5>False answer</h5>

        <#if question.getFalseAnswers()??>
            <#list question.getFalseAnswers()! as answer>
                <div class="question-answer">
                <input type="text" name="${answer.getId()}" value="${answer.getText()}">
                <a class="delete" href="/test/delete/${question.getId()}/${answer.getId()}/${test.getId()}">
                    <img src="/static/edit-recycle_bin.svg" width="20px" height="20px" alt="delete">
                </a>
                </div>
            </#list>

        </#if>


        <a class="add" href="/test/addAnswer/${test.getId()}/${question.getId()}">
            <img src="/static/edit-plus.svg" width="20px" height="20px" alt="add"></a>


        <button type="submit">Save</button>

    </form>
    </div>
    <form method="get" action="/test/addQuestion/">


</@c.page>