package src.ch14_file;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String tempPath = "C:\\Users\\user\\temp\\dog.jpg";

        String copyPath = "C:\\Users\\user\\dog.jpg";

        try(FileInputStream fis = new FileInputStream(tempPath);
            FileOutputStream fos = new FileOutputStream(copyPath);) {
            byte[] spoon = new byte[1];

            while(true){
                int count = fis.read(spoon);
                if(count == -1)
                    break;

                fos.write(spoon);
                fos.flush();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //파일 이동을 원한다면 복사 붙여넣기 후 파일 삭제
        File origin = new File(tempPath);
        origin.delete();
    }
}
