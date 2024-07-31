package com.amap.api.services.core;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SuggestionCity {

    /* renamed from: a */
    private String f7320a;

    /* renamed from: b */
    private String f7321b;

    /* renamed from: c */
    private String f7322c;

    /* renamed from: d */
    private int f7323d;

    protected SuggestionCity() {
    }

    public String getAdCode() {
        return this.f7322c;
    }

    public String getCityCode() {
        return this.f7321b;
    }

    public String getCityName() {
        return this.f7320a;
    }

    public int getSuggestionNum() {
        return this.f7323d;
    }

    public void setAdCode(String str) {
        this.f7322c = str;
    }

    public void setCityCode(String str) {
        this.f7321b = str;
    }

    public void setCityName(String str) {
        this.f7320a = str;
    }

    public void setSuggestionNum(int i) {
        this.f7323d = i;
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.f7320a = str;
        this.f7321b = str2;
        this.f7322c = str3;
        this.f7323d = i;
    }
}
