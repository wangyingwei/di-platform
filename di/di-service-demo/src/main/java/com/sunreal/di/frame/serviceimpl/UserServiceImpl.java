package com.sunreal.di.frame.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunreal.di.frame.mapper.UserDao;
import com.sunreal.di.frame.po.User;
import com.sunreal.di.frame.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	public User selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.selectByUserName(userName);
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return  this.userDao.listAll();
	}

	@Override
	public int insertSelective(User user) {
		// TODO Auto-generated method stub
		return this.userDao.insertSelective(user);
	}
	@Override
	public User selectByPrimaryKey(Integer id){
		
		return this.userDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(id);
	}
}