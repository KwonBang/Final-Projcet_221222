package com.human.web01;

import java.util.Locale;

import javax.inject.Inject;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.IF_Vipcusservice;
import com.human.vo.VipcusVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject 
	IF_Vipcusservice vsrv;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/movejoin", method = RequestMethod.GET)
	public String moveJoin(Locale locale, Model model) {
		return "join";
	}
	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String join(Locale locale, Model model, VipcusVO vvo) throws Exception {
		vsrv.insert(vvo);
		return "home";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) throws Exception {
		model.addAttribute("list", vsrv.select());
		return "cuslist";
	}
	@RequestMapping(value = "/selectOne", method = RequestMethod.GET)
	public String selectOne(Locale locale, Model model,VipcusVO vvo) throws Exception {
		model.addAttribute("vvo",vsrv.selectOne(vvo));
		return "info";
	}
	@RequestMapping(value = "/mod_view", method = RequestMethod.GET)
	public String mod_view(Locale locale, Model model,VipcusVO vvo) throws Exception {
		model.addAttribute("vvo",vsrv.selectOne(vvo));
		return "mod";
	}
	@RequestMapping(value = "/mod", method = RequestMethod.GET)
	public String mod(Locale locale, Model model,VipcusVO vvo) throws Exception {
		vsrv.mod(vvo);
		return "home";
	}
	@RequestMapping(value = "/del_view", method = RequestMethod.GET)
	public String del_view(Locale locale, Model model,VipcusVO vvo) throws Exception {
		vsrv.del(vvo);
		return "home";
	}
}
