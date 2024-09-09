package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JPushMessage implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f4037a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4038b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f4039c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f4040d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f4041e;

    /* renamed from: f  reason: collision with root package name */
    private String f4042f;

    /* renamed from: g  reason: collision with root package name */
    private int f4043g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4044h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4045i;

    /* renamed from: j  reason: collision with root package name */
    private int f4046j;

    /* renamed from: k  reason: collision with root package name */
    private String f4047k;

    public int getAction() {
        return this.f4038b;
    }

    public String getAlias() {
        return this.f4039c;
    }

    public String getCheckTag() {
        return this.f4042f;
    }

    public int getErrorCode() {
        return this.f4043g;
    }

    public String getMobileNumber() {
        return this.f4047k;
    }

    public Map<String, Object> getPros() {
        return this.f4041e;
    }

    public int getProtoType() {
        return this.f4037a;
    }

    public int getSequence() {
        return this.f4046j;
    }

    public boolean getTagCheckStateResult() {
        return this.f4044h;
    }

    public Set<String> getTags() {
        return this.f4040d;
    }

    public boolean isTagCheckOperator() {
        return this.f4045i;
    }

    public void setAction(int i4) {
        this.f4038b = i4;
    }

    public void setAlias(String str) {
        this.f4039c = str;
    }

    public void setCheckTag(String str) {
        this.f4042f = str;
    }

    public void setErrorCode(int i4) {
        this.f4043g = i4;
    }

    public void setMobileNumber(String str) {
        this.f4047k = str;
    }

    public void setPros(Map<String, Object> map) {
        this.f4041e = map;
    }

    public void setProtoType(int i4) {
        this.f4037a = i4;
    }

    public void setSequence(int i4) {
        this.f4046j = i4;
    }

    public void setTagCheckOperator(boolean z3) {
        this.f4045i = z3;
    }

    public void setTagCheckStateResult(boolean z3) {
        this.f4044h = z3;
    }

    public void setTags(Set<String> set) {
        this.f4040d = set;
    }

    public String toString() {
        return "JPushMessage{alias='" + this.f4039c + "', tags=" + this.f4040d + ", pros=" + this.f4041e + ", checkTag='" + this.f4042f + "', errorCode=" + this.f4043g + ", tagCheckStateResult=" + this.f4044h + ", isTagCheckOperator=" + this.f4045i + ", sequence=" + this.f4046j + ", mobileNumber=" + this.f4047k + '}';
    }
}
