package javaCode;


/**
 * @author: 이평석
 *
 */
public enum BooleanStatus {
	Y("true", "Y", true, 1),
	N("false", "F", false, 2);
	
	private String val1;
	private String val2;
	private Boolean val3;
	private int val4;
	
	BooleanStatus(String val1, String val2, boolean val3, int val4){
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
		this.val4 = val4;
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}

	public Boolean getVal3() {
		return val3;
	}

	public void setVal3(Boolean val3) {
		this.val3 = val3;
	}

	public int getVal4() {
		return val4;
	}

	public void setVal4(int val4) {
		this.val4 = val4;
	}
	
}
