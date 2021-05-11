package presentation;



import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// create a users class
public class Users{
    
    private int Id;
    private String Fname;
    private String Lname;
    private int Age;
    
    public Users(int id,String fname,String lname,int age){
        this.Id = id;
        this.Fname = fname;
        this.Lname = lname;
        this.Age = age;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public String getFname(){
        return this.Fname;
    }
    
    public String getLname(){
        return this.Lname;
    }
    
    public int getAge(){
        return this.Age;
    } 
}

