// Brian Pitcher
// CS-499

package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {

        // Create a task using valid information
        Task task = new Task(
                "1234567890",
                "Test Task",
                "Test Description"
        );

        // Check that each value was stored correctly
        assertEquals(
                "1234567890",
                task.getTaskId()
        );

        assertEquals(
                "Test Task",
                task.getName()
        );

        assertEquals(
                "Test Description",
                task.getDescription()
        );
    }

    @Test
    public void testInvalidTaskId() {

        // a task ID longer than ten characters should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "12345678901",
                        "Test Task",
                        "Test Description"
                )
        );
    }

    @Test
    public void testBlankTaskName() {

        // A blank task name should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "1234567890",
                        "",
                        "Test Description"
                )
        );
    }

    @Test
    public void testTaskNameTooLong() {

        // A task name over 20 characters should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "1234567890",
                        "This Task Name Is Too Long",
                        "Test Description"
                )
        );
    }

    @Test
    public void testBlankTaskDescription() {

        // A blank task description should not be accepted
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "1234567890",
                        "Test Task",
                        ""
                )
        );
    }

    @Test
    public void testTaskDescriptionTooLong() {

        // A description over 50 characters should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "1234567890",
                        "Test Task",
                        "This description is intentionally longer than fifty characters."
                )
        );
    }

    @Test
    public void testUpdateTaskName() {

        Task task = new Task(
                "1234567890",
                "Original Name",
                "Test Description"
        );

        // Change the task name
        task.setName("Updated Name");

        // Check that the new name was saved
        assertEquals(
                "Updated Name",
                task.getName()
        );
    }

    @Test
    public void testUpdateTaskDescription() {

        Task task = new Task(
                "1234567890",
                "Test Task",
                "Original Description"
        );

        // Change the task description.
        task.setDescription(
                "Updated Description"
        );

        // Check that the new description was saved.
        assertEquals(
                "Updated Description",
                task.getDescription()
        );
    }
}