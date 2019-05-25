
function save(){
    var context=UE.getEditor('myEditor').getContent();
    var papername = $('#papaername').val();
    var infor =$('#infor').val();
    if(papername==null||papername==""){
        alert("文章名称不能为空");
    }else{
         var obj = new Object();
         obj.papername=papername;
         obj.context=context;
         obj.infor=infor;
         console.log(JSON.stringify(obj));
         $.ajax({
             type:'post',
             url:'AddPaper',
             data:{
            	 "papername":papername,
            	 "context":context
             },
             success:function (data) {
                 if(data.data.obj.flag){
                     alert("提交成功");
                 }else{
                     alert("提交失败");
                 }
             }
         })
    }

}
