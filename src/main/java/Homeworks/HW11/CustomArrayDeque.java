package Homeworks.HW11;

public class CustomArrayDeque implements CustomDeque {
    private int [] source;
    private int size = 0;
    private int firstElementIndex = 0;

    private static final int INITIAL_CAPACITY = 4;

    public String toString()  {
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int v = source[(firstElementIndex + i) % source.length];
            b.append(v);
            if (i < size - 1)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(int value) {
        if (size() == source.length)
            increaseCapacity(); //create array double length and copy there elements

        // decrease firstElementIndex by 1 considering source.length
        firstElementIndex = (firstElementIndex - 1 + source.length) % source.length;
        source[firstElementIndex] = value;
        size++;
    }

    private void increaseCapacity() {
        int [] tempSource = new int[source.length * 2];
        int j = 0; // index in the array tempSource

        for (int i = firstElementIndex; i < source.length; i++) {
            tempSource[j++] = source[i];
        }
        for (int i = 0; i < firstElementIndex; i++) {
            tempSource[j++] = source[i];
        }

        firstElementIndex = 0;
        source = tempSource;
    }

    @Override
    public int getFirst() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();
        return source[firstElementIndex];
    }

    @Override
    public int removeFirst() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();

        int firstElem = source[firstElementIndex];
        firstElementIndex = (firstElementIndex + 1) % source.length;
        size--;

        return firstElem;
    }

    @Override
    public void addLast(int value) {
        if (size() == source.length)
            increaseCapacity();

        source[(firstElementIndex + size()) % source.length] = value;
        size++;
    }

    @Override
    public int getLast() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();

        return source[(firstElementIndex + size() - 1) % source.length];
    }

    @Override
    public int removeLast() {
        if (size() == 0)
            throw new IndexOutOfBoundsException();

        int lastElem = source[(firstElementIndex + size() - 1) % source.length];
        size--;

        return lastElem;
    }
}
