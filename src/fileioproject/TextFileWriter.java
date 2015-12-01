/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileioproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Taylor
 */
public class TextFileWriter implements FileWriterStrategy {
    private FileFormatStrategy fmtStrat;
    private String fileLocation;

    public TextFileWriter(String fileLocation, FileFormatStrategy fmtStrat) {
        this.fileLocation = fileLocation;
        this.fmtStrat = fmtStrat;
    }
    
    
    
    @Override
    public void writeFile(List<LinkedHashMap<String, String>> fileData, boolean isHeader) throws IOException {
        File file = new File(fileLocation);
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        
        String data = fmtStrat.encodeAll(fileData, isHeader);
        
        output.print(data);
        output.close();
    }
    

    @Override
    public String getFileLocation() {
        return fileLocation;
    }

    @Override
    public FileFormatStrategy getFormatStrategy() {
        return fmtStrat;
    }

    @Override
    public void setFileLocation(String file) {
        this.fileLocation = file;
    }

    @Override
    public void setFormatStrategy(FileFormatStrategy fmtStrat) {
        this.fmtStrat = fmtStrat;
    }
    
}
