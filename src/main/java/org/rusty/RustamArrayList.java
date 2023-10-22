package org.rusty;

import java.util.Collection;
import java.util.Comparator;
import java.util.RandomAccess;

public class RustamArrayList<E> implements RandomAccess {

    private static final int INITIAL_CAPACITY = 10;

    private Object[] elements;
    private int size = 0;
    private Comparator<? super E> comparator;

    public RustamArrayList() {
        this.elements = new Object[INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index - 1 > size) {
            throw new IndexOutOfBoundsException("Given index out of bounds. Index: " + index);
        }
        return (E) elements[index];
    }

    public void add(E element) {
        if (isFull()) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Given index out of bounds. Index: " + index);
        }
        if (isFull()) {
            grow();
        }
        if (index == size) {
            add(element);
        } else {
            Object[] newElements = new Object[elements.length];
            for (int i = 0, j = 0; i < size(); i++, j++) {
                if (i == index) {
                    newElements[i++] = element;
                    size++;
                }
                newElements[i] = elements[j];
            }
            elements = newElements;
        }
    }

    public void addAll(Collection<? extends E> c) {
        while (size + c.size() > elements.length) {
            grow();
        }
        for (E e : c) {
            add(size, e);
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void remove(Object o) {
        if (o == null) return;
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                remove(i);
                break;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void sort(Comparator<? super E> c) {
        comparator = c;
        mergeSort(elements, size);
    }

    public void mergeSort(Object[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Object[] l = new Object[mid];
        Object[] r = new Object[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    @SuppressWarnings("unchecked")
    private void merge(Object[] a, Object[] l, Object[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare((E) l[i],(E) r[j]) <= 0) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    private boolean isFull() {
        return elements.length == size;
    }

    private void grow() {
        int newCapacity = elements.length + (elements.length >> 1);
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append("\n");
        }
        return sb.toString();
    }
}
