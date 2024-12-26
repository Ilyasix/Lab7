package org.example;

import java.util.LinkedList;
import java.util.List;

/**
 * Клас для управління чергою запитів.
 * Реалізує функції додавання, видалення, оновлення пріоритету та обробки запитів.
 */
public class RequestQueue {
    private List<Request> queue;

    public RequestQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * Додає запит до черги.
     *
     * @param request Запит для додавання.
     */
    public void enqueue(Request request) {
        queue.add(request);
    }

    /**
     * Обробляє запит із найвищим пріоритетом.
     *
     * @return Оброблений запит.
     */
    public Request processHighestPriority() {
        if (queue.isEmpty()) {
            System.out.println("Черга порожня.");
            return null;
        }
        Request highestPriority = queue.stream()
                .max((r1, r2) -> Integer.compare(r1.getPriorityLevel(), r2.getPriorityLevel()))
                .orElse(null);
        queue.remove(highestPriority);
        return highestPriority;
    }

    /**
     * Видаляє запит без обробки.
     *
     * @param request Запит для видалення.
     */
    public void remove(Request request) {
        queue.remove(request);
    }

    /**
     * Оновлює пріоритет запиту.
     *
     * @param request      Запит для оновлення.
     * @param newPriority Новий рівень пріоритету.
     */
    public void updatePriority(Request request, int newPriority) {
        if (queue.contains(request)) {
            request.setPriorityLevel(newPriority);
        }
    }

    /**
     * Виводить поточний стан черги.
     */
    public void displayQueue() {
        System.out.println("Текущая черга:");
        queue.forEach(System.out::println);
    }
}
