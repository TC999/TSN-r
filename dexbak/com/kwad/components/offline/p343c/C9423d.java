package com.kwad.components.offline.p343c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p304n.p311b.p312a.C8730l;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompo;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig;
import com.kwad.components.offline.p343c.p345b.C9416a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.utils.C11031aw;

/* renamed from: com.kwad.components.offline.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9423d implements ITkOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final String getSpKeyTkSoLoadTimes() {
        return "tk_so_load_times";
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final String getSpNameSoLoadTimes() {
        return "ksadsdk_so_load_times";
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final String getTkJsFileDir(Context context, String str) {
        return C11031aw.getTkJsFileDir(context, str);
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final String getTkJsRootDir(Context context) {
        return C11031aw.getTkJsRootDir(context);
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final String getTkVersion() {
        return "5.1.7";
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final boolean isLocalDebugEnable() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return false;
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.c.d.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, @NonNull SoLoadListener soLoadListener) {
                C9416a.m28839a(context, soLoadListener);
            }
        };
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final boolean useTkLite() {
        return C9416a.useTkLite();
    }

    @Override // com.kwad.components.offline.api.p341tk.ITkOfflineCompoInitConfig
    public final boolean useTkSoAll() {
        return C10251d.m26527a(C10250c.aqY);
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new C8730l(ITkOfflineCompo.PACKAGE_NAME);
    }
}
