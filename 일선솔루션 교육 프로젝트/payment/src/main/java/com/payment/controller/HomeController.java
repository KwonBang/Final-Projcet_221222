package com.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.payment.service.PaymentServiceImpl;

@Controller
public class HomeController {
	@Inject
	PaymentServiceImpl paymentService;
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "login",produces = "application/text; charset=UTF-8")
	public String login(@RequestParam Map<String,Object> map, HttpSession session, HttpServletResponse response) throws Exception {
		String message = "성공";
		Map<String, Object> loginMap = paymentService.login(map);
		if(loginMap==null) {
			message = "등록되지 않은 사용자입니다.";
		}else if(loginMap.get("password")==null||!loginMap.get("password").equals(map.get("password"))){
			message = "비밀번호가 일치하지 않습니다.";
		}else {
			if(session.getAttribute("id") != null){
				session.removeAttribute("id");
			}
			if(session.getAttribute("password") != null) {
				session.removeAttribute("password");
			}
			if(session.getAttribute("name") != null) {
				session.removeAttribute("name");
			}
			if(session.getAttribute("rank") != null) {
				session.removeAttribute("rank");
			}
			session.setAttribute("sessionId", map.get("id"));
			session.setAttribute("sessionPassword", map.get("password"));
			session.setAttribute("sessionName", loginMap.get("name"));
			session.setAttribute("sessionRank", loginMap.get("rank"));
		}
		return message;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping("main")
	public String main(HttpSession session,Model model) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", session.getAttribute("sessionId"));
		map.put("rank", session.getAttribute("sessionRank"));
		List<Map<String, Object>> listMap = paymentService.list(map);
		model.addAttribute("list", listMap);
		return "main";
	}
	//글쓰기버튼
	@RequestMapping("write")
	public String write(Model model, HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", session.getAttribute("sessionId"));
		map.put("name", session.getAttribute("sessionName"));
		map.put("rank", session.getAttribute("sessionRank"));
		map.put("listno", paymentService.listCount().get("listno"));
		model.addAttribute("map",map);
		model.addAttribute("pay","insert");
		return "payment";
	}
	
	@RequestMapping("payment")
	public String payment(Model model, HttpSession session,@RequestParam String listno) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listno", listno);
		List<Map<String,Object>> list = paymentService.historyList(map);
		map = paymentService.listNo(map);
		map.put("rank", session.getAttribute("sessionRank"));
		map.put("id", session.getAttribute("sessionId"));
		model.addAttribute("map",map);
		model.addAttribute("list",list);
		return "payment";
	}
	//결재상태 검색
	@RequestMapping("statusSearch")
	@ResponseBody
	public List<Map<String,Object>> statusSearch(HttpSession session,@RequestParam Map<String,Object> map) throws Exception {
		map.put("id", session.getAttribute("sessionId"));
		map.put("rank", session.getAttribute("sessionRank"));
		List<Map<String,Object>> list = paymentService.list(map);
		return list;
	}
	//검색버튼
	@RequestMapping("search")
	public String search(Model model,@RequestParam Map<String,Object> map,HttpSession session) throws Exception {
		map.put("rank", session.getAttribute("sessionRank"));
		map.put("id", session.getAttribute("sessionId"));
		List<Map<String,Object>> list = paymentService.list(map);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		return "main";
	}
	
	@RequestMapping("insert")
	public String insert(@RequestParam Map<String,Object> map,HttpSession session) throws Exception {
		map.put("sessionId", session.getAttribute("sessionId"));
		paymentService.insert(map);
		return "redirect:main";
	}
	
	@RequestMapping("update")
	public String update(@RequestParam Map<String,Object> map,HttpSession session) throws Exception {
		map.put("sessionId", session.getAttribute("sessionId"));
		paymentService.update(map);
		return "redirect:main";
	}
	
}

