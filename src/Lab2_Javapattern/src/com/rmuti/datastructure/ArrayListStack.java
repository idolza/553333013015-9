package com.rmuti.datastructure;

public class ArrayListStack {
	ArrayList list = new ArrayList();
	public void push(Object e) {
		list.add(e);
	}
	public Object pop() {
		Object a = list.get(list.size());
		list.remove(list.size());
		return a;
	}
	public Object peek() {
		return list.get(list.size());
	}
	@Override
	public String toString() {		
		return String.valueOf(list);
	}

}
