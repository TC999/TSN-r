package com.kwad.components.p208ad.draw.p214a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.draw.p215b.p217b.C7370a;
import com.kwad.components.p208ad.draw.p219c.C7399a;
import com.kwad.components.p208ad.p247k.C7824b;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.AbstractC10868a;

/* renamed from: com.kwad.components.ad.draw.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7358b extends AbstractC10868a {
    @Nullable

    /* renamed from: bN */
    public KsDrawAd.AdInteractionListener f25274bN;
    @NonNull

    /* renamed from: bP */
    public C7399a f25275bP;
    @NonNull

    /* renamed from: ch */
    public C7370a f25276ch;
    @Nullable

    /* renamed from: ci */
    public C7824b f25277ci;
    @Nullable
    public C8619c mApkDownloadHelper;
    @NonNull
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.clear();
        }
        this.f25275bP.release();
    }
}
