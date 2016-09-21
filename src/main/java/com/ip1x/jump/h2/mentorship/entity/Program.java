package com.ip1x.jump.h2.mentorship.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="program")
public class Program {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(nullable = false)
    private Long id;
    @Column
    private String name;
    @Column(name="office_location")
    private String officeLocation;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;

    public Program() {
    }

    public Program(Long id, String name, String officeLocation, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.officeLocation = officeLocation;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Program program = (Program) o;

        if (id != null ? !id.equals(program.id) : program.id != null) return false;
        if (name != null ? !name.equals(program.name) : program.name != null) return false;
        if (officeLocation != null ? !officeLocation.equals(program.officeLocation) : program.officeLocation != null)
            return false;
        if (startDate != null ? !startDate.equals(program.startDate) : program.startDate != null) return false;
        return endDate != null ? endDate.equals(program.endDate) : program.endDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (officeLocation != null ? officeLocation.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
