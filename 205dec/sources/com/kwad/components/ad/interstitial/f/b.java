package com.kwad.components.ad.interstitial.f;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bq;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(@NonNull View view, int i4) {
        super(view, 100);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean dW() {
        return bq.o(this.mRootView, 100);
    }
}
