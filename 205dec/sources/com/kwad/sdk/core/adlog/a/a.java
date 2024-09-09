package com.kwad.sdk.core.adlog.a;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public JSONObject apq;
    public com.kwad.sdk.core.adlog.c.a apr;
    public long aps;
    public int apt;
    public String apu;
    public int retryCount;
    public String url;

    public static a Bh() {
        return new a();
    }

    public final a ad(long j4) {
        this.aps = j4;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.apr = aVar;
        return this;
    }

    public final a cX(String str) {
        this.url = str;
        return this;
    }

    public final a cY(String str) {
        this.apu = str;
        return this;
    }

    public final a cr(int i4) {
        this.apt = i4;
        return this;
    }

    public final a i(JSONObject jSONObject) {
        this.apq = jSONObject;
        return this;
    }

    @NonNull
    public final String toString() {
        return "AdLogCache {actionType=" + this.apr.aoM + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.apt + ", retryErrorMsg=" + this.apu + '}';
    }
}
