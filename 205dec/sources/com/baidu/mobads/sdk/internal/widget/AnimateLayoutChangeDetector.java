package com.baidu.mobads.sdk.internal.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class AnimateLayoutChangeDetector {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f12920a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayoutManager f12921b;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f12920a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f12921b = linearLayoutManager;
    }

    private boolean b() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top2;
        int i4;
        int bottom;
        int i5;
        int childCount = this.f12921b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z3 = this.f12921b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, childCount, 2);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = this.f12921b.getChildAt(i6);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f12920a;
                }
                int[] iArr2 = iArr[i6];
                if (z3) {
                    top2 = childAt.getLeft();
                    i4 = marginLayoutParams.leftMargin;
                } else {
                    top2 = childAt.getTop();
                    i4 = marginLayoutParams.topMargin;
                }
                iArr2[0] = top2 - i4;
                int[] iArr3 = iArr[i6];
                if (z3) {
                    bottom = childAt.getRight();
                    i5 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i5 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i5;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: com.baidu.mobads.sdk.internal.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            public int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i7 = 1; i7 < childCount; i7++) {
            if (iArr[i7 - 1][1] != iArr[i7][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    private boolean c() {
        int childCount = this.f12921b.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (a(this.f12921b.getChildAt(i4))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return (!b() || this.f12921b.getChildCount() <= 1) && c();
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                if (a(viewGroup.getChildAt(i4))) {
                    return true;
                }
            }
        }
        return false;
    }
}
