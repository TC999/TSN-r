package com.baidu.liantian.ac;

import android.content.Context;
import android.util.Pair;
import com.baidu.liantian.b;
import com.baidu.liantian.core.e;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LH {
    private LH() {
    }

    public static Pair<String, String> getId(Context context) {
        String str;
        String str2 = "";
        try {
            str = e.a(context);
            try {
                String l4 = com.baidu.liantian.b.e.l(context);
                b.a();
                str2 = new JSONObject(l4).getString("ID");
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return Pair.create(str, str2);
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return Pair.create(str, str2);
    }

    private static String getVersion(Context context) {
        return "3.1.6.7";
    }

    public static void init(Context context, boolean z3) {
        e.a(context, 0, z3);
    }

    public static void initDelay(Context context, int i4, boolean z3) {
        e.a(context, i4, z3);
    }

    public static Pair<String, String> getId(Context context, String str) {
        String str2;
        String str3 = "";
        try {
            str2 = e.a(context);
            try {
                String b4 = com.baidu.liantian.b.e.b(context, str);
                b.a();
                str3 = new JSONObject(b4).getString("ID");
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return Pair.create(str2, str3);
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return Pair.create(str2, str3);
    }
}
