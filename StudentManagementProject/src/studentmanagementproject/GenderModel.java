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
public class GenderModel {
    private boolean gender;
    private String Name;

    public GenderModel(boolean gender) {
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public GenderModel(boolean gender, String Name) {
        this.gender = gender;
        this.Name = Name;
    }

    public GenderModel() {
    }

    @Override
    public String toString() {
        return Name; //To change body of generated methods, choose Tools | Templates.
    }
  @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof GenderModel)) return false;
        
        return ((GenderModel)obj).gender == this.gender; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.gender ? 1 : 0);
        return hash;
    }
}
