package org.uce.spaguettimonolitic.controller;

import org.uce.spaguettimonolitic.model.Task;
import org.uce.spaguettimonolitic.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@RequestBody Map<String, String> body) {
        return service.create(body.get("title"));
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return service.update(id, body.get("title"), body.get("status"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Eliminado";
    }
}