<html>
<body>
<h2>Hello World!</h2>

<button id="btn">click me</button>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script>
    document.getElementById('btn').onclick=function (event) {
        $.ajax({
            url:"/user/new/1",
            type:"put",//不区分大小写，PUT亦可
            data:{
                userName:'Liu'
            },
            success:function(result){
                alert(result);
            }
        });
    }
</script>
</body>
</html>
