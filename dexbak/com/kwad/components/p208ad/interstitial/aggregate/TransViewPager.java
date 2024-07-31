package com.kwad.components.p208ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.interstitial.p245g.C7796c;
import com.kwad.sdk.widget.C11146d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.TransViewPager */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TransViewPager extends C11146d {

    /* renamed from: iY */
    private float f26036iY;
    @SlideType

    /* renamed from: iZ */
    private int f26037iZ;
    private Map<Integer, C7796c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m32640a(View view, View view2, float f) {
        if (this.f26037iZ == 0 && f != 0.0f) {
            float f2 = this.f26036iY;
            if (f2 != 0.0f) {
                if (f > f2) {
                    this.f26037iZ = 1;
                } else {
                    this.f26037iZ = 2;
                }
            }
        }
        if (this.f26037iZ == 1 && view2 != null) {
            if (f <= 0.5d && f > 0.0f) {
                view2.setTranslationX(240.0f * f);
            } else {
                view2.setTranslationX((1.0f - f) * 240.0f);
            }
        }
        if (this.f26037iZ == 2 && view != null) {
            if (f <= 0.5d && f >= 0.0f) {
                view.setTranslationX((-240.0f) * f);
            } else {
                view.setTranslationX((1.0f - f) * (-240.0f));
            }
        }
        this.f26036iY = f;
        if (f == 0.0f) {
            this.f26037iZ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        m32640a(m32639y(i), m32639y(i + 1), f);
        super.onPageScrolled(i, f, i2);
    }

    /* renamed from: y */
    public final C7796c m32639y(int i) {
        return this.map.get(Integer.valueOf(i));
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.f26037iZ = 0;
    }

    /* renamed from: a */
    public final void m32641a(int i, C7796c c7796c) {
        this.map.put(Integer.valueOf(i), c7796c);
    }
}
