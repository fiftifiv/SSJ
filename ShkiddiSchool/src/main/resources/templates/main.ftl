<#import "parts/common.ftl" as c>


<@c.page>

    <div>
        <form method="post">
            <input type="text" name="text" placeholder="Введите сообщение" />
            <input type="text" name="tag" placeholder="Тэг">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>

    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter!"Укажите имя сообщения"}">
        <button type="submit">Найти</button>
    </form>
    <#list messages!"No messages" as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.getAuthor().getUsername()!"Non author"}</strong>
        </div>
    <#else>
        No message
    </#list>
</@c.page>
