package xyz.adscope.ad.model.http.response.config;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class PkgModel {
    public String link;
    public String linkId;

    public String getLink() {
        return this.link;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public String toString() {
        return "{\"linkId\":\"" + this.linkId + "\", \"link\":\"" + this.link + "\"}";
    }
}
