package com.bytedance.sdk.component.r.w.xv;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    private static boolean c(String str) {
        sr sr;
        ux xv = xv(str);
        if (xv == null || (sr = xv.sr()) == null) {
            return false;
        }
        return sr.c();
    }

    public static void sr(String str, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(null, str, uxVar.ux(), 6);
    }

    public static void ux(String str, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(null, str, uxVar.ux(), 100);
    }

    private static String w(String str) {
        sr sr;
        ux xv = xv(str);
        if (xv == null || (sr = xv.sr()) == null) {
            return null;
        }
        return sr.w();
    }

    private static ux xv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.r.w.c.r(str);
    }

    public static void sr(String str, String str2, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(str, str2, uxVar.ux(), 6);
    }

    public static void xv(String str, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(null, str, uxVar.ux(), 5);
    }

    public static void c(String str, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(null, str, uxVar.ux(), 3);
    }

    public static void w(String str, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(null, str, uxVar.ux(), 4);
    }

    public static void xv(String str, String str2, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(str, str2, uxVar.ux(), 5);
    }

    public static void c(String str, String str2, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(str, str2, uxVar.ux(), 3);
    }

    public static void w(String str, String str2, ux uxVar) {
        if (uxVar == null) {
            return;
        }
        c(str, str2, uxVar.ux(), 4);
    }

    public static void c(String str, String str2) {
        c(null, str, str2, 3);
    }

    public static void w(String str, String str2) {
        c(null, str, str2, 4);
    }

    public static void c(String str, String str2, String str3) {
        c(str, str2, str3, 4);
    }

    private static void c(String str, String str2, String str3, int i4) {
        try {
            if (c(str3) || i4 == 100) {
                String w3 = w(str3);
                if (w3 == null) {
                    w3 = "";
                }
                String str4 = w3 + "log";
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i4 == 2) {
                    Log.v(str4, str2);
                } else if (i4 == 3) {
                    Log.d(str4, str2);
                } else if (i4 == 4) {
                    Log.i(str4, str2);
                } else if (i4 == 5) {
                    Log.w(str4, str2);
                } else if (i4 == 6 || i4 == 100) {
                    Log.e(str4, str2);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
