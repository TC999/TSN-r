package com.mbridge.msdk.rover;

import com.mbridge.msdk.foundation.same.net.k;
import org.json.JSONObject;

/* compiled from: RoverReportResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class f extends com.mbridge.msdk.foundation.same.net.f<JSONObject> {
    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<JSONObject> kVar) {
        f();
    }

    public abstract void a(String str);

    public abstract void f();

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        a(aVar.f39484a + "");
    }
}
