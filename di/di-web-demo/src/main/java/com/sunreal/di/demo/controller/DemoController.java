package com.sunreal.di.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunreal.di.demo.po.Demo;
import com.sunreal.di.demo.service.DemoService;
import com.sunreal.di.mq.producer.MessageProducer;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@Resource
	private MessageProducer messageProducer;

	@RequestMapping("/listAll")
	public String listAll(HttpServletRequest request, Model model) {
		List<Demo> demoList = this.demoService.listAll();
		model.addAttribute("demoList", demoList);
		
		String message="message : query all demo";
	    messageProducer.sendMessage(message);
	    
		return "/demo/demoList";
	}

	@RequestMapping("/editDemo")
	public String getDemoById(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		Demo demo = this.demoService.selectByPrimaryKey(id);
		model.addAttribute("demo", demo);
		return "/demo/editDemo";
	}

	@RequestMapping("/updateDemo")
	public String updateDemo(Demo demo, HttpServletRequest request) {
		System.out.println("---- DemoController updateDemo ----");
		int updateNum = this.demoService.updateByPrimaryKeySelective(demo);
		if (updateNum == 1) {
			request.setAttribute("InfoMessage", "编辑demo成功");
			return "redirect:/demo/listAll";
		} else {
			request.setAttribute("InfoMessage", "编辑demo失败");
			return "/demo/editDemo";
		}
	}

	@RequestMapping("/addDemo")
	public String addDemo(HttpServletRequest request) {
		System.out.println("---- addDemo ----");
		return "/demo/addDemo";
	}

	@RequestMapping("/insertDemo")
	public String insertDemo(Demo demo, HttpServletRequest request) {
		System.out.println("---- insertDemo ----");
		int insertNum = this.demoService.insertSelective(demo);
		if (insertNum == 1) {
			request.setAttribute("InfoMessage", "新建demo成功");
			return "redirect:/demo/listAll";
		} else {
			request.setAttribute("InfoMessage", "新建demo失败");
			return "/demo/addDemo";
		}

	}
	
	@RequestMapping("/deleteDemo")
	public String deleteDemo(HttpServletRequest request) {
		System.out.println("---- deleteDemo ----");
		int id = Integer.parseInt(request.getParameter("id"));
		int deleteNum = this.demoService.deleteByPrimaryKey(id);
		if (deleteNum == 1) {
			request.setAttribute("InfoMessage", "删除demo成功");
			return "redirect:/demo/listAll";
		} else {
			request.setAttribute("InfoMessage", "删除demo失败");
			return "redirect:/demo/listAll";
		}

	}

}
