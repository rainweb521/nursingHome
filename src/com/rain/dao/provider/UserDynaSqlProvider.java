package com.rain.dao.provider;

import static com.rain.util.common.Constants.USERTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.User;

public class UserDynaSqlProvider {
			// 动态插入
			public String insert_Notice(User job){
				
				return new SQL(){
					{
						INSERT_INTO(USERTABLE);
						if(job.getLoginname() != null ){
							VALUES("loginname", "#{loginname}");
						}
						if(job.getPassword()!=null){
							VALUES("password","#{password}");
						}
						if(job.getUsername()!=null){
							VALUES("username","#{username}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getAddress()!=null){
							VALUES("address","#{address}");
						}
						if(job.getPhone()!=null){
							VALUES("phone","#{phone}");
						}
						if(job.getStatus()!=null){
							VALUES("status","#{status}");
						}
					
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(User job){
				
				return new SQL(){
					{
						UPDATE(USERTABLE);
						if(job.getLoginname() != null ){
							SET("loginname = #{loginname}");
						}
						if(job.getPassword()!=null){
							SET("password = #{password}");
						}
						if(job.getUsername()!=null){
							SET("username = #{username}");
						}
						if(job.getAddress()!=null){
							SET("address = #{address}");
						}
						if(job.getPhone()!=null){
							SET("phone = #{phone}");
						}
						if(job.getStatus()!=null){
							SET("status = #{status}");
						}
				
						
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
