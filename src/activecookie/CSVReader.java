package activecookie;

import java.io.*;

public class CSVReader {
    File inputFile;
    String filePath;
    BufferedReader csvLineReader;
    FileReader csvFileReader;

    public CSVReader(String filePath) {
        this.filePath = "./src/activecookie/" + filePath;
    }

    public boolean isValid() {
        this.inputFile = new File(this.filePath);
        return inputFile.isFile();
    }

    public void initReader() throws FileNotFoundException {
        if (!isValid()) {
            throw new FileNotFoundException("File Does Not Exist!");
        }
        this.csvFileReader = new FileReader(inputFile);
        this.csvLineReader = new BufferedReader(this.csvFileReader);
    }

    public void close() throws IOException {
        csvLineReader.close();
        csvLineReader.close();
    }

    public String readLine() throws IOException {
        return csvLineReader.readLine();
    }

}
