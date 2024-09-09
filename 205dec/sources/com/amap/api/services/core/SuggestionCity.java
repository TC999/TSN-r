package com.amap.api.services.core;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SuggestionCity {

    /* renamed from: a  reason: collision with root package name */
    private String f11014a;

    /* renamed from: b  reason: collision with root package name */
    private String f11015b;

    /* renamed from: c  reason: collision with root package name */
    private String f11016c;

    /* renamed from: d  reason: collision with root package name */
    private int f11017d;

    protected SuggestionCity() {
    }

    public String getAdCode() {
        return this.f11016c;
    }

    public String getCityCode() {
        return this.f11015b;
    }

    public String getCityName() {
        return this.f11014a;
    }

    public int getSuggestionNum() {
        return this.f11017d;
    }

    public void setAdCode(String str) {
        this.f11016c = str;
    }

    public void setCityCode(String str) {
        this.f11015b = str;
    }

    public void setCityName(String str) {
        this.f11014a = str;
    }

    public void setSuggestionNum(int i4) {
        this.f11017d = i4;
    }

    public SuggestionCity(String str, String str2, String str3, int i4) {
        this.f11014a = str;
        this.f11015b = str2;
        this.f11016c = str3;
        this.f11017d = i4;
    }
}
