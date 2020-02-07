package ru.cft.shift.repetito.entity;

import ru.cft.shift.repetito.params.request.UserParamsRequest;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic") //вообще middle_name надо по идее
    private String patronymic;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "course")
    private long course;

    @Column(name = "degree")
    private String degree;

    @Column(name = "about")
    private String about;

    @Column(name = "teacher")
    private Boolean isTeacher;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "avg_mark")
    private float avgMark;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<ReviewEntity> writtenReviews;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<ReviewEntity> receivedReviews;

    @ManyToMany
    @JoinTable(
            name = "user_subject",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<SubjectEntity> subjects;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "token_id")
    private TokenEntity token;

    public UserEntity(UserParamsRequest userParamsRequest) {
        this.email = userParamsRequest.getEmail();
        this.password = userParamsRequest.getPassword();
        this.firstName = userParamsRequest.getFirstName();
        this.lastName = userParamsRequest.getLastName();
        this.patronymic = userParamsRequest.getPatronymic();
        this.faculty = userParamsRequest.getFaculty();
        this.degree = userParamsRequest.getDegree();
        this.about = userParamsRequest.getAbout();
        String price = userParamsRequest.getPrice();

        if (price != null)
            this.price = Integer.parseInt(price);
        else this.price = 0;

        String course = userParamsRequest.getCourse();
        if (course != null)
            this.course = Integer.parseInt(course);
        else this.course = 0;

        String isTeacher = userParamsRequest.getIsTeacher();
        if (isTeacher != null)
            this.isTeacher = Boolean.parseBoolean(isTeacher);
        else this.isTeacher = false;
    }

    public UserEntity Edit (UserParamsRequest userParamsRequest){
        String email = userParamsRequest.getEmail();
        if (email != null)
            this.setEmail(email);

        String password = userParamsRequest.getPassword();
        if (password != null)
            this.setPassword(password);

        String firstName = userParamsRequest.getFirstName();
        if (firstName != null)
            this.setFirstName(firstName);

        String lastName = userParamsRequest.getLastName();
        if (lastName != null)
            this.setLastName(lastName);

        String patronymic = userParamsRequest.getPatronymic();
        if (patronymic != null)
            this.setPatronymic(patronymic);

        String faculty = userParamsRequest.getFaculty();
        if (faculty != null)
            this.setFaculty(faculty);

        String  course = userParamsRequest.getCourse();
        if (course != null)
            this.setCourse(Integer.parseInt(course));

        String isTeacher = userParamsRequest.getIsTeacher();
        if (course != null)
            this.setIsTeacher(Boolean.parseBoolean(isTeacher));

        String degree = userParamsRequest.getDegree();
        if (degree != null)
            this.setDegree(degree);

        String about = userParamsRequest.getAbout();
        if (about != null)
            this.setAbout(about);

        String price = userParamsRequest.getPrice();
        if (price != null)
            this.setPrice(Integer.parseInt(price));
        return this;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Boolean teacher) {
        this.isTeacher = teacher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public List<ReviewEntity> getWrittenReviews() {
        return writtenReviews;
    }

    public void setWrittenReviews(List<ReviewEntity> writtenReviews) {
        this.writtenReviews = writtenReviews;
    }

    public List<ReviewEntity> getReceivedReviews() {
        return receivedReviews;
    }

    public void setReceivedReviews(List<ReviewEntity> receivedReviews) {
        this.receivedReviews = receivedReviews;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }

    public TokenEntity getToken() {
        return token;
    }

    public void setToken(TokenEntity token) {
        this.token = token;
    }
}



