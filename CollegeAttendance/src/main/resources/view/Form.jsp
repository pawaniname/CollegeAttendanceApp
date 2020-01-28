<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Form example with Java, Spring Boot, FreeMarker</title>
        <link href="/css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <div class="col s12">
            <div class="row">
                <center> <h4>Attendance Login</h4></center>
                <#if user??>
                Your submitted data<br>
                First name: ${user.firstName}<br>
                Last name: ${user.lastName}<br>
                <#else>
                <div class="col s12 m4">
                </div>
                <div class="col s12 m4">
                    <form action="/Form" method="post" > 
                        <div class="card ">
                            <div class="card-content">
                                <div class="input-field">
                                    <input type="text" name="firstName" class="validate">
                                    <label for="firstName">First Name</label>
                                </div>
                                <div class="input-field "> 
                                    <input type="text" name="lastName" class="validate">
                                    <label for="lastName">Last Name</label>
                                </div>  
                            </div>
                            <div class="card-action">
                                <div class="center">
                                    <button class="btn waves-effect waves-light" type="submit" name="action">Login
                                        <i class="material-icons right">send</i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>    
                </div>
                <div class="col s12 m4">
                </div>
            </div>
        </div>
        </#if>
        <script src="/js/main.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>