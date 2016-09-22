/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sunandan
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.util.*;
public class ReadFileEnc {
	
	public void readExcelEnc() throws BiffException, IOException,WriteException, Exception 
        {
            Scanner sc = new Scanner(System.in);
            String s = "C:\\Users\\Sunandan\\Documents\\NetBeansProjects\\NaveenPro\\NaveenPro-war\\web\\sample.xls";
            //System.out.println("Enter the number of coloumns to be encrypted : ");
            int NoOfColumns = 2;
            ArrayList<Integer> ar = new <Integer>ArrayList();
            //System.out.println("Enter the column indices that are to be encrypted : ");
            //for(int i=0; i<NoOfColumns ; i++)
            //{
                ar.add(0);
                ar.add(1);
            //}
            String OutFile = "D:\\output1.xls";
            FileInputStream fs = new FileInputStream(s);
            Workbook wb = Workbook.getWorkbook(fs);
            WritableWorkbook wworkbook;                 //second xls
            wworkbook = Workbook.createWorkbook(new File(OutFile));
            WritableSheet wsheet = wworkbook.createSheet("Sheet1", 0);
            Sheet sh = wb.getSheet("Sheet1");           // TO get the access to the sheet
            int totalNoOfRows = sh.getRows();           // To get the number of rows present in sheet
            int totalNoOfCols = sh.getColumns();// To get the number of columns present in sheet
            //int kk=0;
   //         int k=0;
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
                    //    k++;
                        kk++;
                        System.out.println();
                    } else 
                    {  
                        
                        Label label = new Label(col, kk,Crypt.encrypt(sh.getCell(col, row).getContents()));
                        wsheet.addCell(label);
                        String a=Crypt.encrypt(sh.getCell(col, row).getContents());
                     //   k++;
                        kk++;
                        
                        System.out.println(a);
                        System.out.println();
                    }
                }
            }
           // FileOutputStream out=new FileOutputStream(new File("D:\\out.xls"));
            wworkbook.write();
            wworkbook.close();
            Workbook workbook = Workbook.getWorkbook(new File(OutFile));
          // Sheet sheet = workbook.getSheet(0);
           // Cell cell1 = sheet.getCell(0, 2);
            System.out.println("Encryption done!!!");
            workbook.close();
            System.out.println(OutFile);
	}
	
}
