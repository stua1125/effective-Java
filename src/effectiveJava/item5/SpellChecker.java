package effectiveJava.item5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpellChecker {
	private final Lexicon dictionary;

	public SpellChecker(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}
	
	/*
	 * 클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면 시글턴과 정적 유틸리티 클래스는 사용하지 않는 것이 좋다.
	 * 대신 필요한 자원을 생성자에 넘겨준다. 의존 객체 주입이라 하는 이 기법은 클래스의 유연성, 재사용성, 테스트 용이성을 개선해준다.
	 */
	
	private boolean isValid(String word) { return true; }
    public List<String> suggestions(String typo) { return new ArrayList<String>(); }
}
