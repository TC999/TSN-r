package com.kwad.components.p208ad.interstitial.p245g;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* renamed from: com.kwad.components.ad.interstitial.g.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7794a extends FrameLayout {
    @NonNull
    public Context mContext;

    public AbstractC7794a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* renamed from: a */
    public abstract void mo32360a(@NonNull AdResultData adResultData, AlertDialogC7725d alertDialogC7725d, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener);

    /* renamed from: cr */
    public abstract void mo32359cr();

    /* renamed from: cs */
    public abstract void mo32358cs();

    public abstract void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener);
}
