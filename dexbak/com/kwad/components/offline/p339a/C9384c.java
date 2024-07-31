package com.kwad.components.offline.p339a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p304n.p311b.p312a.C8730l;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.p339a.p340a.C9379a;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.utils.C11025ar;
import com.kwad.sdk.utils.C11028au;
import java.util.Map;

/* renamed from: com.kwad.components.offline.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9384c implements IAdLiveOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig
    public final AdLiveHttpRequestListenerDelegate getAdLiveHttpRequestListenerDelegate() {
        return new AdLiveHttpRequestListenerDelegate() { // from class: com.kwad.components.offline.a.c.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveHttpRequestListenerDelegate
            public final C10415c doPost(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
                try {
                    return C10756f.m24902xT().doPost(C11025ar.appendUrl(str, map), map2, map3);
                } catch (Throwable unused) {
                    return null;
                }
            }
        };
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.a.c.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                C9379a.m28868a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig
    public final boolean usePhoneStateDisable() {
        return C11028au.usePhoneStateDisable();
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new C8730l(IAdLiveOfflineCompo.PACKAGE_NAME);
    }
}
