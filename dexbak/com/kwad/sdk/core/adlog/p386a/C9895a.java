package com.kwad.sdk.core.adlog.p386a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.adlog.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9895a {
    public JSONObject apq;
    public C9912a apr;
    public long aps;
    public int apt;
    public String apu;
    public int retryCount;
    public String url;

    /* renamed from: Bh */
    public static C9895a m27413Bh() {
        return new C9895a();
    }

    /* renamed from: ad */
    public final C9895a m27411ad(long j) {
        this.aps = j;
        return this;
    }

    /* renamed from: c */
    public final C9895a m27410c(C9912a c9912a) {
        this.apr = c9912a;
        return this;
    }

    /* renamed from: cX */
    public final C9895a m27409cX(String str) {
        this.url = str;
        return this;
    }

    /* renamed from: cY */
    public final C9895a m27408cY(String str) {
        this.apu = str;
        return this;
    }

    /* renamed from: cr */
    public final C9895a m27407cr(int i) {
        this.apt = i;
        return this;
    }

    /* renamed from: i */
    public final C9895a m27406i(JSONObject jSONObject) {
        this.apq = jSONObject;
        return this;
    }

    @NonNull
    public final String toString() {
        return "AdLogCache {actionType=" + this.apr.aoM + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.apt + ", retryErrorMsg=" + this.apu + '}';
    }
}
