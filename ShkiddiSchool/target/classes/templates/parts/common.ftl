<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>ShkiddiSchoolJava</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/static/style.css">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
    <#include "navbar.ftl" />
    <main>
<#--        <div>-->
            <#nested>
<#--        </div>-->
    </main>
    <footer class="footer">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="navbar">
                        <div class="container">
                            <ul class="nav">
                                <li><a href="#">Team</a></li>
                                <li><a href="#">Tools</a></li>
                                <li><a href="#">Store</a></li>
                                <li><a href="#">UKRAINE ☺ + ☻ = ♥</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="container politic">
                        © <span>2019</span> <a href="#">Shkiddi Software</a>, Inc. All Rights Reserved.
                    <a href="#">Terms of Use</a> •
                    <a href="#">Privacy</a> •
                    <a href="#">Trademark Guidelines</a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <script src="/static/logo-change.js"></script>
    </body>
    </html>
</#macro>
