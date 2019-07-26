
public class HashMap {
    private int size;


    private Entry[] map;

    public HashMap() {
        size = 0;
        map = new Entry[10];
    }

    public void put(int key, long value) {
        Entry existingEntry = getEntry(key);
        if (existingEntry == null) {
            size++;
            if (size > map.length * 0.75)
                resize(map.length * 2);
            put(new Entry(key, value), map);
        } else {
            existingEntry.setValue(value);
        }

    }

    //returns null if there is no such key
    public Long get(int key) {
        Entry result = getEntry(key);
        return result == null ? null : result.getValue();
    }

    public int size() {
        return size;
    }

    private void resize(int size) {
        Entry[] temp = new Entry[size];
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null)
                put(map[i], temp);
        }
        map = temp;
    }

    private void put(Entry e, Entry[] storage) {
        boolean freeCell = false;
        int i = e.hashCode() % storage.length;
        while (!freeCell) {
            if (storage[i] == null)
                freeCell = true;
            else i++;
            if (i == storage.length)
                i = 0;
        }
        storage[i] = e;

    }

    private Entry getEntry(int key) {
        //hashcode of the entry is the key
        int i = key % map.length;
        while (map[i] != null && map[i].getKey() != key) {
            i++;
        }
        return map[i];
    }


    private class Entry {
        private int key;
        private long value;

        Entry(int key, long value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}
