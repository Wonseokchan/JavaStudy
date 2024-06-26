package src.ch15_network;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataParsing {
    public static void main(String[] args) throws Exception {
        //MediData.txt 파일 내용 문자열로 꺼내기
        String path = System.getProperty("user.dir");
        String targetPath = path + File.separator + "src" + File.separator + "ch15_network" + File.separator + "MediData.txt";

        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(targetPath);

        char[] cup = new char[10];

        while(true){
            int count = reader.read(cup);
            if(count == -1)
                break;

            sb.append(cup);
        }
        reader.close();

        System.out.println(sb);

        //json 객체로 변환(parsing)
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(sb.toString());

        System.out.println("\n=============================\n");
        //동아제약인 약품명만 꺼내기
        JSONObject body = (JSONObject) json.get("body");
        System.out.println(body);

        JSONObject items =  (JSONObject) body.get("items");
        System.out.println(items.get(3));

        for(int i = 0; i < items.size(); i++){
            JSONObject medi = (JSONObject) items.get(i);

            String entpName = (String) medi.get("entpName");

            if(entpName.contains("동아제약")){
                String itemName = (String)medi.get("itemName");
                System.out.println(itemName);
            }
        }


    }
}
