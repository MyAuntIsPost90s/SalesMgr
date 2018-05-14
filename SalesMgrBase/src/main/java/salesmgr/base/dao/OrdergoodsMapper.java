package salesmgr.base.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import lingshi.mybaties.mapperextend.BaseMapper;
import salesmgr.base.model.Ordergoods;

public interface OrdergoodsMapper extends BaseMapper<Ordergoods> {

	/**
	 * 获取各项值的统计数据
	 * 
	 * @param userid
	 * @param ordertime
	 * @param type
	 * @return
	 */
	Ordergoods getItemSum(@Param("userid") String userid, @Param("ordertime") Date ordertime,
			@Param("ordertype") Integer ordertype, @Param("type") String type);
}