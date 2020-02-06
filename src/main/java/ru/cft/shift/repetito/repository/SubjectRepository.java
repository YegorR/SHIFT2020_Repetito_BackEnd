package ru.cft.shift.repetito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shift.repetito.entity.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
