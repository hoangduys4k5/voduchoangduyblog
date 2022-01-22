<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Hoàng Duy</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP +
				MySQL Example - Customer Management</h3>
			<hr />

			<input type="button" value="Add Blog"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div>
				 <form>
				        Search by first name:
				        <input name="s" type="text"/>
				        <input type="submit" value="Search"/>
				    </form>
				<br/>
				</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Customer List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Title</th>
							<th>Content</th>
							<th>Images</th>
							<th>Likes</th>
							<th>Tagname</th>
							<th>comment</th>
							<th>category</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="blog" items="${blogs.content}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/blogadmin/updateForm">
								<c:param name="blogId" value="${blog.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/blogadmin/delete">
								<c:param name="blogId" value="${blog.id}" />
							</c:url>

							<tr>
								<td>${blog.title}</td>
								<td>${blog.content}</td>
								<td><img src="../resources/images/${blog.image}" width="50px" height="40px"></td>
								<td>${blog.like}</td>
								<td>
									<c:forEach var="tag" items="${blog.tagnames}">
									<span class="btn-sm">${tag.name}</span>
									</c:forEach>
								</td>
								<td>
								<c:forEach var="cmt" items="${blog.comments}">
									<span class="btn-sm">${cmt.cmt}</span>
									</c:forEach>
								</td>
								<td>${blog.category.catName}</td>
								
								
								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
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
			</div>
		</div>

	</div>
	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>









