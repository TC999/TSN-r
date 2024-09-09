package xyz.adscope.ad.tool.monitor;

import android.graphics.Rect;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeADNScreenTool {
    public static boolean isVisible(View view, int i4) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || !view.hasWindowFocus()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            int height = rect.height() * rect.width();
            int height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= i4 * height2;
        }
        return false;
    }
}
