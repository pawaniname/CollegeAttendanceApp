<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login Form</title>
        <link href="/css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <f:view>
        <div class="col s12">
            <div class="row">
                <center> <h4>Attendance Login</h4></center>
                <div class="col s12 m4">
                </div>
                <div class="col s12 m4">
                    <form action="/Login" method="post" > 
                        <div class="card ">
                            <div class="card-content">
                                <div class="input-field">
                                    <input type="text" name="firstName" class="validate">
                                    <label for="firstName">Username</label>
                                </div>
                                <div class="input-field "> 
                                    <input type="password" name="lastName" class="validate">
                                    <label for="lastName">Password</label>
                                </div>  
                            </div>
                            <div class="card-action">
                                <div class="center">
                                    <button class="btn waves-effect waves-light" type="submit" name="action" style="border-radius: 15px; background-color: #3f51b5;">Login
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
</f:view>
        <script src="/js/main.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>