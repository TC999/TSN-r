package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;

@KsJson
/* renamed from: com.kwad.sdk.core.request.model.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10480f extends C10482a implements InterfaceC9914b {
    public int adStyle;
    public long azP;
    public int count;
    public int taskType;

    public C10480f() {
    }

    /* renamed from: ar */
    public final void m25983ar(long j) {
        this.azP = j;
    }

    public C10480f(int i, int i2, int i3, long j) {
        this.adStyle = i;
        this.taskType = i2;
        this.count = 1;
        this.azP = j;
    }
}
