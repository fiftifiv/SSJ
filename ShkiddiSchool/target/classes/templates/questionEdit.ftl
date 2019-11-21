<#import "parts/common.ftl" as c>
<@c.page>

    <form method="get" action="/test/updateQuestion/${question.getId()}">
        <h5>Question</h5>
        <input type="text" name="question" value="${question.getQuestion()}">

        <h5>True answer</h5>
        <input type="text" name="trueAnswer" value="${question.getTrueAnswer()!}">
        <h5>False answer</h5>

        <#list question.getFalseAnswers() as answer>
            <input type="text" name="falseAnswer" value="${answer.getText()}">
            <a href="/test/delete/${question.getId()}/${answer.getId()}">Delete</a>
        </#list>

        <h5>New false answer</h5>

        <input type="text" name="newFalseAnswer" value="New false answer"/>

        <button type="submit">Save</button>

    </form>

</@c.page>