package Homeworks.HW15.hashmap;

public interface MyMap {
    int size(); // количество пар
    boolean contains(String key); // есть ли в map пара с таким ключом
    void put(String key, String value); // сохранить пару
    String get(String key); // получение значения по ключу
    String remove(String key); // удаление значения по ключу
}
