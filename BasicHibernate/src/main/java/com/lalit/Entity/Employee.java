package com.lalit.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    Name name;

    @OneToOne(mappedBy = "emp") // mapped by will not create a column for asset its saying that this association is mapped by asset class ka emp variable
    @JoinColumn(name = "ass_id")
    Asset asset;

//    @OneToMany(cascade = CascadeType.ALL) // now we dont have to save these courses explicitly it will be auto saved
//    @JoinTable(name = "Employee_Courses",
//            joinColumns = {@JoinColumn(name = "timepass_emp_id")},
//            inverseJoinColumns = {@JoinColumn(name = "timepass_curse_id")})
//    List<Course> courses;
    // this will create new table  Employee_Courses  with primary key of both table i.e employee and courses
    // primary key of emp is changed to timepass_emp_id and that of course is  timepass_curse_id



    // to not make another table but add the mapping responsibility in course table
    // # courseId, name, taughtBy, emp_id
    // # '2', 'python', 'ML', '2'
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "emp")
    List<Course> courses;


    public Employee() {
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", asset=" + asset +
                '}';
    }
}
