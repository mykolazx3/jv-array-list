package core.basesyntax;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private int maxSize;
    private T[] list;
    private int size;

    public ArrayList() {
        maxSize = 10;
        list = (T[]) new Object[maxSize];
        size = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public void add(T value) {
        list[size] = value;
        size++;
        growIfArrayFull();
    }

    @Override
    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Incorrect index");
        } else {
            replaceArray(index, true);
            list[index] = value;
        }
    }

    @Override
    public void addAll(List<T> list) {
        size += list.size();
        while (size >= maxSize) {
            growIfArrayFull();
        }
        int tempSize = size - list.size();
        for (int i = 0; i < list.size(); i++) {
            this.list[tempSize + i] = list.get(i);
        }
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Incorrect index");
        } else {
            return list[index];
        }
    }

    @Override
    public void set(T value, int index) {
        if (index >= size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Incorrect index");
        } else {
            list[index] = value;
        }
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayListIndexOutOfBoundsException("Incorrect index");
        } else {
            T object = list[index];
            replaceArray(index, false);
            return object;
        }
    }

    @Override
    public T remove(T element) {
        T object;
        for (int i = 0; i < size; i++) {
            if ((element == null && list[i] == null)
                    || (list[i] != null && list[i].equals(element))) {
                object = list[i];
                remove(i);
                return object;
            }
            ;
        }
        throw new NoSuchElementException("Element isn't find;");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void growIfArrayFull() {
        if (size >= maxSize) {
            int newMaximumSize = (int) (maxSize * 1.5);
            T[] extendedList = (T[]) new Object[newMaximumSize];
            System.arraycopy(list, 0, extendedList, 0, maxSize);
            list = extendedList;
            maxSize = newMaximumSize;
        }
    }

    private void replaceArray(int index, boolean addOrRemove) {

        int newMaximumSize = addOrRemove ? maxSize + 1 : maxSize - 1;
        T[] replacedList = (T[]) new Object[newMaximumSize];

        System.arraycopy(list, 0, replacedList, 0, index);
        System.arraycopy(list,
                addOrRemove ? index : index + 1,
                replacedList,
                addOrRemove ? index + 1 : index,
                size - index);

        size = addOrRemove ? size + 1 : size - 1;
        list = replacedList;
        maxSize = newMaximumSize;

    }

}


