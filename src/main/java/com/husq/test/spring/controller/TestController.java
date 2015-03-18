/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.husq.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.husq.test.spring.service.UserService;
import com.husq.test.spring.vo.User;

/**
 * 主题Controller
 * @author ERICHU
 * @version 2014-06-24
 */
@Controller
@RequestMapping(value = "/TestController")
@Scope("prototype")
public class TestController{

	private static final Logger logger = Logger.getLogger(TestController.class);
	@Autowired
	private UserService userService; 
	private int count;
	
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, HttpServletResponse response,Model model,RedirectAttributes redirectAttributes){
		try {
			logger.info("enter login method");
			request.setCharacterEncoding("utf-8");
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			
			count++;
			logger.info("username:"+user.getUsername());
			logger.info("password:"+user.getPassword());
			logger.info("**********************************************"+count);
			
			userService.login(user);
			
			model.addAttribute("user", user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "userInfo";
	}
	
}
