package xyz.adscope.ad.model.http.request.crash;

import xyz.adscope.ad.model.BaseModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CrashRequestModel extends BaseModel {
    private String affiliated;
    private String exception;
    private String log_time;

    public String getAffiliated() {
        return this.affiliated;
    }

    public String getException() {
        return this.exception;
    }

    public String getLog_time() {
        return this.log_time;
    }

    public void setAffiliated(String str) {
        this.affiliated = str;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void setLog_time(String str) {
        this.log_time = str;
    }
}
