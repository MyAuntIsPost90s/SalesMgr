package salesmgr.service;

import java.util.List;

import salesmgr.base.model.Orderform;
import salesmgr.base.model.Ordergoods;
import salesmgr.uimodel.EUIPageList;

public interface OrderFormService {
	/**
	 * 获取单条数据
	 * 
	 * @param userId
	 * @return
	 */
	Orderform single(String orderformid);

	/**
	 * 获取集合列表
	 * 
	 * @param userinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Orderform> list(Orderform orderform, int page, int rows);

	/**
	 * 添加
	 * 
	 * @param userinfo
	 * @param stringBuilder
	 */
	void add(List<Ordergoods> ordergoods, String userid) throws Exception;

	/**
	 * 修改
	 * 
	 * @param userinfo
	 */
	void update(Orderform orderform);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<String> ids);
}
