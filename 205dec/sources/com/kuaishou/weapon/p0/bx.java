package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bx {

    /* renamed from: a  reason: collision with root package name */
    private static String f38121a = c.b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);

    /* renamed from: b  reason: collision with root package name */
    private static String f38122b = c.b(f38122b, 2);

    /* renamed from: b  reason: collision with root package name */
    private static String f38122b = c.b(f38122b, 2);

    public static String a(Context context) {
        String str = TextUtils.isEmpty(d(context)) ? "0" : "1";
        String c4 = c(context);
        if (TextUtils.isEmpty(c4)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        b(context, c4);
        return str2;
    }

    public static String b(Context context) {
        String c4 = c(context);
        String d4 = d(context);
        if (TextUtils.isEmpty(c4) || !TextUtils.equals(c4, d4)) {
            if (!TextUtils.isEmpty(c4)) {
                b(context, c4);
                return c4;
            } else if (TextUtils.isEmpty(d4)) {
                return "";
            } else {
                a(context, d4);
                return d4;
            }
        }
        return c4;
    }

    public static String c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f38121a);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return df.a(context).e();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                Settings.System.putString(context.getContentResolver(), f38121a, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        df.a(context).d(str);
    }
}
