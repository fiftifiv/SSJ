<#import "parts/common.ftl" as c>

<@c.page>
    <form action="/article/update/${article.getId()}">
        <div class="form-group">
            <label>To add a photo write this template in the place where you want to insert a photo {#name
                photo#}</label>
            <input class="form-control form-control-lg" type="text" name="title" value="${article.getTitle()!}">
            <textarea class="form-control" type="text" name="text" rows="6">${article.getText()!}</textarea>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button class="btn btn-secondary btn-lg btn-block" type="submit">Save</button>
        </div>
    </form>

    <div>

    <#list article.getPhotoArticles()! as photo>

    <div class="card mb-3">
        <img src="/img/${photo.getName()}" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${photo.getNumber()}</h5>
            
        </div>


        </#list>
    </div>

    <form action="/article/photo/${article.getId()}" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-secondary btn-lg btn-block" type="submit">Add photo</button>
    </form>

</@c.page>