package com.bytedance.sdk.openadsdk.core.u;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wv {

    /* renamed from: a  reason: collision with root package name */
    public long f34862a;

    /* renamed from: k  reason: collision with root package name */
    public long f34865k;

    /* renamed from: p  reason: collision with root package name */
    public long f34866p;
    public int sr;
    public boolean ux;
    public String xv;

    /* renamed from: c  reason: collision with root package name */
    public final String f34863c = com.bytedance.sdk.openadsdk.core.eq.wv.r();

    /* renamed from: w  reason: collision with root package name */
    public int f34869w = -1;

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f34864f = null;

    /* renamed from: r  reason: collision with root package name */
    public int f34867r = 1;
    public long ev = System.currentTimeMillis();
    public long gd = System.currentTimeMillis();
    public JSONObject bk = null;

    /* renamed from: t  reason: collision with root package name */
    public int f34868t = -1;
    public com.bytedance.sdk.openadsdk.core.n ys = com.bytedance.sdk.openadsdk.core.n.c("");

    public wv c() {
        wv wvVar = new wv();
        wvVar.f34869w = this.f34869w;
        wvVar.f34864f = this.f34864f;
        wvVar.f34867r = this.f34867r;
        wvVar.ev = this.ev;
        wvVar.f34866p = this.f34866p;
        wvVar.f34865k = this.f34865k;
        wvVar.f34862a = this.f34862a;
        wvVar.f34868t = this.f34868t;
        return wvVar;
    }

    public void c(String str, boolean z3) {
        com.bytedance.sdk.openadsdk.core.n nVar;
        if (!z3 || (nVar = this.ys) == null || str == null) {
            return;
        }
        nVar.w("cst_" + str);
    }

    public void c(String str, long j4, boolean z3) {
        com.bytedance.sdk.openadsdk.core.n nVar;
        if (!z3 || (nVar = this.ys) == null || str == null) {
            return;
        }
        nVar.c("cst_" + str, j4);
    }
}
