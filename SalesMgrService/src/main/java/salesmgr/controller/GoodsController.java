package salesmgr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import salesmgr.base.model.Goods;
import salesmgr.base.model.dto.GoodsDto;
import salesmgr.service.GoodsService;
import salesmgr.uimodel.EUIPageList;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	/**
	 * 获取集合列表
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, Goods goods, int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<GoodsDto> list = goodsService.list(goods, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单条数据
	 * 
	 * @param request
	 * @param response
	 * @param userId
	 */
	@ResponseBody
	@RequestMapping("/single")
	public void single(HttpServletRequest request, HttpServletResponse response, String goodsid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Goods goods = goodsService.single(goodsid);
			requestHolder.success(goods);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param userinfo
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(HttpServletRequest request, HttpServletResponse response, Goods goods, String urls) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			goodsService.update(goods, urls);
			requestHolder.success("操作成功", goods);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @param userinfo
	 */
	@ResponseBody
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response, Goods goods, String urls) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			goodsService.add(goods, urls);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param request
	 * @param response
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping("/batchDelete")
	public void batchDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<String> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			goodsService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
