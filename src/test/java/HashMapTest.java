import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void put() {
        HashMap map = new HashMap();
        map.put(10, 10);
        assertEquals(1, map.size());
        assertTrue(10 == map.get(10));
    }

    @Test
    public void putCollision() {
        HashMap map = new HashMap();
        map.put(10, 10);
        assertEquals(1, map.size());
        assertTrue(10 == map.get(10));
        map.put(20, 100);
        assertEquals(2, map.size());
        assertTrue(100 == map.get(20));
    }
    @Test
    public void putUntilResized() {
        HashMap map = new HashMap();
        for (int i = 0; i < 15; i++) {
            map.put(i,i);
        }
        assertEquals(15,map.size());
    }

    @Test
    public void get() {
        HashMap map = new HashMap();
        map.put(10, 10);
        assertTrue(10 == map.get(10));
        map.put(11, 100);
        assertTrue(100 == map.get(11));
        map.put(100, 100);
        assertTrue(100 == map.get(100));
    }

    @Test
    public void size() {
        HashMap map = new HashMap();
        assertEquals(0, map.size());
        map.put(10, 10);
        assertEquals(1, map.size());
        map.put(100, 10);
        assertEquals(2, map.size());
    }
}