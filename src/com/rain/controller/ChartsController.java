package com.rain.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
@RequestMapping("/charts")
public class ChartsController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	private String PREFIX = "/charts";
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName(PREFIX+"list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = PREFIX+"/"+formName;
			return blank;
		}
		
		
		@RequestMapping(value="/area",method=RequestMethod.GET)
		 public String index(Model model,String content) throws ParseException{
			String yz_time=getLastTimeInterval();//获取上周时间
	        String array[]=yz_time.split(",");
	        String start_time=array[0];//本周第一天
	        String end_time=array[1];  //本周最后一天 
	          //格式化日期     
	          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	          Date dBegin = sdf.parse(start_time);  
	          Date dEnd = sdf.parse(end_time);  
	          List<Date> lDate = findDates(dBegin, dEnd);//获取上周所有date
	          Map<String,Integer> map = new HashMap();
	         int i = 1;
	          for (Date date : lDate){  
	        	  List<String> job_list = rainservice.get_NoticeLikeList("date",sdf.format(date)).stream().map(Notice::getPrice).collect(Collectors.toList());
	        	  int sum = 0;
	        	  for (int j = 0 ;j < job_list.size();j++) {
	        		  sum = sum + Integer.parseInt(job_list.get(j));
	        	  }
	        	  map.put("data"+i, sum);
	        	  System.out.println(sdf.format(date));  
	           	i++;
	          }
	          model.addAttribute("data", map);
			return PREFIX+"/area";
		}
		

	    public String getTimeInterval(Date date) {  
	         Calendar cal = Calendar.getInstance();  
	         cal.setTime(date);  
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	         // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	         int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
	         if (1 == dayWeek) {  
	            cal.add(Calendar.DAY_OF_MONTH, -1);  
	         }  
	         // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期  
	         // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
	         cal.setFirstDayOfWeek(Calendar.MONDAY);  
	         // 获得当前日期是一个星期的第几天  
	         int day = cal.get(Calendar.DAY_OF_WEEK);  
	         // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
	         cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
	         String imptimeBegin = sdf.format(cal.getTime());  
	         // System.out.println("所在周星期一的日期：" + imptimeBegin);  
	         cal.add(Calendar.DATE, 6);  
	         String imptimeEnd = sdf.format(cal.getTime());  
	         // System.out.println("所在周星期日的日期：" + imptimeEnd);  
	         return imptimeBegin + "," + imptimeEnd;  
	    }
	    public static List<Date> findDates(Date dBegin, Date dEnd)  
	     {  
	      List lDate = new ArrayList();  
	      lDate.add(dBegin);  
	      Calendar calBegin = Calendar.getInstance();  
	      // 使用给定的 Date 设置此 Calendar 的时间  
	      calBegin.setTime(dBegin);  
	      Calendar calEnd = Calendar.getInstance();  
	      // 使用给定的 Date 设置此 Calendar 的时间  
	      calEnd.setTime(dEnd);  
	      // 测试此日期是否在指定日期之后  
	      while (dEnd.after(calBegin.getTime()))  
	      {  
	       // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
	       calBegin.add(Calendar.DAY_OF_MONTH, 1);  
	       lDate.add(calBegin.getTime());  
	      }  
	      return lDate;  
	     }
	    public String getLastTimeInterval() {  
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	         Calendar calendar1 = Calendar.getInstance();  
	         Calendar calendar2 = Calendar.getInstance();  
	         int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;  
	         int offset1 = 1 - dayOfWeek;  
	         int offset2 = 7 - dayOfWeek;  
	         calendar1.add(Calendar.DATE, offset1 - 7);  
	         calendar2.add(Calendar.DATE, offset2 - 7);  
	         // System.out.println(sdf.format(calendar1.getTime()));// last Monday  
	         String lastBeginDate = sdf.format(calendar1.getTime());  
	         // System.out.println(sdf.format(calendar2.getTime()));// last Sunday  
	         String lastEndDate = sdf.format(calendar2.getTime());  
	         return lastBeginDate + "," + lastEndDate;  
	    }
}
