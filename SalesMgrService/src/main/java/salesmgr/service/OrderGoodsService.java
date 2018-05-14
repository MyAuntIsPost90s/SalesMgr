package salesmgr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import salesmgr.base.model.Ordergoods;
import salesmgr.common.OrderEnums.SearchOrderFormType;
import salesmgr.uimodel.EUIPageList;

public interface OrderGoodsService {

	/**
	 * 获取统计数据
	 * 
	 * @param userid
	 * @param date
	 * @return
	 */
	Ordergoods getItemSum(String userid, Date date);

	/**
	 * 获取财务报表
	 * 
	 * @return
	 */
	Map<String, String> getOrderForm(Date date, SearchOrderFormType orderFormType);

	/**
	 * 获取单条数据
	 * 
	 * @param userId
	 * @return
	 */
	Ordergoods single(String ordergoodsid);

	/**
	 * 获取集合列表
	 * 
	 * @param userinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Ordergoods> list(Ordergoods ordergoods, int page, int rows);

	/**
	 * 添加
	 * 
	 * @param userinfo
	 * @param stringBuilder
	 */
	void add(Ordergoods ordergoods, int ordertype) throws Exception;

	/**
	 * 修改
	 * 
	 * @param userinfo
	 */
	void update(Ordergoods ordergoods);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<String> ids);
}
