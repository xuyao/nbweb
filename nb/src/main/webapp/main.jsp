<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	<!-- css files -->
	<link rel="stylesheet" href="<%=path %>/css/common.css" type="text/css" media="screen" charset="utf-8" />
	<link rel="stylesheet" href="<%=path %>/css/main.css" type="text/css" media="screen" charset="utf-8" />
  	<link rel="stylesheet" type="text/css" href="<%=path %>/js/tree_themes/SimpleTree.css"/>
	<!-- js files -->
	<script src="<%=path %>/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=path %>/js/jquery.SuperSlide.js" type="text/javascript" charset="utf-8"></script>
 	 <script type="text/javascript" src="<%=path %>/js/SimpleTree.js"></script>
	<script type="text/javascript">
	  $(function(){
		  /**
	      $(".sideMenu").slide({
	         titCell:"h3", 
	         targetCell:"ul",
	         defaultIndex:0, 
	         effect:'slideDown', 
	         delayTime:'500' , 
	         trigger:'click', 
	         triggerTime:'150', 
	         defaultPlay:true, 
	         returnDefault:false,
	         easing:'easeInQuint',
	         endFun:function(){
	             // scrollWW();
	         }
	       });*/
	       
	      //$(window).resize(function() {
	         // scrollWW();
	      //});
	      //设置默认的菜单打开样式
	      //$("div.sideMenu").children("ul:first").find("li:first").addClass("on");
	      //设置当前位置
	      $("#current_menu").html($("div.st_tree").children("ul:first").find("li:first").html());
	      //$("#rightMain").attr("src",$("div.sideMenu").children("ul:first").find("li:first>a").attr("href"));
	  });
	  
	  //菜单选择提示
	  function setClass(obj){
		$("[href]").css("backgroundColor", "");
		//设置当前位置
		$("#current_menu").html($(obj).html());
		$(obj).css("backgroundColor","#D9D9D9");
		}
	  
  </script>
  </head>
  <body>
    	<div class="top">
      <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
          <img src="<%=path %>/img/a.png" alt="" width="60" height="60">
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="javascript:void(0);" id="hp">&nbsp;</a>
              <a href="javascript:void(0);" id="gy">&nbsp;</a>
              <a href="<%=path %>/logout.jspa" id="out">&nbsp;</a>
            </div>
            <div class="info_center">123</div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：<span id="current_menu"></span></div>
      </div>
    </div>
    
    <div class="side">
        <div class="st_tree" style="margin:0 auto">
			<ul>
				<li>首页
					<ul>
						<li><a href="<%=path %>/fw/admin_table.jsp" onclick="setClass(this)" target="right">用户管理</a></li>
					</ul>
				</li>
				<!-- 
				<li>探索
					<ul>
						<li><a href="<%=path %>/tansuo/gc/list.jspa" onclick="setClass(this)" target="right">观察</a></li>
						<li><a href="<%=path %>/tansuo/wx/list.jspa" onclick="setClass(this)" target="right">万象</a></li>
						<li><a href="<%=path %>/tansuo/kt/list.jspa" onclick="setClass(this)" target="right">课堂</a></li>
						<li><a href="<%=path %>/tansuo/rw/list.jspa" onclick="setClass(this)" target="right">人物</a></li>
						<li><a href="<%=path %>/tansuo/sj/list.jspa" onclick="setClass(this)" target="right">数据</a></li>
					</ul>
				</li>
				 -->
			</ul>
       </div>
    </div>
    
    <div class="main">
       <iframe name="right" id="rightMain" src="" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
    </div>
    <div class="bottom">
    	<div id="bottom_bg">©Copyright 2016 <a target="_blank"  href="http://www.51per.com/"> <b>51per软件开发团队</b> </a>. All Rights Reserved</div>
	</div>
    </body>
</html>
