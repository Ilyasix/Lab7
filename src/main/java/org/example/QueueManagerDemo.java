package org.example;

/**
 * Головний клас для демонстрації роботи з чергою запитів.
 */
public class QueueManagerDemo {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();

        // Створення запитів
        Request req1 = new Request("/users", "GET", 1);
        Request req2 = new Request("/data", "POST", 4);
        Request req3 = new Request("/login", "POST", 2);

        // Додавання запитів у чергу
        requestQueue.enqueue(req1);
        requestQueue.enqueue(req2);
        requestQueue.enqueue(req3);

        // Виведення черги
        System.out.println("Додавання запитів:");
        requestQueue.displayQueue();

        // Оновлення пріоритету
        System.out.println("\nОновлення пріоритету для /users:");
        requestQueue.updatePriority(req1, 5);
        requestQueue.displayQueue();

        // Видалення запиту без обробки
        System.out.println("\nВидалення запиту /data:");
        requestQueue.remove(req2);
        requestQueue.displayQueue();

        // Обробка запиту з найвищим пріоритетом
        System.out.println("\nОбробка запиту з найвищим пріоритетом:");
        Request processedRequest = requestQueue.processHighestPriority();
        System.out.println("Оброблений запит: " + processedRequest);

        // Виведення залишку черги
        requestQueue.displayQueue();
    }
}
