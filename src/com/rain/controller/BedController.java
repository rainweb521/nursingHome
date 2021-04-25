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
import com.rain.domain.Notice;
import com.rain.domain.User;
import com.rain.domain.Yuyue;
import com.rain.service.RainService;
import com.rain.util.common.Constants;

@Controller
public class BedController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/bed/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("bed/list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/bed/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/bed/list";
			return blank;
		}
		@RequestMapping(value="/bed/yuyue")
		 public String index3(){
			String blank = "/bed/yuyue";
			return blank;
		}
		@RequestMapping(value="/bed/addyuyue",method=RequestMethod.POST)
		 public ModelAndView yuyue(ModelAndView mv,@ModelAttribute Yuyue notice ){
			Date date = new Date();    
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			notice.setCreate_date(sdf.format(date));
			rainservice.insert_yuyue(notice);
			mv.addObject("message", "预约成功");
			mv.setViewName("forward:/bed/yuyue");
			return mv;
		}
		@RequestMapping(value="/bed/yuyuelist",method=RequestMethod.GET)
		 public String yuyuelist(Model model){
			List<Yuyue> job_list = rainservice.get_YuyueList();
			
			model.addAttribute("list",job_list);
			return "bed/yuyuelist";
		}
		@RequestMapping(value="/bed/list",method=RequestMethod.GET)
		 public String index(Model model,String content){
			List<Bed> job_list = rainservice.get_BedList();
			if (content!=null){
				job_list = rainservice.get_BedLikeList(content);
			}
			model.addAttribute("list",job_list);
			return "bed/list";
		}
		@RequestMapping(value="/bed/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				Bed job = rainservice.get_BedInfo(id);
				model.addAttribute("job",job);
			}
			return "/bed/add";
		}
		@RequestMapping(value="/bed/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv,@ModelAttribute Bed notice ,Integer id){
			System.out.println(id);
			Date date = new Date();    
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			notice.setCreate_date(sdf.format(date));
			if(id!=null){
				rainservice.update_BedInfo(notice);
			}else{
				rainservice.insert_BedInfo(notice);
			}
			mv.setViewName("redirect:/bed/list");
			return mv;
		}
		@RequestMapping(value="/bed/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.delete_BedInfo(id);
			}
		}
		@RequestMapping(value="/bed/yuyuebed",method=RequestMethod.GET)
		 public void yuyuebed(Integer id,HttpSession session){
			if(id!=null){
				Bed bed = rainservice.get_BedInfo(id);
				User user = (User) session.getAttribute(Constants.USER_SESSION);
				bed.setStatus(user.getId());
				rainservice.update_BedInfo(bed);
			}
		}
		@RequestMapping(value="/bed/cancelbed",method=RequestMethod.POST)
		 public void cancel(Integer id,HttpSession session){
			if(id!=null){
				Bed bed = rainservice.get_BedInfo(id);
				bed.setStatus(0);
				rainservice.update_BedInfo(bed);
			}
		}
		@RequestMapping(value="/bed/mybed",method=RequestMethod.GET)
		 public String cancel(Model model,HttpSession session){
			User user = (User) session.getAttribute(Constants.USER_SESSION);
			Bed bed = rainservice.get_BedByStatus(""+user.getId());
			
			model.addAttribute("job",bed);
			return "/bed/mybed";
			
		}
}
