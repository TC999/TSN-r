package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* compiled from: ViewCoveredUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ak {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f39781a;

    public static boolean a(View view) {
        if (view.getVisibility() != 0) {
            x.d("ViewUtils", "Banner Judge : Banner's not visible.");
            return true;
        } else if (view.getAlpha() < 0.5f) {
            x.d("ViewUtils", "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        } else if (view.getParent() != null && (view.getParent() instanceof ViewGroup) && ((ViewGroup) view.getParent()).getVisibility() != 0) {
            x.d("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        } else {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z3 = (rect.bottom - rect.top) * (rect.right - rect.left) >= (view.getMeasuredHeight() * view.getMeasuredWidth()) / 2;
            boolean z4 = globalVisibleRect && z3;
            x.d("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z3);
            StringBuilder sb = new StringBuilder();
            sb.append("View Judge : totalViewVisible is ");
            sb.append(z4);
            x.d("ViewUtils", sb.toString());
            if (z4) {
                ViewGroup viewGroup = view;
                while (viewGroup.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                    for (int a4 = a(viewGroup, viewGroup2) + 1; a4 < viewGroup2.getChildCount(); a4++) {
                        View childAt = viewGroup2.getChildAt(a4);
                        if (childAt.getVisibility() == 0 && a(view, childAt)) {
                            if (childAt instanceof ViewGroup) {
                                ViewGroup viewGroup3 = (ViewGroup) childAt;
                                if (viewGroup3.getChildCount() > 0) {
                                    x.d("ViewUtils", "View Judge : Covered by ViewGroup.");
                                    boolean b4 = b(view, viewGroup3);
                                    f39781a = false;
                                    if (b4) {
                                        return true;
                                    }
                                }
                            }
                            if (b(childAt)) {
                                x.d("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                                return true;
                            }
                        }
                    }
                    viewGroup = viewGroup2;
                }
                x.d("ViewUtils", "View Judge : Well done, View is not covered.");
                return false;
            }
            return true;
        }
    }

    private static boolean b(View view) {
        if (view.getAlpha() <= 0.5f) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getBackground() != null && view.getBackground().getAlpha() > 127;
        }
        return true;
    }

    private static boolean b(View view, ViewGroup viewGroup) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            x.d("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i4);
            if (childAt.getVisibility() == 0 && a(view, childAt)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    x.d("ViewUtils", "View Judge : View Covered by WebView.");
                    f39781a = true;
                }
                if (b(childAt)) {
                    x.d("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    f39781a = true;
                }
                if (f39781a) {
                    break;
                } else if (childAt instanceof ViewGroup) {
                    b(view, (ViewGroup) childAt);
                }
            }
        }
        return f39781a;
    }

    private static boolean a(View view, View view2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect, rect2) && ((Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left)) * (Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top))) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth();
    }

    private static int a(View view, ViewGroup viewGroup) {
        int i4 = 0;
        while (i4 < viewGroup.getChildCount() && viewGroup.getChildAt(i4) != view) {
            i4++;
        }
        return i4;
    }
}
