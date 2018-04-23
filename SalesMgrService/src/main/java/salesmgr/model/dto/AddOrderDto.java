package salesmgr.model.dto;

import java.util.List;

import salesmgr.base.model.Ordergoods;

public class AddOrderDto {

	private List<Ordergoods> list;

	private String ordernote;

	public List<Ordergoods> getList() {
		return list;
	}

	public void setList(List<Ordergoods> list) {
		this.list = list;
	}

	public String getOrdernote() {
		return ordernote;
	}

	public void setOrdernote(String ordernote) {
		this.ordernote = ordernote;
	}

}
