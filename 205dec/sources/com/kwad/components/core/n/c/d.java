package com.kwad.components.core.n.c;

import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d extends com.kwad.sdk.commercial.c.a {
    public String NR;
    public long NS;
    public long NT;
    public String NV;
    public long NW;

    public final d C(long j4) {
        this.NS = j4;
        return this;
    }

    public final d D(long j4) {
        this.NT = j4;
        return this;
    }

    public final d E(long j4) {
        this.NW = j4;
        return this;
    }

    public final d ap(String str) {
        this.NR = str;
        return this;
    }

    public final d aq(String str) {
        this.errorMsg = str;
        return this;
    }

    public final d ar(String str) {
        this.NV = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: ay */
    public final d setErrorCode(int i4) {
        this.errorCode = i4;
        return this;
    }
}
