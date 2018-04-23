package salesmgr.base.enums;

public class UserInfoEnum {

	/**
	 * 用户类型
	 *
	 */
	public enum UserType {
		ADMIN(-1, "管理员"), SALES(1, "分销员"), BUY(2, "采购员"), CHARGE(3, "主管");
		public int value;
		public String valueZh;

		UserType(int value, String valueZh) {
			this.value = value;
			this.valueZh = valueZh;
		}
	}
}
