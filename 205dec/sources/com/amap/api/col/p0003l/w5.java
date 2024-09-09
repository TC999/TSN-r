package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CrashManager.java */
/* renamed from: com.amap.api.col.3l.w5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w5 {

    /* renamed from: a  reason: collision with root package name */
    private p4 f9365a;

    /* compiled from: CrashManager.java */
    /* renamed from: com.amap.api.col.3l.w5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, w5> f9366a = new HashMap();
    }

    private w5(p4 p4Var) {
        this.f9365a = p4Var;
    }

    public static w5 a(p4 p4Var) {
        if (a.f9366a.get(p4Var.a()) == null) {
            a.f9366a.put(p4Var.a(), new w5(p4Var));
        }
        return a.f9366a.get(p4Var.a());
    }

    public final void b(Context context, boolean z3, boolean z4) {
        z5.b(context, this.f9365a, "sckey", String.valueOf(z3));
        if (z3) {
            z5.b(context, this.f9365a, "scisf", String.valueOf(z4));
        }
    }

    public final boolean c(Context context) {
        try {
            return Boolean.parseBoolean(z5.a(context, this.f9365a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean d(Context context) {
        try {
            return Boolean.parseBoolean(z5.a(context, this.f9365a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }
}
