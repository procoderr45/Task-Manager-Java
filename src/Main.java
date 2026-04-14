import java.util.Scanner;
import java.util.InputMismatchException;

import model.Task;
import service.TaskService;

public class Main {

    public static void showMenus() {
        System.out.println("\n==== TASK MANAGER ====");
        System.out.println("1. Add task");
        System.out.println("2. Get task by id");
        System.out.println("3. Delete task by id");
        System.out.println("4. Exit");
    }

    public static void main(String []args) {
        TaskService taskService = new TaskService();
        Scanner sc = new Scanner(System.in);

        // CLI based interactive options
        while(true) {
            // prompt which operation to perform
            showMenus();

            // exception handling for input mismatch
            // ex- here we require a int, but if user enters string
            // show them message to enter a number
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                
                switch(choice) {
                case 1:
                    System.out.println("Enter task title: ");
                    String title = sc.nextLine();
                    taskService.saveTask(title);
                    System.out.println("Task added successfully");
                    
                    break;
                case 2:
                    System.out.println("Enter task id: ");
                    int taskId = sc.nextInt();

                    if(taskId <= 0) {
                        System.out.println("⚠️ Invalid task id");
                    }

                    Task task = taskService.getTask(taskId);
                    if(task != null) {
                        System.out.println("------------------------------------");
                        System.out.println();
                        System.out.println(task.getId() + " | " + task.getTitle() + " | " + task.getDate() + " | " + task.getStatus());
                        System.out.println();
                        System.out.println("------------------------------------");
                    }
                    else {
                        System.out.println();
                        System.out.println("⚠️ Task not found");
                        System.out.println();
                    }
                
                    break;

                    case 3:
                        System.out.println("Enter task id to delete");
                        int id = sc.nextInt();
                                           
                        if(id <= 0) {
                            System.out.println("⚠️ Invalid task id");
                        }

                        Task deletedTask = taskService.deleteTask(id);
                        if(deletedTask != null) {
                            System.out.println("Task deleted succefully");
                        }
                        else {
                            System.out.println("⚠️ Task not found");
                        }
                        break;
                    
                    
                    case 4: 
                        return;
                    
                default:
                    System.out.println("Please enter valid number");
                    
                }
            }
            catch(InputMismatchException e) {
                System.out.println("⚠️ Please enter a integer");
                sc.nextLine();
            }
        }

    }
}