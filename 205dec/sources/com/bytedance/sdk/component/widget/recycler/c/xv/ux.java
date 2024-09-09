package com.bytedance.sdk.component.widget.recycler.c.xv;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ux {
    boolean onNestedFling(View view, float f4, float f5, boolean z3);

    boolean onNestedPreFling(View view, float f4, float f5);

    void onNestedPreScroll(View view, int i4, int i5, int[] iArr);

    void onNestedScroll(View view, int i4, int i5, int i6, int i7);

    void onNestedScrollAccepted(View view, View view2, int i4);

    boolean onStartNestedScroll(View view, View view2, int i4);

    void onStopNestedScroll(View view);
}
