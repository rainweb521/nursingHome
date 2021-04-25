package com.rain.dao.provider;

import static com.rain.util.common.Constants.PROVIDERTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Bed;
import com.rain.domain.Notice;
import com.rain.domain.Provider;

public class ProviderDynaSqlProvider {
			// 动态插入
			public String insert(Provider job){
				
				return new SQL(){
					{
						INSERT_INTO(PROVIDERTABLE);
						if(job.getName() != null ){
							VALUES("name", "#{name}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getRemark()!=null){
							VALUES("remark","#{remark}");
						}
						if(job.getContent()!=null){
							VALUES("content","#{content}");
						}
						
						
					}
				}.toString();
			}	
			// 动态更新
			public String update(Provider job){
				
				return new SQL(){
					{
						UPDATE(PROVIDERTABLE);
						if(job.getName() != null ){
							SET("name = #{name}");
						}
						if(job.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if(job.getRemark()!=null){
							SET("remark = #{remark}");
						}
						if(job.getContent()!=null){
							SET("content = #{content}");
						}
						
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
