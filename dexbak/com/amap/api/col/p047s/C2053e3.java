package com.amap.api.col.p047s;

import android.content.Context;

/* compiled from: OfflineLocEntity.java */
/* renamed from: com.amap.api.col.s.e3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2053e3 {

    /* renamed from: a */
    private Context f6104a;

    /* renamed from: b */
    private C2073i1 f6105b;

    /* renamed from: c */
    private String f6106c;

    /* renamed from: a */
    private static String m53016a(Context context, C2073i1 c2073i1, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(c2073i1.m52916f());
            sb.append("\",\"product\":\"");
            sb.append(c2073i1.m52918d());
            sb.append("\",\"nt\":\"");
            sb.append(C2023c1.m53156r(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final byte[] m53015b() {
        return C2079j1.m52862o(m53016a(this.f6104a, this.f6105b, this.f6106c));
    }
}
