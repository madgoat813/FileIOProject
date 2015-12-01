package fileioproject;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Taylor
 */
public interface FileFormatStrategy {
    
    List<LinkedHashMap<String,String>> decodeFile(String data);
    
    String encodeAll(List<LinkedHashMap<String,String>> fileData, boolean isHeader) throws IOException;
}
