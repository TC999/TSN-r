package com.kwad.components.p208ad.reward.presenter.p272f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.reward.presenter.f.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8188g extends AbstractDialogInterface$OnDismissListenerC8159d {

    /* renamed from: wD */
    public KSFrameLayout f27116wD;

    /* renamed from: a */
    protected void mo31320a(FrameLayout frameLayout) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public FrameLayout getTKContainer() {
        KSFrameLayout kSFrameLayout = this.f27116wD;
        if (kSFrameLayout != null) {
            return kSFrameLayout;
        }
        KSFrameLayout kSFrameLayout2 = (KSFrameLayout) findViewById(mo31278hM());
        this.f27116wD = kSFrameLayout2;
        if (kSFrameLayout2 == null) {
            KSFrameLayout kSFrameLayout3 = new KSFrameLayout(getContext());
            this.f27116wD = kSFrameLayout3;
            kSFrameLayout3.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            mo31320a(this.f27116wD);
            ((FrameLayout) getRootView()).addView(this.f27116wD, layoutParams);
        }
        return this.f27116wD;
    }

    @IdRes
    /* renamed from: hM */
    protected abstract int mo31278hM();
}
