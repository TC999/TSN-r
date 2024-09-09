package xyz.adscope.ad.model.http.request.ad;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RegsModel {
    private int ccpa;
    private int coppa;
    private int gdpr;

    public int getCcpa() {
        return this.ccpa;
    }

    public int getCoppa() {
        return this.coppa;
    }

    public int getGdpr() {
        return this.gdpr;
    }

    public void setCcpa(int i4) {
        this.ccpa = i4;
    }

    public void setCoppa(int i4) {
        this.coppa = i4;
    }

    public void setGdpr(int i4) {
        this.gdpr = i4;
    }

    public String toString() {
        return "{\"coppa\":" + this.coppa + ", \"gdpr\":" + this.gdpr + ", \"ccpa\":" + this.ccpa + '}';
    }
}
