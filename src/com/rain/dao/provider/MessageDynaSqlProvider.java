package com.rain.dao.provider;

import static com.rain.util.common.Constants.MESSAGETABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Bed;
import com.rain.domain.Message;
import com.rain.domain.Notice;
import com.rain.domain.Yuyue;

public class MessageDynaSqlProvider {
			// 动态插入
			public String insert(Message job){
				
				return new SQL(){
					{
						INSERT_INTO(MESSAGETABLE);
						if(job.getTitle() != null ){
							VALUES("title", "#{title}");
						}
						if(job.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
						if(job.getContent()!=null){
							VALUES("content","#{content}");
						}
						if(job.getU_id() != 0){
							VALUES("u_id","#{u_id}");
						}
						if(job.getReply()!=null){
							VALUES("reply","#{reply}");
						}
						
						
					}
				}.toString();
			}	
			
			// 动态更新
			public String update(Message job){
				
				return new SQL(){
					{
						UPDATE(MESSAGETABLE);
						if(job.getTitle() != null ){
							SET("title = #{title}");
						}
						if(job.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
						if(job.getContent()!=null){
							SET("content = #{content}");
						}
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
			
}
