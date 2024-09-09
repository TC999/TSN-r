package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v extends e implements u {

    /* renamed from: g1  reason: collision with root package name */
    String f43735g1;

    /* renamed from: h1  reason: collision with root package name */
    String f43736h1;

    /* renamed from: i1  reason: collision with root package name */
    int f43737i1;

    public v(String str, String str2, String str3, String str4, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
        super(str, str2, str3, str4, com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN, jSONObject, lVar);
        w.a(this, jSONObject);
        int a4 = com.qq.e.comm.plugin.intersitial2.j.c.a(this);
        this.f43737i1 = a4;
        try {
            jSONObject.putOpt("card_show_time", Integer.valueOf(a4));
        } catch (JSONException unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final String a() {
        return this.f43736h1;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public boolean c() {
        return o() == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN && TextUtils.isEmpty(L0());
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final e d() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final String e() {
        return this.f43735g1;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final boolean f() {
        return com.qq.e.comm.plugin.b.b.a(b0());
    }
}
