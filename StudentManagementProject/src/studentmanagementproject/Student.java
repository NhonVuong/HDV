/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementproject;

/**
 *
 * @author Unmatched TaiNguyen
 */
public class Student {
//    "Id": 1,
//    "LastName": "sample string 2",
//    "FirstName": "sample string 3",
//    "Gender": true,
//    "Address": "sample string 5",
//    "ObjectClassId": 6,
//    "ClassName": "sample string 7"
    private int Id;
    private String LastName;
    private String FirstName;
    private boolean Gender;
    private String Address;
    private int ObjectClassId;
    private String ClassName;

    public Student(int Id) {
        this.Id = Id;
    }
    
    public Student() {
    }

    public Student(int Id, String LastName, String FirstName, boolean Gender, String Address, int ObjectClassId, String ClassName) {
        this.Id = Id;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Gender = Gender;
        this.Address = Address;
        this.ObjectClassId = ObjectClassId;
        this.ClassName = ClassName;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getObjectClassId() {
        return ObjectClassId;
    }

    public void setObjectClassId(int ObjectClassId) {
        this.ObjectClassId = ObjectClassId;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }
     @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Student)) return false;
        
        return this.Id == ((Student)obj).Id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.Id;
        return hash;
    }
}
