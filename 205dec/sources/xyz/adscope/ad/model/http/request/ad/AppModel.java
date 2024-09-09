package xyz.adscope.ad.model.http.request.ad;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppModel {
    private String appId;
    private String bundle;
    private Object ext;
    private long install;
    private String name;
    private String storeid;
    private long update;
    private String ver;

    public String getAppId() {
        return this.appId;
    }

    public String getBundle() {
        return this.bundle;
    }

    public Object getExt() {
        return this.ext;
    }

    public long getInstall() {
        return this.install;
    }

    public String getName() {
        return this.name;
    }

    public String getStoreId() {
        return this.storeid;
    }

    public long getUpdate() {
        return this.update;
    }

    public String getVer() {
        return this.ver;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public void setExt(Object obj) {
        this.ext = obj;
    }

    public void setInstall(long j4) {
        this.install = j4;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStoreId(String str) {
        this.storeid = str;
    }

    public void setUpdate(long j4) {
        this.update = j4;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public String toString() {
        return "{\"bundle\":\"" + this.bundle + "\", \"ver\":\"" + this.ver + "\", \"name\":\"" + this.name + "\", \"install\":" + this.install + ", \"update\":" + this.update + ", \"storeid\":\"" + this.storeid + "\", \"appId\":\"" + this.appId + "\", \"ext\":" + this.ext + '}';
    }
}
