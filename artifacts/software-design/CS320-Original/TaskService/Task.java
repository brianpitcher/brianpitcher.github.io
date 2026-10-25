package Task;

//Brian Pitcher
//CS-320

class Task {
    private final String taskId; // Unique identifier for the task
    private String name; // Name of the task
    private String description; // Description of the task

    public Task(String taskId, String name, String description) {
        // Validate task ID constraints
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must be non-null and at most 10 characters long");
        }
        // Validate name constraints
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and at most 20 characters long");
        }
        // Validate description constraints
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters long");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public String getTaskId() {
        return taskId; // Return the unique task ID
    }

    public String getName() {
        return name; // Return the task name
    }

    public void setName(String name) {
        // Validate and set a new task name
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and at most 20 characters long");
        }
        this.name = name;
    }

    public String getDescription() {
        return description; // Return the task description
    }

    public void setDescription(String description) {
        // Validate and set a new task description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and at most 50 characters long");
        }
        this.description = description;
    }
}
