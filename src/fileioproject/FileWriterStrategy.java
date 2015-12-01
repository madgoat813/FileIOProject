/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioproject;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Taylor
 */
public interface FileWriterStrategy {
    void writeFile(List<LinkedHashMap<String,String>> fileData, boolean isHeader) throws IOException;
    
    String getFileLocation();
    
    FileFormatStrategy getFormatStrategy();
    
    void setFileLocation(String file);
    
    void setFormatStrategy(FileFormatStrategy fmtStrat);
}
