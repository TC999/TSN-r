package com.qq.e.comm.plugin.util;

import android.view.View;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q {
    public static void a(View view) {
        if (view == null) {
            return;
        }
        int b4 = f1.b(view.getContext(), view.getWidth());
        int b5 = f1.b(view.getContext(), view.getHeight());
        int i4 = 1;
        boolean z3 = b5 < 48;
        boolean z4 = b4 == 0 || ((float) b5) / ((float) b4) > 0.32f;
        if (z3 || z4) {
            if (z3 && z4) {
                i4 = 3;
            } else if (!z3) {
                i4 = z4 ? 2 : 0;
            }
            GDTLogger.e("\u60a8\u4f20\u5165\u7684Banner\u5e7f\u544a\u5bb9\u5668\u5c3a\u5bf8\u4e0d\u7b26\u5408\u8981\u6c42\uff0c\u53ef\u80fd\u5f71\u54cd\u5e7f\u544a\u5c55\u793a\u6837\u5f0f\uff0c\u8bf7\u6309Demo\u4e2d\u89c4\u8303\u8c03\u6574\uff01");
            com.qq.e.comm.plugin.n0.v.a(1050020, null, Integer.valueOf(i4));
        }
    }
}
