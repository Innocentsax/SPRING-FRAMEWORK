package dev.Innocent.service.Impl;

import dev.Innocent.enums.TaskStatus;
import dev.Innocent.model.Tasks;
import dev.Innocent.repository.TaskRepository;
import dev.Innocent.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public Tasks createTask(Tasks task, String requesterRole) throws Exception {
        if(!requesterRole.equals(("ROLE_ADMIN"))){
            throw new Exception("Only admin can create task");
        }
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);
        return taskRepository.save(task);
    }

    @Override
    public Tasks getTaskById(Long id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() ->
                new Exception("Tasks not found with id " + id));
    }

    @Override
    public List<Tasks> getAllTask(TaskStatus status) {
        List<Tasks> allTask = taskRepository.findAll();
        List<Tasks> filteredTasks = allTask.stream().filter(
                task -> status == null || task.getStatus().name().equalsIgnoreCase(
                        status.toString())
        ).collect(Collectors.toList());
        return filteredTasks;
    }

    @Override
    public Tasks updateTask(Long id, Tasks updatedTask, Long userId) throws Exception {
        Tasks existingTask = getTaskById(id);
        if(updatedTask.getTitle() != null){
            existingTask.setTitle(updatedTask.getTitle());
        }
        if(updatedTask.getImage() != null){
            existingTask.setImage(updatedTask.getImage());
        }
        if(updatedTask.getDescription() != null){
            existingTask.setDescription(updatedTask.getDescription());
        }
        if(updatedTask.getStatus() != null){
            existingTask.setStatus(updatedTask.getStatus());
        }
        if(updatedTask.getDeadline() != null){
            existingTask.setDeadline(updatedTask.getDeadline());
        }
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) throws Exception {
        getTaskById(id);
        taskRepository.deleteById(id);
    }

    @Override
    public Tasks assignedToUser(Long userId, Long taskId) throws Exception {
        Tasks task = getTaskById(taskId);
        task.setAssignedUserId(userId);
        task.setStatus(TaskStatus.DONE);
        return taskRepository.save(task);
    }

    @Override
    public List<Tasks> assignedUsersTask(Long userId, TaskStatus status) throws Exception {
        List<Tasks> allTask = taskRepository.findByAssignedUserId(userId);
        return allTask.stream().filter(
                task -> status == null || task.getStatus().name().equalsIgnoreCase(
                        status.toString())
        ).collect(Collectors.toList());
    }

    @Override
    public Tasks completedTasks(Long taskId) throws Exception {
        Tasks tasks = getTaskById(taskId);
        tasks.setStatus(TaskStatus.DONE);
        return taskRepository.save(tasks);
    }
}
