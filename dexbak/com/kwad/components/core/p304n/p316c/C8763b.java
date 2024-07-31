package com.kwad.components.core.p304n.p316c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;

@KsJson
/* renamed from: com.kwad.components.core.n.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8763b extends AbstractC9822a {

    /* renamed from: NR */
    public String f28464NR;

    /* renamed from: NS */
    public long f28465NS;

    /* renamed from: NT */
    public long f28466NT;

    /* renamed from: NU */
    public long f28467NU;

    /* renamed from: NV */
    public String f28468NV;

    /* renamed from: A */
    public final C8763b m29937A(long j) {
        this.f28465NS = j;
        return this;
    }

    /* renamed from: B */
    public final C8763b m29936B(long j) {
        this.f28466NT = j;
        return this;
    }

    /* renamed from: am */
    public final C8763b m29935am(String str) {
        this.f28464NR = str;
        return this;
    }

    /* renamed from: an */
    public final C8763b m29934an(String str) {
        this.errorMsg = str;
        return this;
    }

    /* renamed from: ao */
    public final C8763b m29933ao(String str) {
        this.f28468NV = str;
        return this;
    }

    /* renamed from: aw */
    public final C8763b m29932aw(int i) {
        this.f28467NU = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.p374c.AbstractC9822a
    /* renamed from: ax */
    public final C8763b setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }
}
