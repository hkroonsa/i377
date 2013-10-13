<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Search</title>
<style><%@ include file="style.css"%> </style>
</head>
<body>
	<ul id="menu">
    <li><a href="Search" id="menu_Search">Otsi</a></li>
    <li><a href="Add" id="menu_Add">Lisa</a></li>
    <li><a href="Admin?do=clear_data" id="menu_ClearData">Tühjenda</a></li>
    <li><a href="Admin?do=insert_data" id="menu_InsertData">Sisesta näidisandmed</a></li>    
</ul>
<br /><br /><br />
	<form method="get" action="Search">
		<input name="searchString" id="searchStringBox" value="" /> 
		<input type="submit" id="filterButton" value="Filtreeri" /> 
		<br /> <br />
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="unit" items="${units}">
					<tr>
						<td>
							<div id="row_${unit.code}">
								<c:out value="${unit.name}"></c:out>
							</div>
						</td>
						<td>${unit.code}</td>
						<td><a href="Search?do=delete&id=${unit.id}"
							id="delete_${unit.code}">Kustuta</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>