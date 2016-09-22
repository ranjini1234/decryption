/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author Sunandan
 */
import java.util.*;
import java.io.IOException;
import jxl.write.WriteException;

public class SCBJencryptMain 
{
    public static void main(String[] args) throws IOException, WriteException, Exception 
    {
        ReadFileEnc rfe = new ReadFileEnc();
        ReadFileDec rfd = new ReadFileDec();
        
        System.out.println("\t\t\t\tWelcome to SCBJencrypt");
        System.out.println("Please select an action to perform :");
        System.out.println("Enter '1' for Encryption.");
        System.out.println("Enter '2' for Decryption.");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch(option)
        {
            case 1 :
            {
                rfe.readExcelEnc();
                //System.out.println(path);
                break;
                        
            }
            case 2:
            {
                rfd.readExcelDec();
                break;
            }
        }
        
        
    }
    
}
