package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;

/* renamed from: com.kuaishou.weapon.p0.bx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7209bx {

    /* renamed from: a */
    private static String f24622a = C7212c.m34106b("Y29tLmt3YWkud2VhcG9uLmNvbmp1cmU=\n", 2);

    /* renamed from: b */
    private static String f24623b = C7212c.m34106b(f24623b, 2);

    /* renamed from: b */
    private static String f24623b = C7212c.m34106b(f24623b, 2);

    /* renamed from: a */
    public static String m34121a(Context context) {
        String str = TextUtils.isEmpty(m34116d(context)) ? "0" : "1";
        String m34117c = m34117c(context);
        if (TextUtils.isEmpty(m34117c)) {
            return "0" + str;
        }
        String str2 = "1" + str;
        m34118b(context, m34117c);
        return str2;
    }

    /* renamed from: b */
    public static String m34119b(Context context) {
        String m34117c = m34117c(context);
        String m34116d = m34116d(context);
        if (TextUtils.isEmpty(m34117c) || !TextUtils.equals(m34117c, m34116d)) {
            if (!TextUtils.isEmpty(m34117c)) {
                m34118b(context, m34117c);
                return m34117c;
            } else if (TextUtils.isEmpty(m34116d)) {
                return "";
            } else {
                m34120a(context, m34116d);
                return m34116d;
            }
        }
        return m34117c;
    }

    /* renamed from: c */
    public static String m34117c(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), f24622a);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: d */
    public static String m34116d(Context context) {
        try {
            return C7262df.m33986a(context).m33975e();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m34120a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                Settings.System.putString(context.getContentResolver(), f24622a, str);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m34118b(Context context, String str) {
        C7262df.m33986a(context).m33976d(str);
    }
}
