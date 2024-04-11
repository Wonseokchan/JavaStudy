package src.ch15_network;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OpenAPI {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=s9LtJ4f28XKtHHjtRa94y0gWEWaArpqpuNkbkpRyVgYYyLDPigB20QyFaSduFmFXXydgwTJSD4Ef53t5Z1%2BnFg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/

        //위에서 완성한 하나의 문자열에 대한 URL 객체 생성
        URL url = new URL(urlBuilder.toString());

        // 해당 URL 주소에 대한 연결
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        //BufferedReader rd 에 담긴 데이터를 한줄씩(\n) line에 담은 후 StringBuilder sb 에 추가
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        // 서버 요청, 응답에 사용한 객체 정리
        rd.close();
        conn.disconnect();

        //응답 데이터를 문자열로 확보
        System.out.println(sb.toString());

        String path = System.getProperty("user.dir");
        String targetPath = path + File.separator + "src" + File.separator + "ch15_network" + File.separator + "MediData.txt";

        FileWriter writer = new FileWriter(targetPath);
        writer.write(sb.toString());

        writer.flush();
        writer.close();
    }
}

