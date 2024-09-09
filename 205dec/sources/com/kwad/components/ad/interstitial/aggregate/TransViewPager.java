package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    private float iY;
    @SlideType
    private int iZ;
    private Map<Integer, com.kwad.components.ad.interstitial.g.c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void a(View view, View view2, float f4) {
        if (this.iZ == 0 && f4 != 0.0f) {
            float f5 = this.iY;
            if (f5 != 0.0f) {
                if (f4 > f5) {
                    this.iZ = 1;
                } else {
                    this.iZ = 2;
                }
            }
        }
        if (this.iZ == 1 && view2 != null) {
            if (f4 <= 0.5d && f4 > 0.0f) {
                view2.setTranslationX(240.0f * f4);
            } else {
                view2.setTranslationX((1.0f - f4) * 240.0f);
            }
        }
        if (this.iZ == 2 && view != null) {
            if (f4 <= 0.5d && f4 >= 0.0f) {
                view.setTranslationX((-240.0f) * f4);
            } else {
                view.setTranslationX((1.0f - f4) * (-240.0f));
            }
        }
        this.iY = f4;
        if (f4 == 0.0f) {
            this.iZ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i4, float f4, int i5) {
        a(y(i4), y(i4 + 1), f4);
        super.onPageScrolled(i4, f4, i5);
    }

    public final com.kwad.components.ad.interstitial.g.c y(int i4) {
        return this.map.get(Integer.valueOf(i4));
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.iZ = 0;
    }

    public final void a(int i4, com.kwad.components.ad.interstitial.g.c cVar) {
        this.map.put(Integer.valueOf(i4), cVar);
    }
}
