package com.kwad.components.core.p289e.p292c;

import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.AbstractC10868a;

/* renamed from: com.kwad.components.core.e.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8607d extends AbstractC10868a {
    @Nullable

    /* renamed from: Ke */
    public AlertDialogC8602b f28189Ke;

    /* renamed from: Kf */
    public AlertDialogC8602b.C8605b f28190Kf;
    public AdTemplate mAdTemplate;
    @Nullable
    public C8619c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.clear();
        }
    }
}
