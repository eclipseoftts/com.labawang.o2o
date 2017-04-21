<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>拉把网管理后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="layout" content="main"/>
    

    <script src="${pageContext.request.contextPath}/public/js/jquery/jquery-1.8.2.min.js" type="text/javascript" ></script>
    <link href="${pageContext.request.contextPath}/public/css/customize-template.css" type="text/css" media="screen, projection" rel="stylesheet" />
	
    <script type="text/javascript">  
		var basePath = "<%=request.getContextPath()%>";  
		$(function(){  
		   // checkcode();  
		});  
		function checkcode(){  
		    var XMLHttp = null;  
		    if (window.XMLHttpRequest) {  
		        XMLHttp = new XMLHttpRequest()  
		    } else if (window.ActiveXObject) {  
		        XMLHttp = new ActiveXObject("Microsoft.XMLHTTP");  
		    }  
		    XMLHttp.onreadystatechange = function() {  
		        if (XMLHttp.readyState == 4) {  
		            document.getElementById("imageCode").src = basePath  
		                    + "index/getImage.do?" + new Date();//改变验证码图片    
		        }  
		    }  
		    //将请求发送出去    
		    //加上new Date()防止浏览器缓存，不重新发送请求  
		    XMLHttp.open("GET", basePath + "index/getImage.do?" + new Date(), true);  
		    XMLHttp.send(null);  
		}  
		</script>  
</head>
    <body>
        <div class="navbar navbar-fixed-top" style="background-color: #6e8e21;font-size: 30px;">
            <div class="navbar-inner">
                <div class="container">
                    <button class="btn btn-navbar" data-toggle="collapse" data-target="#app-nav-top-bar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="dashboard.html" class="brand">
						<img alt="拉把网" src="${pageContext.request.contextPath}/public/images/logo.png" height="50%" width="50%">
					</a>
                    <div id="app-nav-top-bar" class="nav-collapse" style="margin-top:30px;">
                        <ul class="nav pull-right">
                            <li>
                                <a href="login.html">拉把网管理后台</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="body-container">
                    <div id="body-content">
                        
                        
            <div class='container'>
                
                <div class="signin-row row">
                    <div class="span4"></div>
                    <div class="span8">
                        <div class="container-signin">
                            <legend>登录窗口</legend>
                            <form action='${pageContext.request.contextPath}/login/loginInit.do' method='POST' id='loginForm' class='form-signin' autocomplete='off'>
                                <div class="form-inner">
                                    <div class="input-prepend">
                                        
                                        <span class="add-on" rel="tooltip" title="Username or E-Mail Address" data-placement="top"><i class="icon-envelope"></i></span>
                                        <input type='text' class='span4' id='username'name="name"/>
                                    </div>

                                    <div class="input-prepend">
                                        
                                        <span class="add-on"><i class="icon-key"></i></span>
                                        <input type='password' class='span4' id='password' name="password"/>
                                    </div>
                                    <!-- 
                                    <img id="imageCode" alt="" src="" onclick="checkcode()" style="cursor: pointer;" title="点我更换验证码"/>  
                                     -->
                                    <label >
                                    		<span>${error }</span>
                                    </label>
                                </div>
                                <footer class="signin-actions">
                                    <input class="btn btn-primary" type='submit' id="submit" value='登录'/>
                                    <input class="btn btn-primary" type='reset' value='取消'/>
                                </footer>
                            </form>
                        </div>
                    </div>
                    <div class="span3"></div>
                </div>

            <!--<div class="span4">

                </div>-->
            </div>
    

            </div>
        </div>

        <div id="spinner" class="spinner" style="display:none;">
            Loading&hellip;
        </div>

        <footer class="application-footer">
            <div class="container">
                <p>拉把贸易有限公司</p>
                <div class="disclaimer">
                    <p>专注微信朋友圈广告投放</p>
                    <p>Copyright © keaplogik 2011-2012</p>
                </div>
            </div>
        </footer>
        <script type="text/javascript">
            $(function(){
                document.forms['loginForm'].elements['j_username'].focus();
                $('body').addClass('pattern pattern-sandstone');
                $("[rel=tooltip]").tooltip();
            });
        </script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-transition.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-alert.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-modal.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-dropdown.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-scrollspy.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-tab.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-tooltip.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-popover.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-button.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-collapse.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-carousel.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-typeahead.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-affix.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/bootstrap/bootstrap-datepicker.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/jquery/jquery-tablesorter.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/jquery/jquery-chosen.js" type="text/javascript" ></script>
        <script src="${pageContext.request.contextPath}/public/js/jquery/virtual-tour.js" type="text/javascript" ></script>
        

	</body>
</html>