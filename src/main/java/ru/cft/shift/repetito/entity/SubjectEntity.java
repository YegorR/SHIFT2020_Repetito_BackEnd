package ru.cft.shift.repetito.entity;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="subject")
    private String name;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @ManyToMany
    private Set<UserEntity> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
