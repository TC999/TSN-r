package xyz.adscope.ad.model.http.request.ad;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AppInstallModel {
    private String install;
    private String linkId;
    private String updateTime;

    public String getInstall() {
        return this.install;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setInstall(String str) {
        this.install = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "{\"install\":\"" + this.install + "\", \"linkId\":\"" + this.linkId + "\", \"updateTime\":\"" + this.updateTime + "\"}";
    }
}
