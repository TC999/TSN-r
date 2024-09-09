package cn.jpush.android.i;

import android.util.Log;
import cn.jpush.android.f.c;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a {
    public static void a(String str, String str2, int i4, String str3) {
        try {
            if (c.f4187d || i4 >= 5) {
                if (i4 >= 3) {
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
                }
            }
        } catch (Throwable unused) {
        }
    }
}
