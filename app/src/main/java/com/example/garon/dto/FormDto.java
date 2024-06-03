//package com.example.garon.dto;
//
//import java.sql.Date;
//
//public class AddFormRequest {
//    private Date startDate;
//    private String startTime;
//    private Long studentId;
//    private String name;
//    private String sex;
//    private String phone;
//
//    public AddFormRequest() {}
//
//    public AddFormRequest(Date startDate, String startTime, Long studentId, String name, String sex, String phone) {
//        this.startDate = startDate;
//        this.startTime = startTime;
//        this.studentId = studentId;
//        this.name = name;
//        this.sex = sex;
//        this.phone = phone;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public Long getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Long studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Form toEntity() {
//        return new Form(startDate, startTime, studentId, name, sex, phone);
//    }
//}}