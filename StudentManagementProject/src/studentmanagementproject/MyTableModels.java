/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementproject;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Unmatched TaiNguyen
 * @param <T>
 */
public class MyTableModels<T> extends AbstractTableModel{

    @Override
    public String getColumnName(int column) {
         if(_Values == null || _Values.isEmpty()) return null;
            T t = _Values.get(0);
            Field[]  fs = t.getClass().getDeclaredFields();
        return fs[column].getName(); //To change body of generated methods, choose Tools | Templates.
    }

    private final List<T> _Values;
    public MyTableModels(List<T> Values) {
        _Values = Values;
    }
    
    
    @Override
    public int getRowCount() {
        return _Values.size();
    }

    @Override
    public int getColumnCount() {
        if(_Values == null || _Values.isEmpty()) return 0;
        Field[] fs = _Values.get(0).getClass().getDeclaredFields();
        return fs.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            if(_Values == null || _Values.isEmpty()) return null;
            T t = _Values.get(rowIndex);
            Field[]  fs = t.getClass().getDeclaredFields();
            
            if(columnIndex >= fs.length) return  null;
            fs[columnIndex].setAccessible(true);
            
            return fs[columnIndex].get(t);
            
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(MyTableModels.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void RemoveRow(T t){
        _Values.remove(t);
    }
    public void AddRow(T t){
        _Values.add(t);
    }
    public T GetRow(int row){
        if( row >= _Values.size()) return null;
        return _Values.get(row);
    }
}
