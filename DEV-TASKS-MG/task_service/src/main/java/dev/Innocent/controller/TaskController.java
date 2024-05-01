package dev.Innocent.controller;

import dev.Innocent.DTO.UserDTO;
import dev.Innocent.enums.TaskStatus;
import dev.Innocent.model.Tasks;
import dev.Innocent.service.TaskService;
import dev.Innocent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    @PostMapping
    public ResponseEntity<Tasks> createTasks(
            @RequestBody Tasks tasks, @RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO userDTO = userService.getUserProfile(jwt);
        Tasks createdTask = taskService.createTask(tasks, userDTO.getRole());
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTasksById(
            @PathVariable Long id ,@RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO userDTO = userService.getUserProfile(jwt);
        Tasks task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Tasks>> getAssignedUsersTask(
            @RequestParam(required = false) TaskStatus status,
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO userDTO = userService.getUserProfile(jwt);
        List<Tasks> task = taskService.assignedUsersTask(userDTO.getId(), status);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Tasks>> getAllTask(
            @RequestParam(required = false) TaskStatus status,
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO userDTO = userService.getUserProfile(jwt);
        List<Tasks> tasks = taskService.getAllTask(status);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @PutMapping("/{id}/user/{userId}/assigned")
    public ResponseEntity<Tasks> assignedTaskToUser(
            @PathVariable Long id,
            @PathVariable Long userId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO userDTO = userService.getUserProfile(jwt);
        Tasks tasks = taskService.assignedToUser(userId, id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(
            @PathVariable Long id,
            @RequestBody Tasks req,
            @RequestHeader("Authorization") String jwt) throws Exception {
        UserDTO userDTO = userService.getUserProfile(jwt);
        Tasks tasks = taskService.updateTask(id, req, userDTO.getId());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tasks> completeTask(@PathVariable Long id) throws Exception {
        Tasks tasks = taskService.completedTasks(id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws Exception {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
