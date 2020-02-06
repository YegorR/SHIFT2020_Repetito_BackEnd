package ru.cft.shift.repetito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.cft.shift.repetito.entity.ReviewEntity;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query("from ReviewEntity r where r.teacher.id = :teacherId")
    List<ReviewEntity> findByRepetitorId(@Param("teacherId") long teacherId);
}
