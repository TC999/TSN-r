package xyz.adscope.amps.common;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSError {
    private String code;
    private String message;

    public AMPSError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "{\"code\":\"" + this.code + "\", \"message\":\"" + this.message + "\"}";
    }
}
