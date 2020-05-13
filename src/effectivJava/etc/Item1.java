package effectivJava.etc;

public class Item1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	
	/*
	 * 장점 5가지
	 * 1. 이름을 가질 수 있다.
	 * 2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
	 * 3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
	 * 4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
	 * 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
	 */

}
