package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.s;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Aa {
    private static final String C_END = "_mv_end";
    private static final String C_START = "mv_channel_";

    /* renamed from: a  reason: collision with root package name */
    private static String f39479a = "";

    public static String a() {
        return f39479a;
    }

    public static String b() {
        return null;
    }

    private static void b(String str) {
        String str2;
        Integer c4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = s.b(str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith(C_START) && str2.endsWith(C_END) && (c4 = c(str2)) != null) {
            f39479a = String.valueOf(c4);
        } else if (!MBridgeConstans.DEBUG) {
            f39479a = "";
        } else {
            g();
            throw new RuntimeException("please don't update this value");
        }
    }

    private static Integer c(String str) {
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

    private static void g() {
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
