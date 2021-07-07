package com.example.demo.controller;

import com.example.demo.exception.BizException;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {


	@PostMapping("/user")
	public boolean insert(User user) {
		System.out.println("开始新增...");
		//如果姓名为空就手动抛出一个自定义的异常！
		if (user.getName() == null) {
			throw new BizException("-1", "用户姓名不能为空！");
		}
		return true;
	}

	@PutMapping("/user")
	public boolean update(User user) {
		System.out.println("开始更新...");
		//这里故意造成一个空指针的异常，并且不进行处理
		String str = null;
		str.equals("111");
		return true;
	}

	@DeleteMapping("/user")
	public boolean delete(User user) {
		System.out.println("开始删除...");
		//这里故意造成一个字符转换异常，并且不进行处理
		Integer.parseInt("abc123");
		System.out.println("发生异常后继续执行");
		return true;
	}

	@GetMapping("/user")
	public List<User> findByUser(User user) {
		System.out.println("开始查询...");
		List<User> userList = new ArrayList<>();
		User user2 = new User();
		user2.setId(1);
		user2.setName("liuliu");
		user2.setAge(18);
		userList.add(user2);
		return userList;
	}


}