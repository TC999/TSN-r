package xyz.adscope.ad.model.http.request.ad;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SpecModel {
    private SpecExtModel ext;
    private int reward;
    private String sdk;
    private String sdkver;
    private String tagid;

    public SpecExtModel getExt() {
        return this.ext;
    }

    public int getReward() {
        return this.reward;
    }

    public String getSdk() {
        return this.sdk;
    }

    public String getSdkver() {
        return this.sdkver;
    }

    public String getTagid() {
        return this.tagid;
    }

    public void setExt(SpecExtModel specExtModel) {
        this.ext = specExtModel;
    }

    public void setReward(int i4) {
        this.reward = i4;
    }

    public void setSdk(String str) {
        this.sdk = str;
    }

    public void setSdkver(String str) {
        this.sdkver = str;
    }

    public void setTagid(String str) {
        this.tagid = str;
    }

    public String toString() {
        return "{\"tagid\":\"" + this.tagid + "\", \"sdk\":\"" + this.sdk + "\", \"sdkver\":\"" + this.sdkver + "\", \"ext\":" + this.ext + ", \"reward\":" + this.reward + '}';
    }
}
