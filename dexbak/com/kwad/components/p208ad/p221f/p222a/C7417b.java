package com.kwad.components.p208ad.p221f.p222a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.p221f.DialogInterface$OnDismissListenerC7465d;
import com.kwad.components.p208ad.p221f.p224c.C7459a;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.AbstractC10868a;

/* renamed from: com.kwad.components.ad.f.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7417b extends AbstractC10868a {
    @Nullable
    public C8619c mApkDownloadHelper;
    @NonNull

    /* renamed from: mI */
    public AdBasePvFrameLayout f25417mI;
    @NonNull

    /* renamed from: mO */
    public C7459a f25418mO;
    @NonNull

    /* renamed from: mr */
    public KsNativeAd.VideoPlayListener f25419mr;
    @NonNull

    /* renamed from: mw */
    public DialogInterface$OnDismissListenerC7465d.InterfaceC7476a f25420mw;

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.clear();
        }
        this.f25418mO.release();
    }
}
