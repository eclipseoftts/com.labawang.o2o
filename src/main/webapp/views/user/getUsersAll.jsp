<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
	<%@ include file="/views/home/head.jsp"%>
</head>
<body>
	<div id="main-wrapper">
    	<%@ include file="/views/home/top.jsp"%>
    </div>
    <div class="template-page-wrapper">
    	<!-- 左侧导航栏 -->
      <%@ include file="/views/home/left.jsp"%>
<div class="templatemo-content">
<div class="row" style="margin-bottom: 20px;">
		<div class="col-md-4 col-sm-4 col-md-offset-1">
			<c:if test="${type==1 }">
				<button class="btn btn-primary" id="addButton" type="button" >
			    	添加
			    </button>
			    <button class="btn btn-primary" id="deleteButton" type="button" >
			    	删除
			    </button>
		    </c:if>
			<button class="btn btn-primary" id="updateButton" type="button" >
		    	修改
		    </button>
		</div>
		<c:if test="${type==1 }">
			<div class="col-md-6 col-sm-6">
					<form class="form-inline" action="${pageContext.request.contextPath}/user/queryUserByName.do" method="post">
					  <div class="form-group">
					    <label for="exampleInputEmail2">用户名</label>
					    <input type="text" class="form-control" name="name" id="exampleInputEmail2" placeholder="请输入搜索内容">
					  </div>
					  <button type="submit" class="btn btn-primary">搜索</button>
					</form>
			</div>
		</c:if>
	</div>

<!-- 内容部分 -->
<div class="row">
  <div class="col-md-12">
	<div class="templatemo-content-wrapper">
	 <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                  <thead>
                    <tr>
                      <th><input type="checkbox" id="selectCheckBoxAll"/></th>
                      <th>用户名</th>
                      <th>状态标识</th>
                      <th>角色</th>
                      <th>真实名字</th>
                      <th>最后登录时间</th>
                      <th>最后登录ip地址</th>
                      <th>电话号码</th>
                      <th>电话号码</th>
                    </tr>
                  </thead>
                  <c:if test="${type==1 }">
                  		<c:forEach items="${usersAll.list }" var="user">
                  			<tbody>
			                    <tr>
			                      <td><input type="checkbox" class="selectCheckBoxAll" value="${user.id}"/></td>
			                      <td>${user.name }</td>
			                      <c:if test="${user.isstart=='0' }">
			                      	<td>暂停使用</td>
			                      </c:if>
			                      <c:if test="${user.isstart=='1' }">
			                      	<td>正在使用</td>
			                      </c:if>
			                      <td>${user.role.rolename }</td>
			                      <td>${user.username }</td>
			                      <td><fmt:formatDate value="${user.lastLogin }" pattern="yyyy-MM-dd "/></td>
			                      <td>${user.ip }</td>                    
			                      <td>${user.telephone }</td>                    
			                      <td>
			                        <!-- Split button -->
			                        <div class="btn-group">
			                          <button type="button" class="btn btn-info">Action</button>
			                          <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
			                            <span class="caret"></span>
			                            <span class="sr-only">Toggle Dropdown</span>
			                          </button>
			                          <ul class="dropdown-menu" role="menu">
			                            <li><a href="#">Bootstrap</a></li>
			                            <li><a href="#">Font Awesome</a></li>
			                            <li><a href="#">jQuery</a></li>
			                          </ul>
			                        </div>
			                      </td>
			                      <td><a href="#" class="btn btn-link">Delete</a></td>
			                    </tr>
			                  </tbody>
                  		</c:forEach>
                  </c:if>
                  <c:if test="${type==0 }">
	                 <tbody>
			                    <tr>
			                      <td><input type="checkbox" class="selectCheckBoxAll" value="${user.id}"/></td>
			                      <td>${user.name }</td>
			                      <c:if test="${user.isstart=='0' }">
			                      	<td>暂停使用</td>
			                      </c:if>
			                      <c:if test="${user.isstart=='1' }">
			                      	<td>正在使用</td>
			                      </c:if>
			                      <td>${user.role.rolename }</td>
			                      <td>${user.username }</td>
			                      <td>${user.lastLogin }</td>
			                      <td>${user.ip }</td>                    
			                      <td>${user.telephone }</td>                    
			                      <td>
			                        <!-- Split button -->
			                        <div class="btn-group">
			                          <button type="button" class="btn btn-info">Action</button>
			                          <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
			                            <span class="caret"></span>
			                            <span class="sr-only">Toggle Dropdown</span>
			                          </button>
			                          <ul class="dropdown-menu" role="menu">
			                            <li><a href="#">Bootstrap</a></li>
			                            <li><a href="#">Font Awesome</a></li>
			                            <li><a href="#">jQuery</a></li>
			                          </ul>
			                        </div>
			                      </td>
			                      <td><a href="#" class="btn btn-link">Delete</a></td>
			                    </tr>
			                  </tbody>
                  </c:if>
                </table>
              </div>
              <ul class="pagination pull-right">
                <li class="disabled"><a href="#">${error}</a></li>
                <li class="disabled"><a href="#">总共：${usersAll.size }</a></li>
                <li class="disabled"><a href="#">总共：${usersAll.total }</a></li>
                <li>
	                <a href="${pageContext.request.contextPath}/user/queryUser.do?pageNum=${usersAll.prePage }&pageSize=10"> 
	                	上一页<span class="sr-only"></span>
	                </a>
                </li>
                <li>
	                <a href="${pageContext.request.contextPath}/user/queryUser.do?pageNum=${usersAll.nextPage }&pageSize=10">
	                	下一页<span class="sr-only"></span>
	                </a>
                </li>
              </ul>  
            </div>
            </div>
            </div>
            </div>
	 <%@ include file="/views/home/bottom.jsp"%>
	 </div>
	 <script type="text/javascript">
	 	$(function(){
	 		$("#selectCheckBoxAll").click(function(){   
	 		    if(this.checked){   
	 		        $(":checkbox").prop("checked", true);  
	 		    }else{   
	 			$(":checkbox").prop("checked", false);
	 		    }   
	 		});
	 		
	 		$("#addButton").click(function(){
	 			window.location.href = "${pageContext.request.contextPath}/user/saveUsers.do?type='t'";
	 		});
	 		
	 		$("#updateButton").click(function(){
	 			var length = $(".selectCheckBoxAll:checked").length;
	 			if(length==0){
	 				alert("你还没哟选择任何内容");
	 			}else if(length==1){
	 				window.location.href = "${pageContext.request.contextPath}/user/saveUsers.do?type="+$(".selectCheckBoxAll:checked").val();
	 			}else{
	 				alert("修改时只能选择一项");
	 			}
	 		});
	 		$(".backUl").each(function(){
		        //取出ul下的第一个li
		        var li= $(this).children().first();
		        li.addClass('back');
		    });
	 		
	 		$("#deleteButton").click(function(){
	 			var chk_value =[]; 
	 			$('.selectCheckBoxAll:checked').each(function(){ 
	 				chk_value.push($(this).val()); 
	 			}); 
	 			var value = "";
	 			for(var i=0;i<chk_value.length;i++){
	 				if(i<chk_value.length-1){
	 					value+=chk_value[i]+",";
	 				}else{
	 					value+=chk_value[i];
	 				}
	 			}
	 			$.ajax({
  				  type: "GET",
  				  contentType : 'application/json',
  		          url: "${pageContext.request.contextPath}/user/deleteUsers.do",
  		          dataType: "json",
  		          data: {userId:value},
  		          success: function(data) {
  		        	  alert(data);
  		        	window.location.href=window.location.href;
  		             /* $.each(data, function(index, element) {
  		              alert(element);
  		            });  */
  		          },
  		          error: function() {
  		            alert("删除成功");
  		          window.location.href=window.location.href;
  		          }
  		        });  
	 		});
	 		$("#getUsersAll").addClass("back");
	 		var type = ${type-1};
	 		 if(type>=1){
	 			$("#profession ").get(0).selectedIndex=type;
	 		 }
	 	})
	 </script>
</body>
</html>