package com.ailipei.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailipei.mapper.TbUserMapper;
import com.ailipei.pojo.PagerResult;
import com.ailipei.pojo.TbUser;
import com.ailipei.pojo.TbUserExample;
import com.ailipei.pojo.TbUserExample.Criteria;
import com.ailipei.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 用户服务service
 * @author chen
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper; 
	@Override
	public TbUser getUserById(long userId) {
		/**
		 * 根据主键查询
		 */
        //TbUser tbUser = userMapper.selectByPrimaryKey(userId);
		TbUserExample example=new TbUserExample();
		Criteria createCriteria = example.createCriteria();
		//设置查询条件
		createCriteria.andIdEqualTo(userId);
		//执行查询
	    List<TbUser> list = userMapper.selectByExample(example);
	    if (list!=null&&list.size()>0) {
			return list.get(0);
		}    
		return null;
	}
	public PagerResult getTbUserList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbUserExample example=new TbUserExample();
		List<TbUser> list = userMapper.selectByExample(example);
		//创建一个返回值对象
		PagerResult result=new PagerResult();
		result.setRows(list);
		//取分页结果
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		//取总记录数
		long total = pageInfo.getTotal();
		result.setTotal(total);	
		return result;
	}

}
