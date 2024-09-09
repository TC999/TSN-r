package com.kwad.sdk.commercial.d;

import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public String adSource;
    public String aow;
    public boolean aox;
    public boolean aoy;
    public String aoz;

    public static b AM() {
        return new b();
    }

    public final b bk(boolean z3) {
        this.aox = z3;
        return this;
    }

    public final b cA(String str) {
        this.adSource = str;
        return this;
    }

    public final b ci(int i4) {
        this.adNum = i4;
        return this;
    }

    public final b cy(String str) {
        this.aow = str;
        return this;
    }

    public final b cz(String str) {
        this.aoz = str;
        return this;
    }
}
