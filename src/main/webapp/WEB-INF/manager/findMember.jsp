<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%String path=request.getContextPath(); 
//System.out.println("path:"+path);
%>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" >
<script type="text/javascript" src="<%=path%>/js/common/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-inline" role="form" style="margin-left: 10px;margin-top: 8px;">
  <div class="form-group">
    <label  for="name">手机号搜索：</label>
    <input type="text" class="form-control" id="membertel" placeholder="请输入手机号">
  </div>
  <button type="button" class="btn btn-default" onclick="javascript:findMember()">确认</button>
</form>
<hr/>
<table class="table table-striped">
  <thead>
    <tr>
	    <th width="10%">编号</th>
		<th width="20%">姓名</th>
		<th width="10%">性别</th>
		<th width="20%">联系方式</th>
		<th width="20%">邮箱</th>
		<th width="10%">操作</th>
		<th width="10%">用户状态</th>
  </thead>
  <tbody id="member_info">
    
  </tbody>
</table>
<ul class="pagination" id="pagination_info">
    <!-- <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li> -->
</ul>
</body>
<script type="text/javascript">
var page = 1;
var size = 3;
$(function(){
	findPage(page);
	$.post('../../login/member/totalPage',null,function(data){
		pageInfo(data);
	});
});

// 查看所有
function findAll(){
	$.get("../../login/member/findAll",null,function(data){
		// 显示管理员信息
		util(data);
		
	})
}

function findMember(){
	var tel = $('#membertel').val();
	$.get("../../login/member/findMember",{membertel:tel},function(data){
		// 显示管理员信息
		util(data);
	});
}

// 重置密码
function resetPwd(mno){
	$.get("../../login/member/update",{mno:mno},function(data){
		 data=parseInt(data.trim());
		 if(data>0){
			 alert('用户密码已重置为手机号码后6位，请提醒用户及时修改...');
		 } else{
			 alert('用户密码重置失败...');
		 }
	},'text');
}

// 修改状态
function updateState(mno,status){
	$.post('../../login/member/updateState',{mno:mno,status:status},function(data){
		findPage(page);
	 },'text');
}

//分页
function findPage(page){

	$.post('../../login/member/findByPage',{page:page,size:size},function(data){
		// 显示管理员信息
		util(data);
		// 显示分页信息
		$('#pagination_info');
	});
}

//统计页数
function pageInfo(total){
	var totalPage = Math.ceil(total/size);
	var str = '<li><a href="javascript:findPage(1)">1</a></li>';
	for(var i=2;i<=totalPage;i++){
		str+='<li><a href="javascript:findPage('+i+')">'+i+'</a></li>'
	}
	$('#pagination_info').html('').append(str);;
}

//显示表格
function util(data){
	var str="";
	$.each(data,function(index,item){
		if(item.status==1){
			str+='<tr><td>'+item.mno+'</td><td>'+item.nickname+'</td><td>'+item.sex+'</td>'
			+'<td>'+item.tel+'</td><td>'+item.email+'</td>'
			+'<td><a href="javascript:resetPwd('+item.mno+')">[重置密码]</a></td><td><a href="javascript:updateState('+item.mno+','+item.status+')">[可用]</a></td></tr>';
		}
		if(item.status==0){
			str+='<tr><td>'+item.mno+'</td><td>'+item.nickname+'</td><td>'+item.sex+'</td>'
			+'<td>'+item.tel+'</td><td>'+item.email+'</td>'
			+'<td><a href="javascript:resetPwd('+item.mno+')">[重置密码]</a></td><td><a href="javascript:updateState('+item.mno+','+item.status+')">[禁用]</a></td></tr>';
		}
	});
	console.log(data);
	$('#member_info').html('').append(str);
}


</script>
</html>