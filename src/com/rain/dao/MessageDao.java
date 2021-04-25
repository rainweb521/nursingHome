package com.rain.dao;

import static com.rain.util.common.Constants.MESSAGETABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.BedDynaSqlProvider;
import com.rain.dao.provider.MessageDynaSqlProvider;
import com.rain.dao.provider.NoticeDynaSqlProvider;
import com.rain.domain.Bed;
import com.rain.domain.Message;
import com.rain.domain.Yuyue;

public interface MessageDao {

	@Select("select * from "+MESSAGETABLE+" ")
	List<Message> get_List();
	
	@Select("select * from "+MESSAGETABLE+"  where title like CONCAT('%',#{content},'%')")
	List<Message> get_LikeList(String content);

	@SelectProvider(type=MessageDynaSqlProvider.class,method="insert")
	void insert_Info(Message employee);
	
	@Select("select * from "+MESSAGETABLE+" where id = #{id}")
	Message get_Info(Integer id);

	@SelectProvider(type=MessageDynaSqlProvider.class,method="update")
	void update_Info(Message employee);
	// 根据id删除部门
	@Delete(" delete from "+MESSAGETABLE+" where id = #{id} ")
	void delete_Info(Integer id);

	@Select("select * from "+MESSAGETABLE+" where status = #{string}")
	Message getStatus(String string);

}
