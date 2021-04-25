package com.rain.dao.provider;

import static com.rain.util.common.Constants.EMPLOYEETABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Employee;

public class EmployeeDynaSqlProvider {
			// 动态插入
			public String insert_Employee(Employee job){
				
				return new SQL(){
					{
						INSERT_INTO(EMPLOYEETABLE);
						
						if(job.getAddress()!=null){
							VALUES("address","#{address}");
						}
						if(job.getBegin()!=null){
							VALUES("begin","#{begin}");
						}
						if(job.getEnd()!=null){
							VALUES("end","#{end}");
						}
						if(job.getDept_name()!=null){
							VALUES("dept_name","#{dept_name}");
						}
						if(job.getNum()!=null){
							VALUES("num","#{num}");
						}
						if(job.getTitle()!=null){
							VALUES("title","#{title}");
						}
						if(job.getContent()!=null){
							VALUES("content","#{content}");
						}
						
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getDept_id()!=null){
							VALUES("dept_id","#{dept_id}");
						}
					}
				}.toString();
			}	
			// 动态更新
			public String update_Employee(Employee job){
				
				return new SQL(){
					{
						UPDATE(EMPLOYEETABLE);
						if(job.getAddress() != null ){
							SET("address = #{address}");
						}
						if(job.getBegin()!=null){
							SET("begin = #{begin}");
						}
						if(job.getEnd()!=null){
							SET("end = #{end}");
						}
						if(job.getDept_name()!=null){
							SET("dept_name = #{dept_name}");
						}
						if(job.getNum()!=null){
							SET("num = #{num}");
						}
						if(job.getTitle()!=null){
							SET("title = #{title}");
						}
						if(job.getContent()!=null){
							SET("content = #{content}");
						}
						if(job.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if(job.getDept_id()!=null){
							SET("dept_id = #{dept_id}");
						}
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
