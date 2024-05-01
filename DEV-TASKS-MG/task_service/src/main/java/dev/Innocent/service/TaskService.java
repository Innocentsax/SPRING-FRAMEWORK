package dev.Innocent.service;

import dev.Innocent.enums.TaskStatus;
import dev.Innocent.model.Tasks;

import java.util.List;

public interface TaskService {
    Tasks createTask(Tasks task, String requesterRole) throws Exception;
    Tasks getTaskById(Long id) throws Exception;
    List<Tasks> getAllTask(TaskStatus status);
    Tasks updateTask(Long id, Tasks updatedTask, Long userId) throws Exception;
    void deleteTask(Long id) throws Exception;
    Tasks assignedToUser(Long userId, Long taskId) throws Exception;
    List<Tasks> assignedUsersTask(Long userId, TaskStatus status) throws Exception;
    Tasks completedTasks(Long taskId) throws Exception;
}
