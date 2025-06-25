public class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public Task(String title, String description, String dueDate, boolean completed){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getDueDate(){
        return dueDate;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void markCompleted(){
        this.completed = true;
    }

    public String toString(){
        return title+", "+description+", "+dueDate+", "+completed;
    }

    public static Task fromString(String line){
        String[] parts = line.split(", ", 4);
        return new Task(parts[0],parts[1],parts[2],Boolean.parseBoolean(parts[3]));
    }
}
