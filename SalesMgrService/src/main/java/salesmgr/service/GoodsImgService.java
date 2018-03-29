package salesmgr.service;

import java.util.List;

import salesmgr.base.model.Goodsimg;

public interface GoodsImgService {

	List<Goodsimg> list(String goodsid);
	
	void update(List<String> urls, String goodsid);
	
	void deleteByGoodsId(String goodsid);
}
