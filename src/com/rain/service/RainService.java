package com.rain.service;

import java.util.List;

import com.rain.domain.User;
import com.rain.domain.Bed;
import com.rain.domain.Dept;
import com.rain.domain.Employee;
import com.rain.domain.Yuyue;
import com.rain.domain.Job;
import com.rain.domain.Message;
import com.rain.domain.Notice;
import com.rain.domain.Provider;

public interface RainService {
	/**
	 * 组织信息的service
	 * @param content
	 * @return
	 */
	List<Dept> findAllDept(String content);
	
	void addDept(Dept dept);

	Dept get_Info(Integer id);

	void update_Info(Dept dept);

	void delete_Info(Integer id);

	List<Dept> findAllDept();
	/**
	 * 信息的service
	 * @return
	 */

	List<Job> findAllJob();
	
	List<Job> findAllJob(String content);

	Job get_JobInfo(Integer id);

	void update_JobInfo(Job job);

	void insert_JobInfo(Job job);

	void delete_JobInfo(Integer id);
	/**
	 * 活动信息的service
	 */
	List<Employee> get_EmployeeList();
	List<Employee> get_EmployeeLikeList(String content);
	Employee get_EmployeeInfo(Integer id);
	void update_EmployeeInfo(Employee data);
	void insert_EmployeeInfo(Employee data);
	void delete_EmployeeInfo(Integer id);
	Employee login2(String loginname, String password);

	
	List<Bed> get_BedList();
	List<Bed> get_BedLikeList(String content);
	Bed get_BedInfo(Integer id);
	void update_BedInfo(Bed notice);
	void insert_BedInfo(Bed notice);
	void delete_BedInfo(Integer id);
	
	List<Notice> get_NoticeList();
	
	List<Notice> get_NoticeLikeList(String date,String content);

	Notice get_NoticeInfo(Integer id);

	void update_NoticeInfo(Notice notice);

	void insert_NoticeInfo(Notice notice);

	void delete_NoticeInfo(Integer id);



	void delete_DocumentInfo(Integer id);

	User login(String loginname, String password);

	List<User> get_UserList();

	List<User> get_UserLikeList(String content);

	User get_UserInfo(Integer id);

	void update_UserInfo(User notice);

	void insert_UserInfo(User notice);

	void delete_UserInfo(Integer id);

	
	
	List<Provider> get_ProviderList();
	List<Provider> get_ProviderLikeList(String content);
	Provider get_ProviderInfo(Integer id);
	void update_ProviderInfo(Provider notice);
	void insert_ProviderInfo(Provider notice);
	void delete_ProviderInfo(Integer id);

	void insert_yuyue(Yuyue notice);

	List<Yuyue> get_YuyueList();

	Bed get_BedByStatus(String string);

	List<Message> get_MessageList();

	void update_MessageInfo(Message notice);

	void insert_MessageInfo(Message notice);

	void delete_MessageInfo(Integer id);

	
	
}
