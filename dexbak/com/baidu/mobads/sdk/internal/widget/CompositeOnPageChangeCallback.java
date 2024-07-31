package com.baidu.mobads.sdk.internal.widget;

import androidx.annotation.InterfaceC0075Px;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    @NonNull

    /* renamed from: a */
    private final List<ViewPager2.OnPageChangeCallback> f9137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeOnPageChangeCallback(int i) {
        this.f9137a = new ArrayList(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m50293a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f9137a.add(onPageChangeCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m50291b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f9137a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f9137a) {
                onPageChangeCallback.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            m50292a(e);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, @InterfaceC0075Px int i2) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f9137a) {
                onPageChangeCallback.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            m50292a(e);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageChangeCallback : this.f9137a) {
                onPageChangeCallback.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            m50292a(e);
        }
    }

    /* renamed from: a */
    private void m50292a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
