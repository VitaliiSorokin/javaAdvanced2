package myarraylist;

public class MyArrayList<E> {
    private E[] a;
    private int curSize;

    MyArrayList() {
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
            resize(a.length * 2 + 1);
        }
        System.arraycopy(a, index, a, index + 1, curSize - 1 - index);

        a[index] = elem;
        curSize++;
    }

    public E get(int index) {
        return a[index];
    }

    public E remove(int index) {
        E removedElem = get(index);

        System.arraycopy(a, index + 1, a, index, curSize - 1 - index);
        curSize--;

        return removedElem;
    }

    private void resize(int newSize) {
        E[] old = a;
        a = (E[]) new Object[newSize];
        System.arraycopy(old, 0, a, 0, curSize);
    }
}
