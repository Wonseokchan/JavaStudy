package source.ch07_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {
    public static void main(String[] args) {
        //Map은 데이터를 key와 Value의 한쌍으로 저장
        //Map의 선언
        //HashMap
        HashMap<String, String> stuMap = new HashMap<>();

        //다형성 이용
        //어지간한 경우에 Key값의 타입은 String이다.
        Map<String, Integer> coinMap = new HashMap<>();

        //map에 값 추가
        //.put(key, value)
        stuMap.put("첫째", "선동");
        stuMap.put("둘째", "상일");
        stuMap.put("셋째", "재경");
        System.out.println(stuMap); //데이터의 순서가 보장되지 않는다.

        //중복된 key값을 허용하지 않는다.
        stuMap.put("첫째", "선동");

        //중복된 key값의 데이터가 넘어오면 기존 데이터를 대체( 덮어씀 ) > 데이터의 value 수정 가능
        stuMap.put("첫째", "석찬");
        System.out.println(stuMap);

        coinMap.put("비트코인", 94000000);
        coinMap.put("도지코인", 232);
        System.out.println(coinMap);

        System.out.println("\n============================\n");

        //데이터의 개수 리턴
        //.size()
        System.out.println("stuMap.size() : "+stuMap.size());
        System.out.println("coinMap.size() : "+coinMap.size());

        //key에 해당하는 데이터의 value 값 리턴
        //.get(key)
        System.out.println("stuMap.get(첫째) : "+stuMap.get("첫째"));
        //존재하지 않는 key값을 넣으면 null값을 리턴
        System.out.println("stuMap.get(넷째) : "+stuMap.get("넷째"));

        System.out.println("coinMap.get(도지코인) : "+coinMap.get("도지코인"));

        //map의 내부 요소 중 괄호 안 key가 들어있으면 true, 없으면 false리턴
        //.containskey(key)
        System.out.println(stuMap.containsKey("넷째"));
        System.out.println(stuMap.get("첫째") != null);

        //해당 key를 가지는 데이터를 삭제
        //.remove(key)
        stuMap.remove("둘째");
        System.out.println(stuMap);

        //Map 순회 ( 각 데이터에 접근 )
        //1. keySet 이용
        System.out.println("1. keySet");
        Set<String> stuKeyset = stuMap.keySet(); //map의 key값들로만 구성된 Set을 리턴
        System.out.println("keySet : "+stuKeyset);
        for( String stu : stuKeyset) {
            System.out.println(stu); //첫재, 셋째
            System.out.println(stuMap.get(stu)); //석찬, 재경
        }

        //2. EntrySet 이용
        //Map<String, String> 은 Entry<String, String> 데이터를 저장
        //Map<String, Integer> 은 Entry<String, Integer> 데이터를 저장
        System.out.println("2. EntrySet");
        Set<Entry<String, String >> stuEntrySet = stuMap.entrySet();
        for(Entry<String, String > stuEntry : stuEntrySet){
            System.out.println(stuEntry);
            System.out.println(stuEntry.getKey()); //key 값만 출력
            System.out.println(stuEntry.getValue()); //value 값만 출력
        }



    }
}
