package com.kwad.components.core.p304n.p311b.p312a;

import android.content.Context;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.utils.C11013ag;

/* renamed from: com.kwad.components.core.n.b.a.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8716h implements INet {
    @Override // com.kwad.components.offline.api.core.api.INet
    public final int getActiveNetworkType(Context context) {
        return C11013ag.getActiveNetworkType(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final String getCurrHost(@INet.HostType String str, String str2) {
        return C10425a.m26107DU().m26103W(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final void handleSwitchHost(String str, @INet.HostType String str2, int i, Throwable th) {
        C10425a.m26107DU().m26094a(str, str2, new DomainException(i, th));
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isMobileConnected(Context context) {
        return C11013ag.isMobileConnected(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isNetworkConnected(Context context) {
        return C11013ag.isNetworkConnected(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isWifiConnected(Context context) {
        return C11013ag.isWifiConnected(context);
    }
}
