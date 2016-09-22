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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ReadFileDec {
	
	public void readExcelDec() throws BiffException, IOException,WriteException, Exception 
        {
            System.out.println("Enter the absolute path of the file to be decrypted");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.println("Enter the number of coloumns to be decrypted : ");
            int NoOfColumns = sc.nextInt();
            ArrayList<Integer> ar = new <Integer>ArrayList();
            System.out.println("Enter the column indices that are to be decrypted : ");
            for(int i=0; i<NoOfColumns ; i++)
            {
                ar.add(sc.nextInt());
            }
            String OutFile="output2.xls";
            FileInputStream fs = new FileInputStream(s);
            Workbook wb = Workbook.getWorkbook(fs);
            WritableWorkbook wworkbook;                 //second xls
            wworkbook = Workbook.createWorkbook(new File(OutFile));
            WritableSheet wsheet = wworkbook.createSheet("Sheet1", 0);
            Sheet sh = wb.getSheet("Sheet1");           // TO get the access to the sheet
            int totalNoOfRows = sh.getRows();           // To get the number of rows present in sheet
            int totalNoOfCols = sh.getColumns();// To get the number of columns present in sheet
            //int kk=0;
            //int k=0;
            //int col=0;
            for(int col=0; col< totalNoOfCols; col++)
            {
                int kk=0;
                for (int row = 0; row < totalNoOfRows; row++) 
                {
                    if (!ar.contains(col))
                    {
                        Label label = new Label(col, kk,sh.getCell(col, row).getContents());
                        wsheet.addCell(label);
                      //  k++;
                        kk++;
                        System.out.println();
                    } else 
                    {
                        Label label = new Label(col, kk,Crypt.decrypt(sh.getCell(col, row).getContents()));
                        wsheet.addCell(label);
                     //   k++;
                        kk++;
                        System.out.println();
                    }
                }
            }

            wworkbook.write();
            wworkbook.close();
            Workbook workbook = Workbook.getWorkbook(new File(OutFile));
           // Sheet sheet = workbook.getSheet(0);
         //   Cell cell1 = sheet.getCell(0, 2);
            System.out.println("Decryption done!!!");
            workbook.close();
            System.out.println("The decrypted file is stored in location : C:\\Users\\Sunandan\\Documents\\NetBeansProjects\\Aes_ver1.2\\"+OutFile);
	}
	
}
