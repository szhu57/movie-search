<!DOCTYPE html>

<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.css">

        
       <script type="text/javascript">
    
    var xmlHttpRequest = null;
    
    function ajaxRequest()
    {
        if(window.ActiveXObject)
        {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
        else if(window.XMLHttpRequest) 
        {
            xmlHttpRequest = new XMLHttpRequest();
        }
        if(null != xmlHttpRequest)
        {
            var title = document.getElementById("title").value;
            var director = document.getElementById("director").value;
            var type = document.getElementById("type").value;
            var starts = document.getElementById("starts").value; 
            var coverurl = document.getElementById("coverurl").value;
            var rating = document.getElementById("rating").value;
            var description = document.getElementById("description").value;
            
            xmlHttpRequest.open("POST", "AddMovieServlet", true);
             
      
            xmlHttpRequest.onreadystatechange = ajaxCallBack;
            
        
            xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            
    
            xmlHttpRequest.send("&title=" + title + "&type=" + type+ "&director=" + director+ "&rating=" + rating+ "&description=" + descriptin"+&starts=" + starts+"&coverurl=" + coverurl);    
        }
    }
    
    function ajaxCallBack()
    {
        if(xmlHttpRequest.readyState == 4)
        {
            if(xmlHttpRequest.status == 200)
            {
                var content = xmlHttpRequest.responseText;
                document.getElementById("div1").innerHTML = content;
            }
        }
    }
    
    </script>

  </head>
  
  <body>


    <div class="container">
            <div class="panel panel-warning" id="div1">
                <div class="panel-heading">
                    <h3 class="panel-title">Add new movie</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" >
                        
                        <div class="form-group"> <label for="name"></label>
                            <label for="title" >TITLE</label>
                            <div >
                                <input type="text" class="form-control" id="title" name="title" placeholder="Title of movie" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="director" >DIRECTOR</label>
                            <div >
                                <input type="text" class="form-control" id="director" name="director" placeholder="Director of movie" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="type" >TYPE</label>
                            <div class=>
                                <input type="text" class="form-control" id="type" name="type" placeholder="Type of movie" required>
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="type" >RATING</label>
                            <div class=>
                                <input type="text" class="form-control" id="rating" name="rating" placeholder="Rating of movie" required>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="description" >DESCRIPTION</label>
                            <div >
                                <input type="text" class="form-control" id="description" name="description" placeholder="Description of movie" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="starts" >STARTS</label>
                            <div >
                                <input type="text" class="form-control" id="starts" name="starts" placeholder="">
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
                                <button type="submit" class="btn btn-primary" onclick="ajaxRequest()">SUBMIT</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- panel-->
          </div>

   
   
    
</body>
</html>

