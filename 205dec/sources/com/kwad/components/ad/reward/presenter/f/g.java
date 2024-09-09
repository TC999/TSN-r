package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class g extends d {
    public KSFrameLayout wD;

    protected void a(FrameLayout frameLayout) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        KSFrameLayout kSFrameLayout = this.wD;
        if (kSFrameLayout != null) {
            return kSFrameLayout;
        }
        KSFrameLayout kSFrameLayout2 = (KSFrameLayout) findViewById(hM());
        this.wD = kSFrameLayout2;
        if (kSFrameLayout2 == null) {
            KSFrameLayout kSFrameLayout3 = new KSFrameLayout(getContext());
            this.wD = kSFrameLayout3;
            kSFrameLayout3.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            a(this.wD);
            ((FrameLayout) getRootView()).addView(this.wD, layoutParams);
        }
        return this.wD;
    }

    @IdRes
    protected abstract int hM();
}
