//package source.ch10_java_api;
//
//import com.google.gson.Gson;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import source.ch08_class.school.Student;
//
//import java.util.ArrayList;
//
//public class ApiJson {
//    public static void main(String[] args) throws ParseException {
//        //JSON 객체란?
//        //JavaScript Object Notation
//        //자바스크립트에서의 객체
//
//        //자바에서의 객체
//        //Student 객체 -> name, kor, eng, math, avg
//        //Student 클래스 생성
//        //Student hodong = new Student("호동이", 90, 80, 70)
//
//        //JSON이라면
//        //클래스 생성 x
//        //let hodong = { name : "호동이", kor : 90, eng : 80, math : 70 }
//
//        //자바라면  hodong.getName() -> "호동이"
//        //자바라면 hodong.name -> "호동이"
//
//        //자바스크립트라면 hodong.name -> "호동이"
//        //자바스크립트라면 hodong.["name"] -> "호동이"
//
//        //목표
//        //자바에서 JSON 객체 생성
//        //자바에서 생성한 JSON 객체를 JSON String으로 변환
//        //JSON String을 JSON 객체로 변환
//
//        //위 과정을 가능하게 하는 라이브러리는 JDK 안에 없으므로 다른 사람이 만든 라이브러리를 외부에서 가지고 와야 함
//        //구글에 maven repository 검색 후 json simple 검색해서 .jar 파일 다운로드
//
//        //Menu - project Structure - Libraries 탭에서 .jar 파일 추가
//        JSONObject jsonObject = new JSONObject();
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.toString());
//
//        //JSON 객체는 내부에 key와 value 쌍으로 구성된 데이터를 가진다
//        //HashMap<String, Object > 와 유사하다
//        //key값에는 문자열을 넣고 value값에는 타입의 제한이 없다
//
//        //데이터 추가
//        jsonObject.put("name", "아이유");
//        System.out.println(jsonObject);
//
//        jsonObject.put("age", 30);
//        System.out.println(jsonObject);
//
//        //데이터 수정
//        //Map과 같이 key값이 중복되지 않음
//        jsonObject.put("age", 31);
//        System.out.println(jsonObject);
//
//        //value에 배열 넣기
//        //ArrayList와 사용법이 같음
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add("좋은날");
//        jsonArray.add("Love wins all");
//        jsonArray.add("분홍신");
//        //jsonArray 내에는 타입 상관없이 넣을 수 있다.
//        jsonArray.add(100);
//        System.out.println(jsonArray);
//        //인덱싱
//        System.out.println(jsonArray.get(2));
//
//        jsonObject.put("songList", jsonArray);
//
//        JSONObject taeyeon = new JSONObject();
//        taeyeon.put("name", "태연");
//        taeyeon.put("age", 34);
//
//        JSONArray songs = new JSONArray();
//        songs.add("만약에");
//        songs.add("사계");
//        songs.add("INVU");
//
//        taeyeon.put("songs", songs);
//
//        jsonObject.put("friend", taeyeon);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.toString());
//        System.out.println(jsonObject.toJSONString());
//
//        //JSON 객체 -> JSON String으로 변환
//        String jsonString = jsonObject.toString();
//        System.out.println(jsonString);
//
//        //key에 대한 value 꺼내기
//        System.out.println(jsonObject.get("name"));
//
//        //꺼낸 value를 변수에 옮겨 담기
//        String name = (String)jsonObject.get("name");
//        System.out.println(name);
//
//        int age = (int)jsonObject.get("age");
//        System.out.println(age);
//
//        JSONArray iuSong = (JSONArray)jsonObject.get("songList");
//        System.out.println(iuSong);
//        for(int i=0; i< iuSong.size(); i++)
//            System.out.println(iuSong.get(i));
//
//        //JSONArray 의 .get() 또한 Object 타입을 리턴
//        String pink = (String)iuSong.get(0);
//        System.out.println(pink);
//
//        JSONObject ty = (JSONObject) jsonObject.get("friend");
//        System.out.println(ty);
//        String tyName = (String)ty.get("name");
//        System.out.println(tyName);
//
//        System.out.println("\n===============================================\n");
//
//        //클라이언트로부터 JSON String 으로 데이터가 넘어옴
//        String clientRequest = "{\"name\":\"아이유\",\"friend\":{\"songs\":[\"만약에\",\"사계\",\"INVU\"],\"name\":\"태연\",\"age\":34},\"songList\":[\"좋은날\",\"Love wins all\",\"분홍신\",100],\"age\":31}\n";
//
//        //문자열 덩어리일 뿐
//        System.out.println(clientRequest);
//
//        //JSON String -> JSON 객체로 변환하기 위한 JSONParse 객체 생성
//        JSONParser jsonParser = new JSONParser();
//
//        JSONObject reqJson = (JSONObject) jsonParser.parse(clientRequest);
//        System.out.println(reqJson);
//
//        reqJson.get("name");
//
//        //JSON String 으로부터 Pasing을 통해 꺼낸 JSON Object의 숫자 Value는 long 타입으로 꺼내야 한다. (int는 에러남)
//        long iuAge = (long)reqJson.get("age");
//        System.out.println(iuAge);
//
//        System.out.println("\n======================================================\n");
//        String response = "{ \"city\" : [\"서울\", \"광주\", \"대구\", \"대전\", \"부산\", \"울산\", \"인천\"], \"fields\": [{\"id\": \"자장면\"},{\"id\": \"냉면\"}, {\"id\": \"김밥\"}, {\"id\": \"칼국수\"}], \"records\": [{\"시도명\": \"서울\", \"자장면\": 7069, \"냉면\": 11308, \"김밥\": 3215, \"칼국수\": 8962}, {\"시도명\": \"광주\", \"자장면\": 6800, \"냉면\": 9400, \"김밥\": 3160, \"칼국수\": 8400}, {\"시도명\": \"대구\", \"자장면\": 6250, \"냉면\": 10417, \"김밥\": 2750, \"칼국수\": 6750}, { \"시도명\": \"대전\", \"자장면\": 6700, \"냉면\": 10400, \"김밥\": 3000, \"칼국수\": 7800}, {\"시도명\": \"부산\", \"자장면\": 6143, \"냉면\": 10857, \"김밥\": 2786, \"칼국수\": 6986}, { \"시도명\": \"울산\", \"자장면\": 6500, \"냉면\": 9900, \"김밥\": 3300, \"칼국수\": 8400}, {\"시도명\": \"인천\", \"자장면\": 6500, \"냉면\": 10667, \"김밥\": 3050, \"칼국수\": 8000}]}";
//        System.out.println(response);
//
//        //7개의 도시 중 가장 냉면 값이 저렴한 도시와 그 가격을 찾아서 출력하기
//        //1. 데이터 구조 파악(JSON Parser online 사이트 이용)
//        //2. 기능 구현을 위해 어떤 키 값에 접근해야하는지
//        JSONObject res = (JSONObject) jsonParser.parse(response);
//        System.out.println(res.get("records"));
//
//        System.out.println("\n=========================\n");
//        JSONArray list = (JSONArray) res.get("records");
//
//        JSONObject seoul = (JSONObject) list.get(0);
//        seoul.get("냉면");
//        long min = (long)seoul.get("냉면");
//        String city = (String)seoul.get("시도명");
//
//        for(int i = 0; i < list.size(); i++){
//            JSONObject temp = (JSONObject) list.get(i);
//            long price = (long)temp.get("냉면");
//            if(min > price) {
//                min = price;
//                city = (String)temp.get("시도명");
//            }
//        }
//        System.out.println(min);
//        System.out.println(city);
//        for(int i = 0; i < list.size(); i++){
//            JSONObject temp = (JSONObject) list.get(i);
//            long price = (long)temp.get("냉면");
//            if(min==price){
//                System.out.println(temp.get("시도명"));
//            }
//        }
//
//        System.out.println("\n========================\n");
//        //7개 도시의 자장면 평균 가격을 계산하여 출력하기(6566원)
//        long sum=0;
//        long avg=0;
//        for(int i = 0; i < list.size(); i++){
//            JSONObject temp = (JSONObject) list.get(i);
//            long price = (long)temp.get("자장면");
//            sum +=price;
//            avg = sum/list.size();
//        }
//        System.out.println("평균가: "+avg);
//
//        System.out.println("\n========================\n");
//
//        //GSON 라이브러리를 이용한 JAVA의 JSON 객체 처리
//        //maven repository - gson 검색 - .jar파일 다운로드 - lib에 복붙
//        //GSON 객체 생성
//        Gson gson = new Gson();
//
//        Student hodong = new Student("호동이",90,80,70);
//        System.out.println(hodong);
//
//        //자바의 객체 hodong을 데이터로 보낼 때 JSON String으로 보내야 함
//        //객체를 JSON String으로 변환하는 과정을 직렬화(= Serialize)
//        //GSON은 직렬화를 한번에 해준다
//        String strHodong = gson.toJson(hodong);
//        System.out.println(strHodong);
//
//        //자바의 배열 직렬화
//        String[] stuArray = {"호빵맨", "찐빵맨", "꿀빵맨"};
//        String strArray = gson.toJson(stuArray);
//
//        //자바의 리스트 직렬화
//        ArrayList<String> nameList = new ArrayList<>();
//        nameList.add("호빵");
//        nameList.add("찐빵");
//        nameList.add("꿀빵");
//        String strList = gson.toJson(nameList);
//        System.out.println(strList);
//
//        //리스트 안에 객체가 들어있어도 직렬화가 가능
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("코난", 90, 90,90));
//        students.add(new Student("맹구", 70, 80,90));
//        students.add(new Student("짱구", 50, 50,50));
//        String strStu = gson.toJson(students);
//        System.out.println(strStu);
//
//        //JSON String -> 객체로 변경
//        // =역직렬화(Deserialize)
//        String reqParam = "{\"name\":\"호동이\",\"kor\":90,\"eng\":80,\"math\":70,\"avg\":80.0}";
//        Student comeback = gson.fromJson(reqParam, Student.class);
//
//        //JSON String의 key값과 일치하는 필드변수만 값이 채워진다
//        System.out.println(comeback);
//        System.out.println(comeback.getName());
//
//
//
//    }
//}
