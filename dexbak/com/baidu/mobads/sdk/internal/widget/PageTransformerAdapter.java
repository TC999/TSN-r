package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a */
    private final LinearLayoutManager f9146a;

    /* renamed from: b */
    private ViewPager2.PageTransformer f9147b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f9146a = linearLayoutManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public ViewPager2.PageTransformer m50284a() {
        return this.f9147b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        if (this.f9147b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.f9146a.getChildCount(); i3++) {
            View childAt = this.f9146a.getChildAt(i3);
            if (childAt != null) {
                this.f9147b.transformPage(childAt, (this.f9146a.getPosition(childAt) - i) + f2);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f9146a.getChildCount())));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m50283a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f9147b = pageTransformer;
    }
}
