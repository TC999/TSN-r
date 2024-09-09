package com.bytedance.msdk.core.k;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private String f28049c;
    private JSONObject ev;

    /* renamed from: f  reason: collision with root package name */
    private List<f> f28050f;
    private double gd;

    /* renamed from: k  reason: collision with root package name */
    private double f28051k;

    /* renamed from: p  reason: collision with root package name */
    private int f28052p;

    /* renamed from: r  reason: collision with root package name */
    private List<ev> f28053r;
    private ev sr;
    private c ux;

    /* renamed from: w  reason: collision with root package name */
    private String f28054w;
    private String xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private String f28055c;

        /* renamed from: w  reason: collision with root package name */
        private List<p> f28056w = new ArrayList();

        public void c(String str) {
            this.f28055c = str;
        }

        public void c(List<p> list) {
            this.f28056w = list;
        }
    }

    public double c() {
        return this.gd;
    }

    public boolean ev() {
        c cVar = this.ux;
        return (cVar == null || TextUtils.isEmpty(cVar.f28055c)) ? false : true;
    }

    public String f() {
        return this.xv;
    }

    public List<p> gd() {
        c cVar = this.ux;
        if (cVar == null) {
            return null;
        }
        return cVar.f28056w;
    }

    public JSONObject r() {
        return this.ev;
    }

    public List<ev> sr() {
        return this.f28053r;
    }

    public List<f> ux() {
        return this.f28050f;
    }

    public int w() {
        return this.f28052p;
    }

    public double xv() {
        return this.f28051k;
    }

    public void c(String str) {
        try {
            this.gd = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public void sr(String str) {
        this.f28054w = str;
    }

    public void ux(String str) {
        this.xv = str;
    }

    public void w(String str) {
        try {
            this.f28051k = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public void xv(String str) {
        this.f28049c = str;
    }

    public void c(int i4) {
        this.f28052p = i4;
    }

    public void w(List<f> list) {
        this.f28050f = list;
    }

    public void c(List<ev> list) {
        this.f28053r = list;
    }

    public void c(ev evVar) {
        this.sr = evVar;
    }

    public void c(c cVar) {
        this.ux = cVar;
    }

    public void c(JSONObject jSONObject) {
        this.ev = jSONObject;
    }
}
