package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f46596a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f46597b;

    private static String a(Context context, Map<Integer, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (com.qq.e.comm.plugin.apkmanager.x.b.b(context, entry.getValue())) {
                sb.append(",");
                sb.append(entry.getKey());
            }
        }
        return sb.length() > 1 ? sb.substring(1) : "";
    }

    public static String a() {
        Context a4;
        String c4;
        try {
            a4 = com.qq.e.comm.plugin.d0.a.d().a();
            c4 = com.qq.e.comm.plugin.d0.a.d().f().c("markets");
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(c4)) {
            return "";
        }
        if (f46597b != null && f46597b.equals(c4)) {
            d1.a("Cache hit", new Object[0]);
            return f46596a;
        }
        if (a4 != null && !TextUtils.isEmpty(c4)) {
            String a5 = a(a4, a(c4.split(",")));
            f46596a = a5;
            f46597b = c4;
            return a5;
        }
        return "";
    }

    private static Map<Integer, String> a(String[] strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    try {
                        hashMap.put(Integer.valueOf(Integer.parseInt(split[0])), split[1]);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return hashMap;
    }
}
