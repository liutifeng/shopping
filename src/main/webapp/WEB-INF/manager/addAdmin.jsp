<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <title>首页</title>
 <%String path=request.getContextPath(); 
//System.out.println("path:"+path);
%>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css" >
<script type="text/javascript" src="<%=path%>/js/common/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/bootstrap.min.js"></script>
<style type="text/css">


</style>
</head>
<body>

<div style="width: 800px; height: 800px; margin: 0 auto; margin-top: 50px;" >
<form class="form-horizontal center-block" role="form" >
  <div class="form-group" >
    <label for="firstname" class="col-sm-2 control-label">用户名：</label>
    <div class="col-sm-6" >
      <input type="text" class="form-control" id="tname" placeholder="请输入用户名">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码：</label>
    <div class="col-sm-6" >
      <input type="password" class="form-control" id="pwd" placeholder="请输入密码">
    </div>
  </div>
  
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">手机号：</label>
    <div class="col-sm-6" >
      <input type="text" class="form-control" id="tel" placeholder="请输入手机号">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10" >
      <button type="button" class="btn btn-primary " style="width: 80px;" onclick="addAdminInfo()">添   加</button>
    </div>
  </div>
</form>
</div>
</body>
<script type="text/javascript">
//添加管理员
 function addAdminInfo(){
	 var aname=$('#tname').val();
	 var tel=$('#tel').val();
	 var pwd=$('#pwd').val();
	 if(''==aname.trim()){
		 alert('请输入管理员名....')
		 return ;
	 }
	 
	 if(''==pwd.trim()){
		 alert('请输入管理员密码...');
		 return ;
	 }
	 
	 if(''==tel.trim()){
		 alert('请输入管理员手机号码...');
		 return ;
	 }
	 
	 $.post('../admin/add',{aname:aname,pwd:pwd,tel:tel},function(data){
		 data=parseInt(data.trim());
		 if(data>0){
			 alert('添加成功！');
			 $('#tname').val('');
			  $('#tel').val('');
			  $('#pwd').val('');
		 }else{
			 alert('管理员信息添加失败，请稍后再试...');
		 }
	 },'text');
	 
 }

 </script>


</html>