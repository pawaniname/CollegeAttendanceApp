

    <html>
        <head>
            <meta charset="UTF-8">
            <title></title>
            <link href="/css/main.css" rel="stylesheet">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        </head>
        <body>
        <div>
            <nav style="background: #3f51b5;">
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo">Attendance Tracker</a>
                    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="AddSubject">Add Subject</a></li>
                        <li><a href="AddTeacher">Add Teacher</a></li>
                        <li><a href="AddClass">Add Class</a></li>
                        <li><a href="AddBatch">Add Batches</a></li>
                        <li><a href="AddClassTest">Class Test</a></li>
                        <li><a href="ImportStudents">Import Students</a></li>
                    </ul>
                </div>
            </nav>  
            <ul class="sidenav" id="mobile-demo">
                <li><a href="AddSubject">Add Subject</a></li>
                <li><a href="AddTeacher">Add Teacher</a></li>
                <li><a href="AddClass">Add Class</a></li>
                <li><a href="AddBatch">Add Batches</a></li>
                <li><a href="ClassTest">Class Test</a></li>
                <li><a href="ImportStudents">Import Students</a></li>
            </ul>
        </div>
            <f:view>
<!--            <div class="col s12">
                <div class="row">
                    <center> <h4>Add New Teacher</h4></center>
                    <div class="col s12 m4">
                    </div>
                    <div class="col s12 m4">
                        <table class="datatable">
                            <tr>
                                <th>Firstname</th>  <th>Lastname</th>
                            </tr>
                            <#list model["subjectsList"] as subject>
                            <tr>
                                <td>subject</td> <td>"Nothing"</td>
                            </tr>
                            </#list>
                        </table>
                    </div>
                    <div class="col s12 m4">
                    </div>
                </div>
            </div>-->
</f:view>
            <script src="/js/main.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
                    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script>
//            document.addEventListener('DOMContentLoaded', function () {
//                var elems = document.querySelectorAll('.sidenav');
//                var instances = M.Sidenav.init(elems, options);
//            });

//            // Or with jQuery
//
            $(document).ready(function () {
                $('.sidenav').sidenav();
            });
        </script>
        </body>
    </html>


