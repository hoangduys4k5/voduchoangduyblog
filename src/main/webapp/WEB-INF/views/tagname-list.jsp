<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@include file="includes/header.jsp" %>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Spring MVC 5 + Spring Data JPA 2 + JSP +
				MySQL Example - Customer Management</h3>
			<hr />

			<input type="button" value="Add tag"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">tagname List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Tag</th>
				
							<th>Action</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="tag" items="${tagnames}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/tagname/updateForm">
								<c:param name="tagnameId" value="${tag.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/tagname/delete">
								<c:param name="tagnameId" value="${tag.id}" />
							</c:url>

							<tr>
								<td>${tag.name}</td>
								
								
								
								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this tag?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>









