<div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="./login/login.do">客户管理系统首页</a></li>
          </ol>
          <h1>平台数据统计</h1>
          <div class="row margin-bottom-30">
            <div class="col-md-12">
              <ul class="nav nav-pills">
                <li class="active"><a href="#">销售人员 <span class="badge">${usersCount }</span></a></li>
                <li class="active"><a href="#">有意向客户<span class="badge">107</span></a></li>
                <li class="active"><a href="#">签单客户<span class="badge">3</span></a></li>
              </ul>          
            </div>
          </div> 
        </div>
      </div>
<script type="text/javascript">
	$(function(){
	    $(".backUl").each(function(){
	        //取出ul下的第一个li
	        var li= $(this).children().first();
	        li.addClass('back');
	    });
	});
	</script>