package org.rusty;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RustamArrayListTest {

    RustamArrayList<String> rustamArrayList;

    @Before
    public void init() {
        rustamArrayList = new RustamArrayList<>();
    }

    @Test
    public void add_test() {
        rustamArrayList.add("2");
        assertEquals("2", rustamArrayList.get(0));

        rustamArrayList.add("1");
        assertEquals("1", rustamArrayList.get(1));

        rustamArrayList.add("0");
        assertEquals("0", rustamArrayList.get(2));
    }

    @Test
    public void add_indexed_test() {
        for (int i = 0; i < 4; i++) {
            rustamArrayList.add(i, String.valueOf(i));
        }
        rustamArrayList.add(2, "one more value");

        assertEquals("0", rustamArrayList.get(0));
        assertEquals("1", rustamArrayList.get(1));
        assertEquals("one more value", rustamArrayList.get(2));
        assertEquals("2", rustamArrayList.get(3));
        assertEquals("3", rustamArrayList.get(4));

        rustamArrayList.add(5, "4");
        assertEquals("4", rustamArrayList.get(5));
    }

    @Test
    public void add_all_test() {
        rustamArrayList.add("1");
        rustamArrayList.add("2");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("al_1");
        strings.add("al_2");

        rustamArrayList.addAll(strings);

        assertEquals("1", rustamArrayList.get(0));
        assertEquals("2", rustamArrayList.get(1));
        assertEquals("al_1", rustamArrayList.get(2));
        assertEquals("al_2", rustamArrayList.get(3));
    }

    @Test
    public void size_test() {
        assertEquals(0, rustamArrayList.size());

        rustamArrayList.add("0");
        assertEquals(1, rustamArrayList.size());

        rustamArrayList.add("1");
        rustamArrayList.add("2");
        assertEquals(3, rustamArrayList.size());

        rustamArrayList.remove(2);
        assertEquals(2, rustamArrayList.size());
    }

    @Test
    public void get_test() {
        rustamArrayList.add("2");
        assertEquals("2", rustamArrayList.get(0));

        rustamArrayList.add("1");
        assertEquals("1", rustamArrayList.get(1));

        rustamArrayList.add("0");
        assertEquals("0", rustamArrayList.get(2));
    }

    @Test
    public void clear_test() {
        for (int i = 0; i < 4; i++) {
            rustamArrayList.add(i, String.valueOf(i));
        }
        rustamArrayList.clear();
        assertEquals(0, rustamArrayList.size());
    }

    @Test
    public void remove_indexed_test() {
        for (int i = 0; i < 4; i++) {
            rustamArrayList.add(i, String.valueOf(i));
        }
        rustamArrayList.remove(2);
        assertEquals("0", rustamArrayList.get(0));
        assertEquals("1", rustamArrayList.get(1));
        assertEquals("3", rustamArrayList.get(2));
    }

    @Test
    public void remove_object_test() {
        for (int i = 0; i < 4; i++) {
            rustamArrayList.add(i, String.valueOf(i));
        }
        rustamArrayList.remove("2");
        assertEquals("0", rustamArrayList.get(0));
        assertEquals("1", rustamArrayList.get(1));
        assertEquals("3", rustamArrayList.get(2));
    }

    @Test
    public void is_empty_test() {
        assertTrue(rustamArrayList.isEmpty());
        rustamArrayList.add("0");
        assertFalse(rustamArrayList.isEmpty());
    }

    @Test
    public void sort_test() {
        RustamArrayList<Integer> integerRustamArrayList = new RustamArrayList<>();
        integerRustamArrayList.add(5);
        integerRustamArrayList.add(1);
        integerRustamArrayList.add(3);
        integerRustamArrayList.add(2);
        integerRustamArrayList.add(4);

        integerRustamArrayList.sort((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o1.equals(o2)) {
                return 0;
            } else {
                return -1;
            }
        });

        assertEquals(1, (int) integerRustamArrayList.get(0));
        assertEquals(2, (int) integerRustamArrayList.get(1));
        assertEquals(3, (int) integerRustamArrayList.get(2));
        assertEquals(4, (int) integerRustamArrayList.get(3));
        assertEquals(5, (int) integerRustamArrayList.get(4));

    }
}
