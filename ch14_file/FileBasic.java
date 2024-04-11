package source.ch14_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileBasic {
    public static void main(String[] args) {
        //현재 디렉토리의 경로 가져오기
        String path = System.getProperty("user.dir");
        System.out.println(path);


        //윈도우는 폴더 경로 구분자가 \임
        //리눅스와 맥은 폴더 경로 구분자가 /임
        //윈도우면 \로, 리눅스와 맥이면 /로 적용이 되는 구분자 적용(= File.separator)
        String srcPath = path + File.separator + "src";
        System.out.println(srcPath);

        //srcPath를 이용하여 자바에서 실제 src 폴더를 객체로 가져오기
        File srcFile = new File(srcPath);
        //toString() 실행 시 해당 File 객체의 풀 경로가 출력됨
        System.out.println(srcFile);

        //해당 File 객체가 폴더인지 파일인지 확인
        System.out.println(srcFile.isDirectory()); //폴더면 true 리턴

        //폴더 내 파일 목록 리턴
        //File 배열을 리턴 (File[])
        File[] fileArray = srcFile.listFiles();
        for(int i = 0; i < fileArray.length; i++) {
            System.out.println(fileArray[i]); //풀경로
            System.out.println(fileArray[i].getName()); //파일명만
        }
        //ch04_control의 풀경로 \RacingGame.java 난 없넹
        System.out.println(fileArray[3]);

        String filePath = fileArray[3] + File.separator + "Conditional";
        System.out.println(filePath);

        //실제로 존재하지 않는 파일 경로에 대해서도 File 객체는 만들어짐
        File file = new File(filePath);
        System.out.println(file);

        //File 객체가 실제로 존재하는 파일을 가르키고 있는지 확인
        System.out.println(file.exists());

        filePath += ".java";
        System.out.println(filePath);

        file = new File(filePath);
        System.out.println(file);
        System.out.println(file.exists());

        System.out.println("\n==========================실제 파일에 대한 정보 보기========================\n");
        //실제 파일에 대한 정보 보기
        //.length() 파일 크기 리턴(byte)
        // 1KB = 1024byte
        // 1MB = 1024KB
        // 1GB = 1024MB
        // 1TB = 1024GB
        System.out.println(file.length()+"byte");

        System.out.println("\n=========================.lastModified() 마지막으로 수정된 날짜=========================\n");
        //.lastModified() 마지막으로 수정된 날짜
        System.out.println(file.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        System.out.println(sdf.format(file.lastModified()));

        System.out.println("\n========================폴더/파일 생성하기==========================\n");
        //폴더 생성하기
        String newFilePath = srcPath + File.separator + "files";
        System.out.println(newFilePath);
        File newFile = new File(newFilePath);
        System.out.println(newFile.exists());

        //.mkdir() 실행 시 해당 경로에 폴더 생성
        newFile.mkdir(); //같은 이름의 폴더가 존재하면 생성안됨(실행 후 코드 안지워도 에러 안남)

        //src//files 폴더 내에 hello.txt 파일 생성
        String helloPath = newFilePath + File.separator + "hello.txt";
        System.out.println(helloPath);
        File helloFile = new File(helloPath);
        System.out.println(helloFile.exists());

        //.creatNewFile() 실행 시 해당 경로에 파일 생성
        try {
            helloFile.createNewFile(); //같은 이름의 파일이 존재하면 생성안됨(실행 후 코드 안지워도 에러 안남)
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n==================================================\n");
        String[] stuArray = {"재연","지인","진율","상연","경택","선동","상일","재경","석찬","영윤"};
        //files 폴더 내에 각 학생의 이름으로 구성된 폴더 생성하기
        for(int i = 0; i < stuArray.length; i++) {
            String stuFilePath = newFilePath + File.separator + stuArray[i];
            File stuFile = new File(stuFilePath);
            stuFile.mkdir();

            String idPath = stuFilePath + File.separator + "id.txt";
            File idFile = new File(idPath);
            try {
                idFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("\n========================파일/폴더 삭제==========================\n");
        //파일 삭제
        //...\files\경택\id.txt 지우기
        String targetPath = newFilePath + File.separator + "경택" + File.separator + "id.txt";
        File targetFile = new File(targetPath);
        targetFile.delete();
        System.out.println(targetFile.exists());

        //폴더 삭제
        //...\files\경택 지우기
        String folderPath = newFilePath + File.separator + "상연"; //폴더 내에 파일이 존재하면 삭제하지 못함
        File folderFile = new File(folderPath);
        folderFile.delete();
        System.out.println(folderFile.exists());

        //files 폴더 지우기
        File targetFolder = new File(newFilePath);
        deleteFolder(targetFolder);

        System.out.println("\n==================================================\n");
        //src 폴더 내에 특정 파일의 경로 찾기
        searchFile("ApiJson.java"); //...\src\ch10_java_api\ApiJson.java
        searchFile("json"); //...\src\ch10_java_api\ApiJson.java
    }

    public static void deleteFolder(File target) {
        //파라미터로 들어온 File 객체가 폴더라면 폴더 내부 파일들에 접근
        if (target.isDirectory()) {
            //폴더 내부 파일 목록 가져오기
            File[] fileArray = target.listFiles();
            System.out.println(fileArray.length);
            if(fileArray.length == 0){
                target.delete();
            }
            for (int i = 0; i < fileArray.length; i++) {
                //파일이면 삭제, 폴더면 다시 내부 파일들에 접근
                deleteFolder(fileArray[i]);
                deleteFolder(fileArray[i]);
            }
        }
        //파라미터로 들어온 File 객체가 파일이라면 삭제
        else{
            target.delete();
        }
    }

    public static void searchFile(String name) {
        String Path = System.getProperty("user.dir");
        String srcPath = Path + File.separator + "src";
        File srcFile = new File(srcPath);
        File[] fileArray = srcFile.listFiles();

        for(int i = 0; i < fileArray.length; i++) {
            whereFile(fileArray[i], name);
        }
    }

    public static void whereFile(File target, String fileName){
        //target이 파일이면 fileName과 일치하는지 확인
        //일치하면 경로를 리턴
        if (target.isDirectory()){
            File[] fileArray = target.listFiles();

            for(int i = 0; i < fileArray.length; i++) {
                whereFile(fileArray[i], fileName);
            }
        }
        else {
            if(target.getName().equals(fileName))
                System.out.println(target);

            if(target.getName().toLowerCase().contains(fileName.toLowerCase())){
                System.out.println(target);
            }
        }
    }
}
