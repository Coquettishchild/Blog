//获取用户信息
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
window.index=1;
getList();
function last(){
	console.log(index);
    if(index<=1){
        alert("已经是第一页了")
    }else{
        index--;
        getList();
    }
};
function next(){
	console.log(index);
    index++;
    getList();
};
//获取文章列表
function getList(){
    $.ajax({
        type:'post',
        url: 'GetPapers.action',
        data: {
            "index":index
        },
        success:function (data) {
            var json = JSON.parse(data);
            if(json.data.flag){
                if(json.data.obj.length!=0){
                	 $('#blog').html("");
                	 var ids = new Array();
                    for(let i=0;i<json.data.obj.length;i++){
                        ids[i]=json.data.obj[i].id;
                        $('#blog').html($('#blog').html()+" <div class='blog-main'> " +
                            "<div class='heading-blog'> " +
                            "<a href='singlepost.html?id="+json.data.obj[i].id+"' class='more' >"+json.data.obj[i].name+ "</a>" +
                            "</div>" +
                            "<div class='blog-info'>" +
                            " <span class='label label-primary' >Posted on "+json.data.obj[i].createtime+"</span>" +
                            " <span class='label label-danger'>By "+json.data.obj[i].author+"</span>" +
                            " <button  class='label label-danger'  onclick='up("+json.data.obj[i].id+")' >修改</button>" +
                            " <button class='label label-danger' onclick='del("+json.data.obj[i].id+")' >删除</button>"+
                            " </div>" +
                            "<div class='blog-txt'>" +
                            json.data.obj[i].infor+
                            "</div>" +
                            "</div>")
                    }
                    sessionStorage.id=ids;
                }else{
                    index--;
                    alert("没有更多数据了")
                }

            }
        }
    });
}
function up(id){
    window.location.href="./updata.html?id="+id;
}
function del(id) {
    $.ajax({
       type:'post',
       url:"DeleteArticle.action",
       data:{
           id:id
       } ,
       success:function (data) {
           try{
               var json = JSON.parse(data);
               if(json.data.flag){
                    alert("删除成功");
                    window.location.href="./index.html";
               }else{
                   alert("删除失败");
               }
           }catch (e) {
                console.log(e);
                alert("删除失败");
           }
       }
    });
}

