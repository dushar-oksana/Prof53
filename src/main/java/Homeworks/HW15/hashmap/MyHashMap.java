package Homeworks.HW15.hashmap;

public class MyHashMap implements MyMap {

    private static class Pair {
        String key;
        String value;
        Pair next; // link to the next pair

        public Pair(String key, String value, Pair next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + ":" + value + "}";
        }
    }

    // начальный размер массива
    private static final int INITIAL_CAPACITY = 4;

    // массив с парами
    private Pair[] source = new Pair[INITIAL_CAPACITY];

    // количество хранящихся пар
    private int size = 0;

    // коэффициент загруженности
    private static final double LOAD_FACTOR = 0.75;

    // if size > LOAD_FACTOR * source.length
    // Map should be rebalanced
    // search in HashMap O(1) if Hashmap balanced good
    // balansing means to create a doublesized array and copying there pairs


    @Override
    public int size() {
        return size;
    }

    private int findBucket(String key) {
        return Math.abs(key.hashCode() % source.length);
    }

    // find a pair by key
    private Pair findPair(String key) {
        int bucket = findBucket(key);
        Pair current = source[bucket];
        while (current != null) {
            if (current.key.equals(key))
                return current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(String key) {
        return findPair(key) != null;
    }

    @Override
    public void put(String key, String value) {
        if (size() > LOAD_FACTOR * source.length)
            resize();
        Pair pair = findPair(key);
        if (pair != null) {
            pair.value = value;
        } else {
            int bucket = findBucket(key);
            source[bucket] = new Pair(key, value, source[bucket]);
            size++;
        }

    }

    private void resize(){
        Pair[] newSource = new Pair[source.length * 2];
        for (Pair p : source) {
            Pair current = p;
            while (current != null) {
                Pair next = current.next;
                int newBucket = Math.abs(current.key.hashCode() % newSource.length);
                current.next = newSource[newBucket];
                newSource[newBucket] = current;
                current = next;
            }
        }
        source = newSource;
    }

    @Override
    public String get(String key) {
        Pair p = findPair(key);
        if (p != null)
            return p.value;
        return null;
    }

    @Override
    public String remove(String key) {
        int bucket = findBucket(key);
        Pair current = source[bucket];
        if (current.key.equals(key)) {
            source[bucket] = current.next;
            size--;
            return current.value;
        }
        Pair prev = current;
        current = current.next;
        while (current != null) {
            if (current.key.equals(key)) {
                prev.next = current.next;
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int s = size() - 1;
        for (Pair p : source) {
            Pair current = p;
            while (current != null) {
                sb.append(current);
                if (--s >= 0)
                    sb.append(", ");
                current = current.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
