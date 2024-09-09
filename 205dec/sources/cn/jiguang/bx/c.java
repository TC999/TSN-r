package cn.jiguang.bx;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    public static boolean a(Context context) {
        String c4 = c(context);
        String e4 = cn.jiguang.d.a.e(context);
        cn.jiguang.bq.d.c("InitHelper", "appkey=" + e4 + " last=" + c4);
        if (cn.jiguang.f.g.a(c4) || "null".equals(c4) || !c4.equalsIgnoreCase(e4)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.ab().a((cn.jiguang.g.a<String>) cn.jiguang.cn.g.a(e4, cn.jiguang.a.a.f2017i)));
            cn.jiguang.bq.d.d("InitHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
            cn.jiguang.bt.b.a(context);
            return true;
        }
        return false;
    }

    public static void b(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.U());
        if (!TextUtils.isEmpty(str)) {
            str.startsWith("1.");
        }
        if (TextUtils.isEmpty(str) || !"4.7.3".equals(str)) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.U().a((cn.jiguang.g.a<String>) "4.7.3"));
        }
    }

    private static String c(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ab());
        if (TextUtils.isEmpty(str)) {
            String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ac());
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.ab().a((cn.jiguang.g.a<String>) cn.jiguang.cn.g.a(str2, cn.jiguang.a.a.f2017i)));
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.ac().a((cn.jiguang.g.a<String>) ""));
            return str2;
        }
        return cn.jiguang.cn.g.b(str, cn.jiguang.a.a.f2017i);
    }
}
