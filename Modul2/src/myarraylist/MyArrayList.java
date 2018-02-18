package myarraylist;

public class MyArrayList<E> {
    private E[] a;
    private int curSize;

    public MyArrayList() {
        a = (E[]) new Object[10];
    }

    public int size() {
        return curSize;
    }

    public int add(E elem) {
        add(elem, curSize);
        return curSize - 1;
    }

    public void add(E elem, int index) {
        if (index > a.length) {
            reSize(a.length * 2 + 1);
        }
        for (int i = curSize - 1; i > index; i--) {
            a[i] = a[i - 1];
        }

        a[index] = elem;
        curSize++;
    }

    public E get(int index) {
        return a[index];
    }

    public E remove(int index) {
        E removedElem = get(index);

        for (int i = index; i < curSize - 1; i++) {
            a[i] = a[i + 1];
        }
        curSize--;

        return removedElem;
    }

    private void reSize(int newSize) {
        E[] old = a;
        a = (E[]) new Object[newSize];
        for (int i = 0; i < curSize; i++) {
            a[i] = old[i];
        }
    }
}
