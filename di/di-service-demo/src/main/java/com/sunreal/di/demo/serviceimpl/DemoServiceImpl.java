package com.sunreal.di.demo.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunreal.di.demo.mapper.DemoMapper;
import com.sunreal.di.demo.po.Demo;
import com.sunreal.di.demo.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Resource
	private DemoMapper demoDao;

	public Demo selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return this.demoDao.selectByPrimaryKey(id);
	}

	public List<Demo> listAll() {
		// TODO Auto-generated method stub
		return this.demoDao.listAll();
	}

	public int updateByPrimaryKeySelective(Demo demo) {
		// TODO Auto-generated method stub
		return demoDao.updateByPrimaryKeySelective(demo);
	}

	public int insertSelective(Demo demo) {
		// TODO Auto-generated method stub
		return demoDao.insertSelective(demo);
	}

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return demoDao.deleteByPrimaryKey(id);
	}

}