<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.css">

        
        <script src="./js/jquery-2.1.4.min.js"type="text/javascript"></script>
        <script src="./js/highcharts.js"type="text/javascript"></script>
        <script type="text/javascript" src="./js/exporting.js"><
        <script src="./bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>

        <title>Welcome to Movie Search!</title>
    </head>
    <body>

        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid" >
                <!-- Brand and toggle get grouped for better mobile display -->

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./index.jsp">Movie Search</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li  aria-label="Left Align"><a href="./index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> HOME</a></li>
                        <li class="active"><a href="./local.jsp">LOCAL</a></li>
                        <li><a href="./flickr.jsp">FLICKR</a></li>
                        <li><a href="./google.jsp">GOOGLE</a></li>
                        <li><a href="./tudou.jsp">TUDOU</a></li>
                        <li><a href="./addmovie.jsp">ADD</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>


        <div class="container">            
            <!-- header-->
            <div class="row">

                <h3 class="text-center"><img height="80" width="250" src="./img/logo.png"></h3>

            </div><!--header -->


            <div class="row">
                <form role="form" class="form-horizontal" method="post" action="MovieServlet?method=local">
                    <div class="form-group-lg">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="yui3-skin-sam input-group">
                                <div id="the-basics">
                                    <input type="text" name="moviename" class="typeahead form-control" placeholder="Search">
                                </div>

                                <span class="input-group-btn">
                                    <button class="btn  btn-primary btn-lg" type="submit" aria-label="Left Align"> <span class="glyphicon glyphicon-search " aria-hidden="true"></span></button>
                                </span>
                            </div><!-- /input-group -->
                        </div>
                    </div>

                </form>
            </div>


            <!-- picture slide-->     

            <hr>
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <h3 class="panel-title">Movie Information</h3>
                </div>
                <div class="panel-body">
                 
                    <div class="row">
                        <div class="col-md-3">

                            <img src="${movie.coverurl}" width="300px" height="370px" >
                        </div>

                        <div class="col-md-5">
                            <ul class="list-group">
                                <li class="list-group-item">

                                    <h5><span class="label label-success">TITLE</span> ${movie.title}</h5>
                                </li>
                                <li class="list-group-item">

                                    <h5><span class="label label-success">Type</span> ${movie.type}</h5>
                                </li>

                                <li class="list-group-item">                                  
                                    <span class="label label-success">Description</span><h5> ${movie.description}</h5>
                                </li>
                                <li class="list-group-item">

                                    <h5><span class="label label-success"> Rating</span> ${movie.rating}</h5>
                                </li>

                                <li class="list-group-item">

                                    <h5><span class="label label-success">Director</span> ${movie.director}</h5>
                                </li>
                                <li class="list-group-item">

                                    <h5><span class="label label-success">Starts</span> ${movie.starts}</h5>
                                </li>
                            </ul>

                        </div>


                        <!--tweet sentiment -->        
                        <div class="col-md-4">
                            <br>
                            <br>
                            <br>
                            <div id="container" style="min-width:350px;height:350px"></div>
                            <script type="text/javascript">
                                $(function () {
                                    $('#container').highcharts({
                                        chart: {
                                            plotBackgroundColor: null,
                                            plotBorderWidth: null,
                                            plotShadow: false
                                        },
                                        title: {
                                            text: 'Sentiment Analysis'
                                        },
                                        tooltip: {
                                            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                                        },
                                        plotOptions: {
                                            pie: {
                                                allowPointSelect: true,
                                                cursor: 'pointer',
                                                dataLabels: {
                                                    enabled: true,
                                                    color: '#000000',
                                                    connectorColor: '#000000',
                                                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                                                }
                                            }
                                        },
                                        series: [{
                                                type: 'pie',
                                                name: 'tweet sentiment',
                                                data: [
                                                    ['Positive', ${score}],
                                                    ['Negative', 1-${score}],
                                                ]
                                            }]
                                    });
                                });
                            </script>
                        </div><!--Sentiment Analysis-->
                    </div>    
                </div><!-- body-->
          


            <!-- duoshuo comments-->
            <div class="ds-thread" data-thread-key="{{ page.url }}" data-title="{{ page.title }}" ></div>
            <script type="text/javascript">
                var duoshuoQuery = {short_name: "szhu57"};
                (function () {
                    var ds = document.createElement('script');
                    ds.type = 'text/javascript';
                    ds.async = true;
                    ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
                    ds.charset = 'UTF-8';
                    (document.getElementsByTagName('head')[0]
                            || document.getElementsByTagName('body')[0]).appendChild(ds);
                })();
            </script>

  </div><!--pannel-->

    </body>
</html>