<#import "parts/common.ftl" as c>
<@c.page>
    <form action="/test/edit" method="post">
        <h1>True answer</h1>
        <input type="text" name="trueAnswer" value="${test.getTrueAnswer()}"/>
        <h2>False answer</h2>
        <#list test.getQuestions() as question>
<input type="test" name="question" value="${question.get}">
        </#list>
    </form>
</@c.page>