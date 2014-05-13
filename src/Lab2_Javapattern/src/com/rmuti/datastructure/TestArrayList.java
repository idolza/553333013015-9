package com.rmuti.datastructure;

public class TestArrayList {
	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		list.add("test5");
		System.out.println(list);

		ArrayListQueue queue = new ArrayListQueue();
		queue.enQueue("test1");
		queue.enQueue("test2");
		queue.enQueue("test3");
		queue.enQueue("test4");
		queue.enQueue("test5");
		System.out.println(queue);

		ArrayListStack stack = new ArrayListStack();
		stack.push("test1");
		stack.push("test2");
		stack.push("test3");
		stack.push("test4");
		stack.push("test5");
		System.out.println(stack);


	}

}
