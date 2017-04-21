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
				<button class="btn btn-primary" id="addButton" type="button" >
			    	添加
			    </button>
				<button class="btn btn-primary" id="updateButton" type="button" >
			    	修改
			    </button>
			    <c:if test="${user.role.remarks==0}">
			    	 <button class="btn btn-primary" id="deleteButton" type="button" >
				    	删除
				    </button>
			    </c:if>
		</div>
		<div class="col-md-6 col-sm-6">
				<form class="form-inline" action="${pageContext.request.contextPath}/customer/getCustomerSearch.do" method="post">
				  <div class="form-group">
				    <label for="profession">搜索</label>
				    <select id = "profession" name="type" class = "form-control"> 
				    	<c:forEach items="${map }" var="map">
				    		<option  value="${map.key }" >${map.value }</option > 
				    	</c:forEach>
				    </select>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail2">&nbsp;&nbsp;-&nbsp;&nbsp;</label>
				    <input type="text" class="form-control" name="name" value="${name}" id="exampleInputEmail2" placeholder="请输入搜索内容">
				  </div>
				  <button type="submit" class="btn btn-primary">搜索</button>
				</form>
		</div>
	</div>
	
<div class="row">
  <div class="col-md-12">
	<div class="templatemo-content-wrapper">
	 <div class="table-responsive">
                <table class="table table-striped table-hover table-bordered">
                  <thead>
                    <tr>
                      <th><input type="checkbox" id="selectCheckBoxAll"/></th>
                      <th>客户意向</th>
                      <th>企业名称</th>
                      <th>联系人</th>
                      <th>职位</th>
                      <th>联系方式</th>
                      <th>行业</th>
                      <th>经营产品</th>
                      <th>过往广告投放</th>
                      <th>添加的时间</th>
                      <th>备注</th>
                    </tr>
                  </thead>
              		<c:forEach items="${customerAll.list }" var="customer">
              			<tbody>
		                   <tr>
		                     <td><input type="checkbox" class="selectCheckBoxAll" value="${customer.id}"/></td>
		                      <c:if test="${customer.grade==1}">
		                      		<td>A类用户</td>
		                      </c:if>
		                      <c:if test="${customer.grade==2}">
		                      		<td>B类用户</td>
		                      </c:if>
		                      <c:if test="${customer.grade==3}">
		                      		<td>C类用户</td>
		                      </c:if>
		                      <c:if test="${customer.grade==4}">
		                      		<td>D类用户</td>
		                      </c:if>
		                     <td>${customer.company}</td>
		                     <td>${customer.name}</td>
		                     <td>${customer.job }</td>
		                     <td>${customer.telephone }</td>
		                     <td>${customer.industry }</td>
		                     <td>${customer.product }</td>
		                     <td>${customer.advertising }</td>
		                     <td><fmt:formatDate value="${customer.intime }" pattern="yyyy-MM-dd "/></td>
		                     <td>${customer.remarks }
		                     </td>                    
		                   </tr>
		                 </tbody>
              		</c:forEach>
                </table>
              </div>
              <ul class="pagination pull-right">
                <li class="disabled"><a href="#">${error}</a></li>
                <li class="disabled"><a href="#">总共：${customerAll.total }</a></li>
                <li>
	                <a href="${pageContext.request.contextPath}/customer/queryCustomer.do?pageNum=${customerAll.prePage }"> 
	                	上一页<span class="sr-only"></span>
	                </a>
                </li>
                <li>
	                <a href="${pageContext.request.contextPath}/customer/queryCustomer.do?pageNum=${customerAll.nextPage }">
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
	 			window.location.href = "${pageContext.request.contextPath}/customer/editCustomer.do?type=t";
	 		});
	 		
	 		$("#updateButton").click(function(){
	 			var length = $(".selectCheckBoxAll:checked").length;
	 			if(length==0){
	 				alert("你还没哟选择任何内容");
	 			}else if(length==1){
	 				window.location.href = "${pageContext.request.contextPath}/customer/editCustomer.do?type="+$(".selectCheckBoxAll:checked").val();
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
	  		          url: "${pageContext.request.contextPath}/customer/deleteCustomer.do",
	  		          dataType: "json",
	  		          data: {userid:value},
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
	 		 $("#getCustomerAll").addClass("back");
	 		 
	 		 var type = ${type-1};
	 		 if(type>=1){
	 			$("#profession ").get(0).selectedIndex=type;
	 		 }
	 	})
	 </script>
</body>
</html>