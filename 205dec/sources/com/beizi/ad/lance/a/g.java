package com.beizi.ad.lance.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ExpandTouchAreaUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g {
    public static View a(int i4, View view, View view2, String str) {
        if (view != null) {
            return a(i4, view2, view, str, true);
        }
        return null;
    }

    private static int b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getResources().getDisplayMetrics().heightPixels;
        }
        return 1920;
    }

    private static int c(Context context) {
        if (context instanceof Activity) {
            Resources resources = ((Activity) context).getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            l.c("BeiZisAd", "Status height:" + dimensionPixelSize);
            return dimensionPixelSize;
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:70:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View a(int r22, android.view.View r23, android.view.View r24, java.lang.String r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 1186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.lance.a.g.a(int, android.view.View, android.view.View, java.lang.String, boolean):android.view.View");
    }

    private static int a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getResources().getDisplayMetrics().widthPixels;
        }
        return 1080;
    }
}
