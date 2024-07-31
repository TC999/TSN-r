package com.bytedance.pangle.log;

/* renamed from: com.bytedance.pangle.log.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6164a {

    /* renamed from: a */
    private String f22072a;

    /* renamed from: b */
    private String f22073b;

    /* renamed from: c */
    private String f22074c;

    /* renamed from: d */
    private long f22075d;

    /* renamed from: e */
    private long f22076e;

    private C6164a(String str, String str2, String str3) {
        this.f22072a = str;
        this.f22073b = str2;
        this.f22074c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f22076e = currentTimeMillis;
        this.f22075d = currentTimeMillis;
        String str4 = this.f22072a;
        ZeusLogger.m37081i(str4, this.f22073b + String.format(" watcher[%s]-start", str3));
    }

    /* renamed from: a */
    public static C6164a m37073a(String str, String str2, String str3) {
        return new C6164a(str, str2, str3);
    }

    /* renamed from: a */
    public final long m37074a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f22076e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f22075d;
        String str2 = this.f22072a;
        ZeusLogger.m37081i(str2, this.f22073b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f22074c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    /* renamed from: a */
    public final long m37075a() {
        return System.currentTimeMillis() - this.f22075d;
    }
}
