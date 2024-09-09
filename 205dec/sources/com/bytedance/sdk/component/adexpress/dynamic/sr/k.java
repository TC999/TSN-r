package com.bytedance.sdk.component.adexpress.dynamic.sr;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.sr.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f29305c = Collections.unmodifiableSet(new HashSet(Arrays.asList(InteractionCommon.DISLIKE_TYPE_EXECUTION, "close", "close-fill", "webview-close")));

    /* renamed from: w  reason: collision with root package name */
    private static String f29306w;

    /* JADX WARN: Removed duplicated region for block: B:210:0x0475  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.sr.w.xv c(java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, boolean r23, int r24, com.bytedance.sdk.component.adexpress.dynamic.xv.ev r25, double r26, int r28, double r29, java.lang.String r31, com.bytedance.sdk.component.adexpress.w.bk r32) {
        /*
            Method dump skipped, instructions count: 1303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.sr.k.c(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.xv.ev, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.w.bk):com.bytedance.sdk.component.adexpress.dynamic.sr.w$xv");
    }

    public static double w(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] w(String str, float f4, boolean z3) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.sr.getContext());
            textView.setTextSize(f4);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z3) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean w() {
        return !TextUtils.isEmpty(f29306w);
    }

    public static String c(String str) {
        String[] split;
        return (TextUtils.isEmpty(str) || (split = str.split("adx:")) == null || split.length < 2) ? "" : split[1];
    }

    private static w.xv c(w.xv xvVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            xvVar.f29322c = 0.0f;
            xvVar.f29323w = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = c(str);
            }
            if (TextUtils.isEmpty(str3)) {
                xvVar.f29322c = 0.0f;
                xvVar.f29323w = 0.0f;
            } else {
                return c(str3, str2);
            }
        }
        return xvVar;
    }

    public static w.xv c(String str, String str2) {
        return c(str, str2, false);
    }

    public static w.xv c(String str, String str2, boolean z3) {
        w.xv xvVar = new w.xv();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] c4 = c(str, (float) w(str2), z3);
            xvVar.f29322c = c4[0];
            xvVar.f29323w = c4[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                xvVar.f29323w = 0.0f;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return xvVar;
    }

    public static int[] c(String str, float f4, boolean z3) {
        int[] w3 = w(str, f4, z3);
        return new int[]{com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), w3[0]), com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), w3[1])};
    }

    public static String c() {
        return f29306w;
    }
}
