package xyz.adscope.amps.model.config.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SdkArrayModel {
    private String sdkId;
    private String sdkName;
    private String version;

    public String getSdkId() {
        return this.sdkId;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public String getVersion() {
        return this.version;
    }

    public void setSdkId(String str) {
        this.sdkId = str;
    }

    public void setSdkName(String str) {
        this.sdkName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"sdkId\":\"" + this.sdkId + "\", \"sdkName\":\"" + this.sdkName + "\", \"version\":\"" + this.version + "\"}";
    }
}
