// Brian Pitcher
// CS-499

package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void testSearchTasksByName() {

        // Add tasks to use for the search
        taskService.addTask(
                "Finish Homework",
                "Complete school work"
        );

        taskService.addTask(
                "Buy Groceries",
                "Pick up food"
        );

        // Search for a task by name
        List<Task> results =
                taskService.searchTasksByName(
                        "Finish Homework"
                );

        // Check that the correct task was found
        assertEquals(
                1,
                results.size()
        );

        assertEquals(
                "Finish Homework",
                results.get(0).getName()
        );
    }

    @Test
    public void testSearchIgnoresCapitalization() {

        taskService.addTask(
                "Finish Project",
                "Work on project"
        );

        // Search using part of the name with different capitalization
        List<Task> results =
                taskService.searchTasksByName(
                        "project"
                );

        // Check that the task was still found
        assertEquals(
                1,
                results.size()
        );

        assertEquals(
                "Finish Project",
                results.get(0).getName()
        );
    }

    @Test
    public void testTasksSortedByName() {

        // Add tasks in an unsorted order
        taskService.addTask(
                "Study",
                "Study for test"
        );

        taskService.addTask(
                "Buy Groceries",
                "Pick up food"
        );

        taskService.addTask(
                "Complete Project",
                "Finish project work"
        );

        // Get the tasks in sorted order
        List<Task> sortedTasks =
                taskService.getTasksSortedByName();

        // Check that the tasks are sorted alphabetically
        assertEquals(
                "Buy Groceries",
                sortedTasks.get(0).getName()
        );

        assertEquals(
                "Complete Project",
                sortedTasks.get(1).getName()
        );

        assertEquals(
                "Study",
                sortedTasks.get(2).getName()
        );
    }
}
