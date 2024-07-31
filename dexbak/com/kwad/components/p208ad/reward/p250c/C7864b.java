package com.kwad.components.p208ad.reward.p250c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;

@KsJson
/* renamed from: com.kwad.components.ad.reward.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7864b extends C10482a {
    public static int STATUS_NONE = 2;

    /* renamed from: rm */
    public static int f26482rm = 1;

    /* renamed from: rn */
    public static int f26483rn = 3;

    /* renamed from: ro */
    public int f26484ro;

    /* renamed from: rp */
    public int f26485rp;

    public C7864b() {
        this.f26484ro = STATUS_NONE;
    }

    /* renamed from: M */
    public final void m32130M(int i) {
        this.f26485rp = i;
    }

    /* renamed from: gO */
    public final int m32129gO() {
        return this.f26485rp;
    }

    public final int getType() {
        return this.f26484ro;
    }

    public C7864b(int i) {
        this.f26484ro = 1;
    }
}
