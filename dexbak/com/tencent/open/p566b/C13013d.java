package com.tencent.open.p566b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13013d {

    /* renamed from: a */
    private static String f37304a;

    /* renamed from: b */
    private static String f37305b;

    /* renamed from: a */
    public static String m15177a(Context context) {
        if (TextUtils.isEmpty(f37304a)) {
            if (context == null) {
                return "";
            }
            f37304a = "";
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                int width = windowManager.getDefaultDisplay().getWidth();
                int height = windowManager.getDefaultDisplay().getHeight();
                f37304a = width + "x" + height;
            }
            return f37304a;
        }
        return f37304a;
    }

    /* renamed from: a */
    public static String m15178a() {
        return Locale.getDefault().getLanguage();
    }
}
