package com.sunreal.di.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunreal.di.demo.po.Demo;
import com.sunreal.di.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/demo/", method = RequestMethod.GET)
	public ResponseEntity<List<Demo>> listAll() {
		List<Demo> demoList = this.demoService.listAll();
		if (demoList.isEmpty()) {
			// You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<Demo>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Demo>>(demoList, HttpStatus.OK);
	}

	@RequestMapping(value = "/demo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Demo> getDemoById(@PathVariable("id") String id) {
		int idInt = Integer.parseInt(id);
		Demo demo = this.demoService.selectByPrimaryKey(idInt);
		if (demo == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Demo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Demo>(demo, HttpStatus.OK);

	}

	@RequestMapping(value = "/demo/", method = RequestMethod.POST)
	public ResponseEntity<Void> insertDemo(@RequestBody Demo demo, UriComponentsBuilder ucBuilder) {
		System.out.println("---- insertDemo ----");
		int insertNum = this.demoService.insertSelective(demo);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(demo.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	 @RequestMapping(value = "/demo/{id}", method = RequestMethod.PUT)  
	public ResponseEntity<Demo> updateDemo(@PathVariable("id") String id, @RequestBody Demo demo) {
		System.out.println("---- DemoController updateDemo ----");
		int idInt = Integer.parseInt(id);
		Demo currentDemo = this.demoService.selectByPrimaryKey(idInt);
		
		//id为主键，不能修改
		//currentDemo.setId(demo.getId());
		currentDemo.setName(demo.getName());
		currentDemo.setItemDescription(demo.getItemDescription());
		currentDemo.setUnit(demo.getUnit());
		currentDemo.setRemark(demo.getRemark());
		
		this.demoService.updateByPrimaryKeySelective(currentDemo);  
	    return new ResponseEntity<Demo>(currentDemo, HttpStatus.OK);
	}

	@RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Demo> deleteDemo(@PathVariable("id") String id) {
		System.out.println("---- deleteDemo ----");
		int idInt = Integer.parseInt(id);
		int deleteNum = this.demoService.deleteByPrimaryKey(idInt);
		if (deleteNum == 0) {  
		    System.out.println("Unable to delete. User with id " + id + " not found");  
		    return new ResponseEntity<Demo>(HttpStatus.NOT_FOUND);  
		}  
		return new ResponseEntity<Demo>(HttpStatus.NO_CONTENT);  
	}

}
