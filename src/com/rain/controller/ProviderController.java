package com.rain.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Bed;
import com.rain.domain.Job;
import com.rain.domain.Notice;
import com.rain.domain.Provider;
import com.rain.service.RainService;

@Controller
public class ProviderController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/provider/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("provider/list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/provider/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/provider/list";
			return blank;
		}
		@RequestMapping(value="/provider/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<Provider> job_list = rainservice.get_ProviderList();
			if (content!=null){
				job_list = rainservice.get_ProviderLikeList(content);
			}
			model.addAttribute("list",job_list);
			return "provider/list";
		}
		@RequestMapping(value="/provider/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				Provider job = rainservice.get_ProviderInfo(id);
				model.addAttribute("job",job);
			}
			return "/provider/add";
		}
		@RequestMapping(value="/provider/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv,@ModelAttribute Provider notice ,Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.update_ProviderInfo(notice);
			}else{
				rainservice.insert_ProviderInfo(notice);
			}
			mv.setViewName("redirect:/provider/list");
			return mv;
		}
		@RequestMapping(value="/provider/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.delete_ProviderInfo(id);
			}
		}
}
