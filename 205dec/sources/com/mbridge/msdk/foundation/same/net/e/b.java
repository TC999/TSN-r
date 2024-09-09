package com.mbridge.msdk.foundation.same.net.e;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f39542a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.mbridge.msdk.foundation.same.net.c.b> f39543b;

    /* renamed from: c  reason: collision with root package name */
    private final InputStream f39544c;

    public b(int i4, List<com.mbridge.msdk.foundation.same.net.c.b> list, InputStream inputStream) {
        this.f39542a = i4;
        this.f39543b = list;
        this.f39544c = inputStream;
    }

    public final int a() {
        return this.f39542a;
    }

    public final List<com.mbridge.msdk.foundation.same.net.c.b> b() {
        return Collections.unmodifiableList(this.f39543b);
    }

    public final InputStream c() {
        return this.f39544c;
    }
}
