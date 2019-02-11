package com.ailipei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ailipei.mapper.TbUserMapper;
import com.ailipei.pojo.TbUser;
import com.ailipei.pojo.TbUserExample;
import com.ailipei.pojo.TbUserExample.Criteria;
import com.ailipei.service.UserService;
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

}
