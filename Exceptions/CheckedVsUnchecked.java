package Exceptions;
import java.io.FileReader;
import java.io.IOException;

public class CheckedVsUnchecked {
    public static void main(String[] args) throws IOException {
        readFile("myFile.txt");
    }
    private static void readFile(String fileName) throws IOException{
        FileReader reader = new FileReader(fileName);
        reader.close();
    }
}
