package com.kwad.components.p208ad.reward.p257j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* renamed from: com.kwad.components.ad.reward.j.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7954a {
    /* renamed from: a */
    public static int m31932a(Activity activity) {
        TextView m31929e;
        if (activity != null && !activity.isFinishing()) {
            View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
            if ((findViewById instanceof ViewGroup) && (m31929e = m31929e((ViewGroup) findViewById)) != null) {
                return m31930b(m31929e);
            }
        }
        return -1;
    }

    @SuppressLint({"InternalInsetResource"})
    /* renamed from: b */
    private static int m31930b(TextView textView) {
        if (textView == null) {
            return -1;
        }
        int[] iArr = new int[2];
        textView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* renamed from: e */
    private static TextView m31929e(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                TextView m31929e = m31929e((ViewGroup) childAt);
                if (m31929e != null) {
                    return m31929e;
                }
            } else if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (m31931a(textView)) {
                    return textView;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m31931a(TextView textView) {
        return textView != null && "topBarCallLabel".equals(textView.getContentDescription());
    }
}
