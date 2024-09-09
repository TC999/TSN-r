package com.kwad.components.ad.reward.c;

import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int rm = 1;
    public static int rn = 3;
    public int ro;
    public int rp;

    public b() {
        this.ro = STATUS_NONE;
    }

    public final void M(int i4) {
        this.rp = i4;
    }

    public final int gO() {
        return this.rp;
    }

    public final int getType() {
        return this.ro;
    }

    public b(int i4) {
        this.ro = 1;
    }
}
