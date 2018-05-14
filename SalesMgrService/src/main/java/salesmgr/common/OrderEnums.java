package salesmgr.common;

public class OrderEnums {

	public enum SearchOrderFormType {
		DAY("d", "天"), MONTH("m", "月"), YEAR("y", "年");
		public String value;
		public String valueZh;

		SearchOrderFormType(String value, String valueZh) {
			this.value = value;
			this.valueZh = valueZh;
		}
	}

	public enum OrderType {
		BUY(0, "采购单"), SALES(1, "销售单");
		public int value;
		public String valueZh;

		OrderType(int value, String valueZh) {
			this.value = value;
			this.valueZh = valueZh;
		}
	}
}
