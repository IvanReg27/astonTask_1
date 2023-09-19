package arrayListCollection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    @Test
    public void addElement() {
        List<Integer> list = new MyArrayList<>();
        list.add(11);
        assertEquals(11, 11);
    }
    @Test
    public void addByIndex() {
        List<Integer> list = new MyArrayList<>();
        list.add(0, 22);
        assertEquals(22, list.get(0));
        assertEquals(22, 22);
    }
    @Test
    public void getElement() {
        List<Integer> list = new MyArrayList<>();
        list.add(33);
        list.get(0);
        assertEquals(33, list.get(0));
    }
    @Test
    public void removeElement() {
        List<Integer> list = new MyArrayList<>();
        list.add(44);
        list.add(55);
        list.remove(0);
        assertTrue(list.size() == 1);
        assertEquals(55, 55);
    }
    @Test
    public void removeAll() {
        List<Integer> list = new MyArrayList<>();
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(99);
        list.add(21);
        list.removeAll(list);
        assertTrue(list.isEmpty());
        assertTrue(list.size() == 0);
    }
    @Test
    void testSort() {
        List<Integer> list = new MyArrayList<>();
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(99);
        list.add(21);
        list.sort(Integer::compare);
        assertEquals("[21,66,77,88,99]", list.toString());
    }
    @Test
    public void setElement() {
        List<Integer> list = new MyArrayList<>();
        list.add(0, 21);
        list.set(0, 31);
        assertEquals(31, list.get(0));
    }
    @Test
    public void iterator() {
        List<Integer> list = new MyArrayList<>();
        list.add(22);
        list.add(33);
        list.add(44);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(22, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(33, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(44, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
    @Test
    public void fillFor() {
        int pick;
        List<Integer> list = new MyArrayList<>();
        Random rand = new Random();
        for (int j = 0; j < 1000; j++) {
            pick = rand.nextInt(100);
            list.add(pick);
        }
        assertTrue(list.size() == 1000);
    }
}