package xyz.adscope.amps.model.config.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SdkModel {
    private String version = "";
    private String ext = "";

    public String getExt() {
        return this.ext;
    }

    public String getVersion() {
        return this.version;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"version\":\"" + this.version + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
