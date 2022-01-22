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
			
				
			
					<c:forEach var="blog" items="${blogs.content}">
					<c:url var="updateLike" value="/user/updateLike">
								<c:param name="blogId" value="${blog.id}" />
					</c:url>
					<c:url var="detailBlog" value="/user/detailBlog">
								<c:param name="blogId" value="${blog.id}" />
					</c:url>
				<div class="chung">
					<div class="hieu_ung"  >
						<div class="noi_dung">
							<img src="../resources/images/${blog.image}" width="100px" height="100px" class="img-thumbnail" >
							<a class="hovera" href="${detailBlog}"style="color: #fff;position:absolute;margin-top:20px;margin-left:20px;padding-right:50px">${blog.title}</a>						
							<a class="hovera" href="${updateLike}" style="color: #red;position:absolute;margin-top:20px;margin-left:400px;padding-right:50px">❤ ${blog.like}</a>
							<a class="hovera" href="{% url 'product' pro.id %}"style="color: #red;position:absolute;margin-top:150px;margin-left:20px;padding-right:50px"> ${blog.category.catName}</a>
							
							
							
						</div>
					</div>
					
						
					</div>
					<p>Tag:</p>
						 <c:forEach var="tag" items="${blog.tagnames}">
								<a class="hovera" href="{% url 'product' pro.id %}" style="color:red"> ${tag.name}</a>
							</c:forEach>
						</c:forEach>
						<div>
				  <div class="d-flex flex-row align-items-center">
				      <c:if test="${blogs.hasPrevious()}">
				           <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                   onclick="location.href = 'page?'">&laquo; first</button>
				           <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                    onclick="location.href = 'page?page=${blogs.number - 1}'">previous</button>
				      </c:if>
				
				      <c:if test="${blogs.totalPages != 1}">
				            <label style="margin: 2px 8px 2px 8px">
				                 Page ${blogs.number +1 } of     ${blogs.totalPages}
				            </label>
				      </c:if>
				
				      <c:if test="${blogs.hasNext()}">
				            <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                   onclick="location.href = 'page?page=${blogs.number + 1}'">next</button>
				            <button type="submit" class="btn btn-primary btn-md" style="margin: 2px"
				                   onclick="location.href = 'page?page=${blogs.totalPages -1}'">last &raquo;</button>                                    
				      </c:if>
				    </div> 
				</div>
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
<style>
	.noi_dung a:hover{
		text-decoration: none;
		
	}
		.hovera{
			text-decoration: none;
		}
		.hovera:active{
		text-decoration: none;
		}
		.hovera:hover{
			
		}
		.chung{
		
			width: 1000px;
          
           
            background: #000;

		}
		.linkkk{
	
		width: 100px;
		
	}
	   .hieu_ung {
		   margin-top: 10px;
		   
		   /* float: left; */
            /* position: absolute; */
			
			/* margin-left: 10px; */
			
            /* top: 50%;
            left: 50%; */
            /* transform: translate(-50%, -50%); */
            width: 360px;
            height: 200px; 
            overflow: hidden;
            background: #000;
        }

        .noi_dung {
            width: 100%;
            height: 100%;
        }

        img {
            width: 100%; 
             transition: 0.5s; 
			 image-rendering: pixelated;
			 transform: scale(1.3);
            opacity: 0.5;
        }

        .hieu_ung:hover img {
            transform: rotate(-10deg) scale(2);
            opacity: 1;
        }

        .phu_de {
            /* position: absolute;
            top: 40px;
            left: 40px;
            right: 40px;
            bottom: 40px; */
            /* background:#fff; */
        }


        .phu_de::before {
            /* content: '';
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            border-top: 1px solid #fff;
            border-bottom: 1px solid #fff;
            box-sizing: border-box;
            transition: 0.5s;
            transform: scale(0, 1) */
        }


        .hieu_ung:hover .phu_de:before {
            transform: scale(1, 1)
        }

        .phu_de::after {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            border-left: 1px solid #fff;
            border-right: 1px solid #fff;
            box-sizing: border-box;
            transition: 0.5s;
            transform: scale(1, 0)
        }


        .hieu_ung:hover .phu_de:after {
            transform: scale(1, 1)
        }


        /* .thong_tin {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            z-index: 1;
            padding: 20px;
            text-align: center;
            opacity: 0;
            transition: 0.5s;
            margin-left: 200px;
        } */

        .hieu_ung:hover .thong_tin {
            opacity: 1;
        }

        /* .thong_tin h3 {
            color: #fff;
            margin: 0;
            padding: 0;
            font-size: 24px;
            text-transform: uppercase;
        }

        .thong_tin p {
            color: #fff;
            margin: 20px 0 0;
            padding: 0;
            font-size: 15px;
        }
        .thong_tin a{
            text-decoration:none;
        } */
</style>

