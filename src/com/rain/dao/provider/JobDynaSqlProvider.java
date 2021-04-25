package com.rain.dao.provider;

import static com.rain.util.common.Constants.JOBTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Job;

public class JobDynaSqlProvider {
	// 动态插入
			public String insertDept(Job job){
				
				return new SQL(){
					{
						INSERT_INTO(JOBTABLE);
						if(job.getName() != null && !job.getName().equals("")){
							VALUES("name", "#{name}");
						}
						if(job.getRemark() != null && !job.getRemark().equals("")){
							VALUES("remark", "#{remark}");
						}
						if(job.getAge() != null){
							VALUES("age", "#{age}");
						}
						if(job.getSex() != null){
							VALUES("sex", "#{sex}");
						}
					}
				}.toString();
			}	
			// 动态更新
			public String updateDept(Job job){
				
				return new SQL(){
					{
						UPDATE(JOBTABLE);
						if(job.getName() != null){
							SET(" name = #{name} ");
						}
						if(job.getRemark() != null){
							SET(" remark = #{remark} ");
						}
						if(job.getAge() != null){
							SET(" age = #{age} ");
						}
						if(job.getSex() != null){
							SET(" sex = #{sex} ");
						}
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
