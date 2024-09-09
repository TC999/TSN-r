package com.qq.e.comm.plugin.i0;

import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import java.util.HashSet;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HashSet<String> f44231a;

    private static String a(String str, boolean z3) {
        if (z3) {
            return JPushConstants.HTTPS_PRE + str.substring(7);
        }
        return JPushConstants.HTTP_PRE + str.substring(8);
    }

    private static String b(String str, int i4) {
        if (TextUtils.isEmpty(str) || !str.startsWith(JPushConstants.HTTP_PRE)) {
            return str;
        }
        a();
        com.qq.e.comm.plugin.n0.d a4 = new com.qq.e.comm.plugin.n0.d().a("url", str);
        if (!i2.a(str, f44231a)) {
            v.a(9720000, null, Integer.valueOf(i4), 0, a4);
            return str;
        }
        v.a(9720000, null, Integer.valueOf(i4), 1, a4);
        return a(str, true);
    }

    public static String a(String str, int i4) {
        return b(str, i4);
    }

    private static void a() {
        String[] split;
        if (f44231a != null) {
            return;
        }
        synchronized (e.class) {
            if (f44231a != null) {
                return;
            }
            try {
                String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("sthdwl", "");
                HashSet<String> hashSet = new HashSet<>();
                if (!TextUtils.isEmpty(b4) && (split = b4.split(",")) != null && split.length > 0) {
                    for (String str : split) {
                        hashSet.add(str);
                    }
                }
                f44231a = hashSet;
            } catch (Exception e4) {
                d1.a(e4.getMessage());
            }
        }
    }
}
