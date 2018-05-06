package salesmgr.service;

import java.util.List;

import salesmgr.base.model.Goods;
import salesmgr.base.model.dto.GoodsDto;
import salesmgr.uimodel.EUIPageList;

public interface GoodsService {
	/**
	 * 获取单条数据
	 * 
	 * @param userId
	 * @return
	 */
	GoodsDto single(String goodsid);

	/**
	 * 获取集合列表
	 * 
	 * @param userinfo
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<GoodsDto> list(Goods goods, int page, int rows);

	/**
	 * 添加
	 * 
	 * @param userinfo
	 * @param stringBuilder
	 */
	void add(Goods goods,String urls);

	/**
	 * 修改
	 * 
	 * @param userinfo
	 */
	void update(Goods goods,String urls);
	
	/**
	 * 仅修改数量
	 * 
	 * @param goods
	 */
	void update4count(Goods goods);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<String> ids);
}
