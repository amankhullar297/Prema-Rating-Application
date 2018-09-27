<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <%@page import="com.dto.GeneralDTO"%>
<html class="no-js" lang=""> <!--<![endif]-->
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
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="swAssets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
         <!-- <link href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">	
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
         -->
       
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
        
        <form action="SendFeedback">
   
        <div style="text-align:center">
       <h1> Select course <br/>  </h1>
  <select name="course" >
  <option value="C" >C</option>
  <option value="C++">C++</option>
  <option value="JAVA">JAVA</option>
  <option value="HADOOP">HADOOP</option>
  <option value="BIG-DATA">BIG-DATA</option>
  </select>  
  </div>
  <br/>
 <div style="text-align:center">       
<fieldset class="rating">
    <h1>Please rate:</h1>
    	<div class="row lead">
        <div id="stars" class="starrr"></div>
        <div style="display:none">
        You gave a rating of <span id="count">0</span> star(s)
        </div>
        
	</div>
   
   	<input name ="rate" id="myrate" type="hidden">
   	 <input  type="submit"  onclick="w()" value="submit rating"> 
   	                                       
  
   
   
</fieldset>
 </div> 
 
 
   </form>
 <%GeneralDTO gdt=(GeneralDTO)request.getAttribute("status");
 String course=(String)request.getAttribute("course");
 if(gdt!=null){
 if(gdt.getStatus()){
 %>
 <h1>You Rated For <%=course%> </h1>
 <% } } %>
</body>
<%@include file="swAssets/include/footer.jsp"%>
<script>
function w(){
var x=$('#count').html();
$('#myrate').val(x);
//alert($('#myrate').val());
}
</script>

