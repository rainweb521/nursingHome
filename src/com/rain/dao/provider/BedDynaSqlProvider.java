package com.rain.dao.provider;

import static com.rain.util.common.Constants.BEDTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Bed;
import com.rain.domain.Notice;
import com.rain.domain.Yuyue;

public class BedDynaSqlProvider {
			// 动态插入
			public String insert(Bed job){
				
				return new SQL(){
					{
						INSERT_INTO(BEDTABLE);
						if(job.getCode() != null ){
							VALUES("code", "#{code}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getFloor()!=null){
							VALUES("floor","#{floor}");
						}
						if(job.getPrice()!=null){
							VALUES("price","#{price}");
						}
						if(job.getRoom()!=null){
							VALUES("room","#{room}");
						}
						if(job.getStatus()!=null){
							VALUES("status","#{status}");
						}
						if(job.getNumber()!=null){
							VALUES("number","#{number}");
						}
						if(job.getType()!=null){
							VALUES("type","#{type}");
						}
						
					}
				}.toString();
			}	
			
			// 动态更新
			public String update(Bed job){
				
				return new SQL(){
					{
						UPDATE(BEDTABLE);
						if(job.getCode() != null ){
							SET("code = #{code}");
						}
						if(job.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if(job.getFloor()!=null){
							SET("floor = #{floor}");
						}
						if(job.getPrice()!=null){
							SET("price = #{price}");
						}
						if(job.getRoom()!=null){
							SET("room = #{room}");
						}
						if(job.getStatus()!=null){
							SET("status = #{status}");
						}
						if(job.getNumber()!=null){
							SET("number = #{number}");
						}
						if(job.getType()!=null){
							SET("type = #{type}");
						}
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
			public String insert_yuyue(Yuyue job){
				
				return new SQL(){
					{
						INSERT_INTO("yuyue");
						if(job.getBegin() != null ){
							VALUES("begin", "#{begin}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getEnd()!=null){
							VALUES("end","#{end}");
						}
						if(job.getBeginday()!=null){
							VALUES("beginday","#{beginday}");
						}
						if(job.getEndday()!=null){
							VALUES("endday","#{endday}");
						}
						if(job.getName()!=null){
							VALUES("name","#{name}");
						}
						
						
					}
				}.toString();
			}
}
