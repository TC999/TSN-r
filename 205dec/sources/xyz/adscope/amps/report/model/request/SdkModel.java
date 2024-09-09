package xyz.adscope.amps.report.model.request;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SdkModel {
    private String bdSdkVersion;
    private String csjSdkVersion;
    private String ext;
    private String gdtSdkVersion;
    private String gmSdkVersion;
    private String ksSdkVersion;
    private String sdkVersion;
    private String yj4SdkVersion;
    private String yj5SdkVersion;

    public SdkModel() {
        this.sdkVersion = "";
        this.ksSdkVersion = "";
        this.csjSdkVersion = "";
        this.gmSdkVersion = "";
        this.gdtSdkVersion = "";
        this.yj4SdkVersion = "";
        this.yj5SdkVersion = "";
        this.bdSdkVersion = "";
        this.ext = "";
    }

    public String getBdSdkVersion() {
        return this.bdSdkVersion;
    }

    public String getCsjSdkVersion() {
        return this.csjSdkVersion;
    }

    public String getExt() {
        return this.ext;
    }

    public String getGdtSdkVersion() {
        return this.gdtSdkVersion;
    }

    public String getGmSdkVersion() {
        return this.gmSdkVersion;
    }

    public String getKsSdkVersion() {
        return this.ksSdkVersion;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public String getYj4SdkVersion() {
        return this.yj4SdkVersion;
    }

    public String getYj5SdkVersion() {
        return this.yj5SdkVersion;
    }

    public void setBdSdkVersion(String str) {
        this.bdSdkVersion = str;
    }

    public void setCsjSdkVersion(String str) {
        this.csjSdkVersion = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setGdtSdkVersion(String str) {
        this.gdtSdkVersion = str;
    }

    public void setGmSdkVersion(String str) {
        this.gmSdkVersion = str;
    }

    public void setKsSdkVersion(String str) {
        this.ksSdkVersion = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public void setYj4SdkVersion(String str) {
        this.yj4SdkVersion = str;
    }

    public void setYj5SdkVersion(String str) {
        this.yj5SdkVersion = str;
    }

    public String toString() {
        return "{\"sdkVersion\":\"" + this.sdkVersion + "\", \"ksSdkVersion\":\"" + this.ksSdkVersion + "\", \"csjSdkVersion\":\"" + this.csjSdkVersion + "\", \"gmSdkVersion\":\"" + this.gmSdkVersion + "\", \"gdtSdkVersion\":\"" + this.gdtSdkVersion + "\", \"yj4SdkVersion\":\"" + this.yj4SdkVersion + "\", \"yj5SdkVersion\":\"" + this.yj5SdkVersion + "\", \"bdSdkVersion\":\"" + this.bdSdkVersion + "\", \"ext\":\"" + this.ext + "\"}";
    }

    public SdkModel(SdkModel sdkModel) {
        this.sdkVersion = "";
        this.ksSdkVersion = "";
        this.csjSdkVersion = "";
        this.gmSdkVersion = "";
        this.gdtSdkVersion = "";
        this.yj4SdkVersion = "";
        this.yj5SdkVersion = "";
        this.bdSdkVersion = "";
        this.ext = "";
        this.sdkVersion = sdkModel.getSdkVersion();
        this.ksSdkVersion = sdkModel.getKsSdkVersion();
        this.csjSdkVersion = sdkModel.getCsjSdkVersion();
        this.gmSdkVersion = sdkModel.getGmSdkVersion();
        this.gdtSdkVersion = sdkModel.getGdtSdkVersion();
        this.yj4SdkVersion = sdkModel.getYj4SdkVersion();
        this.yj5SdkVersion = sdkModel.getYj5SdkVersion();
        this.bdSdkVersion = sdkModel.getBdSdkVersion();
        this.ext = sdkModel.getExt();
    }
}
