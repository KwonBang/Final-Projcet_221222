package com.join.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	//회원가입화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "byeongkuk/home";
	}
	//체크박스화면
	@RequestMapping(value = "/checkStudy", method = RequestMethod.GET)
	public String checkStudy(Locale locale, Model model) {
		return "byeongkuk/checkStudy";
	}
	
	@RequestMapping("qqq")
	public String qqq() {
		
		return "byeongkuk/qqq";
	}
	@RequestMapping("api")
	public String api() {
		return "byeongkuk/api";
	}
	@ResponseBody
	@RequestMapping("idCheck")
	public Map<String,Object> idCheck(@RequestParam(value="id") String id) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return map;
	}
	@ResponseBody
	@RequestMapping("phone")
	public Map<String,Object> phone(@RequestParam(value="phoneNum") String phoneNum) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("phoneNum", phoneNum);
		
		return map;
	}
}
