package salesmgr.base.dao;

import java.util.List;

import lingshi.mybaties.mapperextend.BaseMapper;
import salesmgr.base.model.Goodsimg;

public interface GoodsimgMapper extends BaseMapper<Goodsimg> {

	void deleteByGoodsId(String goodsid);

	void batchInsert(List<Goodsimg> goodsimgs);
}