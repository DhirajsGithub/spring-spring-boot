<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
<title>Todos</title>
</head>
<body>

<h1>Todos for ${name}</h1>
<h1>Your Todos</h1>
<table class="table">
	<thead>
		<tr>
			<th>Description</th>
			<th>Target Date</th>
			<th>Is Done?</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>		
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.description}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>