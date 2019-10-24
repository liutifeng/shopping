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
    <label  for="name">用户名搜索：</label>
    <input type="text" class="form-control" id="adminname" placeholder="请输入用户名">
  </div>
  <button type="button" class="btn btn-default" onclick="javascript:findAdmin()">确认</button>
</form>
<hr/>
<table class="table table-striped">
  <thead>
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>联系方式</th>
      <th>操作</th>
      <th>管理员状态</th>
  </thead>
  <tbody id="admin_info">
 
    
  </tbody>
</table>
<ul id="pagination_info" class="pagination">
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
	//findAll();
	findPage(page);
	$.post('../admin/totalPage',null,function(data){
		pageInfo(data);
	});
	//findTotal();
	
	
});

// 查看所有方法
function findAll(){
	$.get("../admin/findAll",null,function(data){
		util(data);
	});
	
}
//重置密码 
function resetPwd(aid){
	 $.post('../admin/update',{aid:aid},function(data){
		 data=parseInt(data.trim());
		 if(data>0){
			 alert('管理员密码已重置为手机号码后6位，请提醒用户及时修改...');
		 } else{
			 alert('管理员密码重置失败...');
		 }
		 
	 },'text');
	 
}

// 通过用户名查询
function findAdmin(){
	var aname = $('#adminname').val();
	$.get("../admin/findAdmin",{adminname:aname},function(data){
		util(data);
	});
}


// 修改状态
function updetaStatus(aid,status){
	$.post('../admin/updateSta',{aid:aid,status:status},function(data){
		findPage(page);
	 },'text');
	
}

// 分页
function findPage(page){
	$.post('../admin/findByPage',{page:page,size:size},function(data){
		// 显示管理员信息
		util(data);
		// 显示分页信息
		$('#pagination_info');
	});
}

// 统计页数
function pageInfo(total){
	var totalPage = Math.ceil(total/size);
	var str = '<li><a href="javascript:findPage(1)">1</a></li>';
	for(var i=2;i<=totalPage;i++){
		str+='<li><a href="javascript:findPage('+i+')">'+i+'</a></li>'
	}
	$('#pagination_info').html('').append(str);;
}




// 显示表格
function util(data){
	var str="";
	$.each(data,function(index,item){
		if(item.status==0){
			str+='<tr><td>'+item.aid+'</td><td>'+item.aname+'</td><td>'+item.tel+'</td><td><a href="javascript:resetPwd('+item.aid+')">[重置密码]</a></td><td><a href="javascript:updetaStatus('+item.aid+','+item.status+')">[禁用]</a></td></tr>';
		}
		if(item.status==1){
			str+='<tr><td>'+item.aid+'</td><td>'+item.aname+'</td><td>'+item.tel+'</td><td><a href="javascript:resetPwd('+item.aid+')">[重置密码]</a></td><td><a href="javascript:updetaStatus('+item.aid+','+item.status+')">[可用]</a></td></tr>';
		}
	});
	console.log(data);
	$('#admin_info').html('').append(str);
}

</script>

</html>