package com.qq.e.comm.plugin.m;

import android.content.Context;
import com.qq.e.comm.plugin.m.c.f;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f44639e = new b("IMEI", 0, "m1", new f() { // from class: com.qq.e.comm.plugin.m.c.e
        @Override // com.qq.e.comm.plugin.m.a
        public String a(Context context) {
            return com.qq.e.comm.plugin.d0.a.d().c().h();
        }
    });

    /* renamed from: f  reason: collision with root package name */
    public static final b f44640f = new b("ANDROIDID", 1, "m3", new f() { // from class: com.qq.e.comm.plugin.m.c.c
        @Override // com.qq.e.comm.plugin.m.a
        public String a(Context context) {
            return d.b();
        }
    });

    /* renamed from: g  reason: collision with root package name */
    public static final b f44641g = new b("ALLID", 2, "device_ext", new com.qq.e.comm.plugin.m.c.b());

    /* renamed from: c  reason: collision with root package name */
    private final String f44642c;

    /* renamed from: d  reason: collision with root package name */
    private final a f44643d;

    private b(String str, int i4, String str2, a aVar) {
        this.f44642c = str2;
        this.f44643d = aVar;
    }

    public String a(Context context) {
        return b().b(context);
    }

    public a b() {
        return this.f44643d;
    }

    public String a() {
        return this.f44642c;
    }
}
