<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>wapik Multiparpus Template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="swAssets/fonts/stylesheet.css">
        <link rel="stylesheet" href="swAssets/css/font-awesome.min.css">

        <link rel="stylesheet" href="swAssets/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">-->



        <link rel="stylesheet" href="swAssets/css/customicon.css">
        <link rel="stylesheet" href="swAssets/css/linearicons.css">
        <link rel="stylesheet" href="swAssets/css/animate.css">

        <!--For Plugins external css-->
        <link rel="stylesheet" href="swAssets/css/plugins.css" />
        <!--Theme custom css -->
        <link rel="stylesheet" href="swAssets/css/style.css">
        <!--Theme Responsive css-->
        <link rel="stylesheet" href="swAssets/css/responsive.css" />

        <script src="swAssets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
       
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
		<div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <header id="header" class="navbar-fixed-top">
            <div class="container">
                <div class="main_menu wow fadeInDown" data-wow-duration="2s">	
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand our_logo" href="#">PREMA RATING</a>
                                <div class="call_us">
                                    <i class="fa fa-phone"></i>
                                   +91-9425303034
                                </div>	  
                            </div>

                            <!-- Collect the nav links, forms, and other content for toggling -->
                                                  </div><!-- /.container-fluid -->
                    </nav>

                </div>
            </div>
        </header>
        <!--Home page style-->
        
        
         <!-- Sections -->
        <section id="bener5" class="">
            <div class="bener_overlay5">
                <div class="container">
                    <div class="bener_content">
                        <h2>Welcome to PREMA COMPUTERS</h2>
                        <!-- <p>Welcome to the Wapik Welcome to the WapikWelcome to the WapikWelcome to the Wapik</p> -->
                        </div>
                </div> <!-- /container -->
            </div>
        </section>
      
        <section id="our_features">
            <div class="container">
                <div  class="features_top text-center">
                    <h2 class="title_border">SIGN IN</h2>
                    <div class="separator" ></div>
                </div>

                <div class="features_contant">
                    <div class="row">
                    
                        <form method="get"  action="LoginServlet">
                                        <div class="row">
                                            <div class="col-lg-6">
                                               
                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input name="email"  class="form-control" type="email"  placeholder="Email" required="true" />
                                                </div>
                                                <div class="form-group">
                                                    <label>PassWord</label>
                                                     <input name="password"  class="form-control" type="password"  placeholder="Password" required="true" />
                                                      </div>
                                            
                                                 <div class="form-group">
                                            <div align="center" class="col-sm-offset-2 col-sm-10">
                                                <button  type="submit" class="btn btn-default">SignIn </button>
                                            </div>
                                            </div>
                                                                                       
                                            </div>
                                        </div>
                                      </form>

                    </div>
                </div>
            </div>
        </section>

<%@include file="swAssets/include/footer.jsp"%>