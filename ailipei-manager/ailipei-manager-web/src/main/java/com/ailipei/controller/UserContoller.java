package com.ailipei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailipei.pojo.TbUser;
import com.ailipei.service.UserService;
/**
 * 用户查询测试
 * @author chen
 */
@Controller
public class UserContoller {
  
	@Autowired
	private UserService userService;
	/**
	 * 可以取出参数userid
	 */
	@RequestMapping("/user/{userId}")
	@ResponseBody
	public TbUser getUserById(@PathVariable Long userId){
		
		TbUser user = userService.getUserById(userId);
		
		return user;
		
	}
	
	
	
	
}
