package xyz.adscope.amps.model.config.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppModel {
    private String appId = "";
    private String name = "";
    private String bundleid = "";
    private String version = "";
    private String install = "";
    private String update = "";
    private String ext = "";

    public String getAppId() {
        return this.appId;
    }

    public String getBundleid() {
        return this.bundleid;
    }

    public String getExt() {
        return this.ext;
    }

    public String getInstall() {
        return this.install;
    }

    public String getName() {
        return this.name;
    }

    public String getUpdate() {
        return this.update;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBundleid(String str) {
        this.bundleid = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setInstall(String str) {
        this.install = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUpdate(String str) {
        this.update = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"appId\":" + this.appId + ", \"name\":\"" + this.name + "\", \"bundleid\":\"" + this.bundleid + "\", \"version\":\"" + this.version + "\", \"install\":\"" + this.install + "\", \"update\":\"" + this.update + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
