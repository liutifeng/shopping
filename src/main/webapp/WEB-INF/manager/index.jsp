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

</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" >
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" onclick="showpage(this,'welcome.html')" style="color: blue;">享购</a>
    </div>
    <div class="sideMenu" id="sideMenu">
        <ul class="nav navbar-nav">
        	<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">用户信息 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                	
                    <li><a href="javascript:void(0)" onclick="showpage(this,'addAdmin.html')">添加管理员</a></li>
                    <li><a href="javascript:void(0)" onclick="showpage(this,'findAdmin.html')">管理员信息</a></li>
                    <li><a href="javascript:void(0)" onclick="showpage(this,'findMember.html')">用户管理</a></li>
                    <!--
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                      -->
                </ul>
            </li>
            
        	<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">商品信息 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="javascript:void(0)" onclick="showpage(this,'addGood.html')">添加商品</a></li>
                    <li><a href="javascript:void(0)" onclick="showpage(this,'findGood.html')">查询商品</a></li>
                </ul>
            </li>
            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">订单管理 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="javascript:void(0)" onclick="showpage(this,'findOrder.html')">查看订单</a></li>
                </ul>
            </li>
        	
        	<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">报表管理 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="javascript:void(0)" onclick="showpage(this,'findReport.html')">查看报表</a></li>
                </ul>
            </li>
        	
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="javascript:void(0)" onclick="showpage(this,'adminInfo.html')">个人信息</a></li>
                </ul>
            </li>
        	
        </ul>
    </div>
    </div>
    
</nav>

<div class="panel panel-default" style="margin-top: 50px;" >
	<div class="panel-body" style="width: 100%;height: 800px;">
		<div class="main" style="width: 100%;height: 800px;">
	    <iframe name="right" id="rightMain" src="welcome.html" frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true"></iframe>
		</div>
      
	</div>

    <div class="panel-footer">isgo</div>
</div>
<script type="text/javascript">

function showpage(obj,page){
    $("#rightMain").attr("src",page);
    $("#sideMenu li").removeClass("on");
    $(obj).parent().addClass("on");
    $("#here_area").text("当前位置："+$(obj).text());
}


</script>
</body>
</html>