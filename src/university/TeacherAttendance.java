/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university;

/**
 *
 * @author adrianadewunmi
 */
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherAttendance extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2,fh,sh;
    
    TeacherAttendance(){
       
        setLayout(new GridLayout(4,2,50,50));
        c2 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                c2.add(rs.getString("emp_id"));    
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select Teacher ID"));
        add(c2);
      
        l1 = new JLabel("First Half");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
       
        add(l1);
        add(fh);
        
        l2 = new JLabel("Second Half");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
       
        add(l2);
        add(sh);
       
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource() == b1){
            String f = fh.getSelectedItem();
            String s = sh.getSelectedItem();
            String dt = new java.util.Date().toString();
            String id=c2.getSelectedItem();
            String qry = "insert into attendance_teacher values("+ id +",'"+dt+"','"+f+"','"+s+"')";

            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Attendance confirmed");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        else{
            this.setVisible(false);
        }
    }
    
    public static void main(String s[]){
        new TeacherAttendance();
    }
}

