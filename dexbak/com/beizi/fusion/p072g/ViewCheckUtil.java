package com.beizi.fusion.p072g;

import android.graphics.Rect;
import android.view.View;

/* renamed from: com.beizi.fusion.g.ax */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewCheckUtil {
    /* renamed from: a */
    public static boolean m48281a(View view) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.hasWindowFocus()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            int height = rect.height() * rect.width();
            double height2 = view.getHeight() * view.getWidth();
            Double.isNaN(height2);
            int i = (int) (height2 * 0.95d);
            return i > 0 && height >= i;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m48280b(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                    Rect rect = new Rect();
                    if (view.getGlobalVisibleRect(rect)) {
                        return rect.height() * rect.width() > 0;
                    }
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }
}
