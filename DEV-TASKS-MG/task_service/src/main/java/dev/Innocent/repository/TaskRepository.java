package dev.Innocent.repository;

import dev.Innocent.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
    public List<Tasks> findByAssignedUserId(Long userId);
}
