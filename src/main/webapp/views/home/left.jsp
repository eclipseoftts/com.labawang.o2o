     <div class="navbar-collapse collapse templatemo-sidebar">
        <ul class="templatemo-sidebar-menu ">
        	<li><a href="#"><i class="fa fa-database"></i>管理台首页</a></li> 
        	<c:forEach items="${menuList}" var="menu">
        		<c:choose>
				   <c:when test="${empty menu.listMenu}">  
				       <li id="${menu.label }"><a href="${pageContext.request.contextPath}${menu.url }"><i class="${menu.icons}"></i>${menu.menuname }</a></li>   
				   </c:when>
				   <c:otherwise> 
				  		 <li class="sub"  id="${menu.label }">
					            <a href="javascript:;">
					              <i class="${menu.icons}"  id="${menu.label }"></i> ${menu.menuname }<div class="pull-right"><span class="caret"></span></div>
					            </a>
						   		<c:forEach items="${menu.listMenu}" var="nextMenu">
							            <ul class="templatemo-submenu">
							              <li  id="${menu.label }"><a href="${pageContext.request.contextPath}${nextMenu.url }"><i class="${nextMenu.icons}"></i>${nextMenu.menuname }</a></li>
							            </ul>
						   		</c:forEach>
				   		</li>
				   </c:otherwise>
				</c:choose>
				
        	</c:forEach>
        </ul>
      </div><!--/.navbar-collapse -->