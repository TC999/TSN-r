package com.bytedance.sdk.openadsdk.core.u;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public String f34855c;
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private long f34856f;
    private long gd;

    /* renamed from: r  reason: collision with root package name */
    private long f34857r;
    public ArrayList<Integer> sr;
    public com.bytedance.sdk.openadsdk.ys.w.xv.w ux;

    /* renamed from: w  reason: collision with root package name */
    public int f34858w;
    public int xv = 1;

    public String c() {
        return this.f34855c;
    }

    public long ev() {
        return this.ev;
    }

    public long f() {
        return this.f34856f;
    }

    public long gd() {
        return this.gd;
    }

    public long r() {
        return this.f34857r;
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w sr() {
        return this.ux;
    }

    public ArrayList<Integer> ux() {
        return this.sr;
    }

    public int w() {
        return this.f34858w;
    }

    public int xv() {
        return this.xv;
    }

    public void c(String str) {
        this.f34855c = str;
    }

    public void sr(long j4) {
        this.gd = j4;
    }

    public void w(int i4) {
        this.xv = i4;
    }

    public void xv(long j4) {
        this.ev = j4;
    }

    public void c(int i4) {
        this.f34858w = i4;
    }

    public void w(long j4) {
        this.f34857r = j4;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.ux = wVar;
    }

    public void c(ArrayList<Integer> arrayList) {
        this.sr = arrayList;
    }

    public static void c(w wVar) {
        int w3;
        if (wVar == null || wVar.sr() == null || (w3 = wVar.w()) >= 0 || w3 == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.u.w.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", w.this.xv());
                jSONObject.put("err_code", w.this.w());
                jSONObject.put("server_res_str", w.this.c());
                if (w.this.ux() != null && w.this.ux().size() > 0) {
                    jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) w.this.ux()).toString());
                }
                com.bytedance.sdk.component.utils.a.w("AdLogInfoModel", "rd_client_custom_error = ", jSONObject);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("rd_client_custom_error").c(w.this.sr().q()).w(jSONObject.toString());
            }
        }, "rd_client_custom_error");
    }

    public void c(long j4) {
        this.f34856f = j4;
    }
}
