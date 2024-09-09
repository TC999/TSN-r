package xyz.adscope.amps.report.model.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppModel {
    private String bundleId;
    private String ext;
    private String install;
    private String name;
    private String update;
    private String version;

    public AppModel() {
        this.name = "";
        this.bundleId = "";
        this.version = "";
        this.install = "";
        this.update = "";
        this.ext = "";
    }

    public String getBundleId() {
        return this.bundleId;
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

    public void setBundleId(String str) {
        this.bundleId = str;
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
        return "{\"name\":\"" + this.name + "\", \"bundleId\":\"" + this.bundleId + "\", \"version\":\"" + this.version + "\", \"install\":\"" + this.install + "\", \"update\":\"" + this.update + "\", \"ext\":\"" + this.ext + "\"}";
    }

    public AppModel(AppModel appModel) {
        this.name = "";
        this.bundleId = "";
        this.version = "";
        this.install = "";
        this.update = "";
        this.ext = "";
        this.name = appModel.getName();
        this.bundleId = appModel.getBundleId();
        this.version = appModel.getVersion();
        this.install = appModel.getInstall();
        this.update = appModel.getUpdate();
        this.ext = appModel.getExt();
    }
}
