package effectiveJava.item8;


//코드 8-1 cleaner를 안전망으로 활용하는 AutoCloseable 클래스 (44쪽)
// An autocloseable class using a cleaner as a safety net

/*Cleaner는 자바 9부터 지원하는 소멸자이다. cleaner를 사용할지는 내부 구현 방식에서 선택의 문제이다. 이 뜻은 Object 클래스에서 API로 제공했던 finalizer처럼 오버라이드 하는게 아닌 구성을 통해 cleaner를 사용해야 한다.*/
public class Room implements AutoCloseable {
	private static final Cleaner cleaner = Cleaner.create();

	// 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다!
	private static class State implements Runnable {
		int numJunkPiles; // Number of junk piles in this room

		State(int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}

		// close 메서드나 cleaner가 호출한다.
		@Override
		public void run() {
			System.out.println("Cleaning room");
			numJunkPiles = 0;
		}
	}

	// 방의 상태. cleanable과 공유한다.
	private final State state;

	// cleanable 객체. 수거 대상이 되면 방을 청소한다.
	private final Cleaner.Cleanable cleanable;

	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		cleanable = cleaner.register(this, state);
	}

	@Override
	public void close() {
		cleanable.clean();
	}
}