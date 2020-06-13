package effectiveJava.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item15 {

	public static final Object[] VALUES = {1, "string1", 0.1d};
	public Item15() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 값이 변경되는 문제점
	 */
	void interrupt1() {
		for (Object value : VALUES) {
			value = "changed";
		}
	}
	
	/*
	 * 변환 불가능한 컬렉션으로 바꿔서 이용
	 */
	private static final Object[] VALUES_2 = {1, "string1", 0.1d};
	public static final List<Object> PRIVATE_VALUE_2 = Collections.unmodifiableList(Arrays.asList(VALUES_2));
	
	
	/*
	 * 클론으로 방어적으로 사용
	 */
	private static final Object[] VALUES_3 = {1, "string1", 0.1d};
	public static final Object[] values() {
		return VALUES_3.clone();
	}

}
