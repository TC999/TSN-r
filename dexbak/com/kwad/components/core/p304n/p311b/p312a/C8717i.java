package com.kwad.components.core.p304n.p311b.p312a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11064bn;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.n.b.a.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8717i implements INetworkManager {

    /* renamed from: MM */
    private List<INetworkChangeListener> f28386MM = new CopyOnWriteArrayList();

    /* renamed from: MN */
    private NetworkMonitor.InterfaceC9881a f28387MN;

    /* renamed from: ad */
    private void m29983ad(final Context context) {
        if (this.f28387MN != null) {
            return;
        }
        this.f28387MN = new NetworkMonitor.InterfaceC9881a() { // from class: com.kwad.components.core.n.b.a.i.1
            @Override // com.kwad.sdk.core.NetworkMonitor.InterfaceC9881a
            /* renamed from: a */
            public final void mo24766a(NetworkMonitor.NetworkState networkState) {
                C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.i.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C87181 c87181 = C87181.this;
                        int networkType = C8717i.this.getNetworkType(context);
                        for (INetworkChangeListener iNetworkChangeListener : C8717i.this.f28386MM) {
                            iNetworkChangeListener.networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().m27465a(context, this.f28387MN);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            m29983ad(context);
            this.f28386MM.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return C11013ag.m24132ck(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.f28386MM.remove(iNetworkChangeListener);
    }
}
