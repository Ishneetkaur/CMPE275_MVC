<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment 2 - CMPE 275</title>
</head>
<body>
<form method="post">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">Your Details</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
				<td>User ID</td>
				<td><input id="userid" name="userid" type="text" value='${userid}' /></td>
			</tr>
			
			<tr>
				<td>First Name</td>
				<td><input id="firstname" name="firstname" type="text" value='${firstname}' /></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><input id="lastname" name="lastname" type="text"  value='${lastname}' /></td>
			</tr>
			
			<tr>
				<td>Email-ID</td>
				<td><input id="email" name="email" type="text"   value='${email}'/></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td><input id="address" name="address" type="text"  value='${address}' /></td>
			</tr>
			
			<tr>
				<td>Organization</td>
				<td><input id="organization" name="organization" type="text"  value='${organization}' /></td>
			</tr>
			
			<tr>
				<td>About Myself</td>
				<td><input id="aboutMyself" name="aboutMyself" type="text"  value='${aboutMyself}' /></td>
			</tr>
                </tbody>
            </table>
            <input type="hidden" id="mode" name="mode" value="" />
		<button  id="submit" name="submit"  type="submit" onclick="buttonClicked('submit');" >CREATE</button>
        </form>
</body>
</html>