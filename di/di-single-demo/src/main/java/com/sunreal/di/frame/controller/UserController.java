package com.sunreal.di.frame.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunreal.di.frame.po.User;
import com.sunreal.di.frame.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		String userName = request.getParameter("loginName");
		String password = request.getParameter("password");

		//根据用户名查询登陆用户信息
		User user = this.userService.selectByUserName(userName);
		if(user!=null){
			//匹配密码，如果密码匹配成功，则登陆到主压面
			if(password.equals(user.getPassword())){
				return "/frame/frame";
			}else{//如果密码登陆失败，则返回登陆页面，并提示用户名密码错误
				return "/login";
			}
		}else{//如果没有查询到用户，返回登陆页面，并提示用户名密码错误
			return "/login";
		}
	}

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "/user/showUser";
	}
	
    //用户列表——显示所有用户
	@RequestMapping("/userListAll")
	public String userListAll(HttpServletRequest request,Model model){
		List<User> user=this.userService.listAll();
		model.addAttribute(user);
		return "/user/userListAll";
	}
	
    //用户列表——跳转到创建新用户
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request){
		System.out.println("---- addUser ----");
		return "/user/addUser";
	}
	
    //用户列表——插入新用户
	@RequestMapping("/insertUser")
	public String insertUser(HttpServletRequest request,User user){
		String pwd=request.getParameter("password");
		int insertNum=this.userService.insertSelective(user);
		System.out.println("--insertUser--");
		if (insertNum == 1) {
			request.setAttribute("InfoMessage", "新建user成功");
			return "redirect:/user/userListAll";
		} else {
			request.setAttribute("InfoMessage", "新建user失败");
			return "/user/addUser";
		}
	}
	
    //用户列表——跳转到修改用户
	@RequestMapping("/editUser")
	public String getUserById(HttpServletRequest request,Model model){
		int id=Integer.parseInt(request.getParameter("id"));
		User user=this.userService.selectByPrimaryKey(id);
		request.setAttribute("user", user);
		return "/user/editUser";
	}
	
    //用户列表——更新用户信息
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){
		System.out.println("---- UserController updateUser ----");
        
		int updateNum = this.userService.updateByPrimaryKeySelective(user);
		if (updateNum == 1) {
			request.setAttribute("InfoMessage", "编辑user成功");
			return "redirect:/user/userListAll";
		} else {
			request.setAttribute("InfoMessage", "编辑user失败");
			return "/user/editUser";
		}
	}
//	用户列表——删除用户信息
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		int deleteNum=this.userService.deleteUser(id);
		System.out.println("deleteNum"+deleteNum);
//		if (deleteNum == 1) {
//			request.setAttribute("InfoMessage", "删除user成功");
//		} else {
//			request.setAttribute("InfoMessage", "删除user失败");
//		}
		return "redirect:/user/userListAll?flag="+deleteNum;
	}
}
