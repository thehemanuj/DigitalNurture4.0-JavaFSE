package mockito_advanced;

public class FileService {
    private FileReader fileReader;
    private FileWriter fileWriter;
    
    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }
    
    public String processFile() {
        String content = fileReader.read();
        return "Processed " + content;
    }
}