package arrayListCollection;

import java.util.*;

/**
 * The MyArrayList class is used to create an object
 * the collection is ArrayList.
 * @author Ivan Makhorin.
 */

public class MyArrayList<E> implements List<E> {
    private int size = 0;
    private int capacity = 0;
    private final int CAPACITY = 16;
    private Object[] array;

    public MyArrayList() {
        capacity = CAPACITY;
        array = new Object[capacity];
    }
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }
    private void increaseCapacity() {
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }
    private void trimToSizeArray() {
        capacity = size + 1;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    /**
     * Return the number of elements in an array.
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * Checks if a string is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Checking the presence of an element in a set.
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    /**
     * Sequential traversal of a collection,
     * without disclosing details of its implementation.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    /**
     * Внутренний класс-итератор для перебора элементов массива.
     */
    private class MyIterator implements Iterator<E> {
        private int iteratorIndex = 0;

        /**
         * Проверяет, есть ли следующий элемент в массиве.
         *
         * @return true, если есть следующий элемент, иначе false
         */
        @Override
        public boolean hasNext() {
            return iteratorIndex < size;
        }

        /**
         * Возвращает следующий элемент массива и перемещает указатель на следующую позицию.
         *
         * @return следующий элемент массива
         * @throws NoSuchElementException если достигнут конец массива
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(iteratorIndex++);
        }
    }
    /**
     * Copies the elements of the ArrayList to a new Object array.
     */
    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
    /**
     * Adds an element to the collection and expands the list.
     */
    @Override
    public boolean add(Object o) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size++] = o;
        return true;
    }
    private void shiftToLeft(int start) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != start) {
            System.arraycopy(array, start + 1, array, start, size - start);
        }
        array[size] = null;
    }
    /**
     * Removes the passed element from the list.
     */
    @Override
    public boolean remove(Object o) {
        if ((size == 0)) {
            return false;
        }
        int i;
        for (i = 0; i < size; i++) {
            if (array[i] == null && o == null) {
                break;
            }
            if ((array[i] != null) && (array[i].equals(o))) {
                break;
            }
        }
        if (i < size) {
            shiftToLeft(i);
            return true;
        }
        return false;
    }
    /**
     * Adds all elements from the given collection
     * to the end of the list.
     */
    @Override
    public boolean addAll(Collection c) {
        if (c == null) {
            return false;
        }
        if (c.isEmpty()) {
            return false;
        }
        for (Object item : c) {
            add(item);
        }
        return true;
    }
    /**
     * Adding a list and also adding an element
     * to a specific position.
     */
    @Override
    public boolean addAll(int index, Collection c) {
        if (c == null) {
            return false;
        }
        if (c.isEmpty() || (index < 0)) {
            return false;
        }
        if (index > size) {
            index = size;
        }
        for (Object item : c) {
            add(index++, item);
        }
        return true;
    }
    /**
     * Removing all elements from the list.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    /**
     * Returns the element that is
     * at the specified position in the list.
     */
    @Override
    public E get(int index) {
        if ((index < size) && (index >= 0)) {
            return (E) array[index];
        }
        return null;
    }
    /**
     * Setting a new value to the element that is
     * at position index.
     */
    @Override
    public Object set(int index, Object element) {
        if ((index < size) && (index >= 0)) {
            Object o = array[index];
            array[index] = element;
            return o;
        }
        return null;
    }
    /**
     * Replaces the element at the specified position
     * in the list with the specified element.
     */
    @Override
    public void add(int index, Object element) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }
    /**
     * Removes an object from a list by index.
     */
    @Override
    public E remove(int index) {
        Object o = null;
        if ((index < size) && (index >= 0)) {
            o = get(index);
            shiftToLeft(index);
        }
        return (E) o;
    }
    /**
     * Searches for the specified Object and returns
     * the zero-based index of the first occurrence
     * in the collection.
     */
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * Returns the index of the last occurrence of object in a list.
     */
    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    lastIndex = i;
                }
            }
            return lastIndex;
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }
    /**
     * Extends Iterator to allow bidirectional
     * list traversal and element modification.
     */
    @Override
    public ListIterator listIterator() {
        return null;
    }
    /**
     * Returns an iterator list of the elements in this list.
     */
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }
    /**
     * Function for getting a list of elements
     * that are in position from a span.
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            int temp = fromIndex;
            fromIndex = toIndex;
            toIndex = temp;
        }
        if ((fromIndex < 0) || (toIndex > size)) {
            return null;
        }
        List myArrayList = new MyArrayList(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            myArrayList.add(array[i]);
        }
        return myArrayList;
    }
    /**
     * Removes all elements from the calling
     * collection except those contained in c.
     */
    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            return true;
        }
        if (c.size() == 0) {
            clear();
            return true;
        }
        int i = 0;
        boolean modyfied = false;
        while (i < size) {
            if (c.contains(array[i])) {
                i++;
            } else {
                shiftToLeft(i);
                modyfied = true;
            }
        }
        return modyfied;
    }
    /**
     * Removes elements that do not belong to the passed collection.
     */
    @Override
    public boolean removeAll(Collection c) {
        if (c == null) {
            return false;
        }
        if ((c.size() == 0) || (size == 0)) {
            return false;
        }
        boolean modyfied = false;
        int i = 0;
        while (i < size) {
            if (c.contains(array[i])) {
                shiftToLeft(i);
                modyfied = true;
            } else {
                i++;
            }
        }
        return modyfied;
    }
    /**
     * Checking the presence of a collection in a set.
     * Returns true if all elements are contained in the set.
     */
    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            return false;
        }
        if (c.size() == 0) {
            return true;
        }
        for (Object e : c) {
            if (contains(e)) {
                ;
            } else {
                return false;
            }
        }
        return true;
    }
    /**
     * Converts an object to a string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    /**
     * Quick sorting of array elements using a given comparator.
     */
    public void quickSort(E[] array, int left, int right, Comparator<? super E> comparator) {
        int index = 0;
        if (array.length > 1) {
            index = partition(array, left, right, comparator);
            if (left < index - 1) {
                quickSort(array, left, index - 1, comparator);
            }
            if (index < right) {
                quickSort(array, index, right, comparator);
            }
        }
    }
    /**
     * Splits the array into two parts around
     * a pivot element and returns the index
     * of the pivot element.
     */
    private int partition(E[] array, int left, int right, Comparator<? super E> comparator) {
        E half = array[(left + right) / 2];
        while (left <= right) {
            while (comparator.compare(array[left], half) < 0) {
                left++;
            }
            while (comparator.compare(array[right], half) > 0) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    /**
     * Swaps two elements of an array.
     */
    private void swap(E[] array, int firstIndex, int secondIndex) {
        E temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
    /**
     * Sorts the elements of an array using the specified
     * comparator using quicksort.
     */
    public void sort(Comparator<? super E> comparator) {
        quickSort((E[]) array, 0, size - 1, comparator);
    }
    /**
     * Increases the capacity of the array if necessary and
     * copies the elements to a new array.
     */
    private void increaseCapacityAndCopyArray(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = minCapacity * 3 / 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }
    /**
     * Checks that the specified index is within
     * the valid bounds of the array.
     */
    private void validIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
}