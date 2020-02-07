package ru.cft.shift.repetito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.shift.repetito.entity.SubjectEntity;

import java.util.Optional;
@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
