var url = location.href;
try {
    var paraString = url.substring(url.indexOf("=") + 1, url.length);
} catch (e) {
    alert("没有此问卷");
    window.location.href = "./index.html";
}
$.ajax({
	   type:'post',
	    url:'GetUser.action',
	   data:null,
	    success:function (data) {
		    try{
		    	var json = JSON.parse(data);
		        $('#photos').attr('src',"./photos/"+json.data.obj.photos);
		        $('#name').html(json.data.obj.username);
		        $('#major').html(json.data.obj.major);
		        $('#infor').html(json.data.obj.information);    	
		    }catch (e) {
		    	alert("请先登录");
		    	window.location.href="./login.html";
		    }
	    }
	});

$.ajax({
    type:'post',
    url: 'GetonePaper.action',
    data: {
        "id":paraString
    },
    success:function (data) {
        var json = JSON.parse(data);
        if(json.data.flag){
            if(json.data.obj.length!=0){
                $('#blog').html("");
                    $('#blog').html($('#blog').html()+" <div class='blog-main'> " +
                        "<div class='heading-blog'> " +
                         json.data.obj.name +
                        "</div>" +
                        "<div class='blog-info'>" +
                        " <span class='label label-primary' >Posted on "+json.data.obj.createtime+"</span>" +
                        " <span class='label label-danger'>By "+json.data.obj.author+"</span>" +
                        " </div>" +
                        "<div class='blog-txt'>" +
                        json.data.obj.content+
                        "</div>" +
                        "</div>")
                }

            }else{
                index--;
                alert("没有更多数据了")
            }

        }
    });

