package Test;

//Brian Pitcher
//CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        // Initialize a new TaskService before each test
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        // Add a task and ensure it exists in the service
        taskService.addTask("Task 1", "First Task Description");
        Task task = taskService.getTask(taskService.getTask("0123456789").getTaskId());
        assertNotNull(task);
    }

    @Test
    void testDeleteTask() {
        // Add a task, delete it, and verify it no longer exists
        taskService.addTask("Task 1", "First Task Description");
        String taskId = taskService.getTask("0123456789").getTaskId();
        taskService.deleteTask(taskId);
        assertThrows(IllegalArgumentException.class, () -> taskService.getTask(taskId));
    }

    @Test
    void testUpdateTaskName() {
        // Add a task, update its name, and verify the change
        taskService.addTask("Task 1", "First Task Description");
        String taskId = taskService.getTask("0123456789").getTaskId();
        taskService.updateTaskName(taskId, "Updated Task Name");
        assertEquals("Updated Task Name", taskService.getTask(taskId).getName());
    }

    @Test
    void testUpdateTaskDescription() {
        // Add a task, update its description, and verify the change
        taskService.addTask("Task 1", "First Task Description");
        String taskId = taskService.getTask("0123456789").getTaskId();
        taskService.updateTaskDescription(taskId, "Updated Task Description");
        assertEquals("Updated Task Description", taskService.getTask(taskId).getDescription());
    }

    @Test
    void testDeleteNonExistentTask() {
        // Attempt to delete a task that does not exist and expect an exception
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("nonexistent"));
    }
}
