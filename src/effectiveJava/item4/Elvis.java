package effectiveJava.item4;

/*
 * item3: private 생성자나 열거 타입으로 싱글턴임을 보증하라. 
 */

/*
 * 열거 타입 방식의 싱글턴 - 바람직한방법 
 */

public enum Elvis {
	INSTANCE;
	
	public void leaveTheBuilding() {
		// ..구현
	}
}

/*
 * 추가 노력 없이 직렬화할 수 있고, 아주 복잡한 직렬화 상황이나 리플렉션 공격에서도 제2의 인스턴스가 생기는 일을 완벽하게 막아준다.
 * 그러나 대부분의 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.
 */
