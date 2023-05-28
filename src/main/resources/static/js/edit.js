'user strict'


jQuery(function($){
	
	$('#btn-update').click(function(event){
		updateUser();
	});
});

function updateUser(){
	var userData = $('#user-data').serializeArray();
	
	$.ajax({
		type : "PUT",
		cache : false,
		url : '/user/update',
		data : userData,
		dataType : 'json'
	}).done(function(data){
		alert('ユーザー更新に成功しました');
		window.location.href = '/user/list';
	}).fail(function(jqXHR,textStatus,errorThrown){
		alert('ユーザー更新に失敗しました')
	}).always(function(){
		
	});
}