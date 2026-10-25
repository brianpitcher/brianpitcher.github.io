// Brian Pitcher
// CS-499

package task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TaskService {

    // Stores tasks using the task ID as the key
    private final Map<String, Task> tasks =
            new HashMap<>();

    // Add a new task and return its generated ID
    public String addTask(
            String name,
            String description) {

        // Generate a unique 10 character task ID
        String taskId =
                UUID.randomUUID()
                        .toString()
                        .substring(0, 10);

        // Create a new task with the generated ID
        Task task =
                new Task(
                        taskId,
                        name,
                        description
                );

        // Store the task using its ID
        tasks.put(
                taskId,
                task
        );

        // Return the ID so the user can use it later
        return taskId;
    }

    // Delete a task using its ID
    public void deleteTask(String taskId) {

        // Make sure the task exists before deleting it
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException(
                    "Task ID not found");
        }

        tasks.remove(taskId);
    }

    // Update the name of an existing task
    public void updateTaskName(
            String taskId,
            String name) {

        // Make sure the task exists before updating it
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException(
                    "Task ID not found");
        }

        tasks.get(taskId).setName(name);
    }

    // Update the description of an existing task
    public void updateTaskDescription(
            String taskId,
            String description) {

        // Make sure the task exists before updating it
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException(
                    "Task ID not found");
        }

        tasks.get(taskId)
                .setDescription(description);
    }

    // Find and return a task using its ID
    public Task getTask(String taskId) {

        // Throw an error if the task cannot be found
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException(
                    "Task ID not found");
        }

        return tasks.get(taskId);
    }

    // Check whether a task ID exists
    public boolean taskExists(String taskId) {

        return tasks.containsKey(taskId);
    }
}