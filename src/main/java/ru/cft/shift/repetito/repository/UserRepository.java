package ru.cft.shift.repetito.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cft.shift.repetito.entity.UserEntity;
import ru.cft.shift.repetito.service.OffsetBasedPageRequest;


import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    @Query("from UserEntity u where (u.about = :search or :search='null') and (u.course = :course or :course=0) and (u.faculty = :faculty or :faculty='null') and (u.degree = :degree or :degree ='null') and (u.isTeacher = :isTeacher or :isTeacher='false') and (:subject in (select a.id from UserEntity b join b.subjects a) or :subject=0)")
    List<UserEntity> findByFilters(@Param("search") String search, @Param("course") long course, @Param("faculty") String faculty, @Param("degree") String degree, @Param("isTeacher") boolean isTeacher, @Param("subject") int subject , Pageable pageable);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
