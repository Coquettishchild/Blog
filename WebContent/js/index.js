
$.ajax({
   type:'post',
    url:'GetUser',
   data:null,
    success:function (data) {
        var json = JSON.parse(data);
        $('#photos').attr('src',"./photos/"+json.data.obj.photos);
        $('#name').html(json.data.obj.username);
        $('#major').html(json.data.obj.major);
        $('#infor').html(json.data.obj.information);
    }
});
