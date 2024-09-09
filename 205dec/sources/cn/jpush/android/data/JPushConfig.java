package cn.jpush.android.data;

import java.io.Serializable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JPushConfig implements Serializable {
    private static final long serialVersionUID = -3135447319267244288L;

    /* renamed from: a  reason: collision with root package name */
    private String f4151a;

    /* renamed from: b  reason: collision with root package name */
    private String f4152b;

    /* renamed from: c  reason: collision with root package name */
    private String f4153c;

    /* renamed from: d  reason: collision with root package name */
    private String f4154d;

    /* renamed from: e  reason: collision with root package name */
    private String f4155e;

    /* renamed from: f  reason: collision with root package name */
    private String f4156f;

    /* renamed from: g  reason: collision with root package name */
    private String f4157g;

    /* renamed from: h  reason: collision with root package name */
    private String f4158h;

    public String getMzAppId() {
        return this.f4155e;
    }

    public String getMzAppKey() {
        return this.f4156f;
    }

    public String getOppoAppId() {
        return this.f4153c;
    }

    public String getOppoAppKey() {
        return this.f4152b;
    }

    public String getOppoAppSecret() {
        return this.f4154d;
    }

    public String getXmAppId() {
        return this.f4157g;
    }

    public String getXmAppKey() {
        return this.f4158h;
    }

    public String getjAppKey() {
        return this.f4151a;
    }

    public void setMzAppId(String str) {
        this.f4155e = str;
    }

    public void setMzAppKey(String str) {
        this.f4156f = str;
    }

    public void setOppoAppId(String str) {
        this.f4153c = str;
    }

    public void setOppoAppKey(String str) {
        this.f4152b = str;
    }

    public void setOppoAppSecret(String str) {
        this.f4154d = str;
    }

    public void setXmAppId(String str) {
        this.f4157g = str;
    }

    public void setXmAppKey(String str) {
        this.f4158h = str;
    }

    public void setjAppKey(String str) {
        this.f4151a = str;
    }
}
