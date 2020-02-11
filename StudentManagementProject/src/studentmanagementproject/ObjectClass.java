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
//    "Id": 1,
//    "Name": "sample string 2",
//    "FacultyId": 3,
//    "FacultyName": "sample string 4"
public class ObjectClass {
    private int Id;
    private String Name;
    private int FacultyId;
    private String FacultyName;

    public ObjectClass(int Id) {
        this.Id = Id;
    }

    public ObjectClass(int Id, String Name, int FacultyId, String FacultyName) {
        this.Id = Id;
        this.Name = Name;
        this.FacultyId = FacultyId;
        this.FacultyName = FacultyName;
    }

    public ObjectClass() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(int FacultyId) {
        this.FacultyId = FacultyId;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String FacultyName) {
        this.FacultyName = FacultyName;
    }

    @Override
    public String toString() {
        return Name;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof ObjectClass)) return false;
        
        return this.Id == ((ObjectClass)obj).Id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.Id;
        return hash;
    }
    
}
