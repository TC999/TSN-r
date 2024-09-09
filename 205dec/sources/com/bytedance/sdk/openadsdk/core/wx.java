package com.bytedance.sdk.openadsdk.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wx {
    private static boolean c(View view, int i4) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) || (ls.w().ls() && c(view, new Rect(), (Point) null))) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= ((long) i4) * height2;
        }
        return false;
    }

    private static int sr(View view, int i4) {
        if (i4 == 3) {
            return com.bytedance.sdk.openadsdk.core.eq.xk.ux(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext())) / 2;
        }
        return 20;
    }

    private static boolean w(View view) {
        return view != null && view.isShown();
    }

    private static int xv(View view, int i4) {
        if (i4 == 3) {
            double sr = com.bytedance.sdk.openadsdk.core.eq.xk.sr(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
            Double.isNaN(sr);
            return (int) (sr * 0.7d);
        }
        return 20;
    }

    private static boolean w(View view, int i4) {
        return view.getWidth() >= xv(view, i4) && view.getHeight() >= sr(view, i4);
    }

    private static int w(View view, int i4, int i5) throws Throwable {
        if (com.bytedance.sdk.openadsdk.core.eq.gd.c()) {
            if (w(view)) {
                if (w(view, i5)) {
                    return !c(view, i4) ? 3 : 0;
                }
                return 6;
            }
            return 1;
        }
        return 4;
    }

    public static boolean c(View view, Rect rect, Point point) {
        if (view == null) {
            return false;
        }
        int right = view.getRight() - view.getLeft();
        int bottom = view.getBottom() - view.getTop();
        if (right <= 0 || bottom <= 0) {
            return false;
        }
        rect.set(0, 0, right, bottom);
        if (point != null) {
            point.set(-view.getScrollX(), -view.getScrollY());
        }
        return view.getParent() == null || view.getParent().getChildVisibleRect(view, rect, point);
    }

    public static boolean c(View view, int i4, int i5) {
        try {
            return w(view, i4, i5) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            return c(view, 20);
        }
        return false;
    }
}
