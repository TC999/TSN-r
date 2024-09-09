package com.bytedance.sdk.component.r.w.sr.c;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.r.c.w {

    /* renamed from: a  reason: collision with root package name */
    private int f30096a;

    /* renamed from: c  reason: collision with root package name */
    protected JSONObject f30097c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private long f30098f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private String f30099k;

    /* renamed from: p  reason: collision with root package name */
    private byte f30100p;

    /* renamed from: r  reason: collision with root package name */
    private long f30101r;
    private byte sr;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private w f30102w;
    private byte xv;

    public c(String str, JSONObject jSONObject) {
        this.gd = str;
        this.f30097c = jSONObject;
    }

    public static com.bytedance.sdk.component.r.c.w sr(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("priority");
            c cVar = new c();
            cVar.c((byte) optInt);
            cVar.w((byte) optInt2);
            cVar.c(jSONObject.optJSONObject("event"));
            cVar.c(jSONObject.optString("localId"));
            cVar.w(jSONObject.optString("genTime"));
            cVar.c(jSONObject.optInt("channel"));
            return cVar;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public w c() {
        return this.f30102w;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public long ev() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public String f() {
        if (TextUtils.isEmpty(this.gd)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.gd);
            jSONObject.put("event", r());
            jSONObject.put("genTime", k());
            jSONObject.put("priority", (int) this.sr);
            jSONObject.put("type", (int) this.xv);
            jSONObject.put("channel", this.f30096a);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public long gd() {
        return this.f30098f;
    }

    public String k() {
        return this.ev;
    }

    public String p() {
        return this.f30099k;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public synchronized JSONObject r() {
        w wVar;
        if (this.f30097c == null && (wVar = this.f30102w) != null) {
            this.f30097c = wVar.c(p());
        }
        return this.f30097c;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public byte ux() {
        return this.sr;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public byte w() {
        return this.f30100p;
    }

    public void xv(String str) {
        this.f30099k = str;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void c(JSONObject jSONObject) {
        this.f30097c = jSONObject;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void w(String str) {
        this.ev = str;
    }

    public void xv(byte b4) {
        this.f30100p = b4;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void c(byte b4) {
        this.xv = b4;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void w(long j4) {
        this.f30098f = j4;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public String xv() {
        return this.gd;
    }

    public c(String str, w wVar) {
        this.gd = str;
        this.f30102w = wVar;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void c(String str) {
        this.gd = str;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void w(byte b4) {
        this.sr = b4;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void xv(long j4) {
        this.f30101r = j4;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void c(long j4) {
        this.ux = j4;
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public void c(int i4) {
        this.f30096a = i4;
    }

    private c() {
    }

    @Override // com.bytedance.sdk.component.r.c.w
    public byte sr() {
        return this.xv;
    }
}
