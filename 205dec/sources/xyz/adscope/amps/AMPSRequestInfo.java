package xyz.adscope.amps;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSRequestInfo {
    protected String appId;
    protected String className;
    protected String spaceId;

    public AMPSRequestInfo(String str, String str2) {
        this.appId = str;
        this.spaceId = str2;
    }

    public abstract void formatAdResource(String str);

    public String getAppId() {
        return this.appId;
    }

    public String getClassName() {
        return this.className;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }
}
