var url = location.href;
try {
	var paraString = url.substring(url.indexOf("=") + 1, url.length);
} catch (e) {
	alert("没有此文章");
	window.location.href = "./index.html";
}
$.ajax({
	type:'post',
	url:'GetonePaper.action',
	data:{
		"id":paraString
	},
	success:function (data) {
		try {
			var json = JSON.parse(data);
			console.log(json);
			if (json.data.flag){
				$('#papaername').val(json.data.obj.name);
				$('#infor').text(json.data.obj.infor);
				UE.getEditor('myEditor').setContent(json.data.obj.content);
			}
		}catch (e) {
			console.log(e);
			alert("发生异常");
			window.location.href="./index.html";
		}

	}
});
function save() {
	var context = UE.getEditor('myEditor').getContent();
	var papername = $('#papaername').val();
	var infor = $('#infor').val();
	if (papername == null || papername == "") {
		alert("文章名称不能为空");
	} else {
		$.ajax({
			type : 'post',
			url : 'UpdataPaper.action',
			data : {
				"id":paraString,
				"papername" : papername,
				"infor" : infor,
				"context" : context
			},
			success : function(data) {
				var json = JSON.parse(data);
				if(json.data.flag){
					alert("修改成功");
					window.location.href="./index.html";
				}else{
					alert(json.data.message);
					window.location.href="./uedit.html";
				}
			}
		})
	}

}
