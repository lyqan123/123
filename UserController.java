package com.baidu.easyui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.easyui.entity.User;
import com.baidu.easyui.service.IUserService;
import com.baidu.easyui.vo.DataGrid;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
    /**
     * 
     * @param page 当前页
     * @param rows 每页展示的条数
     * @return
     */
	@RequestMapping("/getAll")
	@ResponseBody //给前台返回一个json数据
	public DataGrid<User> getAll(String page,String rows){
		
		
		return userService.getAll(page,rows);
	}
	@RequestMapping("add")
	@ResponseBody
	public String add(User user){
		boolean flag = userService.add(user);
		//TODO 后期优化
		if(flag){
			return "ok";
		}
		return "添加失败";
	}
	
/*	public static void main(String[] args) {
		
		//if(总条数%每页显示的条数>0){ 总条数/每页显示的条数+1}
		int pageCount=0;//分几页
		if(30%5>0){
			pageCount= 32/5+1;
		}else{
			pageCount = 30/5;
		}
		
		System.out.println(pageCount);
		
	}*/
}
