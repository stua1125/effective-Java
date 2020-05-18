package effectiveJava.item6;

import java.util.regex.Pattern;

/*
 * 의도하지 않는 객체가 생성되는 경우가 종종 있다.
 * String.matches 는 손쉽게 문자열 검사를 할 수 있지만 내부적으로 Pattern instance 를 생성하므로 performance 문제가 있다
같은 regular expression 을 사용한다면 immutable 한 Pattern instance 를 미리 생성해 놓고 재사용하는 것이 바람직하다
 */
public class RomanNumerals {
	// 코드 6-1 성능을 훨씬 더 끌어올릴 수 있다!
	static boolean isRomanNumeralSlow(String s) {
		return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}

	// 코드 6-2 값비싼 객체를 재사용해 성능을 개선한다.
	private static final Pattern ROMAN = Pattern
			.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	static boolean isRomanNumeralFast(String s) {
		return ROMAN.matcher(s).matches();
	}

	public static void main(String[] args) {
		int numSets = Integer.parseInt(args[0]);
		int numReps = Integer.parseInt(args[1]);
		boolean b = false;

		for (int i = 0; i < numSets; i++) {
			long start = System.nanoTime();
			for (int j = 0; j < numReps; j++) {
				// 성능 차이를 확인하려면 xxxSlow 메서드를 xxxFast 메서드로 바꿔 실행해보자.
				b ^= isRomanNumeralSlow("MCMLXXVI");
			}
			long end = System.nanoTime();
			System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
		}

		// VM이 최적화하지 못하게 막는 코드
		if (!b)
			System.out.println();
	}
}