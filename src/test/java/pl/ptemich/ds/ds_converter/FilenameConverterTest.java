package pl.ptemich.ds.ds_converter;

import org.junit.Test;

public class FilenameConverterTest {

  @Test
  public void checkFileNameConversion() {
    FilenameConverter fnc = new FilenameConverterImpl();
    fnc.convert("D:\\Konsole\\ds\\test");
  }

}
