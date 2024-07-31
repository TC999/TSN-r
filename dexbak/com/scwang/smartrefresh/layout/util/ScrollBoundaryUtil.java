package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.scwang.smartrefresh.layout.util.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ScrollBoundaryUtil {
    /* renamed from: a */
    public static boolean m19763a(View view, MotionEvent motionEvent) {
        if (!m19761c(view) && m19759e(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (m19758f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return m19763a(childAt, obtain);
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m19762b(View view, MotionEvent motionEvent) {
        if (m19759e(view) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || motionEvent == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (m19758f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(pointF.x, pointF.y);
                return m19762b(childAt, obtain);
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m19761c(View view) {
        return view.canScrollVertically(1);
    }

    /* renamed from: d */
    public static boolean m19760d(View view, MotionEvent motionEvent) {
        if (m19761c(view) && view.getVisibility() == 0) {
            return true;
        }
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (m19758f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(pointF.x, pointF.y);
                    return m19760d(childAt, obtain);
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m19759e(View view) {
        return view.canScrollVertically(-1);
    }

    /* renamed from: f */
    public static boolean m19758f(ViewGroup viewGroup, View view, float f, float f2, PointF pointF) {
        if (view.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        m19756h(viewGroup, view, fArr);
        boolean m19757g = m19757g(view, fArr[0], fArr[1], 0.0f);
        if (m19757g && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return m19757g;
    }

    /* renamed from: g */
    public static boolean m19757g(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) view.getWidth()) + f3 && f2 < ((float) view.getHeight()) + f3;
    }

    /* renamed from: h */
    public static void m19756h(ViewGroup viewGroup, View view, float[] fArr) {
        fArr[0] = fArr[0] + (viewGroup.getScrollX() - view.getLeft());
        fArr[1] = fArr[1] + (viewGroup.getScrollY() - view.getTop());
    }
}
