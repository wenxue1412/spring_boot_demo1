package com.edu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.domain.UserInfo;

@Controller
@RequestMapping("/user")
public class LoginController {

	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> login(@RequestBody UserInfo user) {
		System.out.print(user.getUsername());
		Map<String,String> resultMap = new HashMap<String,String>();
		if("wenxue".equals(user.getUsername()) && "wenxue19970102".equals(user.getPassword())) {
			resultMap.put("result", "success");
			return resultMap;
		} else {
			resultMap.put("result", "failed");
			resultMap.put("reason", "用户名或密码错误");
			return resultMap;
		}
	}
}
