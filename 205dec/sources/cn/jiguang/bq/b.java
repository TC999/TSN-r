package cn.jiguang.bq;

import android.util.Log;
import cn.jiguang.internal.JConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static void a(String str, String str2, boolean z3, int i4, String str3, Throwable th) {
        String str4;
        StringBuilder sb;
        try {
            if (cn.jiguang.a.a.f2015g) {
                if (i4 == 2) {
                    str4 = "T";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i4 == 3) {
                    str4 = "D";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i4 == 4) {
                    str4 = "I";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i4 == 5) {
                    str4 = "W";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i4 == 6) {
                    str4 = "E";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                }
                c.a(str4, sb.toString(), str2, str3, null);
            }
            boolean z4 = false;
            try {
                z4 = JConstants.CMD_TO_PRINT_ALL_LOG;
            } catch (Throwable unused) {
            }
            if (!z4) {
                if (!JConstants.DEBUG_MODE && i4 < 5) {
                    return;
                }
                if ((z3 && i4 < 6) || !a(i4)) {
                    return;
                }
            }
            if (i4 == 2) {
                Log.v("JIGUANG-" + str, "[" + str2 + "] " + str3);
            } else if (i4 == 3) {
                Log.d("JIGUANG-" + str, "[" + str2 + "] " + str3);
            } else if (i4 == 4) {
                Log.i("JIGUANG-" + str, "[" + str2 + "] " + str3);
            } else if (i4 == 5) {
                Log.w("JIGUANG-" + str, "[" + str2 + "] " + str3);
            } else if (i4 != 6) {
            } else {
                Log.e("JIGUANG-" + str, "[" + str2 + "] " + str3);
            }
        } catch (Throwable unused2) {
        }
    }

    private static boolean a(int i4) {
        return i4 >= 2;
    }
}
