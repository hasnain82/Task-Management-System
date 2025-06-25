import java.io.*;
import java.util.*;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private String filename;

    public TaskManager(String username){
        this.filename = "user_"+username+".txt";
        loadTaskFromFile();
    }

    public void loadTaskFromFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                tasks.add(Task.fromString(line));
            }
        } catch(IOException e){

        }
    }
    public void saveTaskToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Task task:tasks){
                bw.write(task.toString());
                bw.newLine();
            }
        } catch(IOException e){

        }
    }

    public void addTask(String title, String description, String dueDate){
        tasks.add(new Task(title, description, dueDate, false));
        saveTaskToFile();
        System.out.println("Task added Successfully");
    }

    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("No Task Available.");
            return;
        }
        int index = 1;
        for(Task task:tasks){
            System.out.println("\nTask "+index++);
            System.out.println("Title: "+task.getTitle());
            System.out.println("Description: "+task.getDescription());
            System.out.println("Due Date: "+task.getDueDate());
            System.out.println("Completed "+(task.isCompleted() ? "Yes" : "No"));  
        }
    }

    public void deleteTask(int taskNumber){
        if(taskNumber < 0 || taskNumber > tasks.size()){
            System.out.println("Invalid Task Number.");
            return;
        }
        tasks.remove(taskNumber - 1);
        saveTaskToFile();
        System.out.println("Task Deleted");
    }

    public void markTaskComplete(int taskNumber){
        if(taskNumber<0 || taskNumber > tasks.size()){
            System.out.println("Invalid Task Number.");
            return;
        }
        Task task = tasks.get(taskNumber - 1);
        task.markCompleted();         
        saveTaskToFile();
        System.out.println("Task marked as complete.");
    }
}
