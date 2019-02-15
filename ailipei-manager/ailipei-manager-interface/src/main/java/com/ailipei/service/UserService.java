package com.ailipei.service;


import java.util.List;

import com.ailipei.pojo.PagerResult;
import com.ailipei.pojo.TbUser;
import com.fasterxml.jackson.databind.util.JSONPObject;

public interface UserService {
	/**
	 * 根据用户id查询
	 * @param userId
	 * @return TbUser
	 */
   TbUser getUserById(long userId);
  /**
   * 分页查询用户数据
   * @param page
   * @param rows
   * @return
   */
   PagerResult getTbUserList(int page, int rows);
}
