package com.rain.dao.provider;

import static com.rain.util.common.Constants.NOTICETABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Notice;

public class NoticeDynaSqlProvider {
			// 动态插入
			public String insert_Notice(Notice job){
				
				return new SQL(){
					{
						INSERT_INTO(NOTICETABLE);
						if(job.getTitle() != null ){
							VALUES("title", "#{title}");
						}
						if(job.getHeat()!=null){
							VALUES("heat","#{heat}");
						}
						if(job.getPabulum()!=null){
							VALUES("pabulum","#{pabulum}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getPrice()!=null){
							VALUES("price","#{price}");
						}
						if(job.getRemark()!=null){
							VALUES("remark","#{remark}");
						}
						if(job.getType()!=null){
							VALUES("type","#{type}");
						}
					
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(Notice job){
				
				return new SQL(){
					{
						UPDATE(NOTICETABLE);
						if(job.getTitle() != null ){
							SET("title = #{title}");
						}
						if(job.getHeat()!=null){
							SET("heat = #{heat}");
						}
						if(job.getPabulum()!=null){
							SET("pabulum = #{pabulum}");
						}
						if(job.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if(job.getPrice()!=null){
							SET("price = #{price}");
						}
						if(job.getRemark()!=null){
							SET("remark = #{remark}");
						}
						if(job.getType()!=null){
							SET("type = #{type}");
						}
				
						
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
