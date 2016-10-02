package com.ip1x.jump.h2.mentorship.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(nullable = false)
    private Long id;

    @Column
    @Size(max = 64, message = "Max available name's length is 64 characters")
    @NotEmpty(message = "Please enter your name.")
    private String name;

    @NotEmpty(message = "Please enter your email.")
    @Email
    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(name="primary_skill")
    private String primarySkill;

    @Column(name="birth_day")
    private LocalDate birthDay;

    @Column(name="create_date")
    private LocalDate createDate;

    @Column(name="created_by_user_with_ip")
    private String createdByUserWithIp;

    @Column(name="modify_date")
    private LocalDate modifyDate;

    @Column(name="modified_by_user_with_ip")
    private String modifiedByUserWithIp;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "program_user", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id"))
    private Set<Program> programs;

    public User() {
    }

    public User(String name, String email, Level level, String primarySkill, LocalDate birthDay) {
        this.name = name;
        this.email = email;
        this.level = level;
        this.primarySkill = primarySkill;
        this.birthDay = birthDay;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCreatedByUserWithIp() {
        return createdByUserWithIp;
    }

    public void setCreatedByUserWithIp(String createdByUserWithIp) {
        this.createdByUserWithIp = createdByUserWithIp;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifiedByUserWithIp() {
        return modifiedByUserWithIp;
    }

    public void setModifiedByUserWithIp(String modifiedByUserWithIp) {
        this.modifiedByUserWithIp = modifiedByUserWithIp;
    }

    public Set<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }

    public  boolean addProgram(Program program){
        return this.programs.add(program);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return birthDay != null ? birthDay.equals(user.birthDay) : user.birthDay == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        return result;
    }
}
