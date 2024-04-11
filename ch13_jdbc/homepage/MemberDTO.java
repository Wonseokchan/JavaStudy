package source.ch13_jdbc.homepage;

//DTD = Data Transfer Obejct : 데이터 전환
public class MemberDTO {
    private String memId;
    private String memPw;
    private String memName;
    private int score;

    public MemberDTO() {
    }

    public MemberDTO(String memId, String memPw, String memName, int score) {
        this.memId = memId;
        this.memPw = memPw;
        this.memName = memName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memId='" + memId + '\'' +
                ", memPw='" + memPw + '\'' +
                ", memName='" + memName + '\'' +
                ", score=" + score +
                '}';
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
