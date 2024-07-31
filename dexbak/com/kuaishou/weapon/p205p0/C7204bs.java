package com.kuaishou.weapon.p205p0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.stub.StubApp;

/* renamed from: com.kuaishou.weapon.p0.bs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7204bs {

    /* renamed from: a */
    public static final String f24612a = "weapon.set";

    /* renamed from: e */
    private static String f24616e;

    /* renamed from: b */
    private static String f24613b = C7212c.m34106b("Y29tLmt3YWkud2VhcG9u", 2);

    /* renamed from: c */
    private static String f24614c = C7212c.m34106b(f24614c, 2);

    /* renamed from: c */
    private static String f24614c = C7212c.m34106b(f24614c, 2);

    /* renamed from: d */
    private static String f24615d = C7212c.m34106b(f24615d, 2);

    /* renamed from: d */
    private static String f24615d = C7212c.m34106b(f24615d, 2);

    private C7204bs() {
    }

    /* renamed from: a */
    public static synchronized String m34142a(Context context) {
        synchronized (C7204bs.class) {
            if (!TextUtils.isEmpty(f24616e)) {
                return f24616e;
            }
            String m34138c = m34138c(context);
            f24616e = m34138c;
            return m34138c;
        }
    }

    /* renamed from: b */
    private static void m34139b(Context context, String str) {
        m34137c(context, str);
        m34135d(context, str);
    }

    /* renamed from: c */
    private static String m34138c(Context context) {
        String m34134e = m34134e(context);
        if (TextUtils.isEmpty(m34134e)) {
            String m34136d = m34136d(context);
            if (!TextUtils.isEmpty(m34136d)) {
                m34139b(context, m34136d);
            }
            return m34136d;
        }
        return m34134e;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0002, B:9:0x001f, B:13:0x002e, B:19:0x004a, B:21:0x0050, B:24:0x005a, B:18:0x0046, B:12:0x0026, B:8:0x001b), top: B:27:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0002, B:9:0x001f, B:13:0x002e, B:19:0x004a, B:21:0x0050, B:24:0x005a, B:18:0x0046, B:12:0x0026, B:8:0x001b), top: B:27:0x0002 }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m34136d(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "re_po_rt"
            com.kuaishou.weapon.p0.h r1 = com.kuaishou.weapon.p205p0.C7283h.m33888a(r5, r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "a1_p_s_p_s"
            boolean r2 = r1.m33867e(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "a1_p_s_p_s_c_b"
            boolean r1 = r1.m33867e(r3)     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L1b
            if (r1 == 0) goto L19
            goto L1b
        L19:
            r3 = r0
            goto L1f
        L1b:
            java.lang.String r3 = com.kuaishou.weapon.p205p0.C7191bh.m34248f(r5)     // Catch: java.lang.Throwable -> L93
        L1f:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L93
            if (r4 != 0) goto L26
            goto L2e
        L26:
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L93
        L2e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.Throwable -> L93
            r4.append(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = com.kuaishou.weapon.p205p0.C7204bs.f24613b     // Catch: java.lang.Throwable -> L93
            r4.append(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L46
            if (r1 == 0) goto L44
            goto L46
        L44:
            r1 = r0
            goto L4a
        L46:
            java.lang.String r1 = com.kuaishou.weapon.p205p0.C7191bh.m34255c(r5)     // Catch: java.lang.Throwable -> L93
        L4a:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L93
            if (r2 != 0) goto L58
            java.lang.String r2 = "RISK"
            boolean r2 = r1.startsWith(r2)     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L5a
        L58:
            java.lang.String r1 = "0"
        L5a:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L93
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuffer r1 = r2.reverse()     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = com.kuaishou.weapon.p205p0.C7281f.m33897a(r3)     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r3.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> L93
            r3.append(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "|"
            r3.append(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r1.toUpperCase()     // Catch: java.lang.Throwable -> L93
            r3.append(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L93
            com.kuaishou.weapon.p0.bn r2 = new com.kuaishou.weapon.p0.bn     // Catch: java.lang.Throwable -> L93
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L93
            java.lang.String r5 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w="
            java.lang.String r5 = r2.m34156a(r1, r5)     // Catch: java.lang.Throwable -> L93
            return r5
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7204bs.m34136d(android.content.Context):java.lang.String");
    }

    /* renamed from: e */
    private static String m34134e(Context context) {
        String m34141a = m34141a(context, f24614c);
        String m34133f = m34133f(context);
        if (TextUtils.isEmpty(m34141a) || !TextUtils.equals(m34141a, m34133f)) {
            if (!TextUtils.isEmpty(m34141a)) {
                m34135d(context, m34141a);
                return m34141a;
            } else if (TextUtils.isEmpty(m34133f)) {
                return "";
            } else {
                m34137c(context, m34133f);
                return m34133f;
            }
        }
        return m34141a;
    }

    /* renamed from: f */
    private static String m34133f(Context context) {
        try {
            return C7262df.m33986a(context).m33977d();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m34140b(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* renamed from: a */
    public static String m34141a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    private static void m34137c(Context context, String str) {
        try {
            if (m34140b(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                Settings.System.putString(contentResolver, f24614c, str);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                Settings.System.putString(contentResolver, f24612a, sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private static void m34135d(Context context, String str) {
        C7262df.m33986a(context).m33978c(str);
    }
}
