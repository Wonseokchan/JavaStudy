package src.ch14_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) {
        //FileInputStream과 FileOutputStreamdms 바이트 단위로 데이터를 읽고 쓴다 -> 텍스트 파일에 대해서는 부적합. 이미지 음악 동영상에는 적합

        //텍스트 파일에 대해서는 문자(char)단위로 데이터를 읽고 쓰는 FileReader와 FileWriter를 사용하는 것이 적합
        String tempPath = "C:\\Users\\user\\temp";
        String todayPath = tempPath + File.separator + "today.txt";

        StringBuffer readData = new StringBuffer();
        try(FileReader fr = new FileReader(todayPath)) {


            //문자 데이터를 옮길 그릇 생성
            char[] spoon = new char[1];

            while(true){
                int count = fr.read(spoon);

                if(count == -1)
                    break;

                readData.append(spoon);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(readData);
    }
}
