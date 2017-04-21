package com.labawang.controllers.index;

import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labawang.utils.ImageCode;

@Controller
@RequestMapping("index")
public class IndexController {
	@Resource  
    ImageCode imageCode;  

	@RequestMapping("/index.do")
	public String index(){
		return "index";
	}
	
        /*@Resource默认按 byName 自动注入,是J2EE提供的， 需导入Package:   
        javax.annotation.Resource; 
        @Resource有两个中重要的属性：name和type ，而Spring将@Resource注解的name属性解析为bean的 
        名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用 
        type属性时则使用 byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用by 
        Name自动注入策略。*/  
  
    @RequestMapping(value = "/getImage.do") 
    public void getImage(HttpServletRequest request,  
            HttpServletResponse response) throws IOException {  
        // 禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
  
        response.setContentType("image/jpeg");  
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = response.getOutputStream();  
        ImageIO.write(imageCode.getImage(request), "jpeg", sos);  
        sos.close();  
    }  
	  
}
