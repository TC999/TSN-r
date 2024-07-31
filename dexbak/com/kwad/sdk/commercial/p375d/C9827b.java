package com.kwad.sdk.commercial.p375d;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;

@KsJson
/* renamed from: com.kwad.sdk.commercial.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9827b extends AbstractC9822a {
    public int adNum;
    public String adSource;
    public String aow;
    public boolean aox;
    public boolean aoy;
    public String aoz;

    /* renamed from: AM */
    public static C9827b m27596AM() {
        return new C9827b();
    }

    /* renamed from: bk */
    public final C9827b m27595bk(boolean z) {
        this.aox = z;
        return this;
    }

    /* renamed from: cA */
    public final C9827b m27594cA(String str) {
        this.adSource = str;
        return this;
    }

    /* renamed from: ci */
    public final C9827b m27593ci(int i) {
        this.adNum = i;
        return this;
    }

    /* renamed from: cy */
    public final C9827b m27592cy(String str) {
        this.aow = str;
        return this;
    }

    /* renamed from: cz */
    public final C9827b m27591cz(String str) {
        this.aoz = str;
        return this;
    }
}
