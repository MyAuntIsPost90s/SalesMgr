package salesmgr.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import salesmgr.base.dao.GoodsMapper;
import salesmgr.base.model.Goods;
import salesmgr.base.model.dto.GoodsDto;
import salesmgr.service.GoodsImgService;
import salesmgr.service.GoodsKindService;
import salesmgr.service.GoodsService;
import salesmgr.uimodel.EUIPageList;
import salesmgr.util.RandomNum;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private GoodsKindService goodsKindService;
	@Resource
	private GoodsImgService goodsImgService;

	@Override
	public GoodsDto single(String goodsid) {
		Goods goods = goodsMapper.getSingle(goodsid);
		GoodsDto goodsDto = new GoodsDto(goods);
		goodsDto.setGoodskind(goodsKindService.single(goods.getGoodskindid()));
		goodsDto.setGoodsimgs(goodsImgService.list(goods.getGoodsid()));
		return goodsDto;
	}

	@Override
	public EUIPageList<GoodsDto> list(Goods goods, int page, int rows) {
		PageList<Goods> pageList = goodsMapper.getListWithPage(goods, new PageBounds(page, rows));
		List<GoodsDto> result = new ArrayList<GoodsDto>();
		for (Goods item : pageList) {
			GoodsDto goodsDto = new GoodsDto(item);
			goodsDto.setGoodskind(goodsKindService.single(item.getGoodskindid()));
			goodsDto.setGoodsimgs(goodsImgService.list(item.getGoodsid()));
			result.add(goodsDto);
		}
		return new EUIPageList<GoodsDto>(pageList.getPaginator().getTotalCount(), result);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void add(Goods goods, String urls) {
		goods.setGoodsid(RandomNum.getLGID());
		goods.setGoodstime(new Date());
		goodsMapper.insert(goods);

		if (urls != null && !urls.isEmpty()) { // 当图片存在时先保存图片到数据库
			String[] urlList = urls.split(",");
			goodsImgService.update(Arrays.asList(urlList), goods.getGoodsid());
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void update(Goods goods, String urls) {
		if (urls != null && !urls.isEmpty()) { // 当图片存在时先保存图片到数据库
			String[] urlList = urls.split(",");
			goodsImgService.update(Arrays.asList(urlList), goods.getGoodsid());
		}
		goodsMapper.update(goods);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void batchDelete(List<String> ids) {
		for (String id : ids) {
			goodsImgService.deleteByGoodsId(id);
		}
		goodsMapper.batchDelete(ids);
	}

}
