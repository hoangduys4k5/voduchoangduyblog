<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<head>
	<!-- templatemo 419 black white -->
    <!-- 
    Black White
    http://www.templatemo.com/preview/templatemo_419_black_white
    -->
	<title>Blog-Võ Đức Hoàng Duy</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="//fonts.googleapis.com/css2?family=Raleway:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Nunito:400,700&display=swap" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">
	<link href="../resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/templatemo_style.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="templatemo-logo visible-xs-block">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg logo-left-container">
			<h1 class="logo-left">Black</h1>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg logo-right-container">
			<h1 class="logo-right">White</h1>
		</div>			
	</div>
	<div class="templatemo-container">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container">
			<h1 class="logo-left hidden-xs margin-bottom-60">Black</h1>			
			<div class="tm-left-inner-container">
				<ul class="nav nav-stacked templatemo-nav">
				  <li><a href="page" class="active"><i class="fa fa-home fa-medium"></i>Homepage</a></li>
				  <li><a href=""><i class="fa fa-shopping-cart fa-medium"></i>TagName</a></li>
				  <li><a href="{% url 'services' %}"><i class="fa fa-send-o fa-medium"></i>Category</a></li>
				  
				  <li><a href="{% url 'blog:all_blogs' %}"><i class="fa fa-comments-o fa-medium"></i>Blog</a></li>
				  <li><a href="{% url 'about' %}"><i class="fa fa-gears fa-medium"></i>About Us</a></li>
				  <li><a href="../blogadmin/page"><i class="fa fa-envelope-o fa-medium"></i>Admin</a></li>
				</ul>
			</div>
		</div> <!-- left section -->
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
			<h1 class="logo-right hidden-xs margin-bottom-60">White</h1>		
			<div class="tm-right-inner-container">
				<h1 class="templatemo-header">Blog-Võ Đức Hoàng Duy</h1>
			
				
			
					<article class="templatemo-item">
					<h2>${blog.title}</h2>
					<img src="../resources/images/${blog.image}" width="50px" height="40px" alt="Gutman Island" class="img-thumbnail">
					<h4>${blog.content}</h4>															
					<!-- <a href="#" class="btn btn-warning">Buy</a>			 -->
				</article><hr>
						
				<footer>
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-copyright">Copyright &copy; 2084 Your Company Name <!-- Credit: www.templatemo.com --></p>
					<p class="col-lg-6 col-md-6 col-sm-12 col-xs-12 templatemo-social">
						<a href="#"><i class="fa fa-facebook fa-medium"></i></a>
						<a href="#"><i class="fa fa-twitter fa-medium"></i></a>
						<a href="#"><i class="fa fa-google-plus fa-medium"></i></a>
						<a href="#"><i class="fa fa-youtube fa-medium"></i></a>
						<a href="#"><i class="fa fa-linkedin fa-medium"></i></a>
					</p>
				</footer>
			</div>	
		</div> <!-- right section -->
	</div>	
	
</body>

