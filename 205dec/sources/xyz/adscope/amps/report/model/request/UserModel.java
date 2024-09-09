package xyz.adscope.amps.report.model.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UserModel {
    private String customData;
    private String ext;
    private String userId;

    public UserModel() {
        this.userId = "";
        this.customData = "";
        this.ext = "";
    }

    public String getCustomData() {
        return this.customData;
    }

    public String getExt() {
        return this.ext;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "{\"userId\":\"" + this.userId + "\", \"customData\":\"" + this.customData + "\", \"ext\":\"" + this.ext + "\"}";
    }

    public UserModel(UserModel userModel) {
        this.userId = "";
        this.customData = "";
        this.ext = "";
        this.userId = userModel.getUserId();
        this.customData = userModel.getCustomData();
        this.ext = userModel.getExt();
    }
}
