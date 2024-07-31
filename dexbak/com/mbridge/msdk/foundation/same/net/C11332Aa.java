package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;

/* renamed from: com.mbridge.msdk.foundation.same.net.Aa */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11332Aa {
    private static final String C_END = "_mv_end";
    private static final String C_START = "mv_channel_";

    /* renamed from: a */
    private static String f30685a = "";

    /* renamed from: a */
    public static String m22305a() {
        return f30685a;
    }

    /* renamed from: b */
    public static String m22304b() {
        return null;
    }

    /* renamed from: b */
    private static void m22303b(String str) {
        String str2;
        Integer m22302c;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = SameBase64Tool.m21812b(str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(C_START) && str2.endsWith(C_END) && (m22302c = m22302c(str2)) != null) {
            f30685a = String.valueOf(m22302c);
        } else if (!MBridgeConstans.DEBUG) {
            f30685a = "";
        } else {
            m22301g();
            throw new RuntimeException("please don't update this value");
        }
    }

    /* renamed from: c */
    private static Integer m22302c(String str) {
        Throwable th;
        Integer num;
        if (str != null) {
            int indexOf = str.indexOf(C_START);
            int indexOf2 = str.indexOf(C_END);
            if (indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf) {
                return null;
            }
            try {
                num = Integer.valueOf(str.substring(indexOf + 11, indexOf2));
            } catch (Throwable th2) {
                th = th2;
                num = null;
            }
            try {
                if (num.intValue() > 0) {
                    return num;
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                return num;
            }
        }
        return null;
    }

    /* renamed from: g */
    private static void m22301g() {
        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.Aa.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Process.killProcess(Process.myPid());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 500L);
    }
}
