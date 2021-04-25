package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.DEPTTABLE;

import com.rain.domain.Dept;

public class DeptDynaSqlProvider {
	
	// 动态插入
		public String insertDept(Dept dept){
			
			return new SQL(){
				{
					INSERT_INTO(DEPTTABLE);
					if(dept.getName() != null && !dept.getName().equals("")){
						VALUES("name", "#{name}");
					}
					if(dept.getRemark() != null && !dept.getRemark().equals("")){
						VALUES("remark", "#{remark}");
					}
					if(dept.getAge() != null){
						VALUES("age", "#{age}");
					}
					if(dept.getSex() != null){
						VALUES("sex", "#{sex}");
					}
					
				}
			}.toString();
		}	
		// 动态更新
		public String updateDept(Dept dept){
			
			return new SQL(){
				{
					UPDATE(DEPTTABLE);
					if(dept.getName() != null){
						SET(" name = #{name} ");
					}
					if(dept.getRemark() != null){
						SET(" remark = #{remark} ");
					}
					if(dept.getAge() != null){
						SET(" age = #{age} ");
					}
					if(dept.getSex() != null){
						SET(" sex = #{sex} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
