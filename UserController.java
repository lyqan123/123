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
     * @param page ��ǰҳ
     * @param rows ÿҳչʾ������
     * @return
     */
	@RequestMapping("/getAll")
	@ResponseBody //��ǰ̨����һ��json����
	public DataGrid<User> getAll(String page,String rows){
		
		
		return userService.getAll(page,rows);
	}
	@RequestMapping("add")
	@ResponseBody
	public String add(User user){
		boolean flag = userService.add(user);
		//TODO �����Ż�
		if(flag){
			return "ok";
		}
		return "���ʧ��";
	}
	
/*	public static void main(String[] args) {
		
		//if(������%ÿҳ��ʾ������>0){ ������/ÿҳ��ʾ������+1}
		int pageCount=0;//�ּ�ҳ
		if(30%5>0){
			pageCount= 32/5+1;
		}else{
			pageCount = 30/5;
		}
		
		System.out.println(pageCount);
		
	}*/
}
