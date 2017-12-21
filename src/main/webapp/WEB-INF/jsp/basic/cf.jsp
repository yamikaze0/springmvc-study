<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web请求三种格式</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var user = {
                id: 1,
                username: "yamikaze",
                password: "xyz"
            };

            function callback(r) {
                alert(r);
            }

            $("#thj").click(function () {
                $.ajax({
                    type: "POST",
                    contentType: "text/plain",
                    url: "thj",
                    data: user,
                    success: callback
                });
            });

            $("#thn").click(function () {
                $.ajax({
                    type: "POST",
                    contentType: "text/plain",
                    url: "thn",
                    data: user,
                    success: callback
                });
            });

            $("#jj").click(function () {
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "jj",
                    data: JSON.stringify(user),
                    success: callback
                });
            });

            $("#jn").click(function () {
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "jn",
                    data: JSON.stringify(user),
                    success: callback
                });
            });

            $("#axj").click(function () {
                $.ajax({
                    type: "POST",
                    url: "axj",
                    data: user,
                    success: callback
                });
            });

            $("#axn").click(function () {
                $.ajax({
                    type: "POST",
                    url: "axn",
                    data: user,
                    success: callback
                });
            });

        });
    </script>
</head>
<body>
<input value="触发text/html格式的请求, 接收方为json格式" id="thj" type="button"/>
<br/>
<input value="触发text/html格式的请求, 接收方为普通格式" id="thn" type="button"/>
<br/>
<input value="触发json格式的请求, 接收方为json格式" id="jj" type="button"/>
<br/>
<input value="触发json格式的请求, 接收方为普通格式" id="jn" type="button"/>
<br/>
<input value="触发application/x-...格式的请求, 接收方为json格式" id="axj" type="button"/>
<br/>
<input value="触发application/x-...格式的请求, 接收方为普通格式" id="axn" type="button"/>
<br/>
<%--
    普通form表单默认以
--%>
<form method="post" enctype="application/x-www-form-urlencoded">
    <label>姓名:</label><input name="username" value = "yamikaze" id = "username"/><br/>
    <label>密码:</label><input name="password" value = "yamikaze" id = "password"/><br/>
    <input type="submit" value="提交表单"/>
</form>
</body>
</html>
