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
public class Faculty {
    private int Id;
    private String Name;

    public Faculty(int Id) {
        this.Id = Id;
    }

    public Faculty() {
    }

    public Faculty(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
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

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Faculty)) return false;
        
        return this.Id == ((Faculty)obj).Id; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.Id;
        return hash;
    }

    @Override
    public String toString() {
        return Name; //To change body of generated methods, choose Tools | Templates.
    }

   
}
