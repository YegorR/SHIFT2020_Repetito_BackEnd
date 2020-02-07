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
    @Query("from UserEntity u where (u.about like :search or :search is not null) and (u.course = :course or :course=0) and (u.faculty like :faculty or :faculty is not null) and (u.degree like :degree or :degree is not null)")
    List<UserEntity> findByFilters(@Param("search") String search, @Param("course") long course, @Param("faculty") String faculty, @Param("degree") String degree, Pageable pageable);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
