import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        AuthManager authmanager = new AuthManager();
        User currentUser = null;

        while(currentUser == null){
            System.out.println("\nTask Management System");
            System.out.println("1. Register ");
            System.out.println("2. login");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                System.out.print("Enter Username: ");
                String username = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                boolean success = authmanager.registerUser(username, password);

                if(success){
                    System.out.println("Registeration Successfull Please Login.");
                } else {
                    System.out.println("Usename Already Exist. Try Another.");
                }
            } else if(choice == 2){
                System.out.print("Enter Username: ");
                String username = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                currentUser = authmanager.loginUser(username, password);

                if(currentUser == null){
                    System.out.println("Inavlid Credential, Try Again.");;
                } else{
                    System.out.println("login Successfull "+currentUser.getUsername());
                }
            } else{
                System.out.println("Invalid Choice. Please Enter 1 or 2.");
            }
        }

        TaskManager taskmanager = new TaskManager(currentUser.getUsername());

        while(true){
            System.out.println("-- Task Menu --");
            System.out.println("1. Add Task");
            System.out.println("2. view Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark as Completed");
            System.out.println("5. Logout");
            System.out.println("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                System.out.print("Enter Task Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Task Description: ");
                String desc = sc.nextLine();
                System.out.print("Enter due Date eg (2025-06-22): ");
                String duedate = sc.nextLine();

                taskmanager.addTask(title, desc, duedate);
                break;

                case 2: 
                taskmanager.viewTask();
                break;

                case 3:
                System.out.print("Enter task no to delete: ");
                int del = sc.nextInt();
                taskmanager.deleteTask(del);
                break;

                case 4:
                System.out.print("Enter task no to mark complete: ");
                int cmplt = sc.nextInt();
                taskmanager.markTaskComplete(cmplt);
                break;

                case 5:
                System.out.println("Logged out Successfull.");
                System.exit(0);
                break;

                default :
                System.out.println("Invalid Choice");
            }
        }
    }
}
