package com.amap.api.col.s;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OfflineLocEntity.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e3 {

    /* renamed from: a  reason: collision with root package name */
    private Context f9832a;

    /* renamed from: b  reason: collision with root package name */
    private i1 f9833b;

    /* renamed from: c  reason: collision with root package name */
    private String f9834c;

    private static String a(Context context, i1 i1Var, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(i1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(i1Var.d());
            sb.append("\",\"nt\":\"");
            sb.append(c1.r(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] b() {
        return j1.o(a(this.f9832a, this.f9833b, this.f9834c));
    }
}
