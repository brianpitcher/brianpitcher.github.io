package Test;

//Brian Pitcher
//CS-320

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void testValidTaskCreation() {
        // Create a task with valid inputs and verify values
        Task task = new Task("0123456789", "Test Task", "This is a test description.");
        assertEquals("0123456789", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    @Test
    void testInvalidTaskId() {
        // Attempt to create a task with an invalid ID (too long)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("01234567891", "Test Task", "Description");
        });
        assertEquals("Task ID must be non-null and at most 10 characters long", exception.getMessage());
    }

    @Test
    void testInvalidName() {
        // Attempt to create a task with a name that exceeds 20 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("0123456789", "This is a very long task name that exceeds limit", "Description");
        });
        assertEquals("Name must be non-null and at most 20 characters long", exception.getMessage());
    }

    @Test
    void testInvalidDescription() {
        // Attempt to create a task with a description exceeding 50 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("0123456789", "Task", "This description is way too long and exceeds the 50 character limit imposed by the system.");
        });
        assertEquals("Description must be non-null and at most 50 characters long", exception.getMessage());
    }

    @Test
    void testUpdateName() {
        // Update a task's name and verify the change
        Task task = new Task("0123456789", "Test", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    void testUpdateDescription() {
        // Update a task's description and verify the change
        Task task = new Task("0123456789", "Test", "Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
}
