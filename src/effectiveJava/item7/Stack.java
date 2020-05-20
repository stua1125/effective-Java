package effectiveJava.item7;
import java.util.Arrays;

/*
 * Memory leak을 null로 방지할 수 있다. (memory 누수 방지)
 * 
 */

public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}

	/**
	 * 원소를 위한 공간을 적어도 하나 이상 확보한다. 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

//    // 코드 7-2 제대로 구현한 pop 메서드 (37쪽)
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null; // 다 쓴 참조 해제
//        return result;
//    }

	public static void main(String[] args) {
		Stack stack = new Stack();
		for (String arg : args)
			stack.push(arg);

		while (true)
			System.err.println(stack.pop());
	}
	
	/*
	 * reference 가 자신의 scope 를 벗어나면 자연스럽게 garbage collecting 이 되지만, 위 예시는 Stack
	 * instance 가 유지되는 한 elements 는 dereferend 되지 않는다 따라서 null 로 쓸데없는 reference 를
	 * 없애줘야 push() 를 통해 늘어난 reference 가 일으키는 memory leak 을 방지할 수 있다
	 */
}
