
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>报表</title>
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
	<label>按年份查询：</label>
    <select class="combobox form-control" name="name" id="name"  style="width: 300px;">
          <option value="" selected="selected">选择时间</option>
          <option  id="year">2019</option>
          <option  id="year">2018</option>
  		</select> 
  </div>
  <button type="button" class="btn btn-default" onclick="javascript:toSure()">确认</button>
</form>
<hr/>
<table class="table table-striped">
  <thead>
    <tr>
	    <th width="20%">时间/（年/月/日）</th>
	    <th width="30%">订单总数/单</th>
		<th width="30%">售出金额（元）</th>
		<th>盈利状况</th>
	</tr>
  </thead>
  <tbody id="order_info">
    
	
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
<script type="text/javascript">
$(function(){
	
})

function toSure(){
	var years = $('#name').val();
	alert(years);
	if(years!=''){
		findByYear(years);
	}
}


function findByYear(years){
	var str="";
	$.post('../../order/orders/findByYear',{years:years},function(data){
		str+='<tr><td>'+years+'</td><td>'+data[0].num+'</td><td>'+data[0].sale+'</td><td>待定</td></tr>';
		$('#order_info').html('').append(str);
	});
	
}


</script>



</html>