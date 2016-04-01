<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String greeting = "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>茄子科技</title>
<link href="<%=path %>/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
window.onresize = function(){
	frameheight();
}
function frameheight(){
	document.getElementById("frame2").height = document.documentElement.clientHeight - 120;	
}
window.history.forward(1);
</script>
</head>
<body onload="frameheight();">
<div class="box">
     <div id="top" style="width:100%;">
            <div class="l_top w100">
                     <div class="l_topleft"><img src="<%=path %>/img/logo.gif"/></div>
                     <div class="l_topleft">欢迎 ： <%=greeting %></div>
                     <div class="l_topright"><img src="<%=path %>/img/r_ad.gif"/></div>
            </div>
     </div>
     <div style="width:100%;height:auto;">
             <div id="left" style="float:left;">
                    <div class="l_box">
                            <div class="menutopbg mt10">
                               <ul>系统管理̬</ul>
                            </div>
                             <div class="limenutopbg">
                               <li><a href="<%=path %>/fw/teacher/teacher_table.jsp"  target="frame2" class="lan12">教师管理</a></li>
                            </div>
                            <div class="limenutopbg">
                               <li><a href="<%=path %>/fw/student/student_table.jsp"  target="frame2" class="lan12">学生管理</a></li>
                            </div>	
                            <div class="limenutopbg">
                               <li><a href="<%=path %>/fw/class/class_table.jsp"  target="frame2" class="lan12">班级管理</a></li>
                            </div>
                            <div class="limenutopbg">
                               <li><a href="<%=path %>/fw/cms/cms_table.jsp"  target="frame2" class="lan12">学校通知</a></li>
                            </div>
                    </div>
            </div>

             <div id="right" style="">
               		<iframe id="frame2" name="frame2" src="" width="100%" height="700" application="no" frameborder="0" class="link1_5" style="overflow-x: hidden; overflow-y: auto; "></iframe>
             </div>
     </div>
     <div id="floor">
     		<ul>建议使用FireFox、Chrome浏览器</ul>
     </div>
</div>
</body>
</html>
