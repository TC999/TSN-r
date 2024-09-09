package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f12932a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.PageTransformer f12933b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f12932a = linearLayoutManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPager2.PageTransformer a() {
        return this.f12933b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i4) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i4, float f4, int i5) {
        if (this.f12933b == null) {
            return;
        }
        float f5 = -f4;
        for (int i6 = 0; i6 < this.f12932a.getChildCount(); i6++) {
            View childAt = this.f12932a.getChildAt(i6);
            if (childAt != null) {
                this.f12933b.transformPage(childAt, (this.f12932a.getPosition(childAt) - i4) + f5);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i6), Integer.valueOf(this.f12932a.getChildCount())));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f12933b = pageTransformer;
    }
}
