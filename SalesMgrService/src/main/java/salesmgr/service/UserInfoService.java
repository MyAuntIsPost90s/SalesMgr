package salesmgr.service;

import java.util.Date;
import java.util.List;

import salesmgr.base.model.Userinfo;
import salesmgr.base.model.dto.UserSalaryDto;
import salesmgr.uimodel.EUIPageList;

public interface UserInfoService {

	/**
	 * 登陆
	 * 
	 * @param userinfo
	 * @param stringBuilder
	 * @return
	 */
	Userinfo login(Userinfo userinfo, StringBuilder stringBuilder);

	/**
	 * 获取单条数据
	 * 
	 * @param userId
	 * @return
	 */
	Userinfo single(String userId);

	/**
	 * 获取集合列表
	 * 
	 * @param userinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Userinfo> list(Userinfo userinfo, int page, int rows);

	/**
	 * 获取用户某月薪资
	 * 
	 * @param userinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<UserSalaryDto> list4salary(Userinfo userinfo, Date date, int page, int rows);

	/**
	 * 添加
	 * 
	 * @param userinfo
	 * @param stringBuilder
	 */
	boolean add(Userinfo userinfo, StringBuilder stringBuilder);

	/**
	 * 修改
	 * 
	 * @param userinfo
	 */
	void update(Userinfo userinfo);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<String> ids);

	/**
	 * 获取员工工资总和
	 * 
	 * @return
	 */
	Integer getStaffWages();
}
