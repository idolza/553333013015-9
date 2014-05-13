package com.rmuti.datastructure;

import java.util.Arrays;

public class ArrayList {
	private Object elementData[] = new Object[1];
	private int size = 0;

	private void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			Object arr[] = new Object[elementData.length * 2];
			for (int i = 0; i < size; i++) {
				arr[i] = elementData[i];
			}
			elementData = arr;
		}
	}

	public void add(Object e) {
		add(size, e);
	}

	public void add(int i, Object e) {
		ensureCapacity(size + 1);
		for (int j = size - 1; j >= i; j--) {
			elementData[j + 1] = elementData[j];
		}
		elementData[i] = e;
		size++;
	}

	@Override
	public String toString() {
		Object arr[] = new Object[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = elementData[i];
		}
		return Arrays.toString(arr);
	}

	public int size() {
		return size;
	}

	public void addFirst(Object e) {
		add(0, e);
	}

	public void addLast(Object e) {
		add(size, e);
	}

	public Object get(int a) {
		Object get = elementData[a];
		return get;
	}

	public void remove(int i) {
		for (int j = i; j < size - 1; j++) {
			elementData[j] = elementData[j + 1];
		}
		elementData[size - 1] = null;
		size--;
	}


}
