package arrayListCollection;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    //NullPointerException???
    @Test
    public void mainSortElement() {
        List<Integer> list = new MyArrayList<>();
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(99);
        list.add(21);
        Collections.sort(list);
        assertEquals("Egor", list.get(0));
    }
    @Test
    public void setElement() {
        List<Integer> list = new MyArrayList<>();
        list.add(0, 21);
        list.set(0, 31);
        assertEquals(31, list.get(0));
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