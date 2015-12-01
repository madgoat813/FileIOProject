/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Taylor
 */
public class StartUp {
    public static void main(String[] args) throws IOException {
        char sep = File.separatorChar;
        
        
        
        FileService fileService = new FileService( new TextFileReader("src" + sep + "fileioproject" + sep + "test.csv", new CsvFormat()),
                                                   new TextFileWriter("src" + sep + "fileioproject" + sep + "test.csv", new CsvFormat()));
        
        List<LinkedHashMap<String, String>> data = fileService.getFileData();
        
        
        
        
        
        
        
        
        
        List<LinkedHashMap<String, String>> fileData = new ArrayList<LinkedHashMap<String, String>>();
        LinkedHashMap<String, String> record = new LinkedHashMap<String, String>();

        record.put("firstName", "Joe");
        record.put("lastName", "Rogan");
        fileData.add(record);

        record = new LinkedHashMap<String, String>();
        record.put("firstName", "Jack");
        record.put("lastName", "Black");
        fileData.add(record);

        fileService.writeRecords(fileData, false);

        
    }
    
    
}
