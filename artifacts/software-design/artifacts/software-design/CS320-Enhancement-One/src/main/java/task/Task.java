// Brian Pitcher
// CS-499

package task;

public class Task {

    // Stores the information for one task
    private final String taskId;
    private String name;
    private String description;

    public Task(
            String taskId,
            String name,
            String description) {

        // Task ID cannot be blank and cannot exceed ten characters
        if (taskId == null ||
                taskId.trim().isEmpty() ||
                taskId.trim().length() > 10) {

            throw new IllegalArgumentException(
                    "Task ID must be between 1 and 10 characters.");
        }

        // Task name cannot be blank and cannot exceed twenty characters
        if (name == null ||
                name.trim().isEmpty() ||
                name.trim().length() > 20) {

            throw new IllegalArgumentException(
                    "Task name must be between 1 and 20 characters.");
        }

        // Description cannot be blank and cannot exceed fifty characters
        if (description == null ||
                description.trim().isEmpty() ||
                description.trim().length() > 50) {

            throw new IllegalArgumentException(
                    "Task description must be between 1 and 50 characters.");
        }

        // Save the validated task information
        this.taskId = taskId.trim();
        this.name = name.trim();
        this.description = description.trim();
    }

    // Return the task ID
    public String getTaskId() {
        return taskId;
    }

    // Return the task name
    public String getName() {
        return name;
    }

    // Update the task name after checking that it is valid
    public void setName(String name) {

        if (name == null ||
                name.trim().isEmpty() ||
                name.trim().length() > 20) {

            throw new IllegalArgumentException(
                    "Task name must be between 1 and 20 characters.");
        }

        this.name = name.trim();
    }

    // Return the task description
    public String getDescription() {
        return description;
    }

    // Update the task description after checking that it is valid.
    public void setDescription(String description) {

        if (description == null ||
                description.trim().isEmpty() ||
                description.trim().length() > 50) {

            throw new IllegalArgumentException(
                    "Task description must be between 1 and 50 characters.");
        }

        this.description = description.trim();
    }
}