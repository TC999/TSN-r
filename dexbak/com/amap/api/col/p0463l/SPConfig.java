package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.amap.api.col.3l.y5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SPConfig {

    /* renamed from: a */
    private static HashMap<String, String> f5787a = new HashMap<>();

    /* renamed from: a */
    public static String m53400a(Context context, SDKInfo sDKInfo, String str) {
        if (sDKInfo == null || TextUtils.isEmpty(sDKInfo.m54400a())) {
            return null;
        }
        String str2 = f5787a.get(sDKInfo.m54400a() + str);
        if (TextUtils.isEmpty(str2)) {
            String str3 = str + sDKInfo.m54400a();
            return (context == null || TextUtils.isEmpty(str3)) ? "" : C1925p4.m54197g(AESMD5Util.m55295e(C1925p4.m54179y(context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).getString(str3, ""))));
        }
        return str2;
    }

    /* renamed from: b */
    public static void m53399b(Context context, SDKInfo sDKInfo, String str, String str2) {
        if (sDKInfo == null || TextUtils.isEmpty(sDKInfo.m54400a())) {
            return;
        }
        String str3 = str + sDKInfo.m54400a();
        f5787a.put(sDKInfo.m54400a() + str, str2);
        if (context == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty("d7afbc6a38848a6801f6e449f3ec8e53") || TextUtils.isEmpty(str2)) {
            return;
        }
        String m54206E = C1925p4.m54206E(AESMD5Util.m55297c(C1925p4.m54189o(str2)));
        SharedPreferences.Editor edit = context.getSharedPreferences("d7afbc6a38848a6801f6e449f3ec8e53", 0).edit();
        edit.putString(str3, m54206E);
        edit.commit();
    }
}
