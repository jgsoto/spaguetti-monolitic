package org.uce.spaguettimonolitic;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class ToDoList {

    private List<Map<String, Object>> tasks = new ArrayList<>();

    @PostMapping
    public Object create(@RequestBody Map<String, String> body) {

        if (body.get("title") == null) {
            return "Title required";
        }

        Map<String, Object> task = new HashMap<>();
        task.put("id", tasks.size() + 1);
        task.put("title", body.get("title"));
        task.put("status", "Pending");

        tasks.add(task);

        return task;
    }

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return tasks;
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody Map<String, String> body) {

        for (Map<String, Object> t : tasks) {
            if ((int)t.get("id") == id) {

                if (body.get("title") != null) {
                    t.put("title", body.get("title"));
                }

                if (body.get("status") != null) {
                    t.put("status", body.get("status"));
                }

                return t;
            }
        }

        return "Not found";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        tasks.removeIf(t -> (int)t.get("id") == id);
        return "Deleted";
    }
}