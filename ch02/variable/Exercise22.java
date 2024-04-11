package ch02.variable;

public class Exercise22 {
    public static void main(String[] args) {
        /*
        지구에서 가장 가까운 별은 어디일까? 정답은 태양이다.
        태양 다음으로 가까운 별은 프록시마 센타우리(Proxima Centauri)별이라고 한다.
        프록시마 센타우리는 지구로부터 40 * 10^12km 떨어져 있다고 한다.
        빛의 속도로 프록시마 센타우리까지 간다면 몇 광년이 걸리는지 직접 계산해보기로 하자.
        빛의 속도는 300,000km/s이다.
        힌트: 천문학에서 사용하는 숫자들은 아주 크기 때문에 double 형을 사용하여야 한다.
        double distance = 40e12;로 나타낼 수 있다.

        <console>
        걸리는 시간: 4.227972264501945광년
         */
        // 입력
        double distance = 40e12;
        // 처리
        // 빛의 속도: 상수
        double speed = 300000;
        // 시간 = 거리 / 속력 => 초 단위
        double time = distance / speed;
        double result = time / (365 * 24 * 60 * 60);
        // 출력
        System.out.println("걸리는 시간: " + result + "광년");

    }
}
