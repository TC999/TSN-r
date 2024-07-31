package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* renamed from: com.mbridge.msdk.foundation.tools.ak */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ViewCoveredUtils {

    /* renamed from: a */
    private static boolean f31008a;

    /* renamed from: a */
    public static boolean m21938a(View view) {
        if (view.getVisibility() != 0) {
            SameLogTool.m21733d("ViewUtils", "Banner Judge : Banner's not visible.");
            return true;
        } else if (view.getAlpha() < 0.5f) {
            SameLogTool.m21733d("ViewUtils", "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        } else if (view.getParent() != null && (view.getParent() instanceof ViewGroup) && ((ViewGroup) view.getParent()).getVisibility() != 0) {
            SameLogTool.m21733d("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        } else {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z = (rect.bottom - rect.top) * (rect.right - rect.left) >= (view.getMeasuredHeight() * view.getMeasuredWidth()) / 2;
            boolean z2 = globalVisibleRect && z;
            SameLogTool.m21733d("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z);
            StringBuilder sb = new StringBuilder();
            sb.append("View Judge : totalViewVisible is ");
            sb.append(z2);
            SameLogTool.m21733d("ViewUtils", sb.toString());
            if (z2) {
                ViewGroup viewGroup = view;
                while (viewGroup.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                    for (int m21936a = m21936a(viewGroup, viewGroup2) + 1; m21936a < viewGroup2.getChildCount(); m21936a++) {
                        View childAt = viewGroup2.getChildAt(m21936a);
                        if (childAt.getVisibility() == 0 && m21937a(view, childAt)) {
                            if (childAt instanceof ViewGroup) {
                                ViewGroup viewGroup3 = (ViewGroup) childAt;
                                if (viewGroup3.getChildCount() > 0) {
                                    SameLogTool.m21733d("ViewUtils", "View Judge : Covered by ViewGroup.");
                                    boolean m21934b = m21934b(view, viewGroup3);
                                    f31008a = false;
                                    if (m21934b) {
                                        return true;
                                    }
                                }
                            }
                            if (m21935b(childAt)) {
                                SameLogTool.m21733d("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                                return true;
                            }
                        }
                    }
                    viewGroup = viewGroup2;
                }
                SameLogTool.m21733d("ViewUtils", "View Judge : Well done, View is not covered.");
                return false;
            }
            return true;
        }
    }

    /* renamed from: b */
    private static boolean m21935b(View view) {
        if (view.getAlpha() <= 0.5f) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getBackground() != null && view.getBackground().getAlpha() > 127;
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m21934b(View view, ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            SameLogTool.m21733d("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0 && m21937a(view, childAt)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    SameLogTool.m21733d("ViewUtils", "View Judge : View Covered by WebView.");
                    f31008a = true;
                }
                if (m21935b(childAt)) {
                    SameLogTool.m21733d("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    f31008a = true;
                }
                if (f31008a) {
                    break;
                } else if (childAt instanceof ViewGroup) {
                    m21934b(view, (ViewGroup) childAt);
                }
            }
        }
        return f31008a;
    }

    /* renamed from: a */
    private static boolean m21937a(View view, View view2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect, rect2) && ((Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top))) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth();
    }

    /* renamed from: a */
    private static int m21936a(View view, ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }
}
