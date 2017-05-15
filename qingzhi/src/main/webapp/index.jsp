<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Login page</title>
</head>
<body>
	<div id="loginDiv">
		<form id="ff" method="post" action="<%=request.getContextPath() %>/login">
			<div>
				<label for="username">账号:</label>
				<!-- 采用 js验证 -->
				<input type="text" name="username" />
			</div>
			<div>
				<label for="password">密码:</label>
				<!-- 行内验证
				<input class="easyui-validatebox" type="text" name="name"
					data-options="required:true,missingMessage:'请填写密码！'" />
					 -->
				<input type="text" name="password" />
			</div>
			<div>
				<input type="submit" value="提交" />
			</div>
		</form>
		
	</div>
	
</body>
</html>
