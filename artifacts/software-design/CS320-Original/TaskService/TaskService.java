package Task;

//Brian Pitcher
//CS-320

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class TaskService {
    private final Map<String, Task> tasks = new HashMap<>(); // Storage for tasks

    public void addTask(String name, String description) {
        // Generate a unique task ID (first 10 characters of UUID)
        String taskId = UUID.randomUUID().toString().substring(0, 10);
        // Create a new task and store it in the map
        Task task = new Task(taskId, name, description);
        tasks.put(taskId, task);
    }

    public void deleteTask(String taskId) {
        // Validate if the task ID exists before removing
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId); // Remove task from the map
    }

    public void updateTaskName(String taskId, String name) {
        // Validate if the task ID exists before updating
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.get(taskId).setName(name); // Update task name
    }

    public void updateTaskDescription(String taskId, String description) {
        // Validate if the task ID exists before updating
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.get(taskId).setDescription(description); // Update task description
    }

    public Task getTask(String taskId) {
        // Validate if the task ID exists before retrieving
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        return tasks.get(taskId); // Return the task
    }
}
