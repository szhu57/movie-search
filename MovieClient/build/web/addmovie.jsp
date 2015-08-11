<!DOCTYPE html>

<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.css">

        <script src="./js/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="./bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
      
    

  </head>
  
  <body>


    <div class="container">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">Add new movie</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" method="post" action="AddMovieServlet" >
                        
                        <div class="form-group"> <label for="name"></label>
                            <label for="title" >TITLE</label>
                            <div>
                                <input type="text" class="form-control" id="title" name="title" placeholder="Add the title of movie" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="director" >DIRECTOR</label>
                            <div>
                                <input type="text" class="form-control" id="director" name="director" placeholder="Add the director of movie" required>
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="rating" >RATING</label>
                            <div>
                                <input type="text" class="form-control" id="director" name="rating" placeholder="Add the rating of movie" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="type" >TYPE</label>
                            <div>
                                <input type="text" class="form-control" id="type" name="type" placeholder="Add the type of movie" required>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="description" >DESCRIPTION</label>
                            <div >
                                <input type="text" class="form-control" id="description" name="description" placeholder="Add the description of movie" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="starts" >STARTS</label>
                            <div >
                                <input type="text" class="form-control" id="starts" name="starts" placeholder="Add the actor of movie">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="coverpath" >URL</label>
                            <div >
                                <input type="text" class="form-control" id="coverurl" name="coverurl" placeholder="URL of the title photo">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary" > SUBMIT</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- panel-->
          </div>

   
   
    
</body>
</html>

