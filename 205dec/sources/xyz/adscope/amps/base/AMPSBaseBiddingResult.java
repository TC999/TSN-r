package xyz.adscope.amps.base;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSBaseBiddingResult {
    private int ecpm;
    private String errorCode;
    private String errorMsg;
    private boolean isSuccess;

    public AMPSBaseBiddingResult(boolean z3, int i4, String str, String str2) {
        this.isSuccess = z3;
        this.ecpm = i4;
        this.errorCode = str;
        this.errorMsg = str2;
    }

    public static AMPSBaseBiddingResult biddingFail(String str, String str2) {
        return new AMPSBaseBiddingResult(false, 0, str, str2);
    }

    public static AMPSBaseBiddingResult biddingSuccess(int i4) {
        return new AMPSBaseBiddingResult(true, i4, "", "");
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setEcpm(int i4) {
        this.ecpm = i4;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setSuccess(boolean z3) {
        this.isSuccess = z3;
    }

    public String toString() {
        return "AMPSBaseBiddingResult{isSuccess=" + this.isSuccess + ", ecpm=" + this.ecpm + ", errorCode='" + this.errorCode + "', errorMsg='" + this.errorMsg + "'}";
    }
}
