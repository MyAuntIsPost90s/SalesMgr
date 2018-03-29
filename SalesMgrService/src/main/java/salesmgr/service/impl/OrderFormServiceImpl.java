package salesmgr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import salesmgr.base.dao.OrderformMapper;
import salesmgr.base.model.Orderform;
import salesmgr.base.model.Ordergoods;
import salesmgr.service.OrderFormService;
import salesmgr.service.OrderGoodsService;
import salesmgr.uimodel.EUIPageList;
import salesmgr.util.RandomNum;

@Service
public class OrderFormServiceImpl implements OrderFormService {

	@Resource
	private OrderformMapper orderformMapper;
	@Resource
	private OrderGoodsService orderGoodsService;

	@Override
	public Orderform single(String orderformid) {
		return orderformMapper.getSingle(orderformid);
	}

	@Override
	public EUIPageList<Orderform> list(Orderform orderform, int page, int rows) {
		PageList<Orderform> pageList = orderformMapper.getListWithPage(orderform, new PageBounds(page, rows));
		return new EUIPageList<Orderform>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void add(List<Ordergoods> ordergoods, String userid) throws Exception {
		Orderform orderform = new Orderform();
		orderform.setOrderid(RandomNum.getLGID());
		// 生成订单详情
		float sum = 0f;
		for (Ordergoods item : ordergoods) {
			item.setOrderid(orderform.getOrderid());
			orderGoodsService.add(item);
			sum += item.getOrdergoodscount() * item.getOrdergoodsprice();
		}
		// 生成订单
		orderform.setOrdertime(new Date());
		orderform.setOrderprice(sum);
		orderform.setUserid(userid);
		orderformMapper.insert(orderform);
	}

	@Override
	public void update(Orderform orderform) {
		orderformMapper.update(orderform);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void batchDelete(List<String> ids) {
		List<String> orderids = new ArrayList<String>();
		Ordergoods condition = new Ordergoods();
		for (String id : ids) {
			condition.setOrderid(id);
			EUIPageList<Ordergoods> list = orderGoodsService.list(condition, 1, 9999);
			if (list.getTotal() < 1) {
				continue;
			}
			for (Ordergoods ordergoods : list.getRows()) {
				orderids.add(ordergoods.getOrdergoodsid());
			}
		}
		if (orderids != null && orderids.size() > 0) {
			orderGoodsService.batchDelete(orderids);
		}
		orderformMapper.batchDelete(ids);
	}

}
