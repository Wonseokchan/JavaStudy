package ch02.variable;

public class StringExample {
    public static void main(String[] args) {
        String name = "홍길동";
        String job = "프로그래머";
        System.out.println(name);
        System.out.println(job);
        // escape character: 이스케이프 문자
        String str = "나는 \"자바\"를 배웁니다.";
        String str2 = "나는 \'자바\'를 배웁니다.";
        System.out.println(str);
        str = "번호\t이름\t직업";
        System.out.println(str);
        str = "나는\n자바를\n배웁니다.";
        System.out.println(str);
        str = "역슬래시(\\)는 이스케이프 문자를 사용할 때 쓴다.";
        System.out.println(str);
        // JDK 13버전부터는 큰따옴표 3개짜리 문자열을 사용할 수 있다.
        String bigStr = """
                나는
                자바를
                배웁니다.
                """;
        System.out.println(bigStr);
        String sql = "";
        sql += "select ";
        sql += "* ";
        sql += "from member ";
        String sql2 = """
                select
                *
                from member
                """;
    }
}
