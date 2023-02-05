package ru.hogwarts.scool8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.scool8.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findByStudentId(Long studentId);

}
