package src.ch14_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIn {
    public static void main(String[] args) {
        String tempPath = "C:\\Users\\user\\temp";
        String todayPath = tempPath + File.separator + "today.txt";
        String todayStr = "";

        // 1. 해당 파일의 내용을 읽어오기 위한 FileInputStream 객체 생성
        // 생성자 안에 해당 파일 객체(File)를 넣어줌
        try(FileInputStream fis = new FileInputStream(todayPath)) {

            // 2. 데이터를 옮길 때 필요한 그릇(byte[] ) 생성
            // 한글이 포함되어 있는 경우 byte단위로 쪼개면서 한글이 깨질 수 있음
            // FileReader를 사용하거나, 그릇의 크기를 파일의 크기만큼 키운다
//            byte[] spoon = new byte[2];

            byte[] spoon = new byte[fis.available()];

            while (true){
                //해당 파일을 spoon의 크기만큼 읽어서 spoon에 담음
                //count에는 spoon에 담긴 데이터의 크기(byte)가 담김
                //더이상 읽어올 데이터가 없는 경우 spoon에 -1이 담김
                int count = fis.read(spoon);

                if(count == -1)
                    break;

                //byte[] -> String으로 변환
                String readData = new String(spoon);
                todayStr += readData;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(todayStr);
    }
}
