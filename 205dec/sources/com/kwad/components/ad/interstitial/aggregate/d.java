package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.utils.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends Scroller {
    private final int jq;

    public d(Context context) {
        super(context);
        this.jq = 1000;
    }

    public final void a(ViewPager viewPager) {
        try {
            s.a(viewPager, "mScroller", this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i4, int i5, int i6, int i7) {
        super.startScroll(i4, i5, i6, i7, 1000);
    }

    @Override // android.widget.Scroller
    public final void startScroll(int i4, int i5, int i6, int i7, int i8) {
        super.startScroll(i4, i5, i6, i7, 1000);
    }
}
