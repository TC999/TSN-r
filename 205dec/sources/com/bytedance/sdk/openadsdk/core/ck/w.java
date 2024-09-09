package com.bytedance.sdk.openadsdk.core.ck;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f32102c;
    private int sr;
    private JSONObject ux;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, String> f32103w;
    private JSONObject xv;

    public JSONObject c() {
        return this.ux;
    }

    public JSONObject sr() {
        return this.xv;
    }

    public Map<String, String> ux() {
        return this.f32103w;
    }

    public int w() {
        return this.sr;
    }

    public byte[] xv() {
        return this.f32102c;
    }

    public void c(JSONObject jSONObject) {
        this.ux = jSONObject;
    }

    public void w(JSONObject jSONObject) {
        this.xv = jSONObject;
    }

    public void c(int i4) {
        this.sr = i4;
    }

    public void c(byte[] bArr) {
        this.f32102c = bArr;
    }

    public void c(Map<String, String> map) {
        this.f32103w = map;
    }
}
