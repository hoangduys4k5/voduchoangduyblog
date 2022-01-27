<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<%@include file="includes/header.jsp" %>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP + MySQL
				Example - Customer Management</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Blog</div>
				</div>
				<div class="panel-body">
					<form:form method="POST" action="saveBlog" enctype="multipart/form-data"
						 modelAttribute="blog">

						<!-- need to associate this data with customer id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="title" class="col-md-3 control-label">Title</label>
							<div class="col-md-9">
								<form:input path="title" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="content" class="col-md-3 control-label">Content</label>
							<div class="col-md-9">
								<form:input path="content" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="image" class="col-md-3 control-label">Image</label>
							<div class="col-md-9">
								<%-- <form:input path="image" cssClass="form-control" /> --%>
								<input type="file" path="image" name="file" />
							</div>
						</div>
						<div class="form-group">
					
					
					<!--    File: <input type="file" accept="image/*" name="file" /> <br /> <br/> -->
			<!-- <input type="file" name ="photo" accept="image/*" cssClass="form-control" placeholder="Hình ảnh" /> -->
					
				
							
						</div>
						<div class="form-group">
							<label for="category" class="col-md-3 control-label">Category</label>
							<div class="col-md-9">
								<form:select path = "category">
				                     <form:option value = "" label = "Select"/>
				                     <c:forEach var="cat" items="${category}">
      									<form:option value="${cat.id }" label="${cat.catName}" 
      									selected="${cat.id==blog.category.id?'selected':''}"
      									/>
   									 </c:forEach>
   
				                  </form:select> 
							</div>
						</div>
						<div class="form-group">
							<label for="tagname" class="col-md-3 control-label">Tagname</label>
							<div class="col-md-9">
								
								<form:select path = "tagnames" multiple="true" 
									itemValue="id"  itemLabel="name" items="${tagname}">
								</form:select> 
							</div>
						</div>
  
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button  cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>
					</form:form> 
					<%-- <form:form method="POST" action="saveBlog" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label>Select a file to upload</label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form> --%>
				</div>
			</div>
		</div>
	</div>
</body>
</html> 