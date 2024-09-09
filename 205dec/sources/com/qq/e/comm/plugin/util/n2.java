package com.qq.e.comm.plugin.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n2 {
    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
