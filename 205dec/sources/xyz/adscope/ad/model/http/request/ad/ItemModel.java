package xyz.adscope.ad.model.http.request.ad;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ItemModel {
    private int dlvy;
    private int exp;
    private Object ext;
    private Double flr;
    private int qty;
    private String sdk;
    private SpecModel spec;

    public int getDlvy() {
        return this.dlvy;
    }

    public int getExp() {
        return this.exp;
    }

    public Object getExt() {
        return this.ext;
    }

    public Double getFlr() {
        return this.flr;
    }

    public int getQty() {
        return this.qty;
    }

    public String getSdk() {
        return this.sdk;
    }

    public SpecModel getSpec() {
        return this.spec;
    }

    public void setDlvy(int i4) {
        this.dlvy = i4;
    }

    public void setExp(int i4) {
        this.exp = i4;
    }

    public void setExt(Object obj) {
        this.ext = obj;
    }

    public void setFlr(Double d4) {
        this.flr = d4;
    }

    public void setQty(int i4) {
        this.qty = i4;
    }

    public void setSdk(String str) {
        this.sdk = str;
    }

    public void setSpec(SpecModel specModel) {
        this.spec = specModel;
    }

    public String toString() {
        return "{\"flr\":" + this.flr + ", \"exp\":" + this.exp + ", \"dlvy\":" + this.dlvy + ", \"spec\":" + this.spec + ", \"qty\":" + this.qty + ", \"sdk\":\"" + this.sdk + "\", \"ext\":" + this.ext + '}';
    }
}
