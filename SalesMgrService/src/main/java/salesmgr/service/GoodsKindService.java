package salesmgr.service;

import java.util.List;

import salesmgr.base.model.Goodskind;
import salesmgr.uimodel.EUIPageList;
import salesmgr.uimodel.EUITree;

public interface GoodsKindService {

	/**
	 * 获取单条数据
	 * 
	 * @param userId
	 * @return
	 */
	Goodskind single(String goodskindid);

	/**
	 * 获取集合列表
	 * 
	 * @param userinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Goodskind> list(Goodskind goodskind, int page, int rows);

	/**
	 * 获取树状集合
	 * 
	 * @param goodskind
	 * @return
	 */
	List<EUITree> tree(Goodskind goodskind);

	/**
	 * 添加
	 * 
	 * @param userinfo
	 * @param stringBuilder
	 */
	void add(Goodskind goodskind);

	/**
	 * 修改
	 * 
	 * @param userinfo
	 */
	void update(Goodskind goodskind);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<String> ids);

}
