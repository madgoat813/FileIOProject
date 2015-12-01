
package fileioproject;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Taylor
 */
public interface FileReaderStrategy {
    
    List<LinkedHashMap<String, String>> getFileData() throws IOException;
    
    String getFileLocation();
    
    FileFormatStrategy getFormatStrategy();
    
    void setFileLocation(String file);
    
    void setFormatStrategy(FileFormatStrategy fmtStrat);
}
