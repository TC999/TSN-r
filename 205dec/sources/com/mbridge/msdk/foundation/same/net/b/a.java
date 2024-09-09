package com.mbridge.msdk.foundation.same.net.b;

import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: CommonStringResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a extends f<String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39494a = "a";

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<String> kVar) {
        if (kVar != null) {
            a(kVar.f39628a);
        }
    }

    public abstract void a(String str);

    public abstract void b(String str);

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f39494a;
        x.d(str, "errorCode = " + aVar.f39484a);
        b(com.mbridge.msdk.foundation.same.net.f.a.a(aVar));
    }
}
