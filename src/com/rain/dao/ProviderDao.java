package com.rain.dao;

import static com.rain.util.common.Constants.PROVIDERTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.BedDynaSqlProvider;
import com.rain.dao.provider.NoticeDynaSqlProvider;
import com.rain.dao.provider.ProviderDynaSqlProvider;
import com.rain.domain.Bed;
import com.rain.domain.Provider;

public interface ProviderDao {

	@Select("select * from "+PROVIDERTABLE+" ")
	List<Provider> get_List();
	
	@Select("select * from "+PROVIDERTABLE+"  where name like CONCAT('%',#{content},'%')")
	List<Provider> get_LikeList(String content);

	@SelectProvider(type=ProviderDynaSqlProvider.class,method="insert")
	void insert_Info(Provider job);
	
	@Select("select * from "+PROVIDERTABLE+" where id = #{id}")
	Provider get_Info(Integer id);

	@SelectProvider(type=ProviderDynaSqlProvider.class,method="update")
	void update_Info(Provider job);
	// 根据id删除部门
	@Delete(" delete from "+PROVIDERTABLE+" where id = #{id} ")
	void delete_Info(Integer id);

}
