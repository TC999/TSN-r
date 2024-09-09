package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String NR;
    public long NS;
    public long NT;
    public long NU;
    public String NV;

    public final b A(long j4) {
        this.NS = j4;
        return this;
    }

    public final b B(long j4) {
        this.NT = j4;
        return this;
    }

    public final b am(String str) {
        this.NR = str;
        return this;
    }

    public final b an(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b ao(String str) {
        this.NV = str;
        return this;
    }

    public final b aw(int i4) {
        this.NU = i4;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ax */
    public final b setErrorCode(int i4) {
        this.errorCode = i4;
        return this;
    }
}
