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
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AnimateLayoutChangeDetector {

    /* renamed from: a */
    private static final ViewGroup.MarginLayoutParams f9134a;

    /* renamed from: b */
    private LinearLayoutManager f9135b;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f9134a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f9135b = linearLayoutManager;
    }

    /* renamed from: b */
    private boolean m50295b() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top2;
        int i;
        int bottom;
        int i2;
        int childCount = this.f9135b.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.f9135b.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f9135b.getChildAt(i3);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f9134a;
                }
                int[] iArr2 = iArr[i3];
                if (z) {
                    top2 = childAt.getLeft();
                    i = marginLayoutParams.leftMargin;
                } else {
                    top2 = childAt.getTop();
                    i = marginLayoutParams.topMargin;
                }
                iArr2[0] = top2 - i;
                int[] iArr3 = iArr[i3];
                if (z) {
                    bottom = childAt.getRight();
                    i2 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i2 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = bottom + i2;
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
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[childCount - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    /* renamed from: c */
    private boolean m50294c() {
        int childCount = this.f9135b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m50296a(this.f9135b.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m50297a() {
        return (!m50295b() || this.f9135b.getChildCount() <= 1) && m50294c();
    }

    /* renamed from: a */
    private static boolean m50296a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (m50296a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
