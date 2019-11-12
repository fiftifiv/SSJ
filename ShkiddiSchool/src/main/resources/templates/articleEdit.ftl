<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/article/update/${article.getId()}">
        <div class="form-group" >
            <label >To add a photo write this template in the place where you want to insert a photo {#name photo#}</label>
            <input class="form-control form-control-lg" type="text" name="title" value="${article.getTitle()!}">

            <textarea class="form-control" type="text" name="text"rows="6"  >${article.getText()!}</textarea>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button  class="btn btn-secondary btn-lg btn-block" type="submit">Save</button>
        </div>
    </form>
</@c.page>