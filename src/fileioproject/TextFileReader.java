package fileioproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Taylor
 */
public class TextFileReader implements FileReaderStrategy{
    private FileFormatStrategy fmtStrat;
    private String fileLocation;

    public TextFileReader(String fileLocation, FileFormatStrategy fmtStrat) {
        this.fileLocation = fileLocation;
        this.fmtStrat = fmtStrat;
    }
    
    
    
    @Override
    public List<LinkedHashMap<String, String>> getFileData() throws IOException{
        
                
        String data = "";
        
        File file = new File(fileLocation);
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(file));
	   String line = in.readLine();
	   while(line != null){
                data += (line + "\n");
                line = in.readLine();
	   }
	 
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                throw new IOException(e.getMessage());
            }
        }
        
        return fmtStrat.decodeFile(data);
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
