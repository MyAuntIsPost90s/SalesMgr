package salesmgr.base.model.dto;

import salesmgr.base.model.Orderform;
import salesmgr.base.model.Userinfo;

public class UserOrderDto extends Orderform {

	private Userinfo userinfo;

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
}
