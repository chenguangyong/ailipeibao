package com.ailipei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailipei.pojo.PagerResult;
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
	 * 根据用户id查询
	 */
	@RequestMapping("/user/{userId}")
	@ResponseBody
	public TbUser getUserById(@PathVariable Long userId){		
		TbUser user = userService.getUserById(userId);		
		return user;		
	}
	/**
	 * 分页查询所有用户数据
	 */
	@RequestMapping("/user/list")
	@ResponseBody
	public PagerResult getUserList(Integer page,Integer rows){
		PagerResult result = userService.getTbUserList(page, rows);
		return result;
	}
	
	
}
