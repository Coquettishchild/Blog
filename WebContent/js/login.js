var btn = $('#denglu');
btn.click(
    function () {
        var username = $('#username').val();
        var password =$('#password').val();
        var user = new Object();
        user.username=username;
        user.password=password;
        
        $.ajax({
            type:'post',
            url:'Login',
            contentType:"application/json;charset=utf8",
            dataType:'json',
            data:JSON.stringify(user),
            success:function (data) {
            	console.log(data);
                if(data.data.flag){
                    window.location.href="../Blog/index.html";
                }else{
                    alert(data.data.message);
                }
            }
        })
    }
);

