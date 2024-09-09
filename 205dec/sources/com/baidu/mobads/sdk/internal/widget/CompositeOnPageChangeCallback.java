package com.baidu.mobads.sdk.internal.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.OnPageChangeCallback> f12923a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeOnPageChangeCallback(int i4) {
        this.f12923a = new ArrayList(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12923a.add(onPageChangeCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f12923a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i4) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f12923a) {
                onPageChangeCallback.onPageScrollStateChanged(i4);
            }
        } catch (ConcurrentModificationException e4) {
            a(e4);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i4, float f4, @Px int i5) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f12923a) {
                onPageChangeCallback.onPageScrolled(i4, f4, i5);
            }
        } catch (ConcurrentModificationException e4) {
            a(e4);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i4) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f12923a) {
                onPageChangeCallback.onPageSelected(i4);
            }
        } catch (ConcurrentModificationException e4) {
            a(e4);
        }
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
