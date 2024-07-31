package com.kwad.components.p208ad.interstitial.aggregate;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.utils.C11124s;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7717d extends Scroller {

    /* renamed from: jq */
    private final int f26110jq;

    public C7717d(Context context) {
        super(context);
        this.f26110jq = 1000;
    }

    /* renamed from: a */
    public final void m32579a(ViewPager viewPager) {
        try {
            C11124s.m23707a(viewPager, "mScroller", this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, 1000);
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, 1000);
    }
}
