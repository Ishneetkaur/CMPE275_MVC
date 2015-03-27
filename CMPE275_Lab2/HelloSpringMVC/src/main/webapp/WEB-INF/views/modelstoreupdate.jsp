<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Update Profile Information</title>
<style>
.error  {color: #ff0000; font-weight: bold; }
</style>
<script type="text/javascript">
		function buttonClicked(text){
			var mode=document.getElementById("mode");
			var value=document.getElementById("firstname").value;
			alert(value);
			mode.value=text;
			form.submit();
		}
	</script>
</head>
<h2>Personal Profile Information</h2>
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
		<input type="submit" name="update"  onclick="buttonClicked('update');" value = "UPDATE" />
		<input type="submit" id="delete" name="delete"   onclick="buttonClicked('delete');" value = "DELETE" />
		<input type="submit" id="brief" name="brief"   onclick="buttonClicked('brief');" value = "BRIEF" />
        </form>
</body>

</html>