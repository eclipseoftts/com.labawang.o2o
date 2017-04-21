<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- 下拉框 -->
<!-- jsp文件头和头部 -->
	<%@ include file="/views/home/head.jsp"%>
</head>
<body>
	<div id="main-wrapper">
    	<%@ include file="/views/home/top.jsp"%>
    </div>
    <div class="template-page-wrapper">
    	<!-- 左侧导航栏 -->
      <%@ include file="/views/home/left.jsp"%>

	  <!-- 中间内容部分 -->
	  <div class="templatemo-content">
			<div class="container">
				<form role = "form" class="form-horizontal" action="${pageContext.request.contextPath}/user/saveUsersAll.do" method="POST"> 
				  <input type="hidden" name="userId" value="${users.id}"/>
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "name">登录名</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type = "text" class = "form-control" id="name" name="name" value="${users.name}" placeholder = "请输入姓名"/> 
				   		</div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "tel">密码</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="password" class="form-control" id="password" name="password" value="${users.password}" placeholder = "请输入您密码"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "tel">姓名</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="username" name="username" value="${users.username}" placeholder = "请输入真实名字"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "tel">电话</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="telephone" name="telephone" value="${users.telephone}" placeholder = "请输入电话号码"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label"  for = "profession">选择权限</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <select id = "profession" name="roleId" class = "form-control"> 
							    <c:forEach items="${roleList }" var="role">
							    	<option  value="${role.code}" >${role.error }</option > 
							    </c:forEach>
						    </select> 
					   </div> 
				  </div> 
				  <div class="form-group"> 
					   <div class="col-sm-2 col-sm-offset-2"> 
					    	<button type="submit" class="btn-info btn-lg">保存</button> 
					   </div>    
					   <div style="color:red;">${error}</div>
				  </div> 
				 </form> 
			</div>
		</div>
      <!-- Modal -->
      <!-- 底部；链接 -->
	  <%@ include file="/views/home/bottom.jsp"%>
    </div>
    <script type="text/javascript">
    		function saveUsersAll(){
    			var name = $("#name").val();
    			var password = $("#password").val();
    			var username = $("#username").val();
    			var telephone = $("#telephone").val();
    			var roleId = $("#profession option:selected").val();
    			 $.ajax({
    				  type: "POST",
    				  contentType : 'application/json',
    		          url: "${pageContext.request.contextPath}/user/saveUsersAll.do",
    		          dataType: "json",
    		          data: {name: name,password: password,username: username,telephone: telephone,roleId: roleId},
    		          success: function(data) {
    		        	  alert(data.msg);
    		            /* $.each(data, function(index, element) {
    		              alert(element);
    		            }); */
    		          },
    		          error: function() {
    		            alert("error");
    		          }
    		        });
    		}
    		
    		$(function(){
    			 $("#getUsersAll").addClass("back");
 		 		var type = ${type-1};
 		 		 if(type>=1){
 		 			$("#profession ").get(0).selectedIndex=type;
 		 		 }
    		})
    </script>
    
    
    
    
</body>
</html>