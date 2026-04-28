package org.uce.spaguettimonolitic.service;

import org.uce.spaguettimonolitic.model.Task;
import org.uce.spaguettimonolitic.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        TaskRepository repository = new TaskRepository(); // en memoria
        service = new TaskService(repository);
    }

    @Test
    void shouldCreateTask() {
        Task task = service.create("Test task");

        assertNotNull(task);
        assertEquals("Test task", task.getTitle());
        assertEquals("Pending", task.getStatus());
    }

    @Test
    void shouldThrowErrorWhenTitleIsNull() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.create(null);
        });

        assertEquals("Title required", exception.getMessage());
    }

    @Test
    void shouldUpdateTaskStatus() {
        Task task = service.create("Test");

        Task updated = service.update(task.getId(), null, "Complete");

        assertEquals("Complete", updated.getStatus());
    }

    @Test
    void shouldDeleteTask() {
        Task task = service.create("Test");

        service.delete(task.getId());

        assertTrue(service.getAll().isEmpty());
    }
}