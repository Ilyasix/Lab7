package org.example;

/**
 * Клас, що представляє HTTP-запит.
 * Містить інформацію про шлях, тип методу та рівень пріоритету.
 */
public class Request {
    private String path;
    private String methodType;
    private int priorityLevel;

    public Request(String path, String methodType, int priorityLevel) {
        this.path = path;
        this.methodType = methodType;
        this.priorityLevel = priorityLevel;
    }

    public String getPath() {
        return path;
    }

    public String getMethodType() {
        return methodType;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return "Request{" +
                "path='" + path + '\'' +
                ", methodType='" + methodType + '\'' +
                ", priorityLevel=" + priorityLevel +
                '}';
    }
}
