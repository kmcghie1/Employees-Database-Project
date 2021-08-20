package com.sparta.kmcgh.cvsproject.dto;

import java.io.IOException;

public class EmployeeDTO implements Comparable<EmployeeDTO>{
    private int employeeId, salary;
    private String namePrefix, firstName, lastName, email, dateOfBirth, dateOfJoining;
    private char middleInitial, gender;

    //Constructor
    public EmployeeDTO(String[] csvData) throws IOException {
        this.employeeId = Integer.parseInt(csvData[0]);
        this.namePrefix = csvData[1];
        this.firstName = csvData[2];
        this.middleInitial = csvData[3].charAt(0);
        this.lastName = csvData[4];
        this.gender = csvData[5].charAt(0);
        this.email = csvData[6];
        this.dateOfBirth = csvData[7];
        this.dateOfJoining = csvData[8];
        this.salary = Integer.parseInt(csvData[9]);

    }

    public int getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public String getNamePrefix(){
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix){
        this.namePrefix = namePrefix;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial){
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining){
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public int compareTo(EmployeeDTO o) {
        return this.employeeId - o.employeeId;
    }

    @Override
    public int hashCode() {
        return this.employeeId;
    }

    @Override
    public boolean equals(Object obj) {
        return this.employeeId == ((EmployeeDTO) obj).employeeId;
    }


    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "EmployeeId=" + employeeId +
                ", NamePrefix='" + namePrefix + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", MiddleInitial='" + middleInitial +
                ", LastName='" + lastName + '\'' +
                ", Gender=" + gender +
                ", Email='" + email + '\'' +
                ", DateOfBirth='" + dateOfBirth +
                ", DateOfJoining=" + dateOfJoining +
                ", Salary=" + salary +
                "} ";
    }

}
