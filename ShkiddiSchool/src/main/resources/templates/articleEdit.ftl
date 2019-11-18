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

    <div class="card-columns">

        <#list article.getPhotoArticles()! as photo>

            <div class="card" style="width: 18rem;">
                <img src="/img/${photo.getName()}" class="card-img-top">
                <div class="card-body">
                    <p class="card-text">${photo.getNumber()}</p>
                </div>
            </div>

        </#list>
    </div>

    <form action="/article/photo/${article.getId()}" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-secondary btn-lg btn-block" type="submit">Add photo</button>
    </form>

</@c.page>