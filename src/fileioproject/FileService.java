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
public class FileService {
    private FileReaderStrategy reader;
    private FileWriterStrategy writer;
    private String readFileLocation;
    private String writeFileLocation;
    private FileFormatStrategy readFmt;
    private FileFormatStrategy writeFmt;

    public FileService(FileReaderStrategy reader, FileWriterStrategy writer) {
        this.reader = reader;
        this.writer = writer;
        this.writeFileLocation = writer.getFileLocation();
        this.writeFmt = writer.getFormatStrategy();
    }

    public FileService(FileReaderStrategy reader) {
        this.reader = reader;
        this.readFileLocation = reader.getFileLocation();
        this.readFmt = reader.getFormatStrategy();
    }

    public FileService(FileWriterStrategy writer) {
        this.writer = writer;
        this.writeFileLocation = writer.getFileLocation();
        this.writeFmt = writer.getFormatStrategy();
    }
    
    public List<LinkedHashMap<String,String>> getFileData() throws IOException {
        return reader.getFileData();
    }
    
    public void writeRecords(List<LinkedHashMap<String,String>> data, boolean isHeader) throws IOException {
        writer.writeFile(data, isHeader);
    }
    
    

    
    
    
}
