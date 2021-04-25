package com.rain.dao;

import static com.rain.util.common.Constants.BEDTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.BedDynaSqlProvider;
import com.rain.dao.provider.NoticeDynaSqlProvider;
import com.rain.domain.Bed;
import com.rain.domain.Yuyue;

public interface BedDao {

	@Select("select * from "+BEDTABLE+" ")
	List<Bed> get_List();
	
	@Select("select * from "+BEDTABLE+"  where room like CONCAT('%',#{content},'%')")
	List<Bed> get_LikeList(String content);

	@SelectProvider(type=BedDynaSqlProvider.class,method="insert")
	void insert_Info(Bed employee);
	
	@Select("select * from "+BEDTABLE+" where id = #{id}")
	Bed get_Info(Integer id);

	@SelectProvider(type=BedDynaSqlProvider.class,method="update")
	void update_Info(Bed employee);
	// 根据id删除部门
	@Delete(" delete from "+BEDTABLE+" where id = #{id} ")
	void delete_Info(Integer id);

	@SelectProvider(type=BedDynaSqlProvider.class,method="insert_yuyue")
	void insert_yuyue(Yuyue notice);

	@Select("select * from yuyue ")
	List<Yuyue> get_Yuyuelist();

	@Select("select * from "+BEDTABLE+" where status = #{string}")
	Bed getStatus(String string);

}
