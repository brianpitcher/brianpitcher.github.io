// Brian Pitcher
// CS-499

package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {

        // Create a fresh TaskService before each test
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {

        // Add a task and save the generated ID
        String taskId =
                taskService.addTask(
                        "Task 1",
                        "First Task Description"
                );

        // Retrieve the task using its actual ID
        Task task =
                taskService.getTask(taskId);

        // Check that the task was added correctly
        assertNotNull(task);

        assertEquals(
                "Task 1",
                task.getName()
        );

        assertEquals(
                "First Task Description",
                task.getDescription()
        );
    }

    @Test
    public void testDeleteTask() {

        // Add a task and save its generated ID
        String taskId =
                taskService.addTask(
                        "Task 1",
                        "First Task Description"
                );

        // Delete the task
        taskService.deleteTask(taskId);

        // The deleted task should no longer be found
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.getTask(taskId)
        );
    }

    @Test
    public void testUpdateTaskName() {

        // Add a task and save its generated ID
        String taskId =
                taskService.addTask(
                        "Task 1",
                        "First Task Description"
                );

        // update the task name
        taskService.updateTaskName(
                taskId,
                "Updated Task Name"
        );

        // Check that the new name was saved
        assertEquals(
                "Updated Task Name",
                taskService.getTask(taskId).getName()
        );
    }

    @Test
    public void testUpdateTaskDescription() {

        // Add a task and save its generated ID
        String taskId =
                taskService.addTask(
                        "Task 1",
                        "First Task Description"
                );

        // Update the task description
        taskService.updateTaskDescription(
                taskId,
                "Updated Task Description"
        );

        // Check that the new description was saved
        assertEquals(
                "Updated Task Description",
                taskService.getTask(taskId).getDescription()
        );
    }

    @Test
    public void testDeleteNonExistentTask() {

        // Deleting a task that does not exist should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.deleteTask("notfound")
        );
    }

    @Test
    public void testGetNonExistentTask() {

        // Retrieving a task that does not exist should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.getTask("notfound")
        );
    }

    @Test
    public void testUpdateNonExistentTask() {

        // Updating a task that does not exist should cause an error
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.updateTaskName(
                        "notfound",
                        "New Name"
                )
        );
    }
}