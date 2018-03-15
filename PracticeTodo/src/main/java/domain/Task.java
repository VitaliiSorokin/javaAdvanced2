package domain;

public final class Task {
    private final int id;
    private final String todo;


    public Task(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }
}
