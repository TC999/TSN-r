package cn.jiguang.cc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.f.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f3269a;

    static {
        ArrayList arrayList = new ArrayList();
        f3269a = arrayList;
        arrayList.add("358673013795895");
        f3269a.add("004999010640000");
        f3269a.add("00000000000000");
        f3269a.add("000000000000000");
    }

    public static String a(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ad());
        if (!TextUtils.isEmpty(str)) {
            str = new String(Base64.decode(str, 2));
        }
        if (a(str)) {
            return str;
        }
        String b4 = b(context);
        if (!TextUtils.isEmpty(b4)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.ad().a((cn.jiguang.g.a<String>) Base64.encodeToString(b4.getBytes(), 2)));
        }
        return b4;
    }

    private static boolean a(String str) {
        if (g.h(str) && str.length() >= 10) {
            for (String str2 : f3269a) {
                if (str.startsWith(str2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static String b(Context context) {
        try {
            String str = a.a(context).f3254p;
            if (a(str)) {
                return str;
            }
            String str2 = a.a(context).f3247i;
            if (!a(str2) || "9774d56d682e549c".equals(str2.toLowerCase(Locale.getDefault()))) {
                String c4 = c(context);
                return a(c4) ? c4 : "";
            }
            return str2;
        } catch (Exception e4) {
            cn.jiguang.bq.d.d("UDIDUtils", "", e4);
            String d4 = d(context);
            return a(d4) ? d4 : "";
        }
    }

    private static String c(Context context) {
        String d4 = d(context);
        return d4 == null ? " " : d4;
    }

    private static String d(Context context) {
        cn.jiguang.bq.d.c("UDIDUtils", "Action:getSavedUuid");
        String str = (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.at());
        if (g.a(str)) {
            if (cn.jiguang.f.a.a()) {
                String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ae());
                return TextUtils.isEmpty(str2) ? (Build.VERSION.SDK_INT >= 23 && !(cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE") && cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE"))) ? g(context) : e(context) : str2;
            }
            return g(context);
        }
        return str;
    }

    private static String e(Context context) {
        String f4 = f(context);
        File file = !g.a(f4) ? new File(f4) : null;
        String d4 = cn.jiguang.f.c.d(file);
        if (!TextUtils.isEmpty(d4)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.ae().a((cn.jiguang.g.a<String>) d4));
            cn.jiguang.bq.d.f("UDIDUtils", "Got sdcard file saved udid - " + d4);
            return d4;
        }
        String j4 = g.j(UUID.nameUUIDFromBytes((System.currentTimeMillis() + "").getBytes()).toString());
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.ae().a((cn.jiguang.g.a<String>) j4));
        cn.jiguang.f.c.c(file, j4);
        return j4;
    }

    private static String f(Context context) {
        String h4 = cn.jiguang.f.a.h(context);
        if (TextUtils.isEmpty(h4)) {
            return null;
        }
        return h4 + ".push_udid";
    }

    private static String g(Context context) {
        cn.jiguang.g.a<String> at = cn.jiguang.g.a.at();
        String str = (String) cn.jiguang.g.b.b(context, at);
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            cn.jiguang.g.b.a(context, at.a((cn.jiguang.g.a<String>) uuid));
            return uuid;
        }
        return str;
    }
}
