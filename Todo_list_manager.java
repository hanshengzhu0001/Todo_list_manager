package leap_year;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Todo_list_manager {
    
    public static class Task {
        private String title;
        private String dueDate;
        private boolean isDone;

        public Task(String title, String dueDate) {
            this.title = title;
            this.dueDate = dueDate;
            this.isDone = false;
        }
    }

    public static void main(String args[]) {
        ArrayList<Task> taskList = new ArrayList<>(); 
        //a list of string*string tuple, by default empty

        Scanner scanner = new Scanner(System.in);
        int choice;
        String taskTitle;
        boolean taskFound;

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1. Add task");
            System.out.println("2. Mark task as done");
            System.out.println("3. Remove task");
            System.out.println("4. List all tasks");
            System.out.println("5. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();  // This consumes the leftover newline

            switch (choice) {
                case 1:
                    System.out.println("Enter your title: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter the due date: ");
                    String dueDate = scanner.nextLine();

                    Task newTask = new Task(title, dueDate);
                    taskList.add(newTask);

                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.println("Enter the title of the task to mark as done:");
                    taskTitle = scanner.nextLine();
                    taskFound = false;

                    for (Task task : taskList) {
                        if (task.title.equals(taskTitle)) {
                            task.isDone = true;
                            taskFound = true;
                            System.out.println("Task marked as done!");
                        }
                    }
                    if (!taskFound) {
                        System.out.println("Task not found");
                    }
                    break;

                case 3:
                    System.out.println("Enter the title of the task to remove:");
                    taskTitle = scanner.nextLine();
                    taskFound = false;
                    
                    Iterator<Task> iterator = taskList.iterator();
                    while(iterator.hasNext()) {
                        Task task = iterator.next();
                        if (task.title.equals(taskTitle)) {
                            taskFound = true;
                            iterator.remove();
                            System.out.println("Task removed!");
                        }
                    }
                    
                    if (!taskFound) {
                        System.out.println("Task not found");
                    }
                    break;

                case 4:
                    for (Task task : taskList) {
                        System.out.print("Title: " + task.title + ", Due date: " + task.dueDate);
                        System.out.println(", Finished? " + (task.isDone ? "Yes" : "No"));
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;  // exit the method

                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }
        }
    }
}

