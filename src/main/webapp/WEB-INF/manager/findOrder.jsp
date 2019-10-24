<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看订单</title>
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
	<label>按时间查询：</label>
    <select class="combobox form-control" name="name" id="name"  style="width: 300px;">
          <option value="" selected="selected">选择时间</option>
          <option value="oneDay">一天内</option>
          <option value="threeDay">三天内</option>
          <option value="weekDay">七天内</option>
          <option value="oneMonth">一个月之内</option>
          <option value="threeMonth">三个月之内</option>
          <option value="more">更多</option>
  		</select> 
    <label  for="name">名称搜索：</label>
    <input type="text" class="form-control" id="goodname" placeholder="请输入商品名">
    <label  for="name">用户搜索：</label>
    <input type="text" class="form-control" id="username" placeholder="请输入用户名">
  </div>
  <button type="submit" class="btn btn-default">确认</button>
</form>
<hr/>
<table class="table table-striped">
  <thead>
    <tr>
      <th width="10%">订单编号</th>
	<th width="20%">商品名</th>
	<th width="10%">数量</th>
	<th width="10%">价格</th>
	<th width="25%">图片</th>
	<th>购买用户</th></tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>牙刷</td>
      <td>100</td>
      <td>2.0</td>
      <td>图片</td>
      <td>张三</td></tr>
    <tr>
      <td>2</td>
      <td>泡面</td>
      <td>100</td>
      <td>2.0</td>
      <td>好吃</td>
      <td>李四</td></tr>
    <tr>
      <td>3</td>
      <td>jj</td>
      <td>100</td>
      <td>2.0</td>
      <td>竹炭</td>
      <td>王五</td></tr>
    <tr>
      <td>4</td>
      <td>ee</td>
      <td>100</td>
      <td>2.0</td>
      <td>竹炭</td>
      <td>赵六</td></tr>
  </tbody>
</table>
<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
</body>
</html>