package com.bytedance.sdk.component.adexpress.dynamic.w;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.xv.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static int c(r rVar) {
        if (rVar == null) {
            return 0;
        }
        String wx = rVar.wx();
        String ls = rVar.ls();
        if (TextUtils.isEmpty(ls) || TextUtils.isEmpty(wx) || !ls.equals("creative")) {
            return 0;
        }
        if (wx.equals("shake")) {
            return 2;
        }
        if (wx.equals("twist")) {
            return 3;
        }
        return wx.equals("slide") ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean w(android.view.View r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 2097610707(0x7d06ffd3, float:1.1215304E37)
            java.lang.Object r7 = r7.getTag(r1)     // Catch: java.lang.Exception -> L42
            android.util.Pair r7 = (android.util.Pair) r7     // Catch: java.lang.Exception -> L42
            if (r7 != 0) goto L10
            return r0
        L10:
            java.lang.Object r1 = r7.first     // Catch: java.lang.Exception -> L42
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L42
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L42
            r2 = 1
            if (r1 != 0) goto L2a
            java.lang.String r1 = "0"
            java.lang.Object r3 = r7.first     // Catch: java.lang.Exception -> L42
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L42
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch: java.lang.Exception -> L42
            if (r1 == 0) goto L28
            goto L2a
        L28:
            r1 = 0
            goto L2b
        L2a:
            r1 = 1
        L2b:
            java.lang.Object r7 = r7.second     // Catch: java.lang.Exception -> L42
            java.lang.Long r7 = (java.lang.Long) r7     // Catch: java.lang.Exception -> L42
            long r3 = r7.longValue()     // Catch: java.lang.Exception -> L42
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L3b
            r7 = 1
            goto L3c
        L3b:
            r7 = 0
        L3c:
            if (r1 == 0) goto L41
            if (r7 == 0) goto L41
            r0 = 1
        L41:
            return r0
        L42:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            java.lang.String r1 = "DynamicInteractHelper"
            com.bytedance.sdk.component.utils.a.w(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.w.c.w(android.view.View):boolean");
    }

    public static boolean c(View view) {
        Object tag;
        if (view == null) {
            return false;
        }
        try {
            tag = view.getTag(2097610708);
        } catch (Exception unused) {
        }
        if (tag == null) {
            return false;
        }
        return ((Integer) tag).intValue() == 1;
    }

    public static boolean c(View view, float f4, float f5, float f6, float f7) {
        if (view == null) {
            return false;
        }
        try {
            Pair pair = (Pair) view.getTag(2097610707);
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                String str = (String) pair.first;
                long longValue = ((Long) pair.second).longValue();
                if (str.equals("0")) {
                    return ((float) Math.sqrt(Math.pow((double) (f4 - f6), 2.0d) + Math.pow((double) (f5 - f7), 2.0d))) >= ((float) longValue);
                } else if (str.equals("1")) {
                    float f8 = f5 - f7;
                    return f8 < 0.0f && Math.abs(f8) >= ((float) longValue);
                } else if (str.equals("2")) {
                    float f9 = f4 - f6;
                    return f9 > 0.0f && Math.abs(f9) >= ((float) longValue);
                } else if (str.equals("3")) {
                    float f10 = f4 - f6;
                    return f10 < 0.0f && Math.abs(f10) >= ((float) longValue);
                } else if (str.equals("4")) {
                    float f11 = f5 - f7;
                    return f11 > 0.0f && Math.abs(f11) >= ((float) longValue);
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
