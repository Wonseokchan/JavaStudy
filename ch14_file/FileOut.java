package src.ch14_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOut {
    public static void main(String[] args) {
        String tempPath = "C:\\Users\\user\\temp";

        // temp 폴더 안에 today.txt 파일 생성하면서 안에 글을 작성
        String todayPath = tempPath + File.separator + "today.txt";

        // 1. 파일 안에 내용을 작성하기 위한 FileOutPutSteam 객체 생성
        // 생성자 괄호 안에 타겟 파일의 경로를 작성한다
        // 파일이 존재하지 않아도, 내용이 작성되면서 파일이 생성됨
        // FileOutputStream 생성자에 두번째 파라미터를 넣지 않으면 덮어쓰기가 된다
        // 두번째 파라미터로 true를 넣으면 이어 붙이기가 된다
        try(FileOutputStream fos = new FileOutputStream(todayPath, true)) {
            //OutputStream 은 byte단위로 데이터를 전송한다
            //"hello"를 작성하고자 한다면
            String msg = "목요일";

            //.getBytes() : String -> byte[]로 변환해줌
            //데이터 쓰기
            fos.write(msg.getBytes());

            //데이터 내보내기
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
