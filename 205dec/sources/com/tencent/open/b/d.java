package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f51704a;

    /* renamed from: b  reason: collision with root package name */
    private static String f51705b;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f51704a)) {
            if (context == null) {
                return "";
            }
            f51704a = "";
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                int width = windowManager.getDefaultDisplay().getWidth();
                int height = windowManager.getDefaultDisplay().getHeight();
                f51704a = width + "x" + height;
            }
            return f51704a;
        }
        return f51704a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}
