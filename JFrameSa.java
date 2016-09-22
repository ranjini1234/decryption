package com;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunandan
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import java.io.File; 
public class JFrameSa 
{
    public String Browse(int n)
    {
        int s1 = n;
        System.out.println(s1);
        
        JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame();
            frame.setTitle("My First Swing Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel("Welcome");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(frame);
            String s="";
            if (result == JFileChooser.APPROVE_OPTION) 
            {
                File selectedFile = fileChooser.getSelectedFile();
                s=selectedFile.getAbsolutePath();
                
            }
            
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
            return s;
    }
    
            
  
}


