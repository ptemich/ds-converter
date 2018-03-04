/**
 * 
 */
package pl.ptemich.ds.ds_converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author qasx
 *
 */
public class FilenameConverterImpl implements FilenameConverter {

  public int convert(String path) {    
    Path paths = Paths.get(path);
    try {
      Stream<Path> files = Files.list(paths);
      files.forEach(pth -> {  
        File file = pth.toAbsolutePath().toFile();
        System.out.println("Process file: " + file);
        String name = file.getName();
        String idPrefixSeparator = " - ";
        int indexOf = name.indexOf(idPrefixSeparator);
        
        if (indexOf != -1) {
          String newFilename = pth.getParent().toString() + "\\" + name.substring(indexOf + idPrefixSeparator.length()); 
          System.out.println("File '" + name + "' renamed to -> '" + newFilename + "'");
          File newFile = new File(newFilename);
          file.renameTo(newFile);
        }        
      });
      files.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return 0;
  }
  
}
