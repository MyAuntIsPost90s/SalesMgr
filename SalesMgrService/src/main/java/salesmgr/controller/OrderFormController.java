package salesmgr.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import salesmgr.base.enums.UserInfoEnum.UserType;
import salesmgr.base.model.Orderform;
import salesmgr.base.model.Ordergoods;
import salesmgr.base.model.Userinfo;
import salesmgr.service.OrderFormService;
import salesmgr.uimodel.EUIPageList;

@Controller
@RequestMapping("/orderForm")
public class OrderFormController {

	@Resource
	private OrderFormService orderFormService;

	/**
	 * 获取集合
	 * 
	 * @param request
	 * @param response
	 * @param orderform
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response, Orderform orderform, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Userinfo nowUser = (Userinfo) requestHolder.getClientUser();
			if (nowUser.getUsertype() != UserType.ADMIN.value) {
				orderform.setUserid(nowUser.getUserid());
			}
			EUIPageList<Orderform> list = orderFormService.list(orderform, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加订单
	 * 
	 * @param request
	 * @param response
	 * @param ordergoods
	 */
	@ResponseBody
	@RequestMapping("/add")
	public void add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<Ordergoods> ordergoods) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Userinfo userinfo = (Userinfo) requestHolder.getClientUser();
			orderFormService.add(ordergoods, userinfo.getUserid());
			requestHolder.success("操作成功，请在订单记录中查看");
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
			orderFormService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
