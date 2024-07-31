package com.mbridge.msdk.foundation.same.net.p484e;

import com.mbridge.msdk.foundation.same.net.p482c.C11336b;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse.java */
/* renamed from: com.mbridge.msdk.foundation.same.net.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11348b {

    /* renamed from: a */
    private final int f30748a;

    /* renamed from: b */
    private final List<C11336b> f30749b;

    /* renamed from: c */
    private final InputStream f30750c;

    public C11348b(int i, List<C11336b> list, InputStream inputStream) {
        this.f30748a = i;
        this.f30749b = list;
        this.f30750c = inputStream;
    }

    /* renamed from: a */
    public final int m22271a() {
        return this.f30748a;
    }

    /* renamed from: b */
    public final List<C11336b> m22270b() {
        return Collections.unmodifiableList(this.f30749b);
    }

    /* renamed from: c */
    public final InputStream m22269c() {
        return this.f30750c;
    }
}
