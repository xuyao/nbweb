<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=path %>/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/themes/color.css"/>
    <script type="text/javascript" src="<%=path %>/script/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/script/jquery.easyui.min.js"></script>
</head>
<body>
    <table id="dg" title="学生列表" class="easyui-datagrid" toolbar="#toolbar">
        <thead>
            <tr>
                <th field="sname" width="50">学生姓名</th>
                <th field="school" width="50">学校</th>
                <th field="sgender" width="50">性别</th>
                <th field="sclass" width="50">班级</th>
                <th field="uname" width="50">家长姓名</th>
                <th field="uphone" width="50">家长手机</th>
                <th field="urelt" width="50">关系</th>
                <th field="status" width="50">状态</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="showUser()">详情</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
        <div class="ftitle">用户信息</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>学生姓名:</label>
                <input name="sname" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>性别:</label>
                <input name="sgender" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>班级:</label>
                <input name="sclass" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>家长姓名:</label>
                <input name="uname" class="easyui-textbox" required="true">
            </div>
			<div class="fitem">
                <label>家长手机:</label>
                <input name="uphone" class="easyui-textbox" required="true">
            </div>
			<div class="fitem">
                <label>关系:</label>
                <input name="urelt" class="easyui-textbox">
            </div>
        </form>
    </div>
    
    <div id="ddlg" class="easyui-dialog" title="从账号详细信息" data-options="iconCls:'icon-help'" closed="true" 
    	style="width:400px;height:200px;padding:10px">
	</div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" id="baocun" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
        var url;
        function showUser(){
        	var row = $('#dg').datagrid('getSelected');
            if (row){
            	$('#ddlg').dialog('open');
                url = '<%=path %>/fw/user/parent?_id='+row._id;
                $.get(url,function(result){
                	var div = '';
                	for(var i=0;i<result.list.length;i++){
                		div = div + '<div>'+result.list[i].pname+"  "
                						   +result.list[i].prelt+"  "
                						   +result.list[i].pphone+'</div>';
                	}
                	$('#ddlg').html(div);
                },'json');
            }
        	
        	
        }
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','新增');
            $('#fm').form('clear');
            url = '<%=path %>/fw/user/add';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','修改');
                $('#fm').form('load',row);
                url = '<%=path %>/fw/user/update?_id='+row._id;
            }
        }
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                	$('#baocun').attr('onclick','');
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                    $('#baocun').attr('onclick','saveUser()');
                }
            });
        }
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('删除','确定删除此消息吗?',function(r){
                    if (r){
                        $.post('<%=path %>/fw/user/delete',{_id:row._id},function(result){
                        $('#dg').datagrid('reload');    // reload the user data
                        },'json');
                    }
                });
            }
        }
    </script>
</body>
<style type="text/css">
    #fm{
        margin:0;
        padding:10px 30px;
    }
    .ftitle{
        font-size:14px;
        font-weight:bold;
        padding:5px 0;
        margin-bottom:10px;
        border-bottom:1px solid #ccc;
    }
    .fitem{
        margin-bottom:5px;
    }
    .fitem label{
        display:inline-block;
        width:80px;
    }
    .fitem input{
        width:160px;
    }
</style>
</html>
<script type="text/javascript">
$('#dg').datagrid({
	url: '<%=path %>/fw/user/list',
	saveUrl: '',
	updateUrl: '',
	destroyUrl: '',
	rownumbers: true,
	pagination: true,
	autoRowHeight:true,
	method:'GET',
	singleSelect:true,
	fitColumns:true,
	pagination:true,
	pageSize:20
});
</script>
