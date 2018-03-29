package salesmgr.common;

public class OrderEnums {

	public enum OrderFormType {
		DAY("d", "天"), MONTH("m", "月"), YEAR("y", "年");
		public String value;
		public String valueZh;

		OrderFormType(String value, String valueZh) {
			this.value = value;
			this.valueZh = valueZh;
		}
	}
}
