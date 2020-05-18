package effectiveJava.item6;

import java.util.Comparator;

/*
 * Auto-boxing 은 불필요한 객체 생성이 일어날 확률이 매우 높다
 * 위 예시는 sum 변수를 Long 으로 선언한 탓에 iteration 횟수만큼 불필요한 Long instance 가 생성된다
 * 따라서 필요한 경우가 아니라면 boxed primitive type 대신 primitive type 을 쓰자
 */
public class Sum {
	private static long sum() {
		Long sum = 0L;
		for (long i = 0; i <= Integer.MAX_VALUE; i++)
			sum += i;
		return sum;
	}

	public static void main(String[] args) {
		int numSets = Integer.parseInt(args[0]);
		long x = 0;

		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			x += sum();
			long end = System.nanoTime();
			System.out.println((end - start) / 1_000_000. + " ms.");
		}

		// VM이 최적화하지 못하게 막는 코드
		if (x == 42)
			System.out.println();
	}
}