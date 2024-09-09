package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ScrollBoundaryUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {
    public static boolean a(View view, MotionEvent motionEvent) {
        if (!c(view) && e(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return a(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean b(View view, MotionEvent motionEvent) {
        if (e(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || motionEvent == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(pointF.x, pointF.y);
                return b(childAt, obtain);
            }
        }
        return true;
    }

    public static boolean c(View view) {
        return view.canScrollVertically(1);
    }

    public static boolean d(View view, MotionEvent motionEvent) {
        if (c(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return d(childAt, obtain);
                }
            }
        }
        return false;
    }

    public static boolean e(View view) {
        return view.canScrollVertically(-1);
    }

    public static boolean f(ViewGroup viewGroup, View view, float f4, float f5, PointF pointF) {
        if (view.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f4, f5};
        h(viewGroup, view, fArr);
        boolean g4 = g(view, fArr[0], fArr[1], 0.0f);
        if (g4 && pointF != null) {
            pointF.set(fArr[0] - f4, fArr[1] - f5);
        }
        return g4;
    }

    public static boolean g(View view, float f4, float f5, float f6) {
        float f7 = -f6;
        return f4 >= f7 && f5 >= f7 && f4 < ((float) view.getWidth()) + f6 && f5 < ((float) view.getHeight()) + f6;
    }

    public static void h(ViewGroup viewGroup, View view, float[] fArr) {
        fArr[0] = fArr[0] + (viewGroup.getScrollX() - view.getLeft());
        fArr[1] = fArr[1] + (viewGroup.getScrollY() - view.getTop());
    }
}
