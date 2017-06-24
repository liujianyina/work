package com.ljy.xml_work.domain;

/**
 * Student实体类
 * <p>
 * Created by 刘剑银 on 2017/6/8.
 */
public class Student {

    /**
     * 学生id
     */
    private Integer id;


    /**
     * 学生姓名
     */
    private String name;


    /**
     * 性别
     */
    private String sex;

    /**
     * 系别
     */
    private String department;

    /**
     * 成绩
     */
    private Integer grade;

    public Student() {
    }

    public Student(Integer id, String name, String sex, String department, Integer grade) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", grade=" + grade +
                '}';
    }
}
