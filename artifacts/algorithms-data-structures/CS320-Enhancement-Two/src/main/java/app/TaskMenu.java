// Brian Pitcher
// CS-499

package app;

import task.Task;
import task.TaskService;

import java.util.Scanner;

public class TaskMenu {

    public static void showMenu(
            Scanner scanner,
            TaskService taskService) {

        // Keeps the task menu running until the user returns to the main menu
        boolean taskMenuRunning = true;

        while (taskMenuRunning) {

            System.out.println();
            System.out.println("Task Menu");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Task");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            // Read the user's menu choice
            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    // Add a new task
                    addTask(scanner, taskService);
                    break;

                case "2":
                    // Update an existing task
                    updateTask(scanner, taskService);
                    break;

                case "3":
                    // Delete an existing task
                    deleteTask(scanner, taskService);
                    break;

                case "4":
                    // Display an existing task
                    viewTask(scanner, taskService);
                    break;

                case "5":
                    // Return to the main menu
                    taskMenuRunning = false;
                    break;

                default:
                    // Handle an invalid menu choice
                    System.out.println(
                            "Invalid selection. Please choose 1 through 5.");
                    break;
            }
        }
    }

    private static void addTask(
            Scanner scanner,
            TaskService taskService) {

        System.out.println();
        System.out.println("Add Task");

        String name;

        // Keep asking until a valid task name is entered
        while (true) {

            System.out.print("Enter task name: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {

                System.out.println(
                        "Error: Task name cannot be blank.");

            } else if (name.length() > 20) {

                System.out.println(
                        "Error: Task name cannot be longer than 20 characters.");

            } else {

                break;
            }
        }

        String description;

        // Keep asking until a valid task description is entered
        while (true) {

            System.out.print("Enter task description; ");
            description = scanner.nextLine().trim();

            if (description.isEmpty()) {

                System.out.println(
                        "Error: Task description cannot be blank.");

            } else if (description.length() > 50) {

                System.out.println(
                        "Error: Task description cannot be longer than 50 characters.");

            } else {

                break;
            }
        }


        try {

            // Add the task and save the ID that was created for it
            String taskId =
                    taskService.addTask(
                            name,
                            description
                    );

            System.out.println(
                    "Task added successfully.");

            // Display the generated ID so the user can use it later
            System.out.println(
                    "Task ID: " + taskId);

            System.out.println(
                    "Save this ID to update, delete, or view the task.");

        } catch (IllegalArgumentException e) {

            // Display any validation error that occurs
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }


    private static void updateTask(
            Scanner scanner,
            TaskService taskService) {

        System.out.println();
        System.out.println("Update Task");

        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine().trim();

        // Check for the task before showing update choices
        if (!taskService.taskExists(taskId)) {

            System.out.println(
                    "Error: Task ID not found.");

            return;
        }

        System.out.println();
        System.out.println(
                "What would you like to update?");
        System.out.println("1. Task Name");
        System.out.println("2. Task Description");
        System.out.print("Enter your choice: ");

        // Read which part of the task the user wants to change
        String choice = scanner.nextLine();

        switch (choice) {

            case "1":

                String name;

                // Keep asking until a valid new task name is entered.,
                while (true) {

                    System.out.print(
                            "Enter new task name: ");

                    name =
                            scanner.nextLine().trim();

                    if (name.isEmpty()) {

                        System.out.println(
                                "Error: Task name cannot be blank.");

                    } else if (name.length() > 20) {

                        System.out.println(
                                "Error: Task name cannot be longer than 20 characters.");

                    } else {

                        break;
                    }
                }

                try {

                    // Update the task name
                    taskService.updateTaskName(
                            taskId,
                            name
                    );

                    System.out.println(
                            "Task name updated successfully.");

                } catch (IllegalArgumentException e) {

                    // Display an error if the update cannot be completed
                    System.out.println(
                            "Error: " + e.getMessage());
                }

                break;


            case "2":

                String description;

                // Keep asking until a valid new description is entered
                while (true) {

                    System.out.print(
                            "Enter new task description: ");

                    description =
                            scanner.nextLine().trim();

                    if (description.isEmpty()) {

                        System.out.println(
                                "Error: Task description cannot be blank.");

                    } else if (description.length() > 50) {

                        System.out.println(
                                "Error: Task description cannot be longer than 50 characters.");

                    } else {

                        break;
                    }
                }

                try {

                    // Update the task description
                    taskService.updateTaskDescription(
                            taskId,
                            description
                    );

                    System.out.println(
                            "Task description updated successfully.");

                } catch (IllegalArgumentException e) {

                    // Display an error if the update cannot be completed
                    System.out.println(
                            "Error: " + e.getMessage());
                }

                break;

            default:

                // Handle an invalid update choice
                System.out.println(
                        "Invalid selection.");
                break;
        }
    }

    private static void deleteTask(
            Scanner scanner,
            TaskService taskService) {

        System.out.println();
        System.out.println("Delete Task");

        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine().trim();

        // Make sure the task exists before trying to delete it
        if (!taskService.taskExists(taskId)) {

            System.out.println(
                    "Error: Task ID not found.");

            return;
        }

        try {

            // delete the task that matches the entered ID
            taskService.deleteTask(taskId);

            System.out.println(
                    "Task deleted successfully.");

        } catch (IllegalArgumentException e) {

            //Display an error if the task cannot be deleted
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

    private static void viewTask(
            Scanner scanner,
            TaskService taskService) {

        System.out.println();
        System.out.println("View Task");

        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine().trim();

        // Make sure the task exists before trying to dispaly it
        if (!taskService.taskExists(taskId)) {

            System.out.println(
                    "Error: Task ID not found.");

            return;
        }

        try {

            // Find the task using its ID
            Task task =
                    taskService.getTask(taskId);

            // Display the saved task information
            System.out.println();
            System.out.println("Task Information");

            System.out.println(
                    "ID: " + task.getTaskId());

            System.out.println(
                    "Name: " + task.getName());

            System.out.println(
                    "Description: "
                            + task.getDescription());

        } catch (IllegalArgumentException e) {

            // Display an error if the task cannot be found
            System.out.println(
                    "Error: " + e.getMessage());
        }
    }

}

