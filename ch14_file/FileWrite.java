package src.ch14_file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) {
        String tempPath = "C:\\Users\\user\\temp";
        String todayPath = tempPath + File.separator + "today.txt";

        try (FileWriter writer = new FileWriter(todayPath, true)){
            String msg = "내일은 금요일";
            writer.write(msg);
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
