package com.lalit.Entity;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseId;
    String name;
    String taughtBy;

    @ManyToOne
    Employee emp;


    public Course() {
    }

    public Course(String name, String taughtBy) {
        this.name = name;
        this.taughtBy = taughtBy;
    }

    public int getCourseId() {
        return courseId;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaughtBy() {
        return taughtBy;
    }

    public void setTaughtBy(String taughtBy) {
        this.taughtBy = taughtBy;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", taughtBy='" + taughtBy + '\'' +
                '}';
    }
}
