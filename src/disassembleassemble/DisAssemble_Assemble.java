

package disassembleassemble;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class DisAssemble_Assemble {
    public static void disassemble(String fileName, int subFileSize) throws FileNotFoundException, IOException{
        int fileCount = 0;
        String subFileName;
        String info="";
               
        FileInputStream fis = new FileInputStream(fileName);
        String txtFileName=(fileName.substring(0, fileName.lastIndexOf("."))+".txt");
        while(fis.available()>0){
            fileCount++;
            subFileName = fileName+"."+"part"+fileCount;
            info+=subFileName+"\n";
            int buffSize=fis.available()>subFileSize?subFileSize:fis.available();
            
            byte[] buffer = new byte[buffSize];
            fis.read(buffer);
            
            FileOutputStream fos = new FileOutputStream(subFileName);
            fos.write(buffer);
            fos.close();
        }
        fis.close();
        
        FileWriter fw = new FileWriter(txtFileName);
        fw.append(info);
        fw.append("end");
        fw.close();
          
    }
    
    public static void assemble(String fileName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        Set<String> set = new TreeSet();
        String endFileName;
        
        String partFileName = br.readLine();
        int index = partFileName.lastIndexOf(".");
        endFileName = partFileName.substring(0,index);
        
        while(!partFileName.equals("end")){
            System.out.println(partFileName);
            set.add(partFileName);
            partFileName=br.readLine();
        }
        br.close();
        
        FileOutputStream fos = new FileOutputStream(endFileName);
        for(String readingFile:set){
            FileInputStream fis = new FileInputStream(readingFile);
            byte[] buffer = new byte[fis.available()];
            while(fis.available()>0){
                fis.read(buffer);
                fos.write(buffer);
            }
            fis.close();
        }
        fos.close();
        
    }

}
