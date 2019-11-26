<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>

    <form method="get" action="/test/updateQuestion/${question.getId()}/${test.getId()}/${currentUserId}">
        <h5>Question</h5>
        <input type="text" name="question" value="${question.getQuestion()}">

        <h5>True answer</h5>
        <input type="text" name="trueAnswer" value="${question.getTrueAnswer()!}">

        <h5>False answer</h5>

        <#if question.getFalseAnswers()??>
            <#list question.getFalseAnswers()! as answer>
                <input type="text" name="${answer.getId()}" value="${answer.getText()}">
                <a href="/test/delete/${question.getId()}/${answer.getId()}/${test.getId()}">Delete</a>
            </#list>

        </#if>


        <a href="/test/addAnswer/${test.getId()}/${question.getId()}">Add new answer</a>


        <button type="submit">Save</button>

    </form>

    <form method="get" action="/test/addQuestion/">


</@c.page>