package cn.jiguang.bj;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2664a = cn.jiguang.bh.a.b(new byte[]{63, 85, 88, 109, 75, 121, Byte.MAX_VALUE, 86, 73, 126});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2665b = cn.jiguang.bh.a.b(new byte[]{116, 72, 84, 52});

    /* renamed from: c  reason: collision with root package name */
    public static final String f2666c = cn.jiguang.bh.a.b(new byte[]{32, 2, 69, 45, 61, 32, 38, 87, 25, 40, 99, 37, 37, 66, 22, 46});

    /* renamed from: d  reason: collision with root package name */
    public static final String f2667d = cn.jiguang.bh.a.b(new byte[]{33, 1, 16, 43, 56, 37, 33, 4, 16, 44, 56, 32, 33, 7, 16, 33});

    /* renamed from: e  reason: collision with root package name */
    public static final String f2668e = cn.jiguang.bh.a.b(new byte[]{85, 118, 97, 33, 60, 84, 32, 0, 98, 46, 73, 85, 85, 116, 18, 44});

    /* renamed from: f  reason: collision with root package name */
    private static SharedPreferences f2669f;

    public static String a(Context context, int i4, String str) {
        if (f2669f == null) {
            f2669f = context.getSharedPreferences(f2664a, 0);
        }
        SharedPreferences sharedPreferences = f2669f;
        String string = sharedPreferences.getString(f2665b + str + "-" + i4, "");
        StringBuilder sb = new StringBuilder();
        sb.append("g1:");
        sb.append(string);
        cn.jiguang.bi.b.b("JC", sb.toString());
        if (!"".equals(string)) {
            try {
                string = new String(i.a(string, f2666c, f2667d));
            } catch (Exception unused) {
                cn.jiguang.bi.b.b("JC", "decrypt plugin failed");
            }
        }
        cn.jiguang.bi.b.b("JC", "g2:" + string);
        return string;
    }

    public static void a(Context context, int i4, String str, String str2, boolean z3) {
        int i5;
        if (z3) {
            i5 = cn.jiguang.bf.c.a().a(context, i4);
            cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2615j, 0, null);
        } else {
            i5 = -1;
        }
        if (f2669f == null) {
            f2669f = context.getSharedPreferences(f2664a, 0);
        }
        try {
            cn.jiguang.bi.b.b("JC", "s1:" + str2);
            str2 = i.a(str2.getBytes(), f2666c, f2667d);
            cn.jiguang.bi.b.b("JC", "s2:" + str2);
        } catch (Throwable th) {
            cn.jiguang.bi.b.g("JC", "aesEncrypt error , msg :" + th.getMessage());
            if (z3) {
                cn.jiguang.dy.c.a().a(context, i4, i5, cn.jiguang.bg.a.f2615j, 2, th.getMessage());
            }
        }
        SharedPreferences.Editor edit = f2669f.edit();
        edit.putString(f2665b + str + "-" + i4, str2);
        edit.commit();
        if (z3) {
            int i6 = i5;
            cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2615j, 1, null);
            cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2611f, 1, null);
        }
    }
}
