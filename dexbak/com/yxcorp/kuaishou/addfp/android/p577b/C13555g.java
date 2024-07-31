package com.yxcorp.kuaishou.addfp.android.p577b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.yxcorp.kuaishou.addfp.p578c.p579a.C13557a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* renamed from: com.yxcorp.kuaishou.addfp.android.b.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13555g {

    /* renamed from: a */
    private static boolean f40058a;

    /* renamed from: a */
    public static String m12874a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    /* renamed from: a */
    public static String m12873a(Throwable th) {
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th3) {
                th3.printStackTrace();
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }

    /* renamed from: a */
    public static void m12872a(boolean z) {
        f40058a = z;
    }

    /* renamed from: a */
    public static boolean m12875a(Context context, String[] strArr) {
        try {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: b */
    public static String m12871b(String str) {
        try {
            C13553e m12864a = C13557a.m12864a(str, false);
            return !TextUtils.isEmpty(m12864a.f40053b) ? m12864a.f40053b : (TextUtils.isEmpty(m12864a.f40054c) || !m12864a.f40054c.contains("denied")) ? TextUtils.isEmpty(m12864a.f40053b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_PE";
        }
    }
}
