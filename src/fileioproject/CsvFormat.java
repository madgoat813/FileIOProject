/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioproject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.*;
/**
 *
 * @author Taylor
 */
public class CsvFormat implements FileFormatStrategy{

    @Override
    public List<LinkedHashMap<String, String>> decodeFile(String data) {
        List<LinkedHashMap<String,String>> allRecords = new ArrayList<LinkedHashMap<String,String>>();
        
        String[] lines = data.split("\\n");
        String[] header = lines[0].split(",");
        
        for(int l=1; l < lines.length; l++) {
            LinkedHashMap<String,String> record = new LinkedHashMap<String,String>();
            String[] recordData = lines[l].split(",");
            for(int r=0;r < recordData.length; r++) {
                record.put(header[r], recordData[r]);
//                System.out.println(header[r]);
//                System.out.println(recordData[r]);
            }
            allRecords.add(record);
        }
        
        return allRecords;
    }

    @Override
    public String encodeAll(List<LinkedHashMap<String, String>> fileData, boolean isHeader) {
      StringBuilder encodedData = new StringBuilder();  
      
      LinkedHashMap<String, String> header = fileData.get(0);
      Set<String> data = header.keySet();
      
      Iterator i = data.iterator();
      
      while(i.hasNext()) {
          encodedData.append("\"").append(i.next()).append("\"").append(",");
      }
      int endRow = encodedData.length()-1;
      encodedData.replace(endRow, endRow + 1, "\n");
      
      for(LinkedHashMap<String, String> recordData : fileData) {
          Iterator r = data.iterator();
          while(r.hasNext()) {
              encodedData.append("\"").append(recordData.get(r.next().toString())).append("\"").append(",");
          }
          endRow = encodedData.length()-1;
          encodedData.replace(endRow, endRow + 1, "\n");     
      }
      endRow = encodedData.length()-1;
      encodedData.replace(endRow, endRow + 1, "\n");
      
      return encodedData.toString();
    }
    
}
