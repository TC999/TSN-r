package com.kwad.components.offline.p342b;

import com.kwad.components.core.p304n.p311b.p312a.C8730l;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11031aw;

/* renamed from: com.kwad.components.offline.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9400d implements IObiwanOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final String getLogDirPath() {
        return C11031aw.m23993cN(ServiceProvider.getContext()).getAbsolutePath();
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final String getLogObiwanData() {
        return C10251d.getLogObiwanData();
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final long getLogObiwanStorageQuota() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return C10251d.m26523a(C10250c.asg);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final boolean isLogObiwanEnableNow() {
        return C10251d.m26527a(C10250c.ase);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final boolean isLogObiwanRecordAll() {
        return C10251d.m26527a(C10250c.asf);
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new C8730l(IObiwanOfflineCompo.PACKAGE_NAME);
    }
}
