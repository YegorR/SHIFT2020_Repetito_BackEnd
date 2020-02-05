package ru.cft.shift.repetito.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReviewEntity {
    @Id
    private Long id;

    @ManyToOne
    private UserEntity repetitor;

    public UserEntity getRepetitor() {
        return repetitor;
    }

    public void setRepetitor(UserEntity repetitor) {
        this.repetitor = repetitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
