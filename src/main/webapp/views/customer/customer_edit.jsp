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
				<form role = "form" class="form-horizontal" action="${pageContext.request.contextPath}/customer/setCustomerAll.do" method="POST"> 
				   <div class = "form-group " style="text-align: center;padding-right: 200px;">
				 	 <h2>添加客户信息</h2>
				  </div>
				  <input type="hidden" name="id" value="${company.id}"/>
				  <input type="hidden" name="userid" value="${company.userid}"/>
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "name">客户名字</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="name" name="name" value="${company.name}" placeholder = "请输入客户名字"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "telephone">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="telephone" name="telephone" value="${company.telephone}" placeholder = "请输入电话号码"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "job">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="job" name="job" value="${company.job}" placeholder = "请输入职位"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "company">公司名字</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type = "text" class = "form-control" id="company" name="company" value="${company.company}" placeholder = "请输入公司名字"/> 
				   		</div> 
				  </div> 
				  
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "address">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="address" name="address" value="${company.address}" placeholder = "请输入地址"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "grade">客户等级</label> 
					   <div class="col-md-6 col-sm-2"> 
					   		<select class="form-control" id="grade" name="grade">
					   			<option value="1">A类用户</option>
					   			<option value="2">B类用户</option>
					   			<option value="3">C类用户</option>
					   			<option value="4">D类用户</option>
					   		</select>
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "industry">行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="industry" name="industry" value="${company.industry}" placeholder = "请输入行业"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "product">经营产品</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="product" name="product" value="${company.product}" placeholder = "请输入经营产品"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "advertising">投放广告</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <input type="text" class="form-control" id="advertising" name="advertising" value="${company.advertising}" placeholder = "请输入以前投放广告"/> 
					   </div> 
				  </div> 
				  <div class = "form-group"> 
					   <label class="col-sm-2 control-label" for = "remarks">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</label> 
					   <div class="col-md-6 col-sm-2"> 
						    <textarea rows="8" cols="8" class="form-control" id="remarks" name="remarks"  placeholder = "请输入备注">
						    	${company.remarks}
						    </textarea>
					   </div> 
				  </div> 
				  <div class="form-group"> 
					   <div class="col-sm-2 col-sm-offset-2"> 
					    	<button type="submit" class="btn-info btn-lg">保存</button> 
					   </div>    
					   <div style="color:red;">${error}</div>
					   <div class="col-sm-2 col-sm-offset-2"> 
					    	<button type="reset" class="btn-info btn-lg">取消</button> 
					   </div>
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
    			
 				$("#getCustomerAll").addClass("back");
    	 		 
    	 		 var type = ${type-1};
    	 		 if(type>=1){
    	 			$("#profession ").get(0).selectedIndex=type;
    	 		 }
    		})
    </script>
    
    
    
    
</body>
</html>