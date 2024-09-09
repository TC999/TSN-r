package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int adStyle;
    public long azP;
    public int count;
    public int taskType;

    public f() {
    }

    public final void ar(long j4) {
        this.azP = j4;
    }

    public f(int i4, int i5, int i6, long j4) {
        this.adStyle = i4;
        this.taskType = i5;
        this.count = 1;
        this.azP = j4;
    }
}
