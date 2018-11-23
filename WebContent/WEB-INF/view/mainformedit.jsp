<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring4 hibernate5</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/font-awesome.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js" />"></script>
</head>
<body>
	<h2>Student Details Edit Form</h2>
	<h3>
		<spring:message code="label.rajesh" />
	</h3>
	<h3>
		<spring:message code="label.welcomeToSpring" />
	</h3>
	<form:form method="post" action="update" commandName="student">
		<form:hidden path="id" name="id" id="id" />
		<table>
			<tr>
				<td><form:label path="name">
						<spring:message code="label.name" />
					</form:label></td>
				<td><form:input path="name" name="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><form:label path="contact">
						<spring:message code="label.contact" />
					</form:label></td>
				<td><form:input path="contact" name="contact" /></td>
				<td><form:errors path="contact" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.edit"/>" /></td>
			</tr>
		</table>
	</form:form>

	<div class="container">
		<div class="row col-md-6 col-md-offset-2 custyle">
			<c:if test="${!empty studentList}">
				<a href="<c:url value="/" />"
					class="btn btn-primary btn-md pull-left"><b>+</b> Add New
					Student</a>
				<table class="table table-striped custab">
					<thead>

						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Contact</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<c:forEach items="${studentList}" var="std">
						<tr>
							<td>${std.id}</td>
							<td>${std.name}</td>
							<td>${std.contact}
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="${std.id}"><span class="glyphicon glyphicon-edit"></span>
									Edit</a> <a href="/SpringMVC4.3.5Hibernate5.1.2/delete/${std.id}"
								class="btn btn-danger btn-xs"><span
									class="glyphicon glyphicon-remove"></span> Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>