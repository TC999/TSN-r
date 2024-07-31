package com.kwad.sdk.core.p399f.p400a;

import android.content.Context;
import com.kwad.sdk.utils.C11124s;

/* renamed from: com.kwad.sdk.core.f.a.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10360i {
    private Context mContext;

    public C10360i(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        try {
            return (String) C11124s.callMethod(C11124s.m23687h("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
        } catch (Exception unused) {
            return "";
        }
    }
}
