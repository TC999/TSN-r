package com.kwad.components.core.p295f;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.p385a.C9889d;
import com.kwad.sdk.core.p385a.InterfaceC9890e;

/* renamed from: com.kwad.components.core.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8646b implements InterfaceC9890e {
    @Override // com.kwad.sdk.core.p385a.InterfaceC9890e
    /* renamed from: al */
    public final String mo27426al(String str) {
        return C9889d.m27429al(str);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final Class getComponentsType() {
        return InterfaceC9890e.class;
    }

    @Override // com.kwad.sdk.core.p385a.InterfaceC9890e
    public final String getResponseData(String str) {
        return C9889d.getResponseData(str);
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.InterfaceC9848a
    public final int priority() {
        return IOfflineCompo.Priority.HIGHEST;
    }
}
