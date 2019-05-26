function save() {
	var context = UE.getEditor('myEditor').getContent();
	var papername = $('#papaername').val();
	var infor = $('#infor').val();
	if (papername == null || papername == "") {
		alert("文章名称不能为空");
	} else {
		var obj = new Object();
		obj.papername = papername;
		obj.context = context;
		obj.infor = infor;
		$.ajax({
			type : 'post',
			url : 'AddPaper.action',
			data : {
				"papername" : papername,
				"infor" : infor,
				"context" : context
			},
			success : function(data) {
				var json = JSON.parse(data);
				if(json.data.flag){
					alert("添加成功");
					window.location.href="./index.html";
				}else{
					alert(json.data.message);
					window.location.href="./uedit.html";
				}
			}
		})
	}

}
