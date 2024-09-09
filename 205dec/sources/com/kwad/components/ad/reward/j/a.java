package com.kwad.components.ad.reward.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static int a(Activity activity) {
        TextView e4;
        if (activity != null && !activity.isFinishing()) {
            View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
            if ((findViewById instanceof ViewGroup) && (e4 = e((ViewGroup) findViewById)) != null) {
                return b(e4);
            }
        }
        return -1;
    }

    @SuppressLint({"InternalInsetResource"})
    private static int b(TextView textView) {
        if (textView == null) {
            return -1;
        }
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    private static TextView e(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof ViewGroup) {
                TextView e4 = e((ViewGroup) childAt);
                if (e4 != null) {
                    return e4;
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (a(textView)) {
                    return textView;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    private static boolean a(TextView textView) {
        return textView != null && "topBarCallLabel".equals(textView.getContentDescription());
    }
}
