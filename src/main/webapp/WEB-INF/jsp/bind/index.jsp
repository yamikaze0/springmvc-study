<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发起时间参数请求</title><script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            function callback(r) {
                alert(r);
            }

            $("#thj").click(function () {
                var dateModel = {};
                dateModel.date = $("#cc").val();
                $.ajax({
                    type: "POST",
                    url: "date",
                    data: dateModel,
                    success: callback
                });
            });



            $("#only").click(function () {
                var dateModel = {};
                dateModel.date = $("#cc").val();
                $.ajax({
                    type: "POST",
                    url: "onlyDate",
                    data: dateModel,
                    success: callback
                });
            });

        });
    </script>
</head>
<body>
<input value="发送时间" id="thj" type="button"/>
<input value="发送时间only" id="only" type="button"/>
<label>输入时间：</label><input id="cc" name="text" value="1995-10-01"/>
<br/>

</body>
</html>
