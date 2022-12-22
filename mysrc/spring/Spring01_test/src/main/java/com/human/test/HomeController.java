package com.human.test;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String wrForm(Locale locale, Model model) {
		
		return "wrForm";
	}
	@RequestMapping(value = "/wrchk", method = RequestMethod.GET)
	public String wrchk(Locale locale, Model model) {
		model.addAttribute("list",list);
		return "wrchk";
	}
	@RequestMapping(value = "/wrAction", method = RequestMethod.GET)
	public String wrAction(Locale locale, Model model,BoardVO bvo) {
		model.addAttribute("list",list);
		model.addAttribute("name",bvo.getName());
		model.addAttribute("pass",bvo.getPass());
		model.addAttribute("email",bvo.getEmail());
		model.addAttribute("title",bvo.getTitle());
		model.addAttribute("content",bvo.getContent());
		list.add(bvo);
		return "wrchk";
	}
}
