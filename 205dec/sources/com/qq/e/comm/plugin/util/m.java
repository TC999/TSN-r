package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m {
    public static Pair<Integer, Integer> a(ADSize aDSize, Context context) {
        if (aDSize.getWidth() <= 0 && aDSize.getWidth() != -1) {
            GDTLogger.w("\u5bbd\u5ea6\u5fc5\u987b\u5927\u4e8e0\u6216\u8005\u4e3aADSize.FULL_WIDTH\uff0c\u5df2\u5c06\u5e7f\u544a\u5bbd\u5ea6\u8c03\u6574\u4e3aADSize.FULL_WIDTH", null);
        }
        if (aDSize.getHeight() <= 0 && aDSize.getHeight() != -2) {
            GDTLogger.w("\u9ad8\u5ea6\u5fc5\u987b\u5927\u4e8e0\u6216\u8005\u4e3aADSize.AUTO_HEIGHT\uff0c\u5df2\u7ecf\u5e7f\u544a\u9ad8\u5ea6\u8c03\u6574\u4e3aADSize.AUTO_HEIGHT", null);
        }
        int b4 = f1.b(context, f1.c(context));
        int b5 = f1.b(context, f1.a(context));
        int width = aDSize.getWidth() <= 0 ? b4 : aDSize.getWidth();
        int max = Math.max(aDSize.getHeight(), 0);
        if (width <= b4) {
            b4 = width;
        }
        if (max <= b5) {
            b5 = max;
        }
        return new Pair<>(Integer.valueOf(b4), Integer.valueOf(b5));
    }
}
