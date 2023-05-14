package Homeworks.HW11;

public interface CustomDeque {
    int size(); // number of elements

    void addFirst(int value); // добавление элемента в начало
    int getFirst(); // посмотреть первый элемент без удаления
    int removeFirst(); // получить первый элемент и удалить его из контейнера

    void addLast(int value);
    int getLast();
    int removeLast();
}
