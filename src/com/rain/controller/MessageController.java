package com.rain.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.rain.domain.Message;
import com.rain.domain.Notice;
import com.rain.domain.User;
import com.rain.domain.Yuyue;
import com.rain.service.RainService;
import com.rain.util.common.Constants;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	private String PREFIX = "/message";
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName(PREFIX+"list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = PREFIX+"/list";
			return blank;
		}
		
		
		@RequestMapping(value="/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<Message> job_list = rainservice.get_MessageList();
			
			model.addAttribute("list",job_list);
			return PREFIX+"/list";
		}
		@RequestMapping(value="/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			System.out.println("***///");
			if(id!=null){
				Bed job = rainservice.get_BedInfo(id);
				model.addAttribute("job",job);
			}
			return PREFIX+"/add";
		}
		@RequestMapping(value="/add",method=RequestMethod.POST)
		 public void add(String title,String content,String create_date ,Integer id,HttpSession session){
			System.out.println("***///");
			Message message = new Message();
			message.setCreate_date(create_date);
			message.setTitle(title);
			message.setContent(content);
			User user = (User) session.getAttribute(Constants.USER_SESSION);
			message.setU_id(user.getId());
			message.setReply("");
			if(id!=null){
				rainservice.update_MessageInfo(message);
			}else{
				rainservice.insert_MessageInfo(message);
			}
			
		}
		@RequestMapping(value="/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.delete_MessageInfo(id);
			}
		}
}
