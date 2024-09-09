package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f34846a = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private String f34847c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f34848f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private JSONArray f34849k;

    /* renamed from: p  reason: collision with root package name */
    private float f34850p;

    /* renamed from: r  reason: collision with root package name */
    private JSONArray f34851r;
    private String sr;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34852w;
    private String xv;

    public String a() {
        return this.gd;
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f34846a.put(str, str2);
    }

    public String ev() {
        return this.sr;
    }

    public String f() {
        return this.f34852w;
    }

    public String gd() {
        return this.f34848f;
    }

    public String k() {
        return this.ev;
    }

    public JSONArray p() {
        return this.f34851r;
    }

    public String r() {
        return this.xv;
    }

    public JSONArray sr() {
        return this.f34849k;
    }

    public String ux() {
        return this.f34847c;
    }

    public String w() {
        return this.ux;
    }

    public float xv() {
        return this.f34850p;
    }

    public void ev(String str) {
        this.gd = str;
    }

    public void f(String str) {
        this.f34848f = str;
    }

    public void r(String str) {
        this.ev = str;
    }

    public void sr(String str) {
        this.xv = str;
    }

    public void ux(String str) {
        this.sr = str;
    }

    public void w(String str) {
        this.f34847c = str;
    }

    public void xv(String str) {
        this.f34852w = str;
    }

    public HashMap<String, String> c() {
        return this.f34846a;
    }

    public void w(JSONArray jSONArray) {
        this.f34851r = jSONArray;
    }

    public void c(String str) {
        this.ux = str;
    }

    public void c(float f4) {
        this.f34850p = f4;
    }

    public void c(JSONArray jSONArray) {
        this.f34849k = jSONArray;
    }
}
