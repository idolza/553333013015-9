package com.rmuti.piority_queue;

import java.util.Arrays;

public class BinaryHeap {
	private Object elementData[] = new Object[1];
	private int size = 0;

	public void enQueue(Object e) {
		ensureCapasity(size + 1);
		elementData[size] = e;
		fixUp(size);
		size++;
	}

	public Object deQueue() {
		Object max = peek();
		size--;
		elementData[0] = elementData[size];
		elementData[size] = null;
		if (size > 1) {
			fixDown(0);
		}
		return max;
	}

	public Object peek() {
		return elementData[0];
	}

	@Override
	public String toString() {
		Object arr[] = new Object[size];
		for (int i = 0; i < size; i++) {
			arr[i] = elementData[i];
		}
		return Arrays.toString(arr);
	}

	private void ensureCapasity(int capasity) {
		if (capasity > elementData.length) {
			Object extenElementData[] = new Object[elementData.length * 2];
			for (int i = 0; i < size; i++) {
				extenElementData[i] = elementData[i];
			}
			elementData = extenElementData;
		}
	}

	private void fixUp(int k) {
		while (k > 0) {
			int p = (k - 1) / 2;
			if (!greatherThan(k, p)) {
				break;
			}
			swap(k, p);
			k = p;
		}

	}

	private void fixDown(int k) {
		int c;
		while ((c = 2 * k + 1) < size) {
			if (c + 1 < size && greatherThan(c + 1, c))
				c++;
			if (!greatherThan(c, k))
				break;
			swap(k, c);
			k = c;
		}
	}

	private void swap(int k, int p) {
		Object a = elementData[k];
		Object b = elementData[p];
		elementData[p] = a;
		elementData[k] = b;
	}

	private boolean greatherThan(int k, int p) {
		Comparable<Object> d = (Comparable) elementData[k];
		if (d.compareTo(elementData[p]) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void heapSort(Object[] data) {
		BinaryHeap h = new BinaryHeap();
		h.elementData = data;
		h.size = data.length;

		for (int i = h.size - 1; i >= 0; i--) {
			h.fixDown(i);
		}

		for (int i = h.size - 1; i >= 0; i--) {
			data[i] = h.deQueue();
		}

	}


}
