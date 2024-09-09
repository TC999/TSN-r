package com.bytedance.sdk.openadsdk.core.component.reward.ux;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w {
    public static float[] c(Context context, float f4, int i4) {
        float min;
        float max;
        float[] fArr = new float[2];
        float sr = xk.sr(context, xk.gd(context));
        float sr2 = xk.sr(context, xk.p(context));
        if (i4 == 2) {
            min = Math.max(sr, sr2);
            max = Math.min(sr, sr2);
        } else {
            min = Math.min(sr, sr2);
            max = Math.max(sr, sr2);
        }
        int sr3 = xk.sr(context, xk.k(context));
        if (xk.w() || f4 != 100.0f) {
            if (i4 != 2) {
                max -= sr3;
            } else {
                if ("SM-A207F".equals(i.u())) {
                    sr3 *= 2;
                }
                min -= sr3;
            }
        }
        fArr[0] = min;
        fArr[1] = max;
        return fArr;
    }

    public static int[] c(Context context, float f4, float f5, int i4) {
        int i5;
        float[] c4 = c(context, f4, i4);
        float f6 = c4[0];
        float f7 = c4[1];
        int[] iArr = new int[4];
        int min = (int) (Math.min(f6, f7) * f5);
        if (i4 != 2) {
            float f8 = min;
            i5 = (int) Math.max((f7 - (((f6 - f8) - f8) / f4)) / 2.0f, 0.0f);
        } else {
            float f9 = min;
            min = (int) Math.max((f6 - (((f7 - f9) - f9) * f4)) / 2.0f, 0.0f);
            i5 = min;
        }
        iArr[0] = min;
        iArr[1] = i5;
        iArr[2] = min;
        iArr[3] = i5;
        return iArr;
    }
}
