package com.kwad.components.core.p304n.p316c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;

@KsJson
/* renamed from: com.kwad.components.core.n.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8765d extends AbstractC9822a {

    /* renamed from: NR */
    public String f28469NR;

    /* renamed from: NS */
    public long f28470NS;

    /* renamed from: NT */
    public long f28471NT;

    /* renamed from: NV */
    public String f28472NV;

    /* renamed from: NW */
    public long f28473NW;

    /* renamed from: C */
    public final C8765d m29926C(long j) {
        this.f28470NS = j;
        return this;
    }

    /* renamed from: D */
    public final C8765d m29925D(long j) {
        this.f28471NT = j;
        return this;
    }

    /* renamed from: E */
    public final C8765d m29924E(long j) {
        this.f28473NW = j;
        return this;
    }

    /* renamed from: ap */
    public final C8765d m29923ap(String str) {
        this.f28469NR = str;
        return this;
    }

    /* renamed from: aq */
    public final C8765d m29922aq(String str) {
        this.errorMsg = str;
        return this;
    }

    /* renamed from: ar */
    public final C8765d m29921ar(String str) {
        this.f28472NV = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: ay */
    public final C8765d setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }
}
