package com.beizi.p051ad.lance.p062a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;

/* renamed from: com.beizi.ad.lance.a.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ExpandTouchAreaUtil {
    /* renamed from: a */
    public static View m49065a(int i, View view, View view2, String str) {
        if (view != null) {
            return m49064a(i, view2, view, str, true);
        }
        return null;
    }

    /* renamed from: b */
    private static int m49062b(Context context) {
        return context instanceof Activity ? ((Activity) context).getResources().getDisplayMetrics().heightPixels : PredefinedCaptureConfigurations.f24410t;
    }

    /* renamed from: c */
    private static int m49061c(Context context) {
        if (context instanceof Activity) {
            Resources resources = ((Activity) context).getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", FaceEnvironment.f8430OS));
            LogUtil.m49044c("BeiZisAd", "Status height:" + dimensionPixelSize);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.View m49064a(int r22, android.view.View r23, android.view.View r24, java.lang.String r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 1186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.lance.p062a.ExpandTouchAreaUtil.m49064a(int, android.view.View, android.view.View, java.lang.String, boolean):android.view.View");
    }

    /* renamed from: a */
    private static int m49063a(Context context) {
        return context instanceof Activity ? ((Activity) context).getResources().getDisplayMetrics().widthPixels : PredefinedCaptureConfigurations.f24409s;
    }
}
