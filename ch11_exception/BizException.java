package source.ch11_exception;

public class BizException extends Exception{
    private int errCode;

    public BizException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}
